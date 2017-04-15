package dynamicprogramming;

/*
 * Reference : http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
 * Please refer the above link for a detailed explanation
 */
public class EggDropping {

	
	private static int eggDropping(int eggs, int floors){
		
		int dp[][] = new int[eggs+1][floors+1];
		

		for(int i = 1; i <= eggs; i++){
			
			dp[i][1] = 1;
			dp[i][0] = 0;
		}
		
		// x trials for x floors and 1 egg
		
		for(int x = 1; x <= floors; x++){
			dp[1][x] = x;
		}
		
		for(int i = 2; i <= eggs; i++){
			
			for(int j = 2; j <= floors; j++){
				dp[i][j] = Integer.MAX_VALUE;
				
				for(int k = 1; k <= j; k++){
					
					int result = 1 + Math.max(dp[i-1][k-1], dp[i][j-k]);
					if(result < dp[i][j]){
						dp[i][j] = result;
					}
				}
				
			}
		}
		
		return dp[eggs][floors];
	}
	public static void  main(String args[] )
    {
        int n = 1, k = 36;
        System.out.println("Minimum number of trials in worst case with "+n+"  eggs and "+k+
                 " floors is "+eggDropping(n, k));   
    }	
}
