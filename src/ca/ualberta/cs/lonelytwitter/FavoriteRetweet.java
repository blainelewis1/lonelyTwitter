package ca.ualberta.cs.lonelytwitter;

public class FavoriteRetweet implements Favorite {

	
	public FavoriteRetweet(ReTweetModel tweet, User user){
		this.tweet = tweet;
		this.user = user;
	}
	
	public User getUser() {
		return this.model;
	}

	public LonelyTweetModel getTweet() {
		return this.tweet;
	
	}

}
