package graph;

import java.util.Stack;

public class AlienDictionary {

	Graph_R3 graph;
	public String alienOrder(String[] words) {

		graph = new Graph_R3();
		int size = words.length;
		for(int i = 0; i < size-1; i++){
			String word1 = words[i], word2 = words[i+1];
			for(int j = 0; j < Math.min(word1.length(), word2.length()); j++){
				if(word1.charAt(j) != word2.charAt(j)){
					graph.addEdge(word1.charAt(j), word2.charAt(j));
					break;
				}
			}
		}
		DetectCycle detect = new DetectCycle();
		if(detect.detectCycle(graph)){
			return "";
		}
		TopologicalSort sort = new TopologicalSort();
		Stack<Character> stack = sort.toposort(graph);
		StringBuilder builder = new StringBuilder();
		while(!stack.isEmpty()){
			builder.append(stack.pop());
		}
		return builder.toString();
    }

	public static void main(String[] args){
		
		AlienDictionary obj = new AlienDictionary();
		String[] words = {"z",
				  "x",
				  "z"};
		System.out.println(obj.alienOrder(words));
	}
}
