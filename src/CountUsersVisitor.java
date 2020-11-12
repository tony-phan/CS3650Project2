
public class CountUsersVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub
		int totalUsers = 0;
		if(user instanceof User) {
			totalUsers += 1;
		}
		else {
			//for(User user : user.) {
				
			//}
		}
		System.out.printf("Total # of users: %d\n", totalUsers);
	}	
}
