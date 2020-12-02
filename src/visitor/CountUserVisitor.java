package visitor;
import composite.Users;

public class CountUserVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub
		System.out.println("Visiting " + user.getName());
	}
}
