package graphimmplement.graph;

public class Vector2d {
    float x,y;
    public Vector2d(){
        this.x = 0;
        this.y = 0;
    }
    public Vector2d(float a, float b){
        this.x = a;
        this.y = b;
    }
    public Vector2d normalize(){
        Vector2d aux = new Vector2d();
        aux.x = (float) (this.x / Math.sqrt(this.x * this.x + this.y * this.y));
        aux.y = (float) (this.y / Math.sqrt(this.x * this.x + this.y * this.y));
        return aux;
    }
    public Vector2d normalize(Vector2d v){
        Vector2d aux = new Vector2d();
        aux.x = (float) (v.x / Math.sqrt(v.x * v.x + v.y * v.y));
        aux.y = (float) (v.y / Math.sqrt(v.x * v.x + v.y * v.y));
        return aux;
    }
    public void setX(float arg){
        this.x = arg;
    }
    public void setY(float arg){
        this.y = arg;
    }
    @Override
    public String toString(){
        String aux = "( ";
        aux = aux.concat(String.valueOf(this.x) + ", ");
        aux = aux.concat(String.valueOf(this.y));
        aux = aux.concat(" )");
        return aux;
    }
}
