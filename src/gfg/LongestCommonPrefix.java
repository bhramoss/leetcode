package gfg;

public class LongestCommonPrefix {

	public String longestCommonPrefix(String []strings, int low, int high){
		
		if(low == high){
			return strings[low];
		}
		//Avoids overflow
		int mid = low + (high-low)/2;
		String string1 = longestCommonPrefix(strings, low, mid);
		String string2 = longestCommonPrefix(strings, mid+1, high);
		return longestCommonPrefixUtil(string1, string2);
	}
	
	private String longestCommonPrefixUtil(String string1, String string2){
		
		StringBuilder result = new StringBuilder();
		for(int i = 0, j = 0; i < Math.min(string1.length(), string2.length()); i++,j++){
			if(string1.charAt(i) != string2.charAt(j)){
				break;
			}
			result.append(string1.charAt(i));
		}
		return result.toString();
	}
	
	public static void main(String[] args){
		
		LongestCommonPrefix obj = new LongestCommonPrefix();
		String[] array = {"geeks","geek","geezer"};
		System.out.println(obj.longestCommonPrefix(array, 0, array.length-1));
	}
}
