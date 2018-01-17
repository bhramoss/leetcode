package google;

import java.util.ArrayList;
import java.util.List;

public class WordSquare {

	Trie root = new Trie();
	
    public List<List<String>> wordSquares(String[] words) {
        
    	List<List<String>> result = new ArrayList<>();
    	if(words == null || words.length == 0) return result;
    	
    	for(String word: words){
    		root.insert(word);
    	}
    	
//    	System.out.println(root.prefixSearch("l"));
    	int length = words[0].length();
    	List<String> resultBuilder = new ArrayList<String>();
    	for(String word: words){
    		resultBuilder.add(word);
    		wordSquaresSearch(resultBuilder, result, length);
    		resultBuilder.remove(resultBuilder.size()-1);
    	}
    	return result;
    }
    
    public void wordSquaresSearch(List<String> resultBuilder, List<List<String>> result, int len){
    	
    	if(resultBuilder.size() == len){
    		result.add(new ArrayList<>(resultBuilder));
    		return;
    	}
    	//build prefix:
    	StringBuilder prefixBuilder = new StringBuilder();
    	int index = resultBuilder.size();
    	for(String str: resultBuilder){
    		prefixBuilder.append(str.charAt(index));
    	}
    	List<String> wordList = this.root.prefixSearch(prefixBuilder.toString());    	
    	for(String word: wordList){
    		resultBuilder.add(word);
    		wordSquaresSearch(resultBuilder, result, len);
    		resultBuilder.remove(resultBuilder.size()-1);
    	}
    }
    
    public static void main(String[] args){
    	
    	WordSquare obj = new WordSquare();
    	String[] array = {"abat","baba","atan","atal"};
    	//ans: [["baba","abat","baba","atal"],["baba","abat","baba","atan"]]
    	List<List<String>> result = obj.wordSquares(array);
    	System.out.println(result);
    }

}
