package leetcode;

public class ExcelNumber {

    public int titleToNumber(String s) {
        
        char [] array = s.toCharArray();
        
        int count = array.length-1;
        int result = 0;
        
        for(char ch : array){
            
        	int n = ch-'A' +1;
            result += n* Math.pow(26,count);
            count--; 
        }
        return result;
    }
    
    public static void main(String[] args){
    	
    	ExcelNumber obj = new ExcelNumber();
    	System.out.println(obj.titleToNumber("AB"));
    }
}
