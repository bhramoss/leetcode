package uber;

public class BigIntegerAddition {
	
	
	public String add(String num1, String num2){
		
		String n1 = new StringBuilder(num1).reverse().toString();
		String n2 = new StringBuilder(num2).reverse().toString();
		int l1 = n1.length();
		int l2 = n2.length();
		int carry = 0;
		int index = 0;
		StringBuilder result = new StringBuilder();
		while(l1 > 0 || l2 > 0 || carry > 0){
			int sum = 0;
			if(l1 > 0){
				sum += n1.charAt(index)-'0';
			}
			if(l2 > 0){
				sum += n2.charAt(index)-'0';
			}
			if(carry > 0){
				sum += carry;
			}
			if(sum > 0)
			result.append(sum%10);
			carry = sum/10;
			index++;
			l1--;
			l2--;
		}
		return result.reverse().toString();
	}

	public static void main(String[] args){
		
		BigIntegerAddition obj = new BigIntegerAddition();
		System.out.println(obj.add("123", "45"));
	}

}
