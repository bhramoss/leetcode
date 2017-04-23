package linkedlist;

public class AddNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	
    int carry = 0;
    ListNode resultList = new ListNode(0);
    ListNode temp = resultList;
    
    while(l1 != null || l2 != null || carry == 1){
    	
    	int result = 0;
    	
    	if(l1 == null && l2 == null){
    		temp.next = new ListNode(carry);
    		return resultList.next;
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
    return resultList.next;
    	
    }
        
    private int length(ListNode node){
        
        int count = 0;
        
        while(node != null){
            
            node = node.next;
            count++;
        }
        return count;
    }
    
    public static void main(String args[]){
    	
    	ListNode l1 = new ListNode(1);
    	ListNode l2 = new ListNode(9);
//    	l1.next = new Node(3);
//    	l1.next.next = new Node(4);
    	l2.next = new ListNode(9);
//    	l2.next.next = new Node(3);
    	
    	AddNumbers obj = new AddNumbers();
    	
    	obj.addTwoNumbers(l1, l2);
    }

}
