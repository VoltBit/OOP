package hmaps.map;

import hmaps.list.AbstractList;
import hmaps.list.List;
import hmaps.list.MyNode;

public class HashMap extends AbstractHashMap{

    int bucketsNumber;
    public HashMap(int bNumber){
        this.bucketsNumber = bNumber;
        this.buckets = new List[bNumber];
    }
    
    @Override
    public AbstractList get(Key key) {
        int index = (key.hashCode() + this.bucketsNumber) % this.bucketsNumber;
        List l = (List)this.buckets[index];
        if(l == null)return null;
        MyNode aux = (MyNode)l.getFirstEqual((MyKey)key);
        if(aux == null){
            return null;
        }
        return ((MyKey)aux.getValue()).getValues();
    }

    @Override
    public boolean containsKey(Key key) {
        int index = (((MyKey)key).hashCode() + this.bucketsNumber) % this.bucketsNumber;
        if(this.buckets[index] == null)return false;
        if(((List)this.buckets[index]).getFirstEqual((MyKey)key) == null)return false;
        return true;
    }

    @Override
    public boolean put(Key key, Value value) {
        int index = (((MyKey)key).hashCode() + this.bucketsNumber) % this.bucketsNumber;
        if(this.containsKey(key)){
            MyNode aux = (MyNode)((List)this.buckets[index]).getFirstEqual((MyKey)key);
            ((MyKey)aux.getValue()).insertValue((MyValue)value);
            return false;
        }else{
            if(this.buckets[index] == null){
                this.buckets[index] = new List();
            }
            ((MyKey)key).insertValue((MyValue)value);
            this.buckets[index].add((MyKey)key);
            return true;
        }
    }

    /**
     * Inserts a key in a bucket - used in load balancing.
     * @param key
     */
    public void put(Key key){
        int index = (((MyKey)key).hashCode() + this.bucketsNumber) % this.bucketsNumber;
        if(this.buckets[index] == null){
            this.buckets[index] = new List();
        }
        this.buckets[index].add((MyKey)key);
    }
    @Override
    public int remove(Key key, Value value) {
        int index = (((MyKey)key).hashCode() + this.bucketsNumber) % this.bucketsNumber;
        if(this.buckets[index] == null)return 0;
        MyNode aux = (MyNode)((List)this.buckets[index]).getFirstEqual((MyKey)key);
        if(aux == null)return 0;
        List auxl = ((MyKey)aux.content).getValues();
        if(auxl == null)return 0;
        MyNode r = (MyNode)auxl.getFirstEqual(value);
        if(r == null){
            return 0;
        }
        int rval = ((MyValue)r.content).occurence;
        auxl.remove(r);
        if(auxl.size() == 0){
            ((List)this.buckets[index]).remove(aux);
            if(((List)this.buckets[index]).size() == 0){
                this.buckets[index] = null;
            }
        }
        return rval;
    }

    @Override
    public AbstractList remove(Key key) {
        int index = (((MyKey)key).hashCode() + this.bucketsNumber) % this.bucketsNumber;
        List raux = (List)this.get(key);
        if(this.buckets[index] == null)return new List();
        if(raux == null){
            //if(this.buckets[index].size() == 0)this.buckets[index] = null;
            return new List();
        }
        MyNode aux = (MyNode)this.buckets[index].getFirstEqual(key);
        if(aux == null){
            return null;
        }
        this.buckets[index].remove(aux);
        if(this.buckets[index].size() == 0)this.buckets[index] = null;
        return raux;
    }
    public int checkLoad(){
        int i,sum = 0;
        for(i = 0; i < this.bucketsNumber; i++){
            if(this.buckets[i] != null)
                sum += this.buckets[i].size();
        }
        return sum;
    }
    
    /**
     * Goes through the buckets array and copies all the keys
     * to the list given.
     * @param keys is the list to which all the keys are copied
     */
    public void gather(List keys){
        int i;
        for(i = 0; i < this.bucketsNumber; i++){
            if(this.buckets[i] != null){
                ((List)this.buckets[i]).copy(keys);
            }
        }
    }
}