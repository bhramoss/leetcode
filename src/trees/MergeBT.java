package trees;

public class MergeBT {

	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

		preOrder(t1, t2);
		return t1;
	}

	private TreeNode preOrder(TreeNode t1, TreeNode t2) {
		
		if(t1 == null){
			return t2;
		}
		if(t2 == null){
			return t1;
		}
		t1.val += t2.val;
		t1.left = preOrder(t1.left, t2.left);
		t1.right = preOrder(t1.right, t2.right);
		return t1;
	}

	public static void main(String[] args) {

		TreeNode t1 = new TreeNode(1);
		t1.left = new TreeNode(3);
		t1.left.left = new TreeNode(5);
		t1.right = new TreeNode(2);
		TreeNode t2 = new TreeNode(2);
		t2.left = new TreeNode(1);
		t2.left.right = new TreeNode(4);
		t2.right = new TreeNode(3);
		t2.right.right = new TreeNode(7);
		MergeBT obj = new MergeBT();
		System.out.println(obj.mergeTrees(t1, t2));
	}
}
