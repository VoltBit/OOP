package oop_lab10;

import java.util.HashMap;

public class ViewRomanian implements Observer{
    HashMap<String, String> dictionary = new HashMap();
    public ViewRomanian(){
        initDictionary();
    }
    public void initDictionary(){
        dictionary.put("word", "cuvant");
        dictionary.put("fun","distractie");
    }
    @Override
    public void update(String msg){
        System.out.print("A new message was added (Romanian): ");
        System.out.println(dictionary.get(msg));
    }
}
