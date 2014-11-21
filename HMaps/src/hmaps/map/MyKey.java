package hmaps.map;

import hmaps.list.List;
import hmaps.list.MyNode;

public class MyKey implements Key{
    public String key;
    List valueList = new List();
    
    public MyKey(String input, List valList){
        this.key = input;
        this.valueList = valList;
    }
    public List getValues(){
        return this.valueList;
    }

    /**
     * inserts a value inside valueList keeping the list sorted
     * @param v value to be inserted in valueList
     */
    public void insertValue(Value v){
        MyNode n = (MyNode)this.valueList.getFirstEqual(v);
        if(n != null){
            ((MyValue)n.getValue()).increaseOccurrence();
            this.valueList.increaseSize();
            //System.out.println("1");
            return;
        }
        if(this.valueList.size() > 0){
            n = (MyNode)this.valueList.getSortedPosition(v);
            this.valueList.insertBefore(n,v);
            //System.out.println("2");
        }
        else{
            //System.out.println("3");
            this.valueList.add(v);
        }
    }
    @Override
    public int hashCode(){
        int i,sum = 0,code = 19;
        for(i = 0; i < key.length(); i++){
            sum += this.key.charAt(i) % 19;
        }
        return sum;
    }
    @Override
    public boolean equals(Object other){
        return this.key.equals(((MyKey)other).key);
    }
    @Override
    public int compareTo(Key o) {
        return this.key.compareTo(((MyKey)o).key);
    }
    @Override
    public String toString() {
        return this.valueList.toString();
    }
}
