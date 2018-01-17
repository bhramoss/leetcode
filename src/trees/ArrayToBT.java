package trees;

public class ArrayToBT {
	
    public TreeNode sortedArrayToBST(int[] nums) {
        
        if(nums == null || nums.length == 0) return null;
        return convert(nums, 0, nums.length-1);
    }
    
    private TreeNode convert(int[]nums, int l, int h){
        
        if(l > h) return null;
        int mid = (l+h)/2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = convert(nums, l, mid-1);
        root.right = convert(nums, mid+1, h);
        return root;
    }


}
