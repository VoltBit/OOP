package oop_lab2;

public class PasswordMaker {
    String alphabet = "abcdefghijklmnopqrstuvwxyz";
    RandomStringGenerator s = new RandomStringGenerator(25,alphabet);
    
    private final int MAGIC_NUMBER = 5;
    private final String MAGIC_STRING = s.next();
    
    String firstName,lastName;
    int age;
    
    PasswordMaker(String firstName, String lastName, int age){
        this.age = age;
        this.firstName = firstName;
        this.lastName = lastName;
    }
    
    public String getPassword(){
        RandomStringGenerator auxGen; 
        auxGen = new RandomStringGenerator(10,this.MAGIC_STRING);
        String auxAlphabet = auxGen.next();
        auxGen = new RandomStringGenerator(this.MAGIC_NUMBER,auxAlphabet);
        String password = auxGen.next();
        return password;
    }
    
}
