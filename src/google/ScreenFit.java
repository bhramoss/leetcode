package google;

class ScreenFit {
    public int wordsTyping(String[] sentence, int rows, int cols) {
    	String s = String.join(" ", sentence) + " ";
    	System.out.println(s+"test");
        int len = sentence.length;
        int count = 0;
        int i = 0;
        int temp = cols;
        while(rows > 0){
            int sentNum= i%len;
            String string = sentence[sentNum];
            if(string.length()+1 <= temp || string.length() == temp){
//            	System.out.print(string);
            	if(!(string.length() == temp)){
//            		System.out.print("-");
            	}
                i++;
                temp -= string.length()+1;
                if(i%len == 0){
                    count++;
//                    System.out.print(count);
                }
                continue;
            }else{
                rows--;
                temp = cols;
//                System.out.println();
            }
        }
        return count;
    }
    
    public static void main(String[] args){
    	
    	ScreenFit obj = new ScreenFit();
    	String[] sentence = {"abc", "de", "f"};
    	System.out.println(obj.wordsTyping(sentence, 4, 6));
    }

}