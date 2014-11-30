package thewar.graph;

public class Vector2d {
    double x,y;
    Vector2d(){
        this.x = 0;
        this.y = 0;
    }
    Vector2d(double a, double b){
        this.x = a;
        this.y = b;
    }
    public Vector2d normalize(){
        Vector2d aux = new Vector2d();
        aux.x = this.x / Math.sqrt(this.x * this.x + this.y * this.y);
        aux.y = this.y / Math.sqrt(this.x * this.x + this.y * this.y);
        return aux;
    }
    public Vector2d normalize(Vector2d v){
        Vector2d aux = new Vector2d();
        aux.x = v.x / Math.sqrt(v.x * v.x + v.y * v.y);
        aux.y = v.y / Math.sqrt(v.x * v.x + v.y * v.y);
        return aux;
    }
}
