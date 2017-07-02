package trees;

public class TreeNode {

	int val;
	
	TreeNode left;
	TreeNode right;
	
	TreeNode(int val){
		
		this.val = val;
		this.left = null;
		this.right = null;
	}

	@Override
	public String toString() {
		return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
	}
	
	
	
}
