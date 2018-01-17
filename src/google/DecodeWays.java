package google;

class DecodeWays {
    public int numDecodings(String s) {
        
        if(s == null || s.length() == 0){
            return 0;
        }
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        dp[1] = s.charAt(0) != '0' ? 1 : 0;
        for(int i = 2; i<= s.length(); i++){
            
            int first = Character.getNumericValue(s.charAt(i-1));
            int second = Integer.parseInt(s.substring(i-2, i));
            if(first <= 9 && first > 0){
                dp[i] += dp[i-1];
            }
            
            if(second >= 10 && second <= 26){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }

    
    public static void main(String[] args){
    	
    	DecodeWays obj = new DecodeWays();
    	System.out.println(obj.numDecodings("0"));
    }
}