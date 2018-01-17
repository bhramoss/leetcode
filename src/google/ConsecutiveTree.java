package google;

import trees.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class ConsecutiveTree {
	
	int count = 1;
	public int longestConsecutive(TreeNode root) {
		
		if(root == null) return 0;
		count = traverseUtil(root, count);
		return count;

	}

	private int traverseUtil(TreeNode root, int count) {

		if (root != null) {
//			System.out.println(root.val);
			int temp = traverse(root, 1);
			if (temp > count) {
				count = temp;
			}
			TreeNode left = root.left;
			TreeNode right = root.right;
			count = traverseUtil(left, count);
			count = traverseUtil(right, count);
		}
		return count;
	}

	public int traverse(TreeNode root, int count) {

		if (root != null) {
			TreeNode left = root.left;
			TreeNode right = root.right;
			if (left != null && root.val == left.val - 1) {
				count++;
				count = traverse(left, count);
			}

			if (right != null && root.val == right.val - 1) {
				count++;
				count = traverse(right, count);
			}
		}
		return count;
	}

	public static void main(String[] args) {

		ConsecutiveTree obj = new ConsecutiveTree();
//		case_1:
		TreeNode root = new TreeNode(1);
		root.left = null;
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		
//		TreeNode root = new TreeNode(1);
//		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.right.left = new TreeNode(2);
//		root.right.left.left = new TreeNode(1);

		System.out.println(obj.longestConsecutive(root));
	}
}