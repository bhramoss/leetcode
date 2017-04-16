package linkedlist;

public class LinkedList {

	public Node createNode(int data, Node current) {

		Node node = new Node(data);
		current.next = node;
		return node;
	}

	public void traverseList(Node node) {

		while (node != null) {
			System.out.print(node.value + " ");
			node = node.next;
		}
		System.out.println();
	}

	public Node insertFront(Node head, int data) {

		Node node = new Node(data);

		node.next = head;
		head = node;
		return head;
	}

	public void insertMiddle(Node prev, int data) {

		System.out.println("Inserting after: " + prev.value);
		Node temp = new Node(data);
		temp.next = prev.next;
		prev.next = temp;
	}

	public void insertEnd(Node head, int data) {

		Node end = new Node(data);
		Node temp = head;
		while (temp.next != null) {

			temp = temp.next;
		}
		temp.next = end;
		end.next = null;

	}
}
