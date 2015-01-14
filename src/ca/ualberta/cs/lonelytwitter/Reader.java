package ca.ualberta.cs.lonelytwitter;

import java.io.IOException;

public class Reader extends User {

	private static boolean enabled = false;
	
	@Override
	public void setName(String x) throws IOException {
		if(x.length() > 8) {
			throw new IOException("Name too long.");
		}
		
		this.name = x;
	}
}
