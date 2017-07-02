package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class WordBreak {

    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean [] dp = new boolean[s.length()+1];
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
            	System.out.println(s.substring(j,i));
                if(wordDict.contains(s.substring(j,i)) && dp[j]){
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
	
    public static void main(String[] args){
    	WordBreak obj = new WordBreak();
    	String s = "carscar";
    	List<String> wordDict = new ArrayList<>();
    	wordDict.add("car");
    	wordDict.add("ars");
    	System.out.println(obj.wordBreak(s, wordDict));
    }
}
