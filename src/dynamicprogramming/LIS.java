package dynamicprogramming;


public class LIS {

    public int lengthOfLIS(int[] nums) {
        
        Integer[] lis = new Integer[nums.length];
        
        
        for(int i = 0 ; i < nums.length; i++){
            lis[i] = 1;
        }
        
        for(int i = 1; i < nums.length; i++){
        	for(int j = 0; j < i; j++){
        		if(nums[i] > nums[j]){
        			int temp = 1 + lis[j];
        			if(temp > lis[i]){
        				lis[i] = temp;
        			}
        		}
        	}
        }
        int max = 0;
        for(int i = 0; i < lis.length; i++){
        	if(lis[i] > max)
        		max = lis[i];
        }
        return max;
    }
    
    
       public static void main(String args[]){
    	   
    	   LIS lic = new LIS();
    	   
    	   int[] nums = {10,9,2,5,3,7,101,18};
    	   System.out.println(lic.lengthOfLIS(nums));
       }

}
