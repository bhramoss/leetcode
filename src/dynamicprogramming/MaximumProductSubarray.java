package dynamicprogramming;

class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        
        if(nums.length == 0) return 0;
        if(nums.length == 1) return nums[0];
        int result = nums[0];
        int max = nums[0];
        int min = nums[0];
        for(int i = 1; i < nums.length; i++){
            
            if(nums[i] < 0){
                int temp = max;
                max = min;
                min = temp;
            }
            max = Math.max(nums[i], nums[i]*max);
            min = Math.min(nums[i], nums[i]*min);
            result = Math.max(result, max);
        }
        return result;
    }
    public static void main(String[] args){
    	
    	int[] nums = {-4,-3,-2};
    	MaximumProductSubarray obj = new MaximumProductSubarray();
    	System.out.println(obj.maxProduct(nums));
    }
}
