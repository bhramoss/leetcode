package uber;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WordBreak2 {

	Map<Integer, List<String>> map = new HashMap<>();
	
    public List<String> wordBreak(String s, List<String> wordDict) {
        
    	List<String> result = new ArrayList<String>();
    	List<List<String>> f = new ArrayList<List<String>>();
    	wordBreakUtil(result, s, 0, wordDict, f);
    	List<String> answer = new ArrayList<String>();
    	for(List<String> li : f){
    		answer.add(String.join(" " , li));
    	}
    	return answer;
    }
    
    
    private void wordBreakUtil(List<String> list, String s, int i, List<String> wordDict, List<List<String>> result){
    	
    	if(i == s.length()){
    		result.add(new ArrayList<String>(list));
    		return;
    	}
    	
    	for(int k = i+1; k <= s.length(); k++){
    		String variableString = s.substring(i, k);
    		if(wordDict.contains(variableString)){
    			list.add(variableString);
    			wordBreakUtil(list, s, k, wordDict, result);
    	    	map.put(i, new ArrayList<String>(list));
        		list.remove(list.size()-1);    	
    		}
    	}
    }

    public static void main(String[] args){
    	WordBreak2 obj = new WordBreak2();
    	List<String> list = new ArrayList<>();
    	list.add("cat");
    	list.add("cats");
    	list.add("and");
    	list.add("sand");
    	list.add("dog");
//    	list.add("a");
    	System.out.println(obj.wordBreak("catsanddog", list));
    }
}
