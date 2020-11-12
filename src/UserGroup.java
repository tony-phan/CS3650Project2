import java.util.List;
import java.util.UUID;

public class UserGroup implements Users {
	
	private String groupID;
	private String groupName;
	private List<Users> users;
	
	public UserGroup(String groupName) {
		groupID = UUID.randomUUID().toString();
		this.groupName = groupName;
	}
	
	public List<Users> getUsers() {
		return users;
	}
	
	public void addUsers(Users user) {
		users.add(user);
	}
	
	public String getGroupID() {
		return groupID;
	}

	public void setGroupID(String groupID) {
		this.groupID = groupID;
	}
	
	public String toString() {
		return groupID;
	}

	public String getName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Override
	public void accept(UsersVisitor visitor) {
		// TODO Auto-generated method stub
		visitor.visitUser(this);
	}
}