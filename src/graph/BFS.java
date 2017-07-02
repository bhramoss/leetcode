package graph;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

	public void bfs(int start, int v,Graph_R1 g){
		
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
}
