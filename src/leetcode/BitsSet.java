package leetcode;

//Check if all bits of a number are set
public class BitsSet {

	public boolean isSet(int num){
		
		while(num != 0){
			int r = 1;
			 r &= num;
			 if(r == 0) return false;
			 num >>= 1;
		}
		return true;
	}
	
	public static void main(String[] args){
		
		BitsSet obj = new BitsSet();
		System.out.println(obj.isSet(7));
	}
}
