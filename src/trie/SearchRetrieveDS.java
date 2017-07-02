package trie;

import java.util.Map;

public class SearchRetrieveDS {

	Trie trie;
	public SearchRetrieveDS(){
		trie = new Trie();
	}
	
	public boolean search(String word){
		
		TrieNode root = trie.root;
		return search(root, 0, word.toCharArray(), word);
	}
	public boolean search(TrieNode node, int current, char[] w, String word){
		
		if(current == w.length){
			return searchUtil(w);
		}else{
			if(w[current] == '.'){
				Map<Character, TrieNode> map = node.map;
				for(Map.Entry<Character, TrieNode> entry : map.entrySet()){
					TrieNode temp = entry.getValue();
					char ch = entry.getKey();
					w[current] = ch;
					if(search(temp, current+1, w, word)){
						return true;
					}
					w[current] = '.';
				}
			}else{
				TrieNode temp = node.map.get(w[current]);
				if(temp != null)
				return search(temp, current+1, w, word);
			}
		}
		return false;
	}
	
	private boolean searchUtil(char[] word){
		
		StringBuffer buffer = new StringBuffer();
		for(char ch : word){
			buffer.append(ch);
		}
		return trie.search(buffer.toString());
	}

	public static void main(String[] args){
		SearchRetrieveDS obj = new SearchRetrieveDS();
		obj.trie.insert("shiva");
		obj.trie.insert("vivah");
//		obj.trie.insert("bivah");
		obj.trie.insert("lavab");
//		System.out.println(obj.trie.search("bla"));
		System.out.println(obj.search("l...."));
	}
}
