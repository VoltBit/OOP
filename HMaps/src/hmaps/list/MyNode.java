package hmaps.list;

public class MyNode implements Node{
    public MyNode nextNode, lastNode;
    public Object content;

    /**
     * Node - main building parts of lists. Nodes are used to
     * build lists and inside the 'content' field can be stored
     * any type of object.
     * @param x is the object representing the content of the node
     */
    public MyNode(Object x){
        this.content = x;
    }
    @Override
    public Node getNext(){
        return this.nextNode;
    }
    @Override
    public Node getPrev(){
        return this.lastNode;
    }
    @Override
    public void setNext(Node node){
        this.nextNode = (MyNode)node;
    }
    @Override
    public void setPrev(Node node){
        this.lastNode = (MyNode)node;
    }
    @Override
    public Object getValue(){
        return this.content;
    }
    @Override
    public boolean equals(Object obj){
        if(obj == null || this.content == null)return false;
        return this.content.equals(obj);
    }
    
    @Override
    public int compareTo(Node o) {
        return 1;
    }
}