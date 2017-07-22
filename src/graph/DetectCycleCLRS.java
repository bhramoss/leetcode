package graph;

import java.util.Iterator;

public class DetectCycleCLRS {
	
	public boolean isCyclicColor(Graph_R1 g, int v){
		
		String[] color = new String[v];
		boolean[] visited = new boolean [v];
		for(int i = 0; i < v; i++){
			if(isCyclicColorUtil(g, color, i, visited)){
				return true;
			}
		}
		return false;
	}
	
	private boolean isCyclicColorUtil(Graph_R1 g, String[] color, int start, boolean[] visited){
		
		visited[start] = true;
		color[start] = "grey";
		
		Iterator<Integer> it = g.getAdjacencyList()[start].iterator();
		while(it.hasNext()){
			int temp = it.next();
			if(!visited[temp] && isCyclicColorUtil(g, color, temp, visited)){
				return true;
			}else if(color[temp] == "grey"){
				return true;
			}
		}
		color[start] = "white";
		return false;
	}

	public static void main(String[] args){
		DetectCycleCLRS obj = new DetectCycleCLRS();
		Graph_R1 g1 = new Graph_R1(4);
		g1.addEdge(0, 1);
	    g1.addEdge(1,0);
	    g1.addEdge(0,3);
	    g1.addEdge(1,3);
	    g1.addEdge(1, 2);
	    System.out.println(obj.isCyclicColor(g1, 4));
	}
}
