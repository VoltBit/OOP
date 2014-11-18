package hmaps;

import hmaps.list.List;
import hmaps.list.MyNode;
import hmaps.map.*;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Random;
import java.util.Scanner;

public class HMaps {
    static int testNumber,aux;
    private static Scanner openFile(){
        FileReader file;
        Scanner read;
        try {
            file = new FileReader("/home/smith/java/OOP/HMaps/src/hmaps/test.txt");
            read = new Scanner(file);
            return read;
        } catch (FileNotFoundException ex) {
            System.out.println("File open error");
            return null;
        }
    }
        static void testing_aparatus(){
        int i,j,aux;
        HashMap h = new HashMap(10);
        String[] s = {"abcd","asldkfh","uinoasd","rthydsk","gfhdfgt"
                ,"bgttyhnty","edcvfe"};
        Random rand = new Random();
        for(i = 0; i < 10; i++){
            aux = Math.abs(rand.nextInt() % 7);
            List valList = new List();
            for(j = 0; j < aux + 1; j++){
                aux = Math.abs(rand.nextInt() % 7);
                MyValue v = new MyValue(s[aux]);
                valList.add(v);
            }
            MyKey k = new MyKey(s[aux],valList);
            List keyList = new List();
            keyList.add(k);
           // h.buckets[k.hashCode() % 10] = keyList;
            System.out.print("[" + i + "]");
            System.out.println(h.get(k));
        }
        
    }
    static void getValues(String keyString, HashMap hmap, int bucketNumber){
        List valList = new List();
        MyKey key = new MyKey(keyString,valList);
        int hash = key.hashCode();
        List list = (List)hmap.get(key);
        System.out.println("Values for key " + keyString + ": " + list.toString());
    }
    
    static void insertValue(String keyString, String val, HashMap hmap, int bucketNumber){
        List valList = new List();
        MyKey key = new MyKey(keyString,valList);
        int hash = key.hashCode();
        MyValue v = new MyValue(val);
        if(!hmap.put(key, v)){
            System.out.println("Insert error");
        }
       System.out.println(hmap.get(key).toString());
    }
    static void checkKey(String keyString, HashMap hmap, int bucketNumber){
        List valList = new List();
        MyKey key = new MyKey(keyString,valList);      
        System.out.println(hmap.containsKey(key));
    }
    public static void main(String[] args) {
        int bucketNumber = 5;
        Scanner read = openFile();
        if(read == null){
            return ;
        }
        HashMap hmap = new HashMap(bucketNumber);
        testNumber = read.nextInt();
        
        while(read.hasNextLine()){
            aux = read.nextInt();
            switch(aux){
                case 0:
                    getValues(read.next(),hmap,bucketNumber);
                    break;
                case 1:
                    insertValue(read.next(),read.next(),hmap,bucketNumber);
                    break;
                case 2:
                    checkKey(read.next(),hmap,bucketNumber);
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wrong input (action type)");
                    break;
            }
        }
        read.close();
    }

}