package oop_lab2;

public class Polygon {
    public Point[] polygonPoints;
    public float[] polygonCoordinates = 
        {1.2f, 3.4f, 5.7f, -5.3f, 5.4f, 6.7f, 8.9f, 10.6f};
   
    public Polygon(Integer n){
        int i;
        for(i = 0; i < n; i++){
            polygonPoints[i] = new Point();
        }
    }
    
    public Polygon(float[] polCoord){
        if(polCoord.length % 2 != 0 || polCoord.length == 0)
            
        Polygon(polCoord.length / 2);
    }
    
    static void displayPolygon(Point[] polygonPoints){
        int i;
        for(i = 0; i < polygonPoints.length; i++){
            Point.displayPoint(polygonPoints[i]);
        }
    }
}
