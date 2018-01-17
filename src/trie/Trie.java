package trie;

import java.util.ArrayList;
import java.util.List;

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
			temp.wordList.add(word);							
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

	public boolean substringMatch(String word) {

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

	public boolean startsWith(String word) {

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

		obj.insert("ball");
		obj.insert("bald");
		obj.insert("bawl");

		List<String> list = obj.prefixSearch("");
		System.out.println(list);
	}

}
