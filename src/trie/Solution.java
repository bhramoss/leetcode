package trie;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
  
        List<Integer> graph[] = new ArrayList[numCourses];
        for(int i = 0; i < numCourses; i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i = 0; i < numCourses; i++){
            graph[prerequisites[i][1]].add(prerequisites[i][0]);
        }
        List<Integer> result = new ArrayList<Integer>();
         topologicalSort(graph, numCourses, result);
        return result.stream().mapToInt(i -> i).toArray();
    }
    
    private boolean topologicalSort(List<Integer> graph[], int V, List<Integer> result){
        
        int[] indegree = new int[V];
        
        for(int i = 0; i < V; i++){
            List<Integer> temp = graph[i];
            for(int node: temp){
                indegree[node]++;
            }
        }
        
        Queue<Integer> queue = new LinkedList<Integer>();
        for(int i = 0; i < indegree.length; i++){
            if(indegree[i] == 0){
                queue.offer(i);
            }
        }
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{-1,1});
        int temp[] = stack.pop();
        temp = stack.pop();
        int count = 0;
                
        while(!queue.isEmpty()){
            
            int u = queue.poll();
            result.add(u);
            
            for(int i : graph[u]){
                if(--indegree[i] == 0){
                    queue.add(i);
                }
            }
            count++;
        }
        if(count != V) return false;
        
        return true;
    }
}