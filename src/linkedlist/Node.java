package linkedlist;

public class Node {

	int value;
	Node next;

	public Node(int value) {

		this.value = value;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [value=");
		builder.append(value);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}

}
