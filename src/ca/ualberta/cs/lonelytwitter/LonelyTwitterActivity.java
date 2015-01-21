package ca.ualberta.cs.lonelytwitter;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity {

	private static final String FILENAME = "file.sav";
	private EditText bodyText;
	private ListView oldTweetsList;
	private ArrayList<String> tweets;
	private ArrayAdapter<String> tweetAdapter;
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		bodyText = (EditText) findViewById(R.id.body);
		Button saveButton = (Button) findViewById(R.id.save);
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();
				
				tweets.add(text);

				saveInFile();
				
				tweetAdapter.notifyDataSetChanged();
				//finish();

			}
		});
	}

	@Override
	protected void onStart() {
		
		super.onStart();
		tweets = loadFromFile();
		tweetAdapter = new ArrayAdapter<String>(this, R.layout.list_item, tweets);
		oldTweetsList.setAdapter(tweetAdapter);
	}

	private ArrayList<String> loadFromFile() {

		Gson gson = new Gson();
		
		ArrayList<String> loadedTweets = null;
		
		try {
			FileInputStream fis = openFileInput(FILENAME);
			InputStreamReader in = new InputStreamReader(fis);
			
			
			//https://sites.google.com/site/gson/gson-user-guide 21-01-2015
			Type myType = new TypeToken<ArrayList<String>>() {}.getType();
			
			loadedTweets = gson.fromJson(in, myType);		
			
			fis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		if(loadedTweets == null){
			loadedTweets = new ArrayList<String>();
		}
		
		return loadedTweets;
	}
	
	private void saveInFile() {
		
		Gson gson = new Gson();
		
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			
			gson.toJson(tweets, osw);

			osw.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void onStop() {
		super.onStop();
		saveInFile();
	}
	
	
}