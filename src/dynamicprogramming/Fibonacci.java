package dynamicprogramming;

public class Fibonacci {

	private int fibRecur(int number){
		
		if(number<=1) return number;
		
		return fibRecur(number-1) + fibRecur(number-2);
	}
	
	private int fibMemoization(int number){
		
		int array[] = new int[number+1];
		array[0] = 0;
		array[1] = 1;
		
		for(int i = 2; i <= number; i++){
			
			array[i] = array[i-1] + array[i-2];
		}
		return array[number];
	}
	
	private int fibDP(int number){
		
		int a = 0;
		int b = 1;
		int c = 0;
		if(number == 0) return a;
		if(number == 1) return b;
		
		for(int i = 2; i <= number; i++){
			
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}
	
	public static void main(String[] args){
		
		Fibonacci obj = new Fibonacci();
		System.out.println(obj.fibRecur(9));
		System.out.println(obj.fibMemoization(9));
		System.out.println(obj.fibDP(9));
	}
}
