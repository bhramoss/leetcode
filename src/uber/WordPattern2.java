package uber;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class WordPattern2 {

	public boolean wordPatternMatch(String str, String pattern){
		
		Map<Character, String> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		return isMatch(pattern, str, 0, 0, map, set);
	}
	
	private boolean isMatch(String pattern, String str, int i, int j, Map<Character, String> map, Set<String> set){
		
		if(i == pattern.length() && j == str.length()) return true;
		if(i == pattern.length() || j == str.length()) return false;
		
		char ch = pattern.charAt(i);
		
		if(map.containsKey(ch)){
			String s = map.get(ch);
			if(str.startsWith(s, j)){
				return isMatch(pattern, str, i+1, j+s.length(), map, set);
			}
			return false;
		}
		
		for(int k = j; k < str.length(); k++){
			
			String s = str.substring(j, k+1);
			map.put(ch, s);
			set.add(s);
			
			if(isMatch(pattern, str, i+1, k+1, map, set)){
				return true;
			}
			map.remove(ch);
			set.remove(s);
		}
		return false;
	}
	
	public static void main(String[] args){
		
		WordPattern2 obj = new WordPattern2();
		
		System.out.println(obj.wordPatternMatch("redblueredblue", "abab"));
	}
}
