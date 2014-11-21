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
    static int testNumber,bucketsNumber = 5;
    public static HashMap hmap;
    public static void initHashMap(int bucketsNumber){
        hmap = new HashMap(bucketsNumber);
    }
    private static Scanner openReadFile(){
        FileReader file;
        Scanner read;
        try {
            file = new FileReader("input.txt");
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
            w = new PrintWriter("output.txt", "UTF-8");
        } catch (UnsupportedEncodingException ex) {
            System.err.println("File not found");
        }
        return w;
    }
    public static boolean loadChecker(int loadLimit){
        int loadFactor;
        loadFactor = hmap.checkLoad()/bucketsNumber;
        return loadFactor > loadLimit;
    }

    /**
     * Balances the loads from buckets. Firstly it checks if current
     * average load is greater than a certain preset load factor
     * (in this case 10). Then it creates an array of keys with all
     * the keys from all the buckets. In the end the keys are redistributed
     * in the buckets array.
     */
    public static void loadBalancer(){
        int loadFactor = 10;
        int i;
        if(loadChecker(loadFactor)){
            List l = new List();
            hmap.gather(l);
            bucketsNumber *= 2;
            initHashMap(bucketsNumber);
            Object[] arrr = new Object[l.size()];
            int sizeArray = l.toArray(arrr);
            for(i = 0; i < sizeArray; i++){
                hmap.put((MyKey)arrr[i]);
            }
        }
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
    
    public static void main(String[] args) throws FileNotFoundException {
        int aux,counter = 0;
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
                    loadBalancer();
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
    }

}