package google;

public class ParagraphBreak {

    public String addBoldTag(String s, String[] dict) {

    	boolean[] dp = new boolean[s.length()];
    	for(String str: dict){
    		for(int i = 0; i <= s.length()-str.length(); i++){
    			if(s.substring(i, i+str.length()).equals(str)){
    				for(int j = i; j < i+str.length(); j++){
    					dp[j] = true;
    				}
    			}
    		}
    	}
    	StringBuilder builder = new StringBuilder();
    	for(int i = 0; i <s.length();){
    		if(dp[i]){
    			builder.append("<b>");
    			while(i <s.length() && dp[i]){
    				builder.append(s.charAt(i++));
    			}
    			builder.append("</b>");
    		}else{
    			builder.append(s.charAt(i++));    			
    		}
    	}
    	return builder.toString();
    }
    
    public static void main(String[] args){
    	
    	ParagraphBreak obj = new ParagraphBreak();
    	String[] dict = {"abc","123"};
    	String str = "abcxyz123";
    	System.out.println(obj.addBoldTag(str, dict));
    	
    }

}
