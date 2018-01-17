package google;

class LongestPalindromSubsequence {
    public String longestPalindrome(String s) {
        
        String reverse = new StringBuilder(s).reverse().toString();
        return longestCommonSubstring(s, reverse);
    }
    
    String longestCommonSubstring(String s1, String s2){
        
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        
        int len = s1.length();
        for(int i = 1; i <= len; i++){
            for(int j = 1; j <= len; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = 0;
                }
            }
        }
        
        StringBuilder builder = new StringBuilder();
        int row = 0, col = 0;
        int max = 0;
        for(int i = 1; i <= len; i ++){
            for(int j = 1; j <= len; j++){
                if(dp[i][j] > max){
                    max = dp[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        while(row >= 0 && col >= 0 && dp[row][col] != 0){
            builder.append(s1.charAt(--row));
            --col;
        }
        return builder.toString();
    }
    
    public static void main(String[] args){
    	
    	LongestPalindromSubsequence obj = new LongestPalindromSubsequence();
    	
    	System.out.println(obj.longestPalindrome("abcdasdfghjkldcba"));
    }
}