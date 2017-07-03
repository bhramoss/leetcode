package graph;

public class Graph_R2Test {

	public static void main(String[] args){
		Graph_R2 g = new Graph_R2();
		g.addEdge("B", "C");
		g.addEdge("A", "B");
		g.addEdge("A", "D");
		g.addEdge("D", "E");
		g.addEdge("C", "E");
//		g.addEdge("three", "three");
		BFS bfs = new BFS();
		System.out.println("BFS of the graph is as follows");
		bfs.bfs("A", g);
		System.out.println();
		System.out.println("DFS of the graph is as follows");
		DFS dfs = new DFS();
		dfs.dfs("A", g);
	}
}
