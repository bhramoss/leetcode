package math;

public class ExcelColumnToTitle {

	  public String convertToTitle(int n) {
	        StringBuilder result = new StringBuilder();

	        while(n>0){
	            n--;
	            result.insert(0, (char)('A' + n % 26));
	            n /= 26;
	        }

	        return result.toString();
	    }
	  
	  public static void main(String[] args){
		  ExcelColumnToTitle obj = new ExcelColumnToTitle();
		  System.out.println(obj.convertToTitle(1));
	  }
}
