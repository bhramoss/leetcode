package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	
    public List<List<Integer>> permute(int[] nums) {
        
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backtrack(list,temp,nums);
        return list;
        
    }
    
    private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums ){
        
        if(temp.size() == nums.length){
            list.add(new ArrayList<Integer>(temp));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            
            if(temp.contains(nums[i])) continue;
            temp.add(nums[i]);
            backtrack(list,temp,nums);
            temp.remove(temp.size()-1);
        }
    }
   
    public static void main(String[] args){
    	
    	Solution1 obj = new Solution1();
    	int[] array = {1,1};
    	System.out.println(obj.permute(array));
    }
}
