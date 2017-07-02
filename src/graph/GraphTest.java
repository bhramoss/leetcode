package graph;

public class GraphTest {

	public static void main(String[] args){
		Graph_R1 g = new Graph_R1(5);
		BFS bfs = new BFS();
		g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(1, 2);
        g.addEdge(2, 0);
        g.addEdge(2, 3);
        g.addEdge(3, 3);
        System.out.println("BFS of the graph is: ");
        bfs.bfs(2, 5, g);
        DFS dfs = new DFS();
        System.out.println();
        System.out.println("DFS of the graph is: ");
        dfs.dfs(2, g, 5);
        Transpose transpose = new Transpose();
        Graph_R1 g2 = transpose.transpose(g, 5);
        System.out.println();
        System.out.println("DFS of transpose of the Graph: ");
        dfs.dfs(2, g2, 5);
	}
}
