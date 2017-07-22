package twopointers;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public void sortColors(int[] nums) {
     
         List<Integer> zeros = new ArrayList<Integer>();
         List<Integer> ones = new ArrayList<Integer>();
         List<Integer> twos = new ArrayList<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                zeros.add(nums[i]);
            }else if(nums[i] == 1){
                ones.add(nums[i]);
            }else{
                twos.add(nums[i]);
            }
        }
        zeros.addAll(ones);
        zeros.addAll(twos);
        nums = null;
        nums = zeros.stream().mapToInt(i->i).toArray();
    }
    
    public static void main(String[] ags){
    	
    	Solution obj = new Solution();
    	int[] nums = {1,0};
    	obj.sortColors(nums);
    	
    }
}