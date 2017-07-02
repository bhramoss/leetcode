package leetcode;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {


    Map<Integer,Integer> map;
    /** Initialize your data structure here. */
    public TwoSum() {
        
        map = new HashMap<Integer,Integer>();
    }
    
    /** Add the number to an internal data structure.. */
    public void add(int number) {
        
        if(map.containsKey(number)){
            
            map.put(number,map.get(number)+1);
        }else{
            map.put(number,1);
        }
    }
    
    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
        
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            
            int key = entry.getKey();
            int val = entry.getValue();
            
            int newVal = val-1;
            
            map.put(key,newVal);
            
            int newKey = value-key;
            
            if(map.get(newKey) != null && map.get(newKey) > 0){
                
                map.put(key,val);
                return true;
            }
                map.put(key,val);
            
        }
        return false;
    }
    
    public static void main(String args[]){
    	
    	TwoSum obj = new TwoSum();
    	obj.add(1);
    	obj.add(3);
    	obj.add(5);
    	obj.find(4);
    	obj.find(7);
    	
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */