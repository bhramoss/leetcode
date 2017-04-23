package linkedlist;

public class AddNumber2 {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    int carry = 0;
    ListNode resultList = new ListNode(0);
    ListNode temp = resultList;
    l1 = reverse(l1);
    l2 = reverse(l2);
    while(l1 != null || l2 != null || carry == 1){
    	
    	int result = 0;
    	
    	if(l1 == null && l2 == null){
    		temp.next = new ListNode(carry);
    	    resultList = reverse(resultList);
    	    return removeLast(resultList);
    	}
    	if(l1 != null) result += l1.val;
    	if(l2 != null) result += l2.val;
    	result += carry;
    	carry = 0;
    	if(result > 9){
    		carry = 1;
    		result = result - 10;
    	}
    	
    	ListNode node = new ListNode(result);
    	temp.next = node;
    	temp = temp.next;
    	if(l1 != null)
    	l1 = l1.next;
    	if(l2 != null)
    	l2 = l2.next;
    	
    }
    resultList = reverse(resultList.next);
    return removeLast(resultList);
    	
    }
            
    private ListNode reverse(ListNode node){

        ListNode current = node;
        ListNode next = null;
        ListNode prev = null;
        
             while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        node = prev;
        return node;
        
    }

    private ListNode removeLast(ListNode head){
    	
    	ListNode node = head;
    	while(node.next != null){
    		
    		node = node.next;
    	}
    	node = node.next;
    	return head;
    }
    public static void main(String args[]){
    	
    	ListNode l1 = new ListNode(7);
    	ListNode l2 = new ListNode(5);
    	l1.next = new ListNode(2);
    	l1.next.next = new ListNode(4);
    	l1.next.next.next = new ListNode(3);
    	l2.next = new ListNode(6);
    	l2.next.next = new ListNode(4);
    	
    	AddNumber2 obj = new AddNumber2();
    	
    	obj.addTwoNumbers(l1, l2);
    }
	
}
