
public class PositiveTweetsVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub
		System.out.println("A positive tweet has been posted by: " + user.getName());
	}
}
