package trees;

public class TreeNode {

	public int val;
	
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(int val){
		
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
	
}
