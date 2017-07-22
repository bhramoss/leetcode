package array;

public class RotatedArray {

	public int search(int[] nums, int target) {

		int lo = findMin(nums, nums.length-1, 0);
		int hi = nums.length-1;
		int result = binarySearch(nums, lo, hi, target);
		if(result != -1) return result;
		hi = nums[lo-1];
		lo = nums[0];
		result = binarySearch(nums, lo, hi, target);
		return result;
	}
	
	private int findMin(int[] nums, int high, int low){
		
		if(high < low) return nums[0];
		if(high == low) return nums[low];
		int mid = low + (high-low)/2;
		
		if(mid < high && nums[mid+1] < nums[mid]){
			return mid+1;
		}
		if(mid > low && nums[mid] < nums[mid-1]){
			return mid;
		}
		
		if(nums[high] > nums[mid]){
			return findMin(nums, low, mid-1);
		}
		return findMin(nums, mid+1, high);
	}

    private int binarySearch(int input[], int low, int high, int target){
        
        while(low < high){
            
            int mid = low + ( high-low)/2;
            if(input[mid] == target){
                return mid;
            }
            if(target < input[mid]){
                return binarySearch(input, low, mid, target);
            }else if(target > input[mid]){
                return binarySearch(input, mid+1, high, target);
            }
        }
        return -1;
    }
    
	public static void main(String[] args) {
		RotatedArray obj = new RotatedArray();
		int[] nums = {1};
//		System.out.println(obj.findMin(nums, nums.length-1, 0));
		System.out.println(obj.search(nums, 1));
	}
}
