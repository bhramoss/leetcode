package dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

//leetcode #523 does not work. Has many flaws
public class OnesAndZeros {

	private class Element{
		
		int m;
		int n;
		int index;
		
		public Element(int m, int n, int index){
			this.m = m;
			this.n = n;
			this.index = index;
		}

		@Override
		public String toString() {
			StringBuilder builder = new StringBuilder();
			builder.append("Element [m=");
			builder.append(m);
			builder.append(", n=");
			builder.append(n);
			builder.append(", index=");
			builder.append(index);
			builder.append("]");
			return builder.toString();
		}		
	}
	
	public int findMaxForm(String[] strs, int m, int n){
		
		List<Element> list = new ArrayList<Element>();
		
		//Count 0s and 1s for each string
		
		for(String string : strs){
			int index = 0;
			char temp[] = string.toCharArray();
			int zeros = 0;
			int ones = 0;
			for(char c: temp){
				if(c =='0') zeros++;
				else
					if(c == '1') ones++;
			}
			list.add(new Element(zeros, ones, index));
			index++;
		}
		
			sort(list, m, n);
			int count = 0;

			while(m != 0 || n != 0){
				
				m = m - list.get(0).m;
				n = n - list.get(0).n;
				count++;
				list.remove(0);
				sort(list, m, n);
				if(m < list.get(0).m && n < list.get(0).n){
					break;
				}
			}
			return count;
	}
	
	private void sort(List<Element> list, int m, int n){
		
		// sort the Strings based on m or n depending on which is smaller.

		if(m > n){
			Collections.sort(list, new Comparator<Element>(){

				@Override
				public int compare(Element o1, Element o2) {
					
					if(o1.n < o2.n)
						return -1;
					else
						if(o1.n > o2.n)	
							return 1;
						else
							return 0;
				}
				
			});
		}else if(n > m){
			Collections.sort(list, new Comparator<Element>() {

				@Override
				public int compare(Element o1, Element o2) {
					
					if(o1.m < o2.m)
						return -1;
					else
						if(o1.m > o2.m)	
							return 1;
						else
							return 0;
				}
			});
		}else{
			Collections.sort(list,new Comparator<Element>(){

				@Override
				public int compare(Element o1, Element o2) {
					
					if(o1.n < o2.n)
						return 1;
					else
						if(o1.n > o2.n)	
							return -1;
						else
							return 0;
				}
				
			});
		}
		
	}
	public static void main(String[] args){
		
		OnesAndZeros obj = new OnesAndZeros();
		
		String array[] = {"10", "0", "1"};
		int m = 1; 
		int n = 1;
		System.out.println(obj.findMaxForm(array, m, n));
	}
	
}

