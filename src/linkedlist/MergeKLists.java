package linkedlist;

import java.util.PriorityQueue;
import java.util.Queue;

public class MergeKLists {

    public ListNode mergeKLists(ListNode[] lists) {
        
        Queue<Integer> minHeap = new PriorityQueue<Integer>();

        for(int i = 0; i < lists.length; i++){
            
            ListNode head = lists[i];
            ListNode temp = head;
            while(temp != null){
                minHeap.add(temp.val);
                temp = temp.next;
            }
        }
        ListNode result = new ListNode(0);
        ListNode temp = result;        
        while(minHeap.peek() != null){
            temp.next = new ListNode(minHeap.poll());
            temp = temp.next;
        }
        return result.next;
    }
    
    public static void main(String[] args){
    	
    	MergeKLists obj = new MergeKLists();
		LinkedList list = new LinkedList();
		ListNode head = new ListNode(1);
		ListNode head2 = null;
		ListNode [] lists = {head2,head};
//		ListNode first = list.createNode(2, head);
//		ListNode second = list.createNode(10,first);
//		ListNode third = list.createNode(20, second);
		obj.mergeKLists(lists);
    }
}
