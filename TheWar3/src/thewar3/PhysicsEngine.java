package thewar3;

import java.util.ArrayList;
import thewar3.graph.Graph;

public class PhysicsEngine {
    Graph unitGraph;
    float cellSize;
    int numCellX,numCellY;
    ArrayList[][] Grid;
    ArrayList units;
    SceneInfo info;
    public PhysicsEngine(ArrayList u, SceneInfo i){
        this.units = u;
        this.info = i;
        unitGraph = new Graph(this.units.size());
        this.cellSize = this.info.unitDistance;
        this.numCellX = (int) (this.info.dreaptaJos.x / this.cellSize);
        this.numCellY = (int) (this.info.dreaptaJos.y / this.cellSize);
        this.Grid = new ArrayList[numCellX][numCellY];
    }
    /**
     *  Synchronizes the units from Application with the ones from 
     *  PhysicsEngine.
     * @param unsync
     */
    public void sync(ArrayList unsync){
        int i,j;
        for(i = 0; i < this.numCellY; i++){
            for(j = 0; j < this.numCellX; i++){
                if(this.Grid[i][j] != null){
                    unsync.addAll(this.Grid[i][j]);
                }
            }
        }
    }
    
    public void initUnitGraph(Application app){
        int i;
        for(i = 0; i < app.listeners.size(); i++){
            this.unitGraph.addVertex(0, app.listeners.get(i));          
        }
    }
    
    /**
     *  Used an ArrayList of units to populate the grid(battlefield). It assigns
     *  every unit a cell based on the range of the units and the size of the
     *  battlefield.
     */
    public void placeUnits(){
        int i;
        for(i = 0; i < this.units.size(); i++){
            int cellPosX = (int)(((Unit)this.units.get(i)).pos.x / this.cellSize);
            int cellPosY = (int)(((Unit)this.units.get(i)).pos.y / this.cellSize);
            if(this.Grid[cellPosY][cellPosX] == null){
                this.Grid[cellPosY][cellPosX] = new ArrayList();
            }
            this.Grid[cellPosY][cellPosX].add(this.units.get(i));
        }
    }

    /**
     *  Removes the "dead" units from the grid.
     */
    public void cleanBattlefield(){
        int i,j,k;
        for(i = 0; i < this.numCellY; i++){
            for(j = 0; j < this.numCellX; j++){
                if(this.Grid[i][j] != null){
                    for(k = 0; k < this.Grid[i][j].size(); k++){
                        if(((Unit)this.Grid[i][j].get(k)).defence <= 0)
                            this.Grid[i][j].remove(k);
                    }
                    if(this.Grid[i][j].isEmpty())
                        this.Grid[i][j] = null;
                }
            }
        }        
    }
    
    /**
     * Calculates the distance between two vectors.
     * @param a first vector
     * @param b second vector
     * @return the absolute distance between a and b
     */
    public float getDistance(Vector2d a, Vector2d b){
        float c1 = Math.abs(a.x - b.x);
        float c2 = Math.abs(a.y - b.y);
        return (float)Math.sqrt(c1 * c1 + c2 * c2);
    }
    
    /**
     * Finds the closest unit to a given position.
     * @param x
     * @return Closest Unit to position x.
     */
    public Unit getClosest(Vector2d x){
        float max = 0,aux;
        Unit auxU = new Unit();
        int i;
        for(i = 0; i < this.units.size(); i++){
            aux = getDistance(x,((Unit)this.units.get(i)).pos);
            if(aux > max){
                max = aux;
                auxU = (Unit)this.units.get(i);
            }
        }
        return auxU;
    }
    
    /**
     * Calculates the position a unit will have in future, at the end of the
     * current frame.
     * @param u unit to have the ending point calculated
     * @param dt the time of the movement
     * @return position vector
     */
    public Vector2d getNextPos(Unit u, float dt){
        Vector2d aux = new Vector2d();
        aux.x = dt / 1000 * u.speed * u.direction.x;
        aux.y = dt / 1000 * u.speed * u.direction.y;
        return aux;
    }

    /**
     * Calculates the trajectories of two units and determines
     * whether or not they will collide in the given amount of time.
     * @param A the first unit
     * @param B the second unit
     * @param dt duration of the movement
     * @return 
     */
    public boolean checkCollision(Unit A, Unit B, float dt){
        Vector2d nextPosA = getNextPos(A, dt);
        Vector2d nextPosB = getNextPos(B, dt);
        /* determine intersection point */
        float slope1 = (A.pos.y - nextPosA.y) /(A.pos.x - nextPosA.x);
        float slope2 = (B.pos.y - nextPosB.y) /(B.pos.x - nextPosB.x);
        if(slope2 == slope1){
            /* paralel directions */
            return false;
        }
        Vector2d intersection = new Vector2d();
        intersection.x =
                (A.pos.y - B.pos.y + slope2 * B.pos.x - slope1 * A.pos.x) / (slope2 - slope1);
        if(intersection.x < 0)System.err.println("Warning - negative size");
        intersection.y = slope1 * (intersection.x - A.pos.x) + A.pos.y;
        if(intersection.y < 0)System.err.println("Warning - negative size");
        
        /*
            calculate if both units will get to the intersection point at the 
            same moment + 3 milliseconds (very basic way of taking into account
            unit's diameter)
        */
        float time1 = intersection.x / (A.speed * A.direction.x);
        float time2 = intersection.x / (B.speed * B.direction.x);
        return (Math.abs(time1 - time2) < 3);
    }
    
    /**
     * Runs a collision check between give unit and the rest of the units.
     * @param A
     * @param dt
     * @return Unit which collides with the given one or null if no collision is
     * found in current frame.
     */
    public Unit searchCollision(Unit A, float dt){
        int i;
        for(i = 0; i < this.units.size(); i++){
            if(checkCollision(A,(Unit)this.units.get(i),dt))
                return (Unit)this.units.get(i);
        }
        return null;
    }
    
    /**
     * Checks is a unit will collide with a wall.
     * @param u
     * @param dt
     * @return boolean true or false
     */
    public boolean wallBounce(Unit u, float dt){
        Vector2d aux = getNextPos(u,dt);
        return outOfBounds(aux);
    }
    
    /**
     * Checks whether or not a give position is outside the battlefield.
     * @param pos
     * @return
     */
    public boolean outOfBounds(Vector2d pos){
        return (pos.x >= this.info.dreaptaJos.x || 
                pos.y >= this.info.dreaptaJos.y || pos.y <= 0 || pos.x <= 0);
    }
    
    /**
     * Calculates the movement of a unit.
     * @param u
     * @param dt the time interval of the movement
     */
    public void moveUnit(Unit u, float dt){
        int i, index;
        index = this.Grid[(int)(u.pos.x / this.cellSize)][(int)(u.pos.y / this.cellSize)].indexOf(u);
        if(index != -1){
            this.Grid[(int)(u.pos.x / this.cellSize)][(int)(u.pos.y / this.cellSize)].remove(index);
        }
        else{
            System.err.println("Unit not in cell!");
        }
        u.pos = getNextPos(u, dt);
        if(outOfBounds(u.pos)){
            u.speed = u.speed * (-1);
            u.pos = getNextPos(u, dt);
        }
        this.Grid[(int)(u.pos.x / this.cellSize)][(int)(u.pos.y / this.cellSize)].add(u);
    }
 
    /**
     * Simulates the combat between units.
     * @param units
     * @param dt
     */
    public void simulateCombat(ArrayList units, float dt){
        int i,j;
        for(i = 0 ; i < this.numCellY; i++){
            for(j = 0; j < this.numCellX; j++){
                solveCell(i,j,dt);
            }
        }
        cleanBattlefield();
    }

    /**
     * Solves the damage dealing between a unit and other nearby units.
     * @param u unit the damage is dealt to
     * @param combatants ArrayList of nearby units
     * @param dt time
     */
    public void dealDamage(Unit u, ArrayList combatants, float dt){
        int k;
        /* check for damage from tune units within this cell */
        for(k = 0; k < combatants.size(); k++){
            if(u.color != ((Unit)combatants.get(k)).color &&
                    getDistance(((Unit)combatants.get(k)).pos, u.pos) <= cellSize){
                if(u.defence > 0){
                    u.defence -= ((Unit)combatants.get(k)).offence * dt / 1000;
                    ((Unit)combatants.get(k)).defence -= ((Unit)combatants.get(k)).offence * dt / 1000;
                }
                else
                    return ;
            }
        } 
    }

    /**
     * Solves the cells by visiting each one and then checking for damage for
     * every unit it holds. It will check all the eight cells around for
     * enemy units as well as the list of units from inside itself.
     * @param i
     * @param j
     * @param dt
     */
    public void solveCell(int i, int j,float dt){

        int k;
        if(this.Grid[i][j] == null)
            return;
        for(k = 0; k < this.Grid[i][j].size(); k++)
        {
            dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i][j], dt);
            /* check the cells around the current one for attackers */
            if(i > 0 && j > 0 && this.Grid[i-1][j-1] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i-1][j-1], dt);
            }
            if(i > 0 && this.Grid[i-1][j] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i-1][j], dt);
            }
            if(j > 0 && this.Grid[i][j-1] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i][j-1], dt);
            }
            if(i < this.numCellY - 1 && j > 0 && this.Grid[i+1][j-1] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i+1][j-1], dt);
            }
            if(i < this.numCellY - 1 && this.Grid[i+1][j] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i+1][j], dt);
            }
            if(i < this.numCellY - 1 && j < this.numCellX - 1 && this.Grid[i+1][j+1] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i+1][j+1], dt);
            }
            if(j < this.numCellX -1 && this.Grid[i][j+1] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i][j+1], dt);
            }
            if(i > 0 && j < this.numCellX - 1 && this.Grid[i-1][j+1] != null){
                dealDamage((Unit)this.Grid[i][j].get(k), this.Grid[i-1][j+1], dt);
            }
        }   
    }
    public void printGrid(){
        int i,j;
        System.out.println("Number of x cells: " + this.numCellX);
        System.out.println("Number of y cells: " + this.numCellY);
        System.out.println("Number of units: " + this.units.size());
        for(i = 0 ; i < this.numCellX; i++){
            for(j = 0; j < this.numCellY; j++){
                System.out.println("\nCell[" + i + "][" + j + "]: ");
                if(this.Grid[i][j] != null)
                    System.out.print(this.Grid[i][j].toString() + " ");
            }
            System.out.println("");
        }
    }
}
