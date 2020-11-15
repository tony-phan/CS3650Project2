
public class PositiveTweetsVisitor implements UsersVisitor {
	
	String[] positiveWords = {"Nice", "Good", "Great", "Awesome", "Amazing"};
	
	@Override
	public void visitUser(Users user) {
		System.out.printf("%d has posted a positive tweet\n", user.getName());
	}
}
