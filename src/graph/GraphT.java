package graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphT<T>{

    private List<EdgeT<T>> allEdges;
    private Map<Long,VertexT<T>> allVertex;
    boolean isDirected = false;
    
    public GraphT(boolean isDirected){
        allEdges = new ArrayList<EdgeT<T>>();
        allVertex = new HashMap<Long,VertexT<T>>();
        this.isDirected = isDirected;
    }
    
    public void addEdge(long id1, long id2){
        addEdge(id1,id2,0);
    }
    
    //This works only for directed graph because for undirected graph we can end up
    //adding edges two times to allEdges
    public void addVertex(VertexT<T> vertex){
        if(allVertex.containsKey(vertex.getId())){
            return;
        }
        allVertex.put(vertex.getId(), vertex);
        for(EdgeT<T> edge : vertex.getEdges()){
            allEdges.add(edge);
        }
    }
    
    public VertexT<T> addSingleVertex(long id){
        if(allVertex.containsKey(id)){
            return allVertex.get(id);
        }
        VertexT<T> v = new VertexT<T>(id);
        allVertex.put(id, v);
        return v;
    }
    
    public VertexT<T> getVertex(long id){
        return allVertex.get(id);
    }
    
    public void addEdge(long id1,long id2, int weight){
        VertexT<T> vertex1 = null;
        if(allVertex.containsKey(id1)){
            vertex1 = allVertex.get(id1);
        }else{
            vertex1 = new VertexT<T>(id1);
            allVertex.put(id1, vertex1);
        }
        VertexT<T> vertex2 = null;
        if(allVertex.containsKey(id2)){
            vertex2 = allVertex.get(id2);
        }else{
            vertex2 = new VertexT<T>(id2);
            allVertex.put(id2, vertex2);
        }

        EdgeT<T> edge = new EdgeT<T>(vertex1,vertex2,isDirected,weight);
        allEdges.add(edge);
        vertex1.addAdjacentVertex(edge, vertex2);
        if(!isDirected){
            vertex2.addAdjacentVertex(edge, vertex1);
        }

    }
    
    public List<EdgeT<T>> getAllEdges(){
        return allEdges;
    }
    
    public Collection<VertexT<T>> getAllVertex(){
        return allVertex.values();
    }
    public void setDataForVertex(long id, T data){
        if(allVertex.containsKey(id)){
            VertexT<T> vertex = allVertex.get(id);
            vertex.setData(data);
        }
    }

    @Override
    public String toString(){
        StringBuffer buffer = new StringBuffer();
        for(EdgeT<T> edge : getAllEdges()){
            buffer.append(edge.getVertex1() + " " + edge.getVertex2() + " " + edge.getWeight());
            buffer.append("\n");
        }
        return buffer.toString();
    }
}


class VertexT<T> {
    long id;
    private T data;
    private List<EdgeT<T>> edges = new ArrayList<>();
    private List<VertexT<T>> adjacentVertex = new ArrayList<>();
    
    VertexT(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void addAdjacentVertex(EdgeT<T> e, VertexT<T> v){
        edges.add(e);
        adjacentVertex.add(v);
    }
    
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<VertexT<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<EdgeT<T>> getEdges(){
        return edges;
    }
    
    public int getDegree(){
        return edges.size();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        VertexT other = (VertexT) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

class EdgeT<T>{
    private boolean isDirected = false;
    private VertexT<T> vertex1;
    private VertexT<T> vertex2;
    private int weight;
    
    EdgeT(VertexT<T> vertex1, VertexT<T> vertex2){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
    }

    EdgeT(VertexT<T> vertex1, VertexT<T> vertex2,boolean isDirected,int weight){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.weight = weight;
        this.isDirected = isDirected;
    }
    
    EdgeT(VertexT<T> vertex1, VertexT<T> vertex2,boolean isDirected){
        this.vertex1 = vertex1;
        this.vertex2 = vertex2;
        this.isDirected = isDirected;
    }
    
    VertexT<T> getVertex1(){
        return vertex1;
    }
    
    VertexT<T> getVertex2(){
        return vertex2;
    }
    
    int getWeight(){
        return weight;
    }
    
    public boolean isDirected(){
        return isDirected;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((vertex1 == null) ? 0 : vertex1.hashCode());
        result = prime * result + ((vertex2 == null) ? 0 : vertex2.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        EdgeT other = (EdgeT) obj;
        if (vertex1 == null) {
            if (other.vertex1 != null)
                return false;
        } else if (!vertex1.equals(other.vertex1))
            return false;
        if (vertex2 == null) {
            if (other.vertex2 != null)
                return false;
        } else if (!vertex2.equals(other.vertex2))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Edge [isDirected=" + isDirected + ", vertex1=" + vertex1
                + ", vertex2=" + vertex2 + ", weight=" + weight + "]";
    }
}