package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Leaves {

	TreeNode t1;

	private TreeNode tree() {
		t1 = new TreeNode(1);
		t1.left = new TreeNode(2);
		t1.left.left = new TreeNode(4);
		t1.left.right = new TreeNode(5);
		t1.right = new TreeNode(3);
		return t1;
	}

	   public List<List<Integer>> findLeaves(TreeNode root) {
	        List<List<Integer>> res =  new ArrayList<>();
	        T(res,root);
	        return res;
	    }
	    private int T(List<List<Integer>>res, TreeNode root){
	            if(root==null)return -1;
	            int height = Math.max(T(res,root.left),T(res,root.right))+1;
	            if(height==res.size()){res.add(new LinkedList<Integer>());}
	            res.get(height).add(root.val);
	            return height;
	        }
	    
	public static void main(String[] args){
		Leaves obj = new Leaves();
		obj.findLeaves(obj.tree());
	}

}
