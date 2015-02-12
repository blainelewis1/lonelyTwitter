package ca.ualberta.cs.lonelytwitter.test;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ViewAsserts;
import android.widget.TextView;
import ca.ualberta.cs.lonelytwitter.IntentReaderActivity;

public class IntentReaderActivityTest extends
		ActivityInstrumentationTestCase2<IntentReaderActivity> {

	public IntentReaderActivityTest() {
		super(IntentReaderActivity.class);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	public void testSendText() {
		String text = "Hello world!";
		
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		
		assertEquals("Activity did not set text", text, activity.getText());
	
	}

	public void testDoubleText() {
		String text = "Hello world!";
		
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.DOUBLE);
		
		assertEquals("Activity did not double text", text + text, activity.getText());
	
	}
	
	public void testReverseText() {
		String text = "Hello world!";
		
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.REVERSE);
		
		assertEquals("Activity did not reverse text", new StringBuilder(text).reverse().toString(), activity.getText());
	
	}
	
	public void testDisplayText() {
		String text = "hello";
		IntentReaderActivity activity = startWithText(text, IntentReaderActivity.NORMAL);
		
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);
		assertEquals("Text displayed is correct", text, textView.getText().toString());
	}
	
	public void testDefautText() {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, IntentReaderActivity.NORMAL);
		setActivityIntent(intent);
		
		IntentReaderActivity activity = getActivity();
		
		
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);

		assertEquals("Defaut text is set", IntentReaderActivity.DEFAULT_TEXT, textView.getText().toString());
		assertEquals("Gettext should return empty string", null, activity.getText());
	}
	
	public void testTextViewVisible() {
		
		IntentReaderActivity activity = startWithText("Hello world", IntentReaderActivity.REVERSE);
		TextView textView = (TextView) activity.findViewById(ca.ualberta.cs.lonelytwitter.R.id.intentText);

		ViewAsserts.assertOnScreen(activity.getWindow().getDecorView(), textView);
		
	}
	
	private IntentReaderActivity startWithText(String text, int mode) {
		Intent intent = new Intent();
		intent.putExtra(IntentReaderActivity.TEXT_KEY, text);
		intent.putExtra(IntentReaderActivity.TRANSFORM_KEY, mode);
		
		setActivityIntent(intent);
			
		return getActivity();
	}
	
}
