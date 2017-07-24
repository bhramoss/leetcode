package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_R3 {

	Map<Character, List<Character>> map;
	public Graph_R3(){
		map = new HashMap<>();
	}
	
	public void addEdge(char edge1, char edge2){
		
		if(!map.containsKey(edge1)){
			List<Character> temp = new ArrayList<>();
			temp.add(edge2);
			map.put(edge1, temp);
		}else{
			map.get(edge1).add(edge2);
		}
	}

	public Map<Character, List<Character>> getMap() {
		return map;
	}

	public void setMap(Map<Character, List<Character>> map) {
		this.map = map;
	}

	@Override
	public String toString() {
		return "Graph_R3 [map=" + map + "]";
	}
	
}
