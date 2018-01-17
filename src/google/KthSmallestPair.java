package google;

import java.util.Arrays;

public class KthSmallestPair {

//	1) Sort the given array a[].
//	2) We can easily find the least possible absolute
//	   difference in O(n) after sorting. The largest
//	   possible difference will be a[n-1] - a[0] after
//	   sorting the array. Let low = minimum_difference
//	   and high = maximum_difference.
//	3) while low < high:
//	4)     mid = (low + high)/2
//	5)     if ((number of pairs with absolute difference
//	                                <= mid) < k):
//	6)        low = mid + 1
//	7)     else:
//	8)        high = mid
//	9) return low	
	
    // Returns number of pairs with absolute difference less than or equal to mid.
    private int countPairs(int[] a, int mid) {
        int n = a.length, res = 0;
        for (int i = 0; i < n; ++i) {
            int j = i;
            while (j < n && a[j] - a[i] <= mid) j++;
            res += j - i - 1;
        }
        return res;
    }

    public int smallestDistancePair(int a[], int k) {
        int n = a.length;
        Arrays.sort(a);

        // Minimum absolute difference
        int low = a[1] - a[0];
        for (int i = 1; i < n - 1; i++)
            low = Math.min(low, a[i + 1] - a[i]);

        // Maximum absolute difference
        int high = a[n - 1] - a[0];

        // Do binary search for k-th absolute difference
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (countPairs(a, mid) < k)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }


}
