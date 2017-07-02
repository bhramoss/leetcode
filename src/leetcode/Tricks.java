package leetcode;

import java.math.BigInteger;

public class Tricks {

	public static void main(String args[]){
		
		System.out.println(Math.floor(Math.log10(12345))+1);
		System.out.println(BigInteger.valueOf(7).isProbablePrime(1));
		
		String a = "   shiva";
		a.replaceAll("^\\s+", "");
		System.out.println(a);
	}
}
