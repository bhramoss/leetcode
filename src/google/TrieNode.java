package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TrieNode {

	Map<Character, TrieNode> map;
	List<String> wordList;
	boolean isLast;
	
	TrieNode(){
		map = new HashMap<Character, TrieNode>();
		wordList = new ArrayList<String>();
	}

	@Override
	public String toString() {
		return "TrieNode [map=" + map + ", isLast=" + isLast + "]";
	}

	
}
