package dynamicprogramming;

public class ClimbingStairs {

	public int climbStairs(int n) {

		int array[] = new int[n + 1];

		array[0] = 0;
		array[1] = 1;

		if (n <= 1) {
			return array[n];
		}
		array[2] = 2;

		if (n <= 2) {
			return array[n];
		}
		for (int i = 3; i <= n; i++) {

			array[i] = array[i - 1] + array[i - 2];
		}
		return array[n];

	}

	public static void main(String args[]){
		
		ClimbingStairs obj = new ClimbingStairs();
		System.out.println(obj.climbStairs(9));
	}
}
