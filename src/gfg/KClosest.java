package gfg;

import java.util.ArrayList;
import java.util.List;

public class KClosest {

	
	private int findCrossOver(int array[],int low, int high, int x){
		
		if(array[low] > x) return low;
		if(array[high] <= x) return high;
		
		
		int mid = (low+high)/2;
		
		if(array[mid] <= x && array[mid+1] > x){
			return mid;
		}
		if(array[mid] > x){
			return findCrossOver(array, low, mid-1, x);
		}
		return findCrossOver(array, mid+1, high, x);
		
	}
	
	private List<Integer> closest(int array[],int x, int k){
		
		int crossOver = findCrossOver(array, 0, array.length-1, x);
		List<Integer> result = new ArrayList<Integer>();
		int left = crossOver;
		int right = crossOver+1;
		if(array[crossOver] == x) left--;
		while(k > 0){
			if(x-array[left] < array[right]-x){
				result.add(array[left]);
				left--;
			}else if(x-array[left] > array[right]-x){
				result.add(array[right]);
				right++;
			}else{
				result.add(array[left]);
				result.add(array[right]);
				left--;
				right++;
				k--;
			}
			k--;
		}
		return result;
		
	}
	
	public static void main(String[] args){
		
		KClosest obj = new KClosest();
		int[] array = {12, 16, 22, 30, 35, 39, 41,45, 48, 50, 53, 55, 56};
		
		System.out.println(array[obj.findCrossOver(array, 0, array.length-1, 40)]);
		System.out.println(obj.closest(array, 40, 2));
	}
}
