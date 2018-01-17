package uber;

import java.util.Stack;

public class DelimiterMatching {

	public boolean delimitMactch(String string){
		
		Stack<Character> stack = new Stack<Character>();
		for(char ch: string.toCharArray()){
			if(ch == '(' || ch == '{' || ch == '['){
				stack.push(ch);
			}else{
				switch(ch){
				case '}':
					if(stack.pop() != '{')
						return false;
					break;
				case ')':
					if(stack.pop() != '(')
						return false;
					break;
				case ']':
					if(stack.pop() != '[')
						return false;
					break;
				}
					
				
			}
		}
		
		return true;
	}
	
	public static void main(String[] args){
		DelimiterMatching obj = new DelimiterMatching();
		System.out.println(obj.delimitMactch("[ { ] } "));
	}
}
