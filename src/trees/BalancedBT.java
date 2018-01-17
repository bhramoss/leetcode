package trees;

public class BalancedBT {

    public boolean isBalanced(TreeNode root) {
        return isBalancedUtil(root);
    }
    
    private boolean isBalancedUtil(TreeNode root){
        
        if(root == null) return true;
        int left = height(root.left);
        int right = height(root.right);
        if(Math.abs(left-right) > 1) return false;
        return isBalancedUtil(root.left) && isBalancedUtil(root.right);
    }
    
    private int height(TreeNode root){
        
        if(root == null){
            return 0;
        }
        return 1+Math.max(height(root.left), height(root.right));
    }


}
