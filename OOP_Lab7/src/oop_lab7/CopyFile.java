/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package oop_lab7;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CopyFile {
    static BufferedInputStream in;
    static BufferedOutputStream out;
    public static void copyContent(String fileName) throws FileNotFoundException, IOException{
        String fileOutName = new String();
        fileOutName = fileName.concat("_copy.out");
        FileInputStream fileIn = new FileInputStream(fileName);
        FileOutputStream fileOut = new FileOutputStream(fileOutName);
        in = new BufferedInputStream(fileIn);
        out = new BufferedOutputStream(fileOut);
        int a = in.read();
        while(a != -1){
            a = in.read();
            out.write(a);
        }
    }

}
