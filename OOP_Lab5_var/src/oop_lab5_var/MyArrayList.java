package oop_lab5_var;

public class MyArrayList {
    public int[] a,b;
    private int s = 0,count = 0;
    MyArrayList(){
           this.b = new int[10];
           this.s = 10;
    }
    MyArrayList(int x){
        this.b = new int[x];
        this.s = x;
    }

    public class ArrayIterator implements Iterator{
        int coursor = -1, cookie = size();
        public boolean hasNext(){
            if(coursor < size())return true;
            else return false;
        }
        public Object next(){
            if(!hasNext()){
                return 0;
            }
            if(size() != cookie)return -1;
            coursor++;
            return b[coursor];
        }
    }

    public ArrayIterator iterator(){
        ArrayIterator var = new ArrayIterator();
        
        return var;
    }


    //____________________________________
    public void add(int v){
        if(this.count + 1 == this.s){
            int i;
            int[] aux = new int[2 * this.s];
            for(i = 0; i < count; i++){
                aux[i] = this.b[i];
            }
            this.b = aux;
            s *= 2;
            //System.out.println("Increse");
        }
        this.b[count] = v;
        //System.out.println("IN: " + this.b[count]);
        count++;
    }
    public void display(){
        int i;
        for(i = 0; i < count ;i++){
            System.out.print(this.b[i] + " ");
        }
        //System.out.println(b); <- ???
    }
   boolean contains(int n){
       int i;
       for(i = 0; i < count; i++){
           if(this.b[i] == n)return true;
       }
       return false;
   }
   public int size(){
       return count;
   }
   public int get(int n){
       int i;
       for(i = 0; i < count; i++){
           if(this.b[i] == n)return i;
       }
       return -1;
   }
   public void remove(int index){
       int i;
       for(i = 0; i < count; i++){
           if(i == index){
               int j;
               for(j = index; j < count - 1; j++)
                   this.b[j] = this.b[j + 1];
               count--;
           }
       }
   }
}
