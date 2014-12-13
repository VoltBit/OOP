package thewar3;

public class Vector2d {
    float x,y;
    public Vector2d(){
        this.x = 0f;
        this.y = 0f;
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
        aux = aux.concat(String.format("%.3f",this.x) + ", ");
        aux = aux.concat(String.format("%.3f",this.y));
        aux = aux.concat(" )");
        return aux;
    }
}
