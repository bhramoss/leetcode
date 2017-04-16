package linkedlist;

// Simple example linked list
public class LLExample {

	Node head;

	private class Node {

		int val;
		Node next;

		public Node(int val) {
			this.val = val;
			this.next = null;
		}

		@Override
		public String toString() {
			return "Node [val=" + val + ", next=" + next + "]";
		}

	}

	private void createLinkedList() {

		head = new Node(1);
		head.next = new Node(2);
		head.next.next = new Node(6);
		head.next.next.next = new Node(4);
	}

	public static void main(String args[]) {

		LLExample list = new LLExample();

		list.createLinkedList();
		while (list.head != null) {

			System.out.println(list.head.val);
			list.head = list.head.next;
		}
	}
}
