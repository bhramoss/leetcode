package trees;

public class Codec {

	
	int index = 0;
	public String serialize(TreeNode root){
		StringBuilder builder = new StringBuilder();
		preorder(root, builder);
		return builder.toString();
	}
	
    private void preorder(TreeNode root, StringBuilder string){
        
        if(root == null){
            string.append("-1000");
            string.append(",");
            return;
        }
        
        string.append(Integer.toString(root.val));
        string.append(",");
        preorder(root.left, string);
        preorder(root.right, string);
    }
	
    public TreeNode deserialize(String nums){
    	
    	String[] temp = nums.split(",");
    	int[] list = new int[temp.length];
    	for(int i = 0; i < temp.length; i++){
    		list[i] = Integer.valueOf(temp[i]);
    	}
    	return deserializeUtil(list);
    }
    
    private TreeNode deserializeUtil(int[] list){
    	
    	if(index > list.length || list[index] == -1000){
    		index++;
    		return null;
    	}
    	
    	TreeNode root = new TreeNode(list[index]);
    	index++;
    	root.left = deserializeUtil(list);
    	root.right = deserializeUtil(list);
    	return root;
    }
    
	public static void main(String[] args){
		
		Codec obj = new Codec();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
//		root.right.left.left = new TreeNode(12);
		root.right.right = new TreeNode(5);
		System.out.println(obj.serialize(root));
		TreeNode tempRoot = obj.deserialize(obj.serialize(root));
		System.out.println(obj.serialize(tempRoot));
	}
}
