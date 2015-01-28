package ca.ualberta.cs.lonelytwitter.test;

import java.util.Date;

import android.test.ActivityInstrumentationTestCase2;
import ca.ualberta.cs.lonelytwitter.ImportantTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

public class NormalTweetModelTest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public NormalTweetModelTest() {
		super(LonelyTwitterActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
		
		
	}
	
	public void testEquals() {
		String text = "hi";
		
		Date date1 = new Date();
		Date date2 = new Date(213);
		NormalTweetModel tweetSameTextDate1 = new NormalTweetModel(text, date1);
		NormalTweetModel tweetSameTextDate2 = new NormalTweetModel(text, date2);
		
		assertFalse("Different tweets are different", tweetSameTextDate1.equals(tweetSameTextDate2));
		
		Date d = new Date();
		
		ImportantTweetModel importantTweet = new ImportantTweetModel("important", d);
		NormalTweetModel normalTweet = new NormalTweetModel("Important! important", d);
		
		assertFalse("Important tweets != normal tweets", importantTweet.equals(normalTweet));
		assertFalse("normal tweets != Important tweets", normalTweet.equals(importantTweet));
		
	}

}
