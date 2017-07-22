package dynamicprogramming;

public class ContinuousSubarraySum {

	public int continuousSum(int[] array){
		
		int minSum = 0;
		int curSum = 0;
		for(int i = 0; i < array.length; i++){
			curSum += array[i];
			minSum = Math.min(minSum, curSum);
			curSum = Math.min(curSum, 0);
		}
		return minSum;
	}
	
	public int continuousSumWithSwaps(int[] array, int min){
		
		//if the array is positive, then pick the minimum value and return it.
		boolean isNegative = false;
		int minPositive = Integer.MAX_VALUE;
		for(int i = 0; i < array.length; i++){
			if(array[i] < minPositive)
					minPositive = array[i];
			if(array[i] < 0){
				isNegative = true;
				break;
			}
		}
		if(!isNegative){
			return minPositive;
		}
		
		//If you have come till here, it means that array has negative value.
		//Use kadane's algorithm n^2 times. Complexity will be O(n^3).
		for(int i = 0; i < array.length; i++){
			for(int j = i+1; j < array.length; j++){
				int temp = array[i];
				array[i] = array[j];
				array[j] = temp;
				int tempMin = continuousSum(array);
				min = Math.min(min, tempMin);
			}
		}
		return min;
	}
	public static void main(String[] args){
		
		ContinuousSubarraySum obj = new ContinuousSubarraySum();
		int[] array = {-1,5,6,-2};
		int min = obj.continuousSum(array);
		System.out.println(obj.continuousSumWithSwaps(array, min));
	}
}
