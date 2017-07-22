package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
	
	public boolean detectCycle(Graph_R2 g){
		
		Set<String> visited = new HashSet<String>();
		Set<String> currentStack = new HashSet<String>();
		Map<String, List<String>> map = g.getMap();
		for(Map.Entry<String, List<String>> entry : map.entrySet()){
			if(detectCycleUtil(map, visited, currentStack, entry.getKey())){
				return true;
			}
		}
		return false;
	}
	private boolean detectCycleUtil(Map<String, List<String>> map, Set<String> visited, Set<String> currentStack, String start){
		
		visited.add(start);
		currentStack.add(start);
		if(map.get(start) != null){
			Iterator<String> it = map.get(start).iterator();
			while(it.hasNext()){
				String temp = it.next();
				if(!visited.contains(temp) && detectCycleUtil(map, visited, currentStack, temp)){
					return true;
				}else if(currentStack.contains(temp)){
					return true;
				}
			}			
		}
		currentStack.remove(start);
		return false;
	}
	
	public static void main(String[] args){
		Graph_R1 g1 = new Graph_R1(4);
		g1.addEdge(0, 1);
	    g1.addEdge(1,0);
	    g1.addEdge(0,3);
	    g1.addEdge(1,3);
	    g1.addEdge(1, 2);
	    DetectCycle detect = new DetectCycle();
	    if(detect.detectCycle(g1)){
	    	System.out.println("Graph is cyclic");
	    }else{
	    	System.out.println("Graph does not have a cycle");
	    }
		Graph_R2 g = new Graph_R2();
		g.addEdge("A", "B");
		g.addEdge("A", "C");
		g.addEdge("B", "C");
		g.addEdge("C", "A");
		g.addEdge("C", "D");
	    
	    if(detect.detectCycle(g)){
	    	System.out.println("Graph is cyclic");
	    }else{
	    	System.out.println("Graph does not have a cycle");
	    }
	    
	}
}
