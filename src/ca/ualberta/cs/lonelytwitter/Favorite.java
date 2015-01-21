package ca.ualberta.cs.lonelytwitter;

public interface Favorite {
	
	private User user;
	private LonelyTweetModel tweet;
	
	public Favorite(User user, LonelyTweetModel tweet);
		
	public User getUser();
	public LonelyTweetModel getTweet();
	
}

