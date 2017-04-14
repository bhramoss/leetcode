package leetcode;

import java.util.Arrays;

public class MissingNumber {

    public int missingNumber(int[] nums) {
        
        int count = nums.length;
        Arrays.sort(nums);
        for(int i = nums.length-1; i >= 0; i--){
            if(nums[i] == count){
                count--;
            }else{
                return count;
            }
        }
        return 0;
    }
	
    public static void main(String args[]){
    	
    	int[] array = {0};
    	MissingNumber obj = new MissingNumber();
    	System.out.println(obj.missingNumber(array));
    }
}
