package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class StringPermutation {

	public List<String> permute(String input) {

		Map<Character, Integer> map = new TreeMap<>();
		char[] inputC = input.toCharArray();

		for (char ch : inputC) {

			if (map.get(ch) != null) {
				int value = map.get(ch);
				map.put(ch, ++value);
			} else {
				map.put(ch, 1);
			}
		}

		int[] count = new int[map.size()];
		char[] str = new char[map.size()];
		int index = 0;
		for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
				
		List<String> resultList = new ArrayList<>();
		char[] resultC = new char[inputC.length];
		permuteUtil(str, count, resultList, resultC, 0);
		return resultList;
		
	}
	
	private void permuteUtil(char[] str, int[] count, List<String> resultList, char[] resultC, int level){
		
		if(level == resultC.length){
			resultList.add(new String(resultC));
			return;
		}
		
		for(int i = 0; i < str.length; i++){
			
			if(count[i] == 0){
				continue;
			}
			resultC[level] = str[i];
			count[i]--;
			permuteUtil(str, count, resultList, resultC, level+1);
			count[i]++;
			
		}
	}

	public static void main(String[] args){
		StringPermutation obj = new StringPermutation();
		
		obj.permute("abc").forEach(s->{System.out.println(s);});
		
	}
}
