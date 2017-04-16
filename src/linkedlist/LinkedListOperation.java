package linkedlist;

public class LinkedListOperation {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		Node head = new Node(1);
		Node first = list.createNode(2, head);
		Node second = list.createNode(5, first);
		Node third = list.createNode(20, second);
		list.traverseList(head);

		// Anomaly
		head = list.insertFront(head, 100);
		list.traverseList(head);

		// list.insertMiddle(second, 150);
		// list.traverseList(head);

		// list.insertEnd(head, 200);
		// list.traverseList(head);
	}
}
