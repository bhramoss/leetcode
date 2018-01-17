package linkedlist;

public class ListNode {

	public int val;
	public ListNode next;

	public ListNode(int value) {

		this.val = value;
		this.next = null;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Node [value=");
		builder.append(val);
		builder.append(", next=");
		builder.append(next);
		builder.append("]");
		return builder.toString();
	}

}
