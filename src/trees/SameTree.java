package trees;

public class SameTree {

	TreeNode t1;
	TreeNode t2;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        
        return isSameTreeUtil(p,q);
    }
    
    private boolean isSameTreeUtil(TreeNode p, TreeNode q){
        
        if(p == null && q == null) return true;
        if(p == null || q == null) return false;
        
        return (p.val == q.val && isSameTreeUtil(p.left, q.left) && isSameTreeUtil(p.right, q.right));
    }

    private TreeNode tree1(){
    	
    	t1 = new TreeNode(10);
    	t1.left = new TreeNode(5);
    	t1.right = new TreeNode(15);
    	return t1;
    }
    
    
    private TreeNode tree2(){
    	
    	t2 = new TreeNode(10);
    	t2.left = new TreeNode(5);
    	t2.left.right = new TreeNode(15);
    	return t2;
    }
    
    public static void main(String[] args){
    	
    	SameTree obj = new SameTree();
    	
    	System.out.println(obj.isSameTree(obj.tree1(), obj.tree2()));
    }
}
