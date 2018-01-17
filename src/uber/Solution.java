package uber;

import java.util.LinkedHashMap;
import java.util.Map;

class LRUCache {

    Map<Integer, Integer> map;
    int capacity;
    int currentSize = 0;
    public LRUCache(int capacity) {
        this.map = new LinkedHashMap<Integer, Integer>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        
        if(map.containsKey(key)){
            int value = map.get(key);
            map.remove(key);
            map.put(key, value);
            return value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        
        if(capacity == currentSize){
            if(map.containsKey(key)){
                map.remove(key);
                map.put(key, value);
            }else{
                int temp = map.entrySet().iterator().next().getValue();
                map.remove(temp);
                map.put(key, value);
            }
        }else{
            currentSize++;
            map.put(key, value);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */