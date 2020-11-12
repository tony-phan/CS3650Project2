import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class User extends Subject implements Users, Observer {
	
	private String id;
	private String name;
	private Set<Users> followers = new HashSet<Users>();
	private Set<Users> following = new HashSet<Users>();
	private List<String> newsFeed = new ArrayList<String>();
	
	public User(String name) {
		id = UUID.randomUUID().toString();
		this.name = name;
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Set<Users> getFollowers() {
		return followers;
	}
	
	public void addFollower(Users follower) {
		followers.add(follower);
	}
	
	public Set<Users> getFollowing() {
		return following;
	}
	
	
	public List<String> getNewsFeed() {
		return newsFeed;
	}
	
	public void postTweet(String tweet) { // subject
		newsFeed.add(tweet);
		super.notifyObservers(tweet);
	}

	public void follow(User user) {
		following.add(user);
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public void notification(Subject user, String message) { // update (observer)
		// TODO Auto-generated method stub
		if(user instanceof User) {
			System.out.println("---------------------------------------");
			System.out.println("New tweet!");
			System.out.println(((User) user).getName() + ": " + message);
			System.out.println("---------------------------------------");
		}
	}

	@Override
	public void accept(UsersVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUser(this);
	}
}