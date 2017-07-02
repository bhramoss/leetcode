package dynamicprogramming;

public class ShortestWordDistance {

    public int shortestDistance(String[] words, String word1, String word2) {
        
        int min = Integer.MAX_VALUE;
        int index1 = -1;
        int index2 = -1;
        
        for(int i = 0; i < words.length; i++){
            
            if(words[i].equals(word1)){
                index1 = i;
            }
            if(words[i].equals(word2)){
                index2 = i;
            }
            
            if(index1 != -1 && index2 != -1){
                min = Math.min(Math.abs(index1-index2),min);
            }
        }
        
        return min;
      }

    public static void main(String args[]){
    	
    	ShortestWordDistance obj = new ShortestWordDistance();
    	
    	String [] array = {"a","b","c","d","d"};
    	
    	System.out.println(obj.shortestDistance(array, "a", "d"));
    }
}
