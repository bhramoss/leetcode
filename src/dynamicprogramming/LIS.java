package dynamicprogramming;

public class LIS {

    public int lengthOfLIS(int[] nums) {
        
        int [] dp = new int[nums.length];
        
        for(int i = 0; i < nums.length; i++){
            nums[i] = 1;
        }
        
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                
                if(nums[i] > nums[j]){
                    if(dp[j]+1 > dp[i]){
                        dp[i] = dp[j]+1;
                    }
                }
            }
        }
        
        System.out.println(dp[3]);
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < dp.length; i++){
            
            if(dp[i] > max)
                max = dp[i];
        }
        
        return max;
    }
    
    public static void main(String args[]){
    	
    	int [] array = {10, 9, 2, 5, 3, 7, 101, 18};
    	
    	LIS obj = new LIS();
    	
    	System.out.println(obj.lengthOfLIS(array));
    }
}
