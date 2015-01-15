package progpatterns;

public class Factory {
    public static Object factoryForge(Number x){
        Number forgedObject = null;
        if(x instanceof Double){
            forgedObject = (Double)x * (Double)x;
        }else if(x instanceof Integer){
            forgedObject = (Integer)x + (Integer)x;
        }else if(x instanceof Object){
            System.out.println("Whaaat?");
            forgedObject = x;
        }
        return forgedObject;
    }
}
