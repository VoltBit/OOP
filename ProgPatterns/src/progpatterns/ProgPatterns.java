package progpatterns;

public class ProgPatterns {

    public static void test(int x){
        switch(x){
            case 1:
                singleton();
                break;
            case 2:
                factory();
                break;
            case 3:
                strategy();
                break;
        }
    }
    private static void singleton(){
        Singleton obj = Singleton.getInstance();
        obj.display();
    }
    private static void factory(){
        Integer x = 10;
        Double y = 2.2222;
        System.out.println(Factory.factoryForge(x).toString());
        System.out.println(Factory.factoryForge(y).toString());
    }
    private static void strategy(){
        
    }
    public static void main(String[] args) {
        test(1);
        test(2);
    }

}
