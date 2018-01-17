package facebook;

public class ValidPalindrome {

	public boolean isPalindrome(String s){

		String original = s.replaceAll("[^\\w]", "").toLowerCase();
		//DOUBT: what does \\w really mean ?
		System.out.println(original);
		String reverse = new StringBuilder(original).reverse().toString();
		if(original.equals(reverse)){
			return true;
		}
		return false;
	}
	
	public static void main(String[] args){
		ValidPalindrome obj = new ValidPalindrome();
		obj.isPalindrome("A man, a plan, a canal: Panama");
	}
}
