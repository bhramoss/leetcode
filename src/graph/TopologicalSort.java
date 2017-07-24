package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
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
	
	//Topological sort using an alternate representation of graph: Map for strings
	public Stack<String> toposort(Graph_R2 g){
		
		Set<String> visited = new HashSet<String>();
		Stack<String> stack = new Stack<String>();
		Map<String, List<String>> map = g.getMap();
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			if(!visited.contains(entry.getKey())){
				topoUtil(stack, visited, map, entry.getKey());				
			}
		}
		return stack;
	}
	
	private void topoUtil(Stack<String> stack, Set<String> visited, Map<String, List<String>> map, String start){
		
		visited.add(start);
		if(map.get(start) != null){
			Iterator<String> it = map.get(start).iterator();
			while(it.hasNext()){
				String temp = it.next();
				if(!visited.contains(temp)){
					topoUtil(stack, visited, map, temp);
				}
			}			
		}
		stack.push(start);
	}
	
	//Topological sort using an alternate representation of graph: Map for strings

	public Stack<Character> toposort(Graph_R3 g){
		
		Set<Character> visited = new HashSet<>();
		Stack<Character> stack = new Stack<>();
		Map<Character, List<Character>> map = g.getMap();
		for(Map.Entry<Character, List<Character>> entry : map.entrySet()){
			if(!visited.contains(entry.getKey())){
				topoUtil(stack, visited, map, entry.getKey());
			}
		}
		return stack;
	}
	
	private void topoUtil(Stack<Character> stack, Set<Character> visited, Map<Character, List<Character>> map, char start){
		
		visited.add(start);
		if(map.get(start)!= null){
			
			Iterator<Character> it = map.get(start).iterator();
			while(it.hasNext()){
				char temp = it.next();
				if(!visited.contains(temp)){
					topoUtil(stack, visited, map, temp);
				}
			}
		}
		stack.push(start);
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
        System.out.println("Topological sort for graph 1: ");
        while(!result.isEmpty()){
        	System.out.print(result.pop() + " ");
        }
        System.out.println();
        System.out.println("Topological sort for graph 2: ");        
        Graph_R2 g2 = new Graph_R2();
        g2.addEdge("A", "C");
        g2.addEdge("C", "B");
        g2.addEdge("B", "A");        
        g2.addEdge("B", "D");
        g2.addEdge("C", "E");
        g2.addEdge("E", "H");
        g2.addEdge("E", "F");
        g2.addEdge("F", "G");
        g2.addEdge("D", "F");
        Stack<String> result2 = topo.toposort(g2);
        while(!result2.isEmpty()){
        	System.out.print(result2.pop() + " ");
        }
        
	}
}
