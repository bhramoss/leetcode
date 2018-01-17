package graph;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CourseSchedule {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        List<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] currentStack = new boolean[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(isCycle(graph, visited, currentStack, i)){
                return false;
            }
        }
        return true;
    }
    
    private boolean isCycle(List<Integer> adj[], boolean[] visited, boolean[] currentStack, int start){
        
        visited[start] = true;
        currentStack[start] = true;
        Iterator<Integer> it = adj[start].iterator();
        while(it.hasNext()){
            int temp = it.next();
            if(!visited[temp] && isCycle(adj, visited, currentStack, temp)){
                return true;
            }else if(currentStack[temp]){
                return true;
            }
        }
        currentStack[start] = false;
        return false;
    }
	 
	 public static void main(String[] args){
		 CourseSchedule obj = new CourseSchedule();
		 int [][] prerequisites = {{1,0},{3,0}, {1,2},{1,4}};
		 System.out.println(obj.canFinish(5, prerequisites));
	 }
}
