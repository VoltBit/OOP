package oop_lab5_var;

public class Main {

    private static void ex1(){
        MyArrayList a = new MyArrayList();
        int i;
        for(i = 0; i < 10; i++){
            a.add(i);
        }
        a.display();

        Iterator it = a.iterator();
        System.out.println(it.hasNext());

        while(it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
    private static void ex2(){
        EncrypterFactory E = new EncrypterFactory();
        String x = "TestTestTest";
        System.out.println(x);
        Encrypt enc = E.get();        
        x = enc.encrypt(x);
        System.out.println(x);
        System.out.println(enc.decrypt(x));
    }
    public static void main(String[] args) {
        ex1();
        ex2();
    }

}
