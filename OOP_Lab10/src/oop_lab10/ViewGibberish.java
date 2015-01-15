package oop_lab10;

import java.util.HashMap;

public class ViewGibberish implements Observer{
    HashMap<String, String> dictionary = new HashMap();
    public ViewGibberish(){
        initDictionary();
    }
    public void initDictionary(){
        dictionary.put("word", "wwwooorrrddd");
        dictionary.put("fun","ffuunn");
    }
    @Override
    public void update(String msg){
        System.out.print("A new message was added (Gibberish): ");
        System.out.println(dictionary.get(msg));
    }
}
