package facebook;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {

	public int schedule(char[] tasks, int n){
		
		int f[] = new int[tasks.length];
		for(char ch : tasks){
			f[ch-'A']++;
		}
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(26, Collections.reverseOrder());
		
		for(int num : f){
			if(num > 0)
			queue.offer(num);
		}
		int time = 0;
		
		while(!queue.isEmpty()){
			int i = 0;
			List<Integer> list = new ArrayList<Integer>();
			while(i <= n){
				if(!queue.isEmpty()){
					if(queue.peek() > 1){
						list.add(queue.poll()-1);
					}else{
						queue.poll();
					}					
				}
				if(queue.isEmpty() && list.isEmpty()){
					break;
				}
				i++;
				time++;
			}
			for(int num : list){
				queue.offer(num);
			}
		}
		return time;
	}
	
	public static void main(String args[]){
		Solution obj = new Solution();
		char[] tasks = {'A','A','A','B','B','B'};
		obj.schedule(tasks, 2);
	}
	
}
