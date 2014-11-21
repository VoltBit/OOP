package hmaps.map;

public class MyValue implements Value{
    public String content;
    public int occurence;
    public MyValue(String s){
        this.content = s;
        this.occurence = 1;
    }
    @Override
    public boolean equals(Object other){
        if(this.content == null || other == null)return false;
        return this.content.equals(((MyValue)other).content);
    }
    @Override
    public int compareTo(Value o) {
        return this.content.compareTo(((MyValue)o).content);
    }
    @Override
    public String toString() {
        String a = "(";
        a = a.concat(this.content).concat(", ")
                .concat(((Integer)this.occurence).toString()).concat(")");
        return a;
    }

    /**
     * Increases number of occurrence of a value inside a list. 
     */
    public void increaseOccurrence(){
        this.occurence++;
    }
}
