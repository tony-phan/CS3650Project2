
public class PositiveTweetsVisitor implements UsersVisitor {
	
	String[] positiveWords = {"Nice", "Good", "Great", "Awesome", "Amazing"};
	
	@Override
	public void visitUser(Users user) {
		int positiveTweets = 0;
		
		System.out.printf("% of positive tweets: %f\n", positiveTweets);
	}
}
