package thewar.list;

public class List extends AbstractList{

    int nodeCounter = 0;

    /**
     * Double linked list. Fields 'first' and 'last' are empty nodes
     * pointing with their 'nextNode' and 'lastNode' links to the
     * first and last elements of the list.
     */
    public List(){
        MyNode n = new MyNode(null);
        this.first = n;
        this.last = n;
        ((MyNode)this.first).nextNode = null;
        ((MyNode)this.last).lastNode = null;
    }
    @Override
    public Node getFirstEqual(Object obj) {
        if(this.size() == 0)return null;
        MyNode aux = ((MyNode)this.first).nextNode;
        if(aux == null){System.out.println("?"); return null;}
        do{
            if(aux.equals(obj)){
                return aux;
            }
            aux = aux.nextNode;
        }while(aux != ((MyNode)this.first).nextNode);
        return null;
    }

    @Override
    public Node getSortedPosition(Object value) {/*
        MyNode aux = ((MyNode)this.first).nextNode;
        do{
            if(((MyValue)aux.getValue()).compareTo((MyValue)value) >= 0){
                return aux;
            }
            aux = aux.nextNode;
        }while(aux != ((MyNode)this.first).nextNode);*/
        return null;
    }

    @Override
    public void insertBefore(Node node, Object nodeContent) {
        if(node == null){
            this.add(nodeContent);
            return;
        }
        MyNode x = new MyNode(nodeContent);
        if(node == ((MyNode)this.first).getNext()){
            //System.out.print("(First)");
            ((MyNode)this.first).setNext(x);
            ((MyNode)this.last).lastNode.setNext(x);
        }
        x.setNext(node);
        x.setPrev(((MyNode)node).lastNode);
        ((MyNode)node).lastNode.setNext(x);
        ((MyNode)node).setPrev(x);
        this.nodeCounter++;
    }

    @Override
    public void add(Object nodeContent) {
        if(nodeContent == null){System.out.println("Test");}
        MyNode x = new MyNode(nodeContent);
        if(this.size() == 0){
            ((MyNode)this.first).nextNode = x;
            ((MyNode)this.last).lastNode = x;
            x.setNext(x);
            x.setPrev(x);
        }else{
            x.setPrev(((MyNode)this.last).lastNode);
            x.setNext(((MyNode)this.first).nextNode);
            ((MyNode)this.last).lastNode.setNext(x);
            ((MyNode)this.last).setPrev(x);
            ((MyNode)this.first).nextNode.setPrev(x);
        }
        this.nodeCounter++;
    }

    @Override
    public void remove(Node node) {
        MyNode aux = ((MyNode)this.first).nextNode;
        MyNode aux2 = new MyNode(null);
        if(((MyNode)node).equals(((MyNode)this.first).nextNode.content) && 
                ((MyNode)node).equals(((MyNode)this.last).lastNode.content)){
            aux = null;
            ((MyNode)node).nextNode = aux2;
            ((MyNode)node).lastNode = aux2;
            ((MyNode)this.first).nextNode = aux2;
            ((MyNode)this.last).lastNode = aux2;
            this.first = aux2;
            this.first = aux2;
            ((MyNode)this.first).nextNode = null;
            ((MyNode)this.last).lastNode = null;
            this.nodeCounter = 0;
            return;
        }
        if(((MyNode)node).equals(((MyNode)this.first).nextNode.content)){
            ((MyNode)this.first).nextNode = ((MyNode)node).nextNode;
            ((MyNode)aux.lastNode).nextNode = (MyNode)aux.nextNode;
            ((MyNode)aux.nextNode).lastNode = (MyNode)aux.lastNode;
            aux = null;
            this.nodeCounter--;
            return;
        }else{
            if(((MyNode)node).equals(((MyNode)this.last).lastNode.content)){
                aux = ((MyNode)this.last).lastNode;
                ((MyNode)this.last).lastNode = ((MyNode)node).lastNode;
                ((MyNode)aux.lastNode).nextNode = (MyNode)aux.nextNode;
                ((MyNode)aux.nextNode).lastNode = (MyNode)aux.lastNode;
                aux = null;
                this.nodeCounter--;
                return;
            }
        }
        do{
            if(aux.equals(((MyNode)node).content)){
                ((MyNode)aux.lastNode).nextNode = (MyNode)aux.nextNode;
                ((MyNode)aux.nextNode).lastNode = (MyNode)aux.lastNode;
                aux2 = aux;
                aux = aux.nextNode;
                aux2 = null;
                this.nodeCounter--;
            }else{
                aux = aux.nextNode;
            }
        }while(aux != ((MyNode)this.first).nextNode);
    }
    @Override
    public int size() {
        return nodeCounter;
    }
    public void increaseSize(){
        this.nodeCounter++;
    }
    @Override
    public String toString() {
        String s = new String();
        MyNode aux = ((MyNode)this.first).nextNode;
        if(aux == null || this.size() == 0){
            return "null";
        }
        if(aux.getValue() == null)return s;
        do{
            if(aux.getValue() != null){
                s = s.concat(aux.getValue().toString()).concat(" ");
                aux = aux.nextNode;
            }else{
                System.err.println("_null error - bad node links");
                break;
            }
        }while(aux != ((MyNode)this.first).nextNode);
        return s;
    }

    /**
     * Makes a copy of the current list.
     * @param copyList is the list to which all the nodes are copied.
     */
    public void copy(List copyList){
        MyNode aux = ((MyNode)this.first).nextNode;
        if(aux == null)return;
        do{
            copyList.add(aux.content);
            aux = aux.nextNode;
        }while(aux != ((MyNode)this.first).nextNode);
    }

    /**
     * Creates an array with the contents of each node.
     * @param array the object array where all the contents of the
     * nodes will be copied
     * @return return the size of array
     */
    public int toArray(Object[] array){
        int i = 0;
        MyNode aux = ((MyNode)this.first).nextNode;
        do{
            array[i] = aux.content;
            aux = aux.nextNode;
            i++;
        }while(aux != ((MyNode)this.first).nextNode);
        return i;
    }
}