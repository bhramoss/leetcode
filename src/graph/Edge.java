package graph;

public class Edge {

	private Vertex vertex1;
	private Vertex vertex2;
	int weight;
	
	public Edge(Vertex v1, Vertex v2, int weight) {

		this.vertex1 = v1;
		this.vertex2 = v2;
		this.weight = weight;
	}

	public Vertex getVertex1() {
		return vertex1;
	}

	public void setVertex1(Vertex vertex1) {
		this.vertex1 = vertex1;
	}

	public Vertex getVertex2() {
		return vertex2;
	}

	public void setVertex2(Vertex vertex2) {
		this.vertex2 = vertex2;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
