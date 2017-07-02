package graph;

import java.util.Iterator;
import java.util.List;

public class DetectCycle {

	public boolean detectCycle(Graph_R1 g){
		
		int size = g.getAdjacencyList().length;
		boolean[] visited = new boolean[size];
		boolean[] currentStack = new boolean[size];
		for(int i = 0; i < size; i++){
			if(detectCycleUtl(g.getAdjacencyList(),i,visited,currentStack)){
				return true;				
			}
		}
		return false;
	}
	
	private boolean detectCycleUtl(List<Integer> adj[],int start, boolean[] visited, boolean[] currentStack){
		
		visited[start] = true;
		currentStack[start] = true;
		
		Iterator<Integer> it = adj[start].iterator();
		while(it.hasNext()){
			int temp = it.next();
			if(!visited[temp] && detectCycleUtl(adj, temp, visited, currentStack)){
				return true;
			}else if(currentStack[temp]){
				return true;
			}
		}
		currentStack[start] = false;
		return false;
	}
	
	public static void main(String[] args){
		Graph_R1 g = new Graph_R1(4);
		g.addEdge(0, 1);
	    g.addEdge(0,2);
	    g.addEdge(0,3);
	    g.addEdge(1,3);
	    g.addEdge(1, 2);
//	    g.addEdge(3, 0);
//	    g.addEdge(2, 3);
//	    g.addEdge(3, 3);
	    DetectCycle detect = new DetectCycle();
	    if(detect.detectCycle(g)){
	    	System.out.println("Graph is cyclic");
	    }else{
	    	System.out.println("Graph does not have a cycle");
	    }
	}
}
