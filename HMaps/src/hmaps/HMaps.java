package hmaps;

import hmaps.list.List;
import hmaps.map.HashMap;
import hmaps.map.MyKey;
import hmaps.map.MyValue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Scanner;

public class HMaps {
    static int testNumber;
    public static HashMap hmap;
    public static void initHashMap(int bucketsNumber){
        hmap = new HashMap(bucketsNumber);
    }
    private static Scanner openReadFile(){
        FileReader file;
        Scanner read;
        try {
            file = new FileReader("/home/smith/java/OOP/HMaps/src/hmaps/test.txt");
            read = new Scanner(file);
            return read;
        } catch (FileNotFoundException ex) {
            System.err.println("File open error");
            return null;
        }
    }
    private static PrintWriter openWriteFile() throws FileNotFoundException{
        PrintWriter w = null;
        try {
            w = new PrintWriter("/home/smith/java/OOP/HMaps/src/hmaps/output.txt", "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.err.println("File not found");
        }
        return w;
    }
    
    public static void listTester(){
        int i,nodeNumber = 10;
        String[] test = {"abab0","bvbvbv1","cjkjkj2",
            "dptptp3","edfdfd4","frtrt5","grwrwr6","hezr7"};
        MyValue[] v1 = new MyValue[8];
        MyValue[] v2 = new MyValue[8];
        for(i = 0; i < 8; i++){
            v1[i] = new MyValue(test[i]);
        }
        for(i = 0; i < 8; i++){
            v2[i] = new MyValue(test[7 - i]);
        }
        HashMap h = new HashMap(nodeNumber);
        /*List[] l = new List[8];
        MyKey[] k = new MyKey[8];
        for(i = 0; i < 8; i++){
            l[i] = new List();
            k[i] = new MyKey(test[i],l[i]);
            h.put(k[i],v1[i]);
            if(i % 2 == 0)h.put(k[i],v2[i]);
            System.out.println(h.get(k[i]).toString() + " [cod: " + (k[i].hashCode() + nodeNumber) % nodeNumber + "]");
        }System.out.println("_________");
        for(i = 0; i < 8; i++){
            System.out.println(h.get(k[i]).toString() + " [cod: " + (k[i].hashCode() + nodeNumber) % nodeNumber + "]");
        }*/
        List l = new List();
        List l2 = new List();
        List l3 = new List();
        MyKey k = new MyKey(test[2],l);
        MyKey k2 = new MyKey(test[3],l2);
        h.put(k,v1[1]);
        h.put(k2,v2[1]);
        h.put(k,v1[5]);
        h.put(k2,v2[6]);
        h.put(k,v1[7]);
        h.put(k,v1[2]);
//        h.put(k,v1[1]);
        h.put(k2,v2[7]);
        h.put(k2,v2[7]);
        h.put(k2,v2[5]);
        h.put(k2,v2[5]);
        System.out.println("Key: " + ((MyKey)k).key + "[" + ((MyKey)k).hashCode() + "]" + " Values: " + k.toString());
        System.out.println("Key: " + ((MyKey)k2).key + "[" + ((MyKey)k2).hashCode() + "]" + " Values: " + k2.toString());
        h.remove(k2,v1[1]);
        System.out.println(h.get(k2));
        h.remove(k2);
        
//        System.out.println("\n" + h.get(k));
        System.out.println(h.get(k2));
    }
    public static MyKey makeKey(String s){
        List l = new List();
        MyKey k = new MyKey(s,l);
        return k;
    }
    public static MyValue makeValue(String s){
        MyValue v = new MyValue(s);
        return v;
    }
    public static String getValues(String s) throws FileNotFoundException{
        List l = (List)hmap.get(makeKey(s));
        if(l == null)return null;
        System.out.println("Get for key: " + s);
        System.out.println(hmap.get(makeKey(s)).toString());
        return hmap.get(makeKey(s)).toString();
    }
    public static void insertPair(String keyString, String valueString){
        hmap.put(makeKey(keyString),makeValue(valueString));
    }
    public static String contains(String keyString){
        if(hmap.containsKey(makeKey(keyString))){
            return "true";
        }
        return "false";
    }
    public static String remove(String keyString){
        return hmap.remove(makeKey(keyString)).toString();
    }
    public static String remove(String keyString, String valueString){
        return ((Integer)hmap.remove(makeKey(keyString),makeValue(valueString))).toString();
    }
    
    public static void testMap() throws FileNotFoundException{
        PrintWriter write = openWriteFile();
        insertPair("aaa","bcd");
        insertPair("aaab","bcd");
        insertPair("aaa","bcc");
        insertPair("aaa","acc");
        MyKey k = makeKey("aaa");
//        write.println(hmap.get(makeKey("aaa")).toString());
//        write.println(remove("aaa","bcd"));
//        write.println(hmap.get(makeKey("aaa")).toString());
//        write.println(remove("aaa","bcc"));
//        write.println(hmap.get(makeKey("aaa")).toString());
//        write.println(remove("aaa"));
//        System.out.println(hmap.get(makeKey("aaa")).toString());
//        System.out.println(remove("aaa"));
        //System.out.println(hmap.get(makeKey("aaa")).toString());
        
        System.out.println(remove("aaa"));
        System.out.println(getValues("aaa"));
        System.out.println(contains("aaa"));
        write.close();
    }
    
    public static void main(String[] args) throws FileNotFoundException {
        //listTester();
        int bucketsNumber = 5,aux,counter = 0;
        initHashMap(bucketsNumber);
        Scanner read = openReadFile();
        PrintWriter write = openWriteFile();
        if(read == null){
            return ;
        }
        testNumber = read.nextInt();
        while(counter < testNumber){
            counter++;
            aux = read.nextInt();
            switch(aux){
                case 0:
                    write.println(getValues(read.next()));
                    break;
                case 1:
                    insertPair(read.next(), read.next());
                    break;
                case 2:
                    write.println(contains(read.next()));
                    break;
                case 3:
                    write.println(remove(read.next()));
                    break;
                case 4:
                    write.println(remove(read.next(),read.next()));
                    break;
                default:
                    System.out.println("Wrong input (action type)");
                    break;
            }
        }
        read.close();
        write.close();
//        testMap();
    }

}