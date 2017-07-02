package graph;

import java.util.LinkedList;
import java.util.List;

//One way to represent a graph
public class Graph_R1 {

	public int v;
	public List<Integer> adjacencyList[];
	
	Graph_R1(int v ){
		this.v = v;
		this.adjacencyList = new LinkedList[v];
		for(int i = 0; i < v; i++){
			adjacencyList[i] = new LinkedList<>();
		}
	}
	
	public void addEdge(int v1, int v2){
		
		adjacencyList[v1].add(v2);
	}

	public int getV() {
		return v;
	}

	public void setV(int v) {
		this.v = v;
	}

	public List<Integer>[] getAdjacencyList() {
		return adjacencyList;
	}

	public void setAdjacencyList(List<Integer>[] adjacencyList) {
		this.adjacencyList = adjacencyList;
	}
	
}
