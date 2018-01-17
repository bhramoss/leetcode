package google;

import java.util.ArrayList;
import java.util.List;

class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        
        boolean[] dp = new boolean[s.length()+1];
        
        dp[0] = true;
        
        for(int i = 1; i <= s.length(); i++){
            for(int j = 0; j < i; j++){
                String temp = s.substring(j,i);
                if(wordDict.contains(temp) && dp[j]){
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
    
    public static void main(String[] args){
    	
    	WordBreak obj = new WordBreak();
    	List<String> list= new ArrayList<String>();
    	list.add("leet");
    	list.add("code");
    	System.out.println(obj.wordBreak("leetcode", list));
    	
    }
    
}