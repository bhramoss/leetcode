package uber;

public class ElementFrequency {

	public int frequency(int[] array, int x){
		
		int r = rightMost(array, array.length, 0, x, array.length);
		int l = leftMost(array, array.length, 0, x, array.length);
		return r-l+1;
	}
	
	private int leftMost(int[] array, int hi, int lo, int x, int size){
		
		if(lo <= hi){
			
			int mid = (lo + (hi-lo)/2);
			if(mid == 0 || array[mid] == x && x > array[mid-1]){
				return mid;
			}else if(x > array[mid]){
				return leftMost(array, size, mid+1, x, size);
			}else{
				return leftMost(array, mid-1, lo, x, size);
			}
		}
		return -1;
	}
	
	private int rightMost(int[] array, int hi, int lo, int x, int size){
		
		if(lo <= hi){
			int mid = (lo + (hi-lo)/2);
			if(mid == size-1 || array[mid] == x && array[mid+1] > x){
				return mid;
			}else if(x < array[mid]){
				return rightMost(array, mid-1, lo, x, size);
			}else{
				return rightMost(array, size, mid+1, x, size);
			}
		}
		return -1;
	}
	
	public static void main(String[] args){
		
		ElementFrequency obj = new ElementFrequency();
		int arr[] = {1, 2, 2, 3, 3, 3, 3};
		int x =  3; 
		System.out.println(obj.frequency(arr, x));
	}
}
