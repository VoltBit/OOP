package thewar2.graph;

public class GraphVertex implements Vertex {

    Object content;
    GraphVertex parent;
    int label;
    
    GraphVertex(GraphVertex p, Object c, int l){
        this.label = l;
        this.content = c;
        this.parent = p;
    }
    GraphVertex(Object c, int l){
        this.content = c;
        this.label = l;
        this.parent = null;
    }
    GraphVertex(int l){
        this.label = l;
        this.content = null;
        this.parent = null;
    }
    
    @Override
    public Object getContent() {
        return this.content;
    }

    @Override
    public Vertex getParent() {
        return this.parent;
    }
    
    @Override
    public boolean equals(Object o){
        return this.content.equals(o);
    }
    @Override
    public String toString(){
        if(this.content == null)return "Empty node - root";
        return this.content.toString();
    }
}
