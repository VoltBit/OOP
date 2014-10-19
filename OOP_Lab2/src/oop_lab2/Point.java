package oop_lab2;

public class Point {
    private float x, y;
    
    public Point(){
        
    }
    
    public Point(float x, float y){
        this.x = x;
        this.y = y;
    }
    public void changeCoords(float x, float y){
        this.x = x;
        this.y = y;
    }
    public static void displayPoint(Point p){
        System.out.println("( " + p.x + ", " + p.y + " )");
    }
}