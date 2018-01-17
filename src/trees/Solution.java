package trees;

class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return isPresent(root, sum);
    }
    
    private boolean isPresent(TreeNode root, int sum){
        
        if(root == null) return false;
        if(root.left == null && root.right == null && sum-root.val == 0){
        	return true;
        }
        return isPresent(root.left, sum-root.val) || isPresent(root.right, sum-root.val);
        
    }
    
    public static void main(String[] args){
    	
    	TreeNode root = new TreeNode(5);
    	root.left = new TreeNode(4);
    	root.left.left = new  TreeNode(11);
    	root.left.left.right = new TreeNode(2);
    	root.right = new TreeNode(8);
    	root.right.right = new TreeNode(4);
    	root.right.right.right = new TreeNode(1);
    	root.right.left = new TreeNode(13);
    	root.left.left.left = new TreeNode(7);
    	
    	Solution obj = new Solution();
    	System.out.println(obj.hasPathSum(root, 22));
    }

}
