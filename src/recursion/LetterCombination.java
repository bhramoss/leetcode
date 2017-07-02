package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class LetterCombination {
	
	 String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
	 
	 public List<String> letterCombinations(String digits) {
		 
		    LinkedList<String> ans = new LinkedList<String>();
		    if(digits.length() == 0 ) return ans;
		    String[] mapping = new String[] {"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
		    ans.add("");
		    for(int i =0; i<digits.length();i++){
		        int x = Character.getNumericValue(digits.charAt(i));
		        while(ans.peek().length()==i){
		            String t = ans.remove();
		            for(char s : mapping[x].toCharArray())
		                ans.add(t+s);
		        }
		    }
		    return ans;
		}
	 
	 public void letterCombination(int[] number, int current, char[] output, int n, List<String> result){
		 
		 if(current == n){
			 result.add((Arrays.toString(output)));
			 return;
		 }
		 
		 for(int i = 0; i < mapping[number[current]].length(); i++){
			 
			 output[current] = mapping[number[current]].charAt(i);
			 letterCombination(number, current+1, output, n, result);
			 if(number[current] == 0 || number[current] == 1){
				 return;
			 }
		 }
		 
		 
	 }

	 public void letterCombination(int[] number, int current, StringBuilder output, int n, List<String> result){
		 
		 if(current == n){
			 result.add(output.toString());
			 return;
		 }
		 
		 for(int i = 0; i < mapping[number[current]].length(); i++){
			 
			 output.append(mapping[number[current]].charAt(i));
			 letterCombination(number, current+1, output, n, result);
			 output.setLength(output.length()-1);
			 if(number[current] == 0 || number[current] == 1){
				 return;
			 }
		 }
		 
		 
	 }
	 
	 public static void main(String args[]){
		 
		 LetterCombination obj = new LetterCombination();
//		 obj.letterCombinations("23").forEach(s->{System.out.println(s);});
		 
		 String n = "210";
		 int number[] = new int[n.length()];
		 for(int i = 0; i < n.length(); i++){
			 number[i] = Integer.valueOf(n.charAt(i))-'0';
		 }
		 
		 char[] output = new char[number.length];
		 List<String> result = new ArrayList<String>();
//		 obj.letterCombination(number, 0, output, number.length,result);
		 StringBuilder builder = new StringBuilder();
		 obj.letterCombination(number, 0, builder, number.length, result);
		 for(String s : result){
			 System.out.println(s);
		 }
	 }
}
