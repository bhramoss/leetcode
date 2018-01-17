package uber;

import java.util.HashMap;
import java.util.Map;

class MinWindow {
    public String minWindow(String s, String t) {
        
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        
        if(t.length() > s.length()){
            return "";
        }
        
        for(char ch: s.toCharArray()){
            map.put(ch, 0);
        }
        for(char ch: t.toCharArray()){
            if(map.containsKey(ch)){
                // int c = map.get(ch);
                map.put(ch, map.get(ch)+1);
            }else{
                return "";
            }
        }
        int counter = t.length(), start = 0, end = 0, minLength = Integer.MAX_VALUE;
        int minStart = 0;
        
        while(end < s.length()){
            
            char ch = s.charAt(end);
            if(map.get(ch) > 0){
                counter--;
            }
            map.put(ch,map.get(ch)-1);
            end++;
            while(counter == 0){
                
                if((end-start) < minLength){
                    minLength = end-start;
                    minStart = start;
                }
                
                char ch2 = s.charAt(start);
                map.put(ch2, map.get(ch2)+1);
                if(map.get(ch2) > 0){
                    counter++;
                }
                start++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart+minLength);
    }
    
    public static void main(String[] args){
    	
    	MinWindow obj = new MinWindow();
    	System.out.println(obj.minWindow("a", "a"));
    }
}