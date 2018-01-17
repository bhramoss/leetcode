package google;

import java.util.ArrayList;
import java.util.List;

public class Trie {

	TrieNode root;
	
	Trie(){
		root = new TrieNode();
	}
	
	public void insert(String word){
		
		TrieNode node = root;
		for(char ch: word.toCharArray()){
			if(!node.map.containsKey(ch)){
				TrieNode temp = new TrieNode();
				node.map.put(ch, temp);
				node = node.map.get(ch);
			}else{
				node = node.map.get(ch);
			}
			node.wordList.add(word);										
		}
		node.isLast = true;
	}
	
	public List<String> prefixSearch(String word) {

		List<String> list = new ArrayList<String>();
		TrieNode temp = root;
		for (char ch : word.toCharArray()) {
			if (temp.map.get(ch) != null) {
				temp = temp.map.get(ch);
			}
		}
		list.addAll(temp.wordList);
		return list;
	}

	@Override
	public String toString() {
		return "Trie [root=" + root + "]";
	}
	
	
}
