package oop_lab5_var;

import java.util.Random;

public class EncrypterFactory {
    //public static String s;
    public static class EncryptionOne implements Encrypt{
        public String encrypt(String x){
            int i;
            String encr = new String();
            for(i = 0; i < x.length(); i++){
                encr += (char)(x.charAt(i) + 1);
            }
            return encr;
        }

        public String decrypt(String x){
            int i;
            String decr = new String();
            for(i = 0; i < x.length(); i++){
                decr += (char)(x.charAt(i) - 1);
            }
            return decr;
        }

    }
    public static class EncryptionTwo implements Encrypt{
        public String encrypt(String x){
            int i;
            String encr = new String();
            for(i = 0; i < x.length(); i++){
                encr += (char)(x.charAt(i) - 5);
            }
            return encr;
        }

        public String decrypt(String x){
            int i;
            String decr = new String();
            for(i = 0; i < x.length(); i++){
                decr += (char)(x.charAt(i) + 5);
            }
            return decr;
        }
    }

    public Encrypt get(){
        Random rand = new Random();
        if(rand.nextBoolean()){
            EncryptionOne en = new EncryptionOne();
            return en;
        }else{
            EncryptionTwo en = new EncryptionTwo();
            return en;
        } 
    }
}
