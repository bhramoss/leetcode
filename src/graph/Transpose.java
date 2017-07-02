package graph;

import java.util.Iterator;
import java.util.List;

public class Transpose {

	
	public Graph_R1 transpose(Graph_R1 g, int v){
		
		List<Integer> adj[] = g.getAdjacencyList();
		Graph_R1 g2 = new Graph_R1(v);
		for(int i = 0; i < v; i++){
			Iterator<Integer> it = adj[i].iterator();
			while(it.hasNext()){
				g2.adjacencyList[it.next()].add(i);
			}
		}
		return g2;
	}
	
}
