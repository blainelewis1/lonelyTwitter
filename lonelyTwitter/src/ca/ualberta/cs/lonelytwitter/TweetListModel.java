package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;

public class TweetListModel {

	private ArrayList<LonelyTweetModel> tweets;
	
	public TweetListModel() {
		tweets = new ArrayList<LonelyTweetModel>();
	}
	
	public int getCount() {
		return tweets.size();
	}

	public void addTweet(LonelyTweetModel tweet) {
		if(hasTweet(tweet)){
			throw new IllegalArgumentException("Two equal tweets cannot be in the same list");
		}
		
		tweets.add(tweet);
	}
	
	public LonelyTweetModel[] getTweets() {
		return tweets.toArray(new LonelyTweetModel[tweets.size()]);
	}
	
	public boolean hasTweet(LonelyTweetModel tweet) {
		return tweets.contains(tweet);
	}
	
	public void removeTweet(LonelyTweetModel tweet) {
		tweets.remove(tweet);
		
	}
	
	public ArrayList<LonelyTweetModel> getTweetsList() {
		return tweets;
	}

}
