package leetcode;

import java.util.Arrays;

public class BitWiseMagic {

	public double myPow(double x, int n) {

		double ans = 1;
		long absN = Math.abs((long) n);
		while (absN > 0) {
			long a = absN & 1;
			if ((absN & 1) == 1)
				ans *= x;
			absN >>= 1;
			x *= x;
		}
		return n < 0 ? 1 / ans : ans;
	}

	public static void main(String args[]) {

		char []c = {'s','h','i','v','a'};

		StringBuilder builder = new StringBuilder();
		
		for(int i = 0; i < c.length; i++){
			builder.append(c[i]);
		}
		String a= builder.toString();
		
		BitWiseMagic obj = new BitWiseMagic();
		
		obj.myPow(2, 9);
		
//		int num = 8;
//
//		while (num > 0) {
//
//			System.out.print(num & 1);
//			num >>= 1;
//			System.out.println(num);
//		}
	}
}
