package oop_lab10;

public class OOP_Lab10 {

    private static void ex1(){
        Observer gibberish = new ViewRomanian();
        Observer romanian = new ViewGibberish();
        MessageSet msgSet = new MessageSet();
        msgSet.attach(gibberish);
        msgSet.attach(romanian);
        msgSet.addMessage("word");
        msgSet.addMessage("fun");
    }
    private static void ex2(){
        ImageCommand c1,c2,c3;
        c1 = ImageCommandFactory.makeCommand("filter");
        c1.execute();
        c2 = ImageCommandFactory.makeCommand("resize");
        c2.execute();
        c3 = ImageCommandFactory.makeCommand("crop");
        c3.execute();
    }
    public static void main(String[] args) {
        //ex1();
        ex2();
    }

}
