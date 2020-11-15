
public class CountTweetsVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub		
		System.out.printf("%d has posted a tweet\n", user.getName());
	}
}
