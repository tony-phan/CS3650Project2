
public class CountGroupsVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub
		System.out.printf("Currently visiting: %d\n", user.getName());
	}
}