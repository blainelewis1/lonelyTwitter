package ca.ualberta.cs.lonelytwitter;

public abstract class ReTweetModel extends LonelyTweetModel {
	
	
	private LonelyTweetModel originalTweet;
	protected User user;

	
	
	public ReTweetModel(LonelyTweetModel originalTweet) {
		this.originalTweet = originalTweet;
	}
	
	public LonelyTweetModel getOriginalTweet() {
		return originalTweet;
	}


	public void setOriginalTweet(LonelyTweetModel originalTweet) {
		this.originalTweet = originalTweet;
	}


	public abstract void getUser();


	public void setUser(User user) {
		this.user = user;
	}



	
	
}
