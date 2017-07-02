package graph;

import java.util.Iterator;
import java.util.List;

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
}
