package leetcode;

import java.util.TreeSet;

public class Duplicates3 {
	public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

		TreeSet<Long> set = new TreeSet<>();

		for (int i = 0; i < nums.length; i++) {

			if ((set.ceiling((long)nums[i]) != null && set.ceiling((long)nums[i]) - (long)nums[i] <= t)
					|| (set.floor((long)nums[i]) != null && nums[i] - set.floor((long)nums[i]) <= t)) {

				return true;
			}
			set.add((long)nums[i]);
			if (set.size() > k) {

				set.remove(i - k);
			}

		}
		return false;
	}

	public static void main(String[] args) {

//		Duplicates3 obj = new Duplicates3();
//
//		int[] nums = { -1, 2147483647 };
//
//		System.out.println(obj.containsNearbyAlmostDuplicate(nums, 1, 2147483647));
		
		String a = "1,2,3,4,5,9,-1,";
		
		String string[] = a.split(",");
		
		int list[] = new int[string.length];
		for(int i = 0; i < string.length; i ++)
			list[i] = Integer.valueOf(string[i]);
		System.out.println(list);

	}
}
