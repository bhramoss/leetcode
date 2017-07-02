package trees;

public class Codec {

	int index = 0;
    public TreeNode deserialize(String data) {
        
        String [] string = data.split(",");
        
        int [] list = new int[string.length];
        
        for(int i = 0; i < string.length; i++)
            list[i] = Integer.valueOf(string[i]);
        
        TreeNode root =  deserializeUtil(list);
        return root;
        
    }
    
    private TreeNode deserializeUtil(int [] list){
        
        if(index > list.length || list[index] == -1){
            
            index++;
            return null;
        }
        
        TreeNode root = new TreeNode(list[index]);
        index++;
        
        root.left = deserializeUtil(list);
        root.right = deserializeUtil(list);
        
        return root;
    }

    public static void main(String [] args){
    	
    	Codec obj = new Codec();
    	
    	TreeNode node = obj.deserialize("-1,0,-1,-1,1,-1,-1,");
    }
}
