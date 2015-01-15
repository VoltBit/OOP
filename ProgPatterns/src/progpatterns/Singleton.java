package progpatterns;

public class Singleton {
    private static Singleton instance = null;
    public static Singleton getInstance(){
        if(instance == null){
            instance = new Singleton();
        }
        return instance; 
    }
    public void display(){
        System.out.println("I am a singletooon!!!");
    }
}
