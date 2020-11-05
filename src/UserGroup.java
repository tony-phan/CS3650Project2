import java.util.List;
import java.util.UUID;

public class UserGroup implements Users {
	
	private String groupID;
	private List<Users> users;
	
	public UserGroup() {
		groupID = UUID.randomUUID().toString();
	}
	
	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
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
}