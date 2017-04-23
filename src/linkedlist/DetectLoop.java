package linkedlist;

public class DetectLoop {
	public ListNode detectCycle(ListNode head) {

		ListNode slow = head;
		ListNode fast = head;
		boolean isCycle = false;

		while (slow != null && fast != null && fast.next != null) {

			slow = slow.next;
			fast = fast.next.next;
			if (slow.equals(fast)) {
				isCycle = true;
				break;
			}
		}
		if (!isCycle)
			return null;
		slow = head;
		while (!slow.equals(fast)) {

			slow = slow.next;
			fast = fast.next;
		}
		return slow;

	}
}
