package htables;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class HTables {
    int testNumber,aux;
    private Scanner openFile(){
        FileReader file;
        Scanner read;
        try {
            file = new FileReader("input.txt");
            read = new Scanner(file);
            return read;
        } catch (FileNotFoundException ex) {
            System.out.println("File open error");
            return null;
        }
    }
    public void main(String[] args) {
        Scanner read = openFile();
        if(read == null){
            return ;
        }
        this.testNumber = read.nextInt();
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
                    System.out.println("Wrong input");
                    break;
            }
        }
        read.close();
    }

}
