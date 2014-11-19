package hmaps;

import hmaps.list.List;
import hmaps.list.MyNode;
import hmaps.map.HashMap;
import hmaps.map.MyKey;
import hmaps.map.MyValue;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HMaps {
    static int testNumber;
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
        MyKey k = new MyKey(test[2],l);
        MyKey k2 = new MyKey(test[3],l2);
        h.put(k,v1[1]);
        h.put(k2,v1[1]);
        h.put(k,v1[5]);
        h.put(k2,v1[6]);
        h.put(k,v1[3]);
//        System.out.println(h.get(k));
//        System.out.println(h.get(k2));
        
        List tst = new List();
        tst.add(k);
        tst.add(k2);
        System.out.println(((MyNode)tst.getFirstEqual(k2)).content.toString());
        System.out.println(((MyNode)tst.getFirstEqual(k)).content.toString());
    }
    
    public static void main(String[] args) {
        
        
        listTester();
        
        
        
        
        
        
        
        
        
        
        int bucketNumber = 5;
        Scanner read = openFile();
        if(read == null){
            return ;
        }
        HashMap hmap = new HashMap(bucketNumber);
        testNumber = read.nextInt();
        
        /*
        while(read.hasNextLine()){
            aux = read.nextInt();
            switch(aux){
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Wrong input (action type)");
                    break;
            }
        }*/
        read.close();
    }

}