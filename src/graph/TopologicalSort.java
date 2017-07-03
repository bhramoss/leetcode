package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class TopologicalSort {

	public Stack<Integer> toposort(Graph_R1 g, int v){
		
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		List<Integer> adj[] = g.getAdjacencyList();
		for(int i = 0; i < v; i++){
			if(visited.contains(i)){
				continue;
			}
			topoUtil(i, stack, visited, adj);
		}
		return stack;
		
	}
	
	private void topoUtil(int vertex, Stack<Integer> stack, Set<Integer> visited, List<Integer> adj[]){
		
		visited.add(vertex);
		Iterator<Integer> it = adj[vertex].listIterator();
		while(it.hasNext()){
			int childVertex = it.next();
			if(visited.contains(childVertex)){
				continue;
			}
			topoUtil(childVertex, stack, visited, adj);
		}
		stack.push(vertex);
	}
	
	public static void main(String[] args){

		Graph_R1 g = new Graph_R1(6);
		g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        TopologicalSort topo = new TopologicalSort();
        Stack<Integer> result = topo.toposort(g, 6);
        while(!result.isEmpty()){
        	System.out.println(result.pop());
        }
	}
}
