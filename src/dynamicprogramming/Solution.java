package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        String[] strs = str.split(" ");
        char[] patterns = pattern.toCharArray();
        if(patterns.length != strs.length) return false;
        
        for(int i = 0; i < patterns.length; i++){
            if(!map.containsKey(patterns[i])){
                map.put(patterns[i], strs[i]);
            }else{
                if(!map.get(patterns[i]).equals(strs[i])){
                    return false;
                }
            }
        }
        return true;
    }
}