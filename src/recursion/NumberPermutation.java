package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class NumberPermutation {
	public List<String> permute(int[] input) {

		Map<Integer, Integer> map = new TreeMap<>();

		for (int in : input) {

			if (map.get(in) != null) {
				int value = map.get(in);
				map.put(in, ++value);
			} else {
				map.put(in, 1);
			}
		}

		int[] count = new int[map.size()];
		int[] str = new int[map.size()];
		int index = 0;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			
			str[index] = entry.getKey();
			count[index] = entry.getValue();
			index++;
		}
				
		List<String> resultList = new ArrayList<>();
		int[] result = new int[input.length];
		permuteUtil(str, count, resultList, result, 0);
		
		return resultList;
		
	}
	
	private void permuteUtil(int[] str, int[] count, List<String> resultList, int[] resultC, int level){
		
		if(level == resultC.length){
			resultList.add(Arrays.toString(resultC));
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
		NumberPermutation obj = new NumberPermutation();
		
		int[] array = {1,2};
		obj.permute(array).forEach(s->{System.out.println(s);});
		
	}

}
