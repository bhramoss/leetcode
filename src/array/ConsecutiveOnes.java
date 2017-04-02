package array;

// 485. Max Consecutive Ones
public class ConsecutiveOnes {

	public int findMaxConsecutiveOnes(int[] nums) {

		int ans = 0;
		int max = 0;
		for (int i = 0; i < nums.length; i++) {

			if (nums[i] == 1) {
				ans++;
				if (max < ans)
					max = ans;
			} else {
				ans = 0;
			}
		}
		return max;
	}

	public static void main(String args[]) {

		ConsecutiveOnes obj = new ConsecutiveOnes();

		int array[] = { 1, 1, 0, 1, 0, 0, 1 };

		System.out.println(obj.findMaxConsecutiveOnes(array));

	}

}
