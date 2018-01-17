package uber;

public class Reverse {
    public void reverseWords(char[] s) {
        
        int start = 0;
        reverse(s, start, s.length-1);
        for(int i = 0; i < s.length; i++){
            if(s[i] == ' '){
              reverse(s, start, i-1);
            }
            start = i+1;
        }
        reverse(s, start, s.length-1);
        
    }
    
    private void reverse(char[] s, int start, int end){
        while(start < end){
            char temp = s[start];
            s[start] = s[end];
            s[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args){
    	
    	Reverse obj = new Reverse();
    	char[] arr = {'h', ' ', 'i',' ', '!'};
    	obj.reverseWords(arr);
    	
    }
}