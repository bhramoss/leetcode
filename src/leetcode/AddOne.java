package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AddOne {

    public int[] plusOne(int[] digits) {
    	
    	List<Integer> list = IntStream.of(digits).boxed().collect(Collectors.toList());  
    	Collections.reverse(list);
    	int carry = 1;
    	int count = 0;
    	
    	while(carry == 1 || count < list.size()){
    		
    		if(count >= list.size() && carry == 1){
    			list.add(1);
    			break;
    		}
    		
    		int result = list.get(count) + carry;
    		carry = 0;
    		
    		if(result > 9){
    			
    			carry = 1;
    			result = result - 10;
    			list.set(count, result);
    		}else{
    			list.set(count, result);
    		}
    		count++;
    	}
    	
    	Collections.reverse(list);
    	int[] array = new int[list.size()];
    	
    	for(int i = 0; i < list.size(); i++){
    		array[i] = list.get(i);
    	}
    	return array;
    }
    	
    public static void main(String args[]){
    	
    	AddOne obj = new AddOne();
    	
    	int [] array = {9,1};
    	array = (obj.plusOne(array));
    	
    	for(int i = 0; i < array.length; i++){
    		System.out.print(array[i] + " ");
    	}
    }
}
