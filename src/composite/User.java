package composite;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import observer.Observer;
import observer.Subject;
import visitor.UsersVisitor;

public class User extends Subject implements Users, Observer {
	
	private String id;
	private long creationTime, lastUpdateTime = 0;
	private Set<User> following = new HashSet<User>();
	private List<String> tweets = new ArrayList<String>();
	
	public User(String id, long creationTime) {
		this.id = id;
		this.creationTime = creationTime;
	}
		
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return id;
	}
	
	// Observer Pattern: Observer (update method)
	@Override
	public void notification(Subject user, String message) {
		// TODO Auto-generated method stub
		System.out.println(id + " has been notified of tweet from " + user);
		tweets.add(user + " posted: " + message);
		lastUpdateTime = System.currentTimeMillis();
	}
	
	// Observer Pattern: Subject
	public void postTweet(String message) {
		tweets.add("You posted: " + message);
		super.notifyObservers(message);
		lastUpdateTime = System.currentTimeMillis();
	}
	
	public Set<User> getFollowing() {
		return following;
	}
	
	public List<String> getTweets() {
		return tweets;
	}
	
	public boolean followUser(User user) {
		try {
			following.add(user);
			return true;
		}
		catch (Exception e){
			System.out.println("Cannot follow a UserGroup" + e);
			return false;
		}
	}
	
	public String toString() {
		return id;
	}
	
	public long getCreationTime() {
		return creationTime;
	}

	@Override
	public void accept(UsersVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUser(this);
	}

	public long getLastUpdateTime() {
		return lastUpdateTime;
	}
}