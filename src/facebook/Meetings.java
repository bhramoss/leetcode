package facebook;

import java.util.Arrays;
import java.util.Comparator;

public class Meetings {

	
	public boolean canAttend(Interval[] intervals){
		
		Arrays.sort(intervals, new Comparator<Interval>() {
			public int compare(Interval i1, Interval i2){
				return i1.start-i2.start;
			}
		});
		for(int i = 0; i < intervals.length-1; i++){
			if(intervals[i].start >= intervals[i+1].end){
				return false;
			}
		}
		
		return true;
		
	}
		
	 class Interval {
		int start;
		int end;

		Interval() {
			start = 0;
			end = 0;
		}

		Interval(int s, int e) {
			start = s;
			end = e;
		}
	}
}
