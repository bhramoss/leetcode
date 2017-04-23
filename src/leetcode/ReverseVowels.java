package leetcode;

import java.util.Stack;

public class ReverseVowels {
	public String reverseVowels(String s) {

		char[] arr = s.toCharArray();
		Stack<Character> stack = new Stack<Character>();
		for (char ch : arr) {
			if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u' || ch == 'A' || ch == 'E' || ch == 'I'
					|| ch == 'O' || ch == 'U') {
				stack.push(ch);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 'a' || arr[i] == 'e' || arr[i] == 'i' || arr[i] == 'o' || arr[i] == 'u' || arr[i] == 'A'
					|| arr[i] == 'E' || arr[i] == 'I' || arr[i] == 'O' || arr[i] == 'U') {
				arr[i] = stack.pop();
			}
		}
		return new String(arr);
	}

	public static void main(String[] args) {

		ReverseVowels obj = new ReverseVowels();
		System.out.println(obj.reverseVowels("hello"));
	}
}
