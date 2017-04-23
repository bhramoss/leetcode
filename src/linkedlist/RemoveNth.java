package linkedlist;

public class RemoveNth {

	public ListNode removeNthFromEnd(ListNode head, int n) {
	    
	    ListNode start = new ListNode(0);
	    ListNode slow = start, fast = start;
	    slow.next = head;
	    
	    //Move fast in front so that the gap between slow and fast becomes n
	    for(int i=1; i<=n+1; i++)   {
	        fast = fast.next;
	    }
	    //Move fast to the end, maintaining the gap
	    while(fast != null) {
	        slow = slow.next;
	        fast = fast.next;
	    }
	    //Skip the desired node
	    slow.next = slow.next.next;
	    return start.next;
	}
	
	public static void main(String args[]){
		
		RemoveNth obj = new RemoveNth();
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(1);
		ListNode first = list.createNode(2, head);
		ListNode second = list.createNode(10,first);
		ListNode third = list.createNode(20, second);
		obj.removeNthFromEnd(head, 2);

		
	}
}
