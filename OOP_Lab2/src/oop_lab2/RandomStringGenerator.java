package oop_lab2;
import java.util.Random;

public class RandomStringGenerator {
    public String alphabet;
    public Integer len;
    RandomStringGenerator(Integer len, String alphabet){
        this.len = len;
        this.alphabet = alphabet;
    }
    
    public String next(){
        int i,aux;
        Random generator = new Random();
        char[] s = this.alphabet.toCharArray();
        char[] randArray = new char[100];
        
        int alphLen = s.length;
        for(i = 0; i < this.len; i++){
            randArray[i] = s[generator.nextInt(alphLen)];
        }
        String randomString = new String(randArray);
        return randomString;
    }
    
}
