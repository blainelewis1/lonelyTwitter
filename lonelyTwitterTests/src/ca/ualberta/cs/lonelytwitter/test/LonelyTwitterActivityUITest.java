package ca.ualberta.cs.lonelytwitter.test;

import java.util.HashSet;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import ca.ualberta.cs.lonelytwitter.LonelyTweetModel;
import ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity;
import ca.ualberta.cs.lonelytwitter.NormalTweetModel;

/*
 * generate this class with new.. JUnit Test Case
 * set superclass to ActivityInstrumentationTestCase2
 */
public class LonelyTwitterActivityUITest extends
		ActivityInstrumentationTestCase2<LonelyTwitterActivity> {

	Instrumentation instrumentation;
	Activity activity;
	EditText textInput;
	
	public LonelyTwitterActivityUITest() {
		super(LonelyTwitterActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
		instrumentation = getInstrumentation();
		activity = getActivity();

		textInput = ((EditText) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.body));
	}
	
	/*
	 * fills in the input text field and clicks the 'save'
	 * button for the activity under test
	 */
	private void makeTweet(final String text) {
		instrumentation.runOnMainSync(new Runnable(){

			@Override
			public void run() {
				assertNotNull(activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save));
				textInput.setText(text);
				((Button) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.save)).performClick();
			}});

	}

	public void testAddTweet() {
		ListView listView = ((ListView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.oldTweetsList));
		
		@SuppressWarnings("unchecked")
		ArrayAdapter<NormalTweetModel> adapter = (ArrayAdapter<NormalTweetModel>) listView.getAdapter();
		

		
		int oldCount = adapter.getCount();
		
		String text = "My text";
		
		makeTweet(text);
		
		
		assertEquals("adater got a new count", oldCount + 1, adapter.getCount());
		
		assertEquals("Text matches", text, adapter.getItem(oldCount).getText());
		
		assertEquals("instance type matches", NormalTweetModel.class, adapter.getItem(oldCount).getClass());
	}
	
	public void testSetText() {
		String text = "tweet";
		
		instrumentation.runOnMainSync(new Runnable(){

			@Override
			public void run() {
				String text = "tweet";
				textInput.setText(text);
			}});
		instrumentation.waitForIdleSync();
		assertEquals("Text input is set properly",text, textInput.getText().toString());
	}

}
