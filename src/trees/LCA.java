package trees;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return traverse(root, p, q);
    }
    
    private TreeNode traverse(TreeNode root, TreeNode p, TreeNode q){
        
        if(root == null || root == p || root == q) return root;
        
        if(root.val < p.val && root.val < q.val){
           return traverse(root.right, p, q);
        }else if(root.val > p.val && root.val > q.val){
            return traverse(root.left, p, q);
        }else{
            return root;
        }
    }


}
