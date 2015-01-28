package ca.ualberta.cs.lonelytwitter.test;

import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import android.test.ActivityInstrumentationTestCase2;

public class LonelyTweetModelTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	public LonelyTweetModelTest () {
		super(LonelyTwitterActivity.class);
	}
	
	protected void setUp() throws Exception {
		super.setUp();
	}
	public void testSampleCode() {
		assertTrue("This is not true", isGreaterEqual(7, 6));
		//fail("this is a failing test");
	}
	
	public boolean isGreaterEqual(int i, int j) {
		return i >= j;
	}
}
