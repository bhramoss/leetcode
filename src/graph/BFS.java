package graph;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class BFS {

	public void bfs(int start, int v, Graph_R1 g){
		
		List<Integer>adjacencyList[] = g.getAdjacencyList();
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[v];
		visited[start] = true;
		queue.add(start);
		while(!queue.isEmpty()){
			
			start = queue.poll();
			System.out.print(start + " ");
			
			Iterator<Integer> it = adjacencyList[start].iterator();
			while(it.hasNext()){
				int temp = it.next();
				if(!visited[temp]){
					queue.offer(temp);
					visited[temp] = true;
				}
			}
		}
		
	}
	
	public void bfs(String start, Graph_R2 g){
		
		Set<String> set = new HashSet<String>();
		Queue<String> queue = new LinkedList<String>();
		set.add(start);
		queue.offer(start);
		while(!queue.isEmpty()){
			
			start = queue.poll();
			System.out.print(start + " ");
			if(g.map.get(start)!= null){
				Iterator<String> it = g.map.get(start).iterator();
				while(it.hasNext()){
					String temp = it.next();
					if(!set.contains(temp)){
						queue.offer(temp);
						set.add(temp);
					}
				}
				
			}
		}
	}
}
