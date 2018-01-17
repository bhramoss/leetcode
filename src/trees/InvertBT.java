package trees;

public class InvertBT {

	public TreeNode invertTree(TreeNode node){
		
		if(node == null){
			return null;
		}
		
		TreeNode left = invertTree(node.left);
		TreeNode right = invertTree(node.right);
		
		node.left = right;
		node.right = left;
		return node;
	}
	
	public static void main(String[] args){
		
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(1);
		root.right = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		InvertBT obj = new InvertBT();
		root = obj.invertTree(root);
	}
}
