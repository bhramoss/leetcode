package linkedlist;

public class RemoveElements {

    public ListNode removeElements(ListNode head, int val) {
        
        if(head == null || (head.val == val && head.next == null)) return null;

        
        ListNode temp = head;
        
        while(temp != null && temp.next != null){
            
            if(temp.next.val == val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

	public static void main(String[] args) {

		RemoveElements obj = new RemoveElements();
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(1);
		ListNode first = list.createNode(1, head);
//		Node second = list.createNode(1, first);
//		Node third = list.createNode(20, second);
		list.traverseList(head);
		head = obj.removeElements(head, 1);
		list.traverseList(head);
	}
    
}
