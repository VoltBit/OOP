package oldTests;



public class FailMessage extends Throwable{
    String message;
    public FailMessage(String s){
        this.message = s;
    }
    public FailMessage(){
        this.message = "Test Failed";
    }
}
