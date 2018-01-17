package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class TrieNode {
	Map<Character, TrieNode> map;
	boolean isEnd;
	String word;
	List<String> wordList;	

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public TrieNode() {
		this.map = new HashMap<>();
		this.wordList = new ArrayList<String>();
		this.isEnd = false;
	}

	public Map<Character, TrieNode> getMap() {
		return map;
	}

	public void setMap(Map<Character, TrieNode> map) {
		this.map = map;
	}

	public boolean isEnd() {
		return isEnd;
	}

	public void setEnd(boolean isEnd) {
		this.isEnd = isEnd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TrieNode [map=");
		builder.append(map);
		builder.append(", isEnd=");
		builder.append(isEnd);
		builder.append(", word=");
		builder.append(word);
		builder.append("]");
		return builder.toString();
	}
	
	
}
