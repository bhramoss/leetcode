package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

	public Node deleteDuplicates(Node head) {

		if (head == null)
			return head;

		Map<Integer, Node> map = new HashMap<Integer, Node>();
		Node temp = head;
		while (temp != null) {

			if (map.get(temp.value) == null) {
				map.put(temp.value, temp);

			} else {
				deleteNode(head, temp);
			}
			temp = temp.next;
		}
		return head;

	}

	private void deleteNode(Node node, Node delete) {

		while (node.next != delete) {

			node = node.next;
		}
		node.next = delete.next;

	}

	public static void main(String[] args) {

		RemoveDuplicates obj = new RemoveDuplicates();
		LinkedList list = new LinkedList();
		Node head = new Node(1);
		Node first = list.createNode(2, head);
		Node second = list.createNode(1, first);
		Node third = list.createNode(20, second);
		list.traverseList(head);
		obj.deleteDuplicates(head);
		list.traverseList(head);
	}

}
