package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class RemoveDuplicates {

	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return head;

		Map<Integer, ListNode> map = new HashMap<Integer, ListNode>();
		ListNode temp = head;
		while (temp != null) {

			if (map.get(temp.val) == null) {
				map.put(temp.val, temp);

			} else {
				deleteNode(head, temp);
			}
			temp = temp.next;
		}
		return head;

	}

	private void deleteNode(ListNode node, ListNode delete) {

		while (node.next != delete) {

			node = node.next;
		}
		node.next = delete.next;

	}

	public static void main(String[] args) {

		RemoveDuplicates obj = new RemoveDuplicates();
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(1);
		ListNode first = list.createNode(2, head);
		ListNode second = list.createNode(1, first);
		ListNode third = list.createNode(20, second);
		list.traverseList(head);
		obj.deleteDuplicates(head);
		list.traverseList(head);
	}

}
