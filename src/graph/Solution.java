package graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;


public class Solution {
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        
        boolean[] visited = new boolean[numCourses];
        boolean[] currentStack = new boolean[numCourses];
        
        for(int i = 0; i < prerequisites.length; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        boolean flag = false;
        for(int i = 0; i < numCourses; i++){
            if(isCycle(graph, visited, currentStack, i)){
                flag = true;
            }
        }
        int[] result = new int[numCourses];
        if(flag){
            return result;
        }
        
        Stack<Integer> stack = toposort(graph, numCourses);
        int i = 0;
        while(!stack.isEmpty()){
            result[i] = stack.pop();
            i++;
        }
        return result;
    }
    
	public Stack<Integer> toposort(List<Integer> adj[], int v){
		
		Stack<Integer> stack = new Stack<>();
		Set<Integer> visited = new HashSet<>();
		for(int i = 0; i < v; i++){
			if(visited.contains(i)){
				continue;
			}
			topoUtil(i, stack, visited, adj);
		}
		return stack;
		
	}
    
	private void topoUtil(int vertex, Stack<Integer> stack, Set<Integer> visited, List<Integer> adj[]){
		
		visited.add(vertex);
		Iterator<Integer> it = adj[vertex].listIterator();
		while(it.hasNext()){
			int childVertex = it.next();
			if(visited.contains(childVertex)){
				continue;
			}
			topoUtil(childVertex, stack, visited, adj);
		}
		stack.push(vertex);
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
    	Solution obj = new Solution();
		 int [][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		 int[] result = obj.findOrder(4, prerequisites);
		 for(int i = 0; i < result.length; i++){
			 System.out.print(result[i] + " ");
		 }
    	
    }
}