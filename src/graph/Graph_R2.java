package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph_R2 {

	public Map<String, List<String>> map;
	public Graph_R2(){
		map = new HashMap<String, List<String>>();
	}
	
	public void addEdge(String v1, String v2){
		if(!map.containsKey(v1)){
			List<String> temp = new ArrayList<String>();
			temp.add(v2);
			map.put(v1, temp);
		}else{
			map.get(v1).add(v2);
		}
	}

	public Map<String, List<String>> getMap() {
		return map;
	}

	public void setMap(Map<String, List<String>> map) {
		this.map = map;
	}
	
	
}
