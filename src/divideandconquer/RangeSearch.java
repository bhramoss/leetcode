package divideandconquer;

public class RangeSearch {

    public int[] searchRange(int[] nums, int target){
        if(nums==null||nums.length<1)return new int[]{-1,-1};
        int[] ret = new int[]{-1,-1};
        int i = 0, j = nums.length-1;
        while(i<j){
            int mid = i + (j-i)/2;
            if(nums[mid]<target) i = mid+1;
            else j = mid;
        }
        if(nums[i]!=target)return ret;
        else ret[0] = i;

        j = nums.length-1;
        while(i<j){
            int mid = i + (j-i)/2 + 1;
            if(nums[mid]>target)j=mid-1;
            else i = mid;
        }
        ret[1]=j;
        return ret;
    }

    public static void main(String[] ags){
    	
    	RangeSearch obj = new RangeSearch();
    	int[] input = {5,7,7,8,8,10};
    	obj.searchRange(input, 5);
    }
}









