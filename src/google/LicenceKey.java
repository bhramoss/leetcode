package google;

class LicenceKey {
    public String licenseKeyFormatting(String S, int K) {
        
    	S = S.replaceAll("-", "");
    	int length = S.length();
    	StringBuilder builder = new StringBuilder();
    	if(length%K == 0){
    		for(int i = K; i <= length; i+=K){
    			builder.append(S.substring(i-K, i));
    			builder.append("-");
    		}
    		}else{
    			builder.append(S.substring(0, length%K));
    			builder.append("-");    				
    			for(int i = length%K+K; i <= length; i+=K){
        			builder.append(S.substring(i-K, i));
        			builder.append("-");    				
    			}
    		}
    return builder.deleteCharAt(builder.length()-1).toString().toUpperCase();
    }
    public static void main(String[] args){
    	
    	LicenceKey obj = new LicenceKey();
    	
    	System.out.println(obj.licenseKeyFormatting("2-5g-3-J", 2));
    }

}