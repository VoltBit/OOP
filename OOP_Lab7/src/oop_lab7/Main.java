package oop_lab7;

import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

        static void ex1() throws FileNotFoundException, IOException{
            CopyFile.copyContent("D:\\md5sum.txt");
        }
        static void ex2() throws FileNotFoundException{
            int nr = WordCount.counter("D:\\md5sum.txt");
            System.out.println(nr);
        }
        static void ex3() throws FileNotFoundException{
            int nr = GrepWordFind.finder("D:\\md5sum.txt", "file");
            System.out.println(nr);
        }
        public static void main(String[] args) throws FileNotFoundException, IOException {
            ex1();
            //ex2();
            //ex3();
        }

}
