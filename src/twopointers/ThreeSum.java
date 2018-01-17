package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

	/**
	 * @param array
	 * @return
	 */
	public List<List<Integer>> threeSum(int[] array){
		
		Arrays.sort(array);
		List<List<Integer>> result = new ArrayList<>();
		int start = 0;
		int size = array.length;
		int secondPointer = array.length-1;
		while(start < size){
			for(int i  = start+1, j = secondPointer; i < j;){
				int sum = array[i]+array[j];
				if(sum+array[start] == 0){
					List<Integer> list = new ArrayList<>();
					list.add(array[start]);
					list.add(array[i]);
					list.add(array[j]);
					result.add(list);
					while(array[i] != array[i++]);
					while(array[j] != array[j--]);
					break;
				}else if(sum <= array[start]){
					while(array[i] != array[i++]);
				}else if(sum > array[start]){
					while(array[j] != array[j--]);
				}
			}
			while(array[start] != array[start++]);
		}
		return result;
	}
	
	public static void main(String[] args){
		
		ThreeSum obj = new ThreeSum();
		int[] array = {0,0,0};
		System.out.println(obj.threeSum(array));
	}
}
