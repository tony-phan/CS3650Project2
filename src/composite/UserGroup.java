package composite;
import java.util.HashMap;

import visitor.UsersVisitor;

public class UserGroup implements Users {
	
	private String groupID;
	private long creationTime;
	private HashMap<Integer, Users> members = new HashMap<Integer, Users>();
	
	public UserGroup(String groupID, long creationTime) {
		this.groupID = groupID;
		this.creationTime = creationTime;
	}
	
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return groupID;
	}
	
	public boolean addUser(Users user) {
		if(members.containsKey(user.toString().hashCode())) {
			System.out.println("User already exists.");
			return false;
		}
		members.put(user.toString().hashCode(), user);
		return true;
	}

	@Override
	public void accept(UsersVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUser(this);
	}
	
	public long getCreationTime() {
		return creationTime;
	}

	public String toString() {
		return groupID;
	}
}