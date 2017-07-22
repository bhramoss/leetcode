package trie;


public class Trie {

	public TrieNode root;

	public Trie() {

		this.root = new TrieNode();
	}

	public void insert(String word) {

		char[] wordArray = word.toCharArray();
		TrieNode temp = root;

		for (char ch : wordArray) {
			if (temp.map.get(ch) == null) {
				TrieNode node = new TrieNode();
				temp.map.put(ch, node);
				temp = node;
			} else {
				temp = temp.map.get(ch);
			}
		}
		temp.isEnd = true;
	}

	public boolean search(String word) {

		TrieNode temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.map.get(ch) != null) {
				temp = temp.map.get(ch);
			} else {
				return false;
			}
		}
		if (temp.isEnd)
			return true;
		else
			return false;

	}

	public boolean substringMatch(String word){
		
		TrieNode temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.map.get(ch) != null) {
				temp = temp.map.get(ch);
			} else {
				return false;
			}
		}
		return true;
	}
	
	public boolean startsWith(String word){
		
		TrieNode temp = root;

		for (char ch : word.toCharArray()) {
			if (temp.map.get(ch) != null) {
				temp = temp.map.get(ch);
			} else {
				return false;
			}
		}
		return true;
		
	}
	
	public static void main(String[] args) {

		Trie obj = new Trie();

		obj.insert("shiva");
		obj.insert("amrit");
		obj.insert("is");
		
		System.out.println(obj.search("shiva"));
		System.out.println(obj.substringMatch("shi"));
		System.out.println(obj.substringMatch("z"));		
	}

}
