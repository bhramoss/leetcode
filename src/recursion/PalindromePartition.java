package recursion;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartition {

	public List<List<String>> partition(String s) {

		List<List<String>> result = new ArrayList<>();
		List<String> temp = new ArrayList<>();
		partitionUtil(s, 0, result, temp);
		return result;
	}

	private void partitionUtil(String s, int pos, List<List<String>> result, List<String> temp) {

		if (pos == s.length()) {
			result.add(new ArrayList<String>(temp));
		} else {

			for (int i = pos; i < s.length(); i++) {
				if (isPalindrome(s, pos, i)) {
					temp.add(s.substring(pos, i + 1));
					partitionUtil(s, i + 1, result, temp);
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	private boolean isPalindrome(String s, int low, int high) {

		while (low < high) {
			if (s.charAt(low++) != s.charAt(high--)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		PalindromePartition obj = new PalindromePartition();

		obj.partition("aab").forEach(s -> {
			System.out.println(s);
		});
	}
}
