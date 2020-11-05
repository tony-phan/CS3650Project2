
public class AdminControlPanel {
	
	private static AdminControlPanel instance = null;
	
	public AdminControlPanel getInstance() {
		if(instance == null) {
			instance = new AdminControlPanel();
		}
		return instance;
	}

	private AdminControlPanel() {

	}
	
	public void createUsers() {
		
	}
	
	public void outputTotalUsers() {
		
	}
	
	public void outputTotalGroups() {
		
	}
	
	public void outputTotalTweets() {
		 
	} 
	
	public void outputPositiveTweetPercentage() {
		
	}
}

