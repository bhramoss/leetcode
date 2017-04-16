package linkedlist;

public class RemoveElements {

    public Node removeElements(Node head, int val) {
        
        if(head == null || (head.value == val && head.next == null)) return null;

        
        Node temp = head;
        
        while(temp != null && temp.next != null){
            
            if(temp.next.value == val){
                temp.next = temp.next.next;
            }
            temp = temp.next;
        }
        return head;
    }

	public static void main(String[] args) {

		RemoveElements obj = new RemoveElements();
		LinkedList list = new LinkedList();
		Node head = new Node(1);
		Node first = list.createNode(1, head);
//		Node second = list.createNode(1, first);
//		Node third = list.createNode(20, second);
		list.traverseList(head);
		head = obj.removeElements(head, 1);
		list.traverseList(head);
	}
    
}
