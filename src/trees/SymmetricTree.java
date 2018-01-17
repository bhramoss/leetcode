package trees;

public class SymmetricTree {

	public boolean isSymmetric(TreeNode root){
		if(root == null){
			return true;
		}
		return isSymmetricUtil(root.left, root.right);
	}
	
	private boolean isSymmetricUtil(TreeNode left, TreeNode right){
		
		if(left == null && right == null){
			return true;
		}
		if(left == null || right == null){
			return false;
		}
		return left.val == right.val && isSymmetricUtil(left.left,right.right) && isSymmetricUtil(left.right, right.left);
	}
	
	public static void main(String[] args){
		SymmetricTree obj = new SymmetricTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(3);
		System.out.println(obj.isSymmetric(root));
	}
}
