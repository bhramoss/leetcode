package facebook;

import java.util.HashMap;

public class SubarraySum {
	public int maxSubArrayLen(int[] nums, int k) {
		if (nums == null || nums.length == 0)
			return 0;
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		map.put(0, -1);
		int sum = 0;
		int maxLen = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (!map.containsKey(sum)) {
				map.put(sum, i);
			}
			if (map.containsKey(sum - k)) {
				int index = map.get(sum - k);
				maxLen = Math.max(maxLen, i - index);
			}
		}
		return maxLen == Integer.MIN_VALUE ? 0 : maxLen;
	}

	public static void main(String args[]) {
		SubarraySum obj = new SubarraySum();
		int[] array = { -2, -1, 2, 1 };
		System.out.println(obj.maxSubArrayLen(array, 1));
	}
}
