package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class Solution {

    char[][] board;
    Set<String> set = new HashSet<>();
    TrieNode root = new TrieNode();

public List<String> findWords(char[][] board, String[] words) {
    
    this.board = board;
    
    boolean [][]visited = new boolean[board.length][board[0].length];
    for(String s : words){
        insert(s);
    }
    
    for(int i = 0; i < board.length; i++){
        for(int j = 0; j < board[0].length; j++){
            dfs(i,j,"",set,visited);
        }
    }
    
    return new ArrayList<>(set);        
}

public void dfs(int i, int j, String str, Set<String> set, boolean[][] visited){
    
    if(i < 0 || j < 0 || i >= board.length || j >= board[0].length) return;
    
    if(visited[i][j]) return;
    str = str + board[i][j];
    if(!startsWith(str)) return;
     if(search(str)){
         set.add(str);
         return;
     }

     visited[i][j] = true;
     dfs(i-1,j,str,set,visited);
     dfs(i+1,j,str,set,visited);
     dfs(i,j-1,str,set,visited);
     dfs(i,j+1,str,set,visited);
     visited[i][j] = false;
    
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
//		if (temp.isEnd)
//			return true;
//		else
//			return false;
		
		if(word.equals(temp.word)) return true;
		else return false;

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
//		temp.isEnd = true;
		temp.word = word;
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


private class TrieNode {

	Map<Character, TrieNode> map;
	boolean isEnd;
	String word;

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public TrieNode() {
		this.map = new HashMap<>();
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
		return "TrieNode [map=" + map + ", isEnd=" + isEnd + ", word=" + word + "]";
	}
	
	

}

	
	public static void main(String args[]){
		
		Solution obj = new Solution();
		
		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
		String[] words = {"oath","pea","eat","rain"};
		System.out.println(obj.findWords(board, words));
		
	}

}
