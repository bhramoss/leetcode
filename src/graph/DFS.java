package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class DFS {

	private void dfsUtil(int start, Graph_R1 g, boolean[] visited){
		System.out.print(start + " ");
		visited[start] = true;
		List<Integer>[] adj = g.getAdjacencyList();
		Iterator<Integer> it = adj[start].iterator();
		while(it.hasNext()){
			int temp = it.next();
			if(!visited[temp]){
				dfsUtil(temp, g, visited);
			}
		}
	}
	
	public void dfs(int start, Graph_R1 g, int v){
		boolean[] visited = new boolean[v];		
		dfsUtil(start, g, visited);
	}
	
	public void dfs(String start, Graph_R2 g){
		Set<String> visited = new HashSet<String>();
		dfsUtil(start, g, visited);
	}
	
	private void dfsUtil(String start, Graph_R2 g, Set<String> visited){
		visited.add(start);
		System.out.print(start+ " ");
		if(g.map.get(start) != null){
			Iterator<String> it = g.map.get(start).iterator();
			while(it.hasNext()){
				String temp = it.next();
				if(!visited.contains(temp)){
					dfsUtil(temp, g, visited);
				}
			}			
		}
	}
}
