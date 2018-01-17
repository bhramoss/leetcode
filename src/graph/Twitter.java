package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Twitter {

	
	
	/*
	 * Complete the function below.
	 */
	static int[] getRecommendedTweets(int[][] followGraph_edges, int[][] likeGraph_edges, 
	                                  int targetUser, int minLikeThreshold) {
		
		
	Map<Integer, List<Integer>> mapUser = new  HashMap<>();	
	
	for(int[] arr: followGraph_edges){
		int source = arr[0];
		int dest = arr[1];
		if(!mapUser.containsKey(source)){
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(dest);
			mapUser.put(source, temp);
		}else{
			List<Integer> exists = mapUser.get(source);
			exists.add(dest);
			mapUser.put(source, exists);
		}
		
	}
	
	Map<Integer, List<Integer>> mapLikes = new  HashMap<>();	
	
	for(int[] arr: likeGraph_edges){
		int source = arr[0];
		int tweetId = arr[1];
		if(!mapLikes.containsKey(source)){
			List<Integer> temp = new ArrayList<Integer>();
			temp.add(tweetId);
			mapLikes.put(source, temp);
		}else{
			List<Integer> exists = mapLikes.get(source);
			exists.add(tweetId);
			mapLikes.put(source, exists);
		}
		
	}
	
	List<Integer> followers = mapUser.get(targetUser);
	
	for(int i : followers){
	
		List<Integer> tweetList =mapLikes.get(i);
		for(int tweet : tweetList){
			Tweet temp = new  Tweet(tweet);
			temp.count++;
		}
		
	}
		return new int[2];
	}
	
}
 class Tweet{
	
	int tweet;
	int count = 0;
	
	public Tweet(int tweet){
		this.tweet = tweet;
	}
}

