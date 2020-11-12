
public class CountTweetsVisitor implements UsersVisitor {

	@Override
	public void visitUser(Users user) {
		// TODO Auto-generated method stub
		int totalTweets = 0;
		
		System.out.printf("Total # of tweets: %d\n", totalTweets);
	}
}
