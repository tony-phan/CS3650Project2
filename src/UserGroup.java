import java.util.HashMap;

public class UserGroup implements Users {
	
	private String groupID;
	private HashMap<Integer, Users> members = new HashMap<Integer, Users>();
	
	public UserGroup(String groupID) {
		this.groupID = groupID;
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
	
	public String toString() {
		return groupID;
	}
}