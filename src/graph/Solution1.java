package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

class Solution1 {
    Set<Integer> set = new HashSet<Integer>();
	
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> g[] = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            g[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < prerequisites.length; i++){
            g[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        
        boolean[] visited = new boolean[numCourses];
        for(int i = 0; i < numCourses; i++){
            if(!set.contains(i)&&isCycle(visited, g, i)){
                return false;
            }
        }        
        return true;
    }
    
    boolean isCycle(boolean[] visited, List<Integer> graph[], int start){
        
        if(visited[start]){
            return true;
        }
        visited[start] = true;
        Iterator<Integer> it = graph[start].iterator();
        while(it.hasNext()){
            int temp = it.next();
            if(isCycle(visited, graph, temp)){
                return true;
            }
        }
        visited[start] = false;
        set.add(start);
        return false;
    }
}