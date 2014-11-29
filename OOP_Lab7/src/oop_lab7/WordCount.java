
package oop_lab7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCount {
    static int counter(String fileName) throws FileNotFoundException{
        File file = new File(fileName);
        int count = 0;
        Scanner scan = new Scanner(file);
        while(scan.hasNext()){
            System.out.println(scan.next());
            count++;
        }
        return count;
    }
}
