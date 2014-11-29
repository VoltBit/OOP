/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop_lab7;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Student
 */

public class GrepWordFind {

    public int altfel(String f) throws FileNotFoundException, IOException{
        int count = 0;
        BufferedReader r = new BufferedReader(new FileReader(f));
        String aux;
        while(r.read() != -1){
            aux = r.readLine();
        }
        return count;
    }
    static int finder(String fileName, String toFind) throws FileNotFoundException{
        File file = new File(fileName);
        String aux;
        int count = 0;
        Scanner scan = new Scanner(file);
        scan.useDelimiter(System.getProperty("line.separator"));
        while(scan.hasNext()){
            aux = scan.next();
            if(aux.contains(toFind)){
                System.out.println(aux);
                return count;
            }
            count++;
        }
        return count;
    }
}
