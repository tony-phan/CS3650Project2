import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class User implements Users {
	
	private String id;
	private Set<User> followers = new HashSet<User>();
	private Set<User> following = new HashSet<User>();
	private List<String> newsFeed = new ArrayList<String>();
	
	public User() {
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public Set<User> getFollowers() {
		return followers;
	}
	
	public void setFollowers(Set<User> followers) {
		this.followers = followers;
	}
	
	public Set<User> getFollowing() {
		return following;
	}
	
	public void setFollowing(Set<User> following) {
		this.following = following;
	}
	
	public List<String> getNewsFeed() {
		return newsFeed;
	}

	public void setNewsFeed(List<String> newsFeed) {
		this.newsFeed = newsFeed;
	}

	public void follow(User user) {
		following.add(user);
	}
	
	public String toString() {
		return id;
	}
}
