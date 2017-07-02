package recursion;

import java.util.ArrayList;

public class RestoreIpAddress {

	public ArrayList<String> restoreIpAddresses(String s) {
		ArrayList<String> result = new ArrayList<String>();
		if (s.length() < 4 || s.length() > 12)
			return result;
		DFS("", s, result, 0);
		return result;
	}

	private void DFS(String tmp, String s, ArrayList<String> result, int count) {
		if (count == 3 && isValid(s)) {
			result.add(tmp + s);
			return;
		}

		for (int i = 1; i < 4 && i < s.length(); i++) {
			String substr = s.substring(0, i);
			if (isValid(substr)) {
				DFS(tmp + substr + '.', s.substring(i), result, count + 1);
			}
		}
	}

	private boolean isValid(String s) {
		if (s.charAt(0) == '0')
			return s.equals("0");
		int num = Integer.parseInt(s);
		return 0 < num && num <= 255;
	}

	public static void main(String[] args) {

		RestoreIpAddress obj = new RestoreIpAddress();

		obj.restoreIpAddresses("25511135").forEach(s -> {
			System.out.println(s);
		});
	}
}
