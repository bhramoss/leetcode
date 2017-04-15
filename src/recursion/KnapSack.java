package recursion;
/*
 * There are two cases every time we take an item into account:-
 * 1. It is included in the bag.
 * 2. It is NOT included in the bag.
 * Whether we end up putting the nth item in the bag depends on if we get maxumum "value" out 
 * of doing so.
 * 
 * ie. Max(value without putting the nth item, value after putting the nth item).
 * If we do PUT the nth item, then its possible that some space(weight) is still available for putting
 * n-2, n-3, n-i item, so we need to consider putting them also. 
 * 
 * 
 */



public class KnapSack {

	private int knapSack(int val[], int wt[], int W, int n){
		
		//exit case
		if(n == 0 || W == 0){
			return 0;
		}
		
		//case where weight is more than knapsack capacity
		if(wt[n-1] > W){
			return knapSack(val, wt, W, n-1);
		}else{
			
			return Math.max(val[n-1] + knapSack(val, wt, W-wt[n-1], n-1), knapSack(val, wt, W, n-1));
		}
	}
	
	public static void main(String[] args){
		
		KnapSack obj = new KnapSack();
		int wt[] = {1,3,4,5};
		int val[] = {1,4,5,7};
		int W = 7;
		System.out.println(obj.knapSack(val, wt, W, val.length));
	}
}
