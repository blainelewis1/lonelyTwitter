package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;
import ca.ualberta.cs.lonelytwitter.TweetListModel;
import android.test.ActivityInstrumentationTestCase2;

public class TwitterListModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	
	TweetListModel tweets;
	
	public TwitterListModelTest() {
		super(LonelyTwitterActivity.class);
	}
	protected void setUp()  throws Exception {
		super.setUp();
		
		tweets = new TweetListModel();
		
	}
	
	public void testCounts() {
		assertEquals("Count should be zero", tweets.getCount(), 0);
		
		tweets.addTweet(new NormalTweetModel("Hello"));
		
		assertEquals("Count should be one", tweets.getCount(), 1);
		
	}

	public void testRemoveTweets() {
		NormalTweetModel tweet = new NormalTweetModel("helllllo");
		
		tweets.addTweet(tweet);
		
		tweets.removeTweet(tweet);
		
		assertFalse("Should not contain tweet", tweets.hasTweet(tweet));
		assertEquals("Count needs to be decremented", tweets.getCount(), 0);
	
	}

	public void testAddTweets() {
		assertNotNull("Tweets should not be null", tweets.getTweetsList());
		
		NormalTweetModel tweet = new NormalTweetModel("hello");
		
		tweets.addTweet(tweet);
		
		assertEquals("Should only have one tweet", tweets.getCount(), 1);
		assertTrue("Should contain tweet", tweets.hasTweet(tweet));
		
		
		try  {
			tweets.addTweet(tweet);
			fail("Cannot add two of the same tweets");
		} catch (IllegalArgumentException e) {}
		
	}
	
}
