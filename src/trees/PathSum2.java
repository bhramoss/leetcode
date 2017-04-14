package trees;

import java.util.ArrayList;
import java.util.List;

//LeetCode #113 pathsum2
public class PathSum2 {

	TreeNode root;

	private List<List<Integer>> pathSum() {
		return pathSum(root, 22);
	}

	private List<List<Integer>> pathSum(TreeNode root, int sum) {

		List<Integer> list = new ArrayList<Integer>();
		List<List<Integer>> result = new ArrayList<>();
		pathSumUtil(root, sum, list, result);
		return result;
	}

	private boolean pathSumUtil(TreeNode root, int sum, List<Integer> list, List<List<Integer>> result) {

		if (root == null) {
			return false;
		}
		list.add(root.val);

		if (sum - root.val == 0 && root.left == null && root.right == null) {
			List<Integer> temp = new ArrayList<Integer>(list);
			result.add(temp);
			list.remove(list.size() - 1);
			return true;
		} else {
			// boolean flag = false;
			// if(root.left != null){
			// flag =
			pathSumUtil(root.left, sum - root.val, list, result);

			// }
			// if(!list.isEmpty() && !flag)
			// list.remove(list.size()-1);

			// if(root.right != null)
			pathSumUtil(root.right, sum - root.val, list, result);
		}
		list.remove(list.size() - 1);
		return true;
	}

	private void createTreeNode() {

		root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right = new TreeNode(8);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(1);
		root.right.left = new TreeNode(13);
		root.right.right.left = new TreeNode(5);
	}

	private class TreeNode {

		int val;
		TreeNode left;
		TreeNode right;

		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}

	}

	public static void main(String[] args) {

		PathSum2 obj = new PathSum2();

		obj.createTreeNode();
		obj.pathSum();
	}

}
