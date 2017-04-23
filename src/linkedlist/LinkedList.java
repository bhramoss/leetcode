package linkedlist;

public class LinkedList {

	public ListNode createNode(int data, ListNode current) {

		ListNode node = new ListNode(data);
		current.next = node;
		return node;
	}

	public void traverseList(ListNode node) {

		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}

	public ListNode insertFront(ListNode head, int data) {

		ListNode node = new ListNode(data);

		node.next = head;
		head = node;
		return head;
	}

	public void insertMiddle(ListNode prev, int data) {

		System.out.println("Inserting after: " + prev.val);
		ListNode temp = new ListNode(data);
		temp.next = prev.next;
		prev.next = temp;
	}

	public void insertEnd(ListNode head, int data) {

		ListNode end = new ListNode(data);
		ListNode temp = head;
		while (temp.next != null) {

			temp = temp.next;
		}
		temp.next = end;
		end.next = null;

	}
}
