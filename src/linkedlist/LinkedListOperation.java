package linkedlist;

public class LinkedListOperation {

	public static void main(String[] args) {

		LinkedList list = new LinkedList();
		ListNode head = new ListNode(1);
		ListNode first = list.createNode(2, head);
		ListNode second = list.createNode(5, first);
		ListNode third = list.createNode(20, second);
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
