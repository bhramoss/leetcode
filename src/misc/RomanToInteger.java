package misc;

import java.util.HashMap;
import java.util.Map;

public class RomanToInteger {

	public int romanToInteger(String roman){
		
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		char[] array = roman.toCharArray();
		int running = 0;
		for(int i = 0; i < array.length-1; i++){
			if(map.get(array[i]) >= map.get(array[i+1])){
				running += map.get(array[i]);
			}else{
				running += map.get(array[i+1]);
				running -= map.get(array[i]);
				i++;
			}
		}
		return running;
	}
	
	public static void main(String[] args){
		RomanToInteger obj = new RomanToInteger();
		System.out.println(obj.romanToInteger("MCMIV"));
	}
}
