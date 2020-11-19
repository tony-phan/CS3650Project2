import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class User extends Subject implements Users, Observer {
	
	private String id;
	private Set<User> following = new HashSet<User>();
	private List<String> tweets = new ArrayList<String>();
	
	public User(String id) {
		this.id = id;
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
	}
	
	// Observer Pattern: Subject
	public void postTweet(String message) {
		tweets.add("You posted: " + message);
		super.notifyObservers(message);
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

	@Override
	public void accept(UsersVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUser(this);
	}
}