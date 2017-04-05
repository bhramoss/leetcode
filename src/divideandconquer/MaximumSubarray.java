package divideandconquer;

public class MaximumSubarray {

	private int crossOver(int[] arr, int l, int m, int h){
		
		int sum = 0;
		int left_sum = Integer.MIN_VALUE;
		
		for(int i = m; i >=l; i--){
			
			sum += arr[i];
			if(sum > left_sum){
				left_sum = sum;
			}
		}
		
		sum = 0;
		int right_sum = Integer.MIN_VALUE;
		
		for(int i = m+1; i <= h; i++){
			
			sum += arr[i];
			if(sum > right_sum){
				right_sum = sum;
			}
		}
		
		return left_sum + right_sum;
	}
	
	private int maximumSubarray(int[] arr, int l, int h){
		
		if(l == h){
			return arr[l];
		}
		
		int mid = (l + h)/2;
		
		return max(maximumSubarray(arr, l, mid), maximumSubarray(arr, mid+1, h), crossOver(arr, l, mid, h));
	}
	
	private int max(int a, int b, int c){
		
		return Math.max(a, Math.max(b, c));
	}
	
	public static void main(String[] args){
		
		MaximumSubarray obj = new MaximumSubarray();
		
		int[] array = {-2, -5, 6, -2, -3, 1, 5, -6};
		
		System.out.println(obj.maximumSubarray(array, 0, array.length-1));
	}
}
