
public class CountTweetsVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub
		System.out.println("A tweet has been posted by: " + user.getName());
	}
}
