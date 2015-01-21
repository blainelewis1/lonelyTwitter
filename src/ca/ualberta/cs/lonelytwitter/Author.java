package ca.ualberta.cs.lonelytwitter;

public class Author extends User {

	public Author(String name) {
		super(name);
	}

	@Override
	public void setName(String x) {
		name = x;
	}
	
}
