package GUI;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import composite.User;
import visitor.CountTweetsVisitor;
import visitor.PositiveTweetsVisitor;

public class UserPanel extends JPanel {
	
	AdminControlPanel admin = AdminControlPanel.getInstance();
	private JTextField postTweetTextBox;
	private JTextField followUserTextField;
	private JList followingList;
	private JList newsFeedList;
	
	DefaultListModel<String> following = new DefaultListModel<String>();
	DefaultListModel<String> tweetsList = new DefaultListModel<String>();
	
	public UserPanel(User user, HashMap<Integer, User> currentUserSet, List<String> tweets) {
		setLayout(null);
		setBorder(BorderFactory.createTitledBorder(user.toString()));
		
		JButton btnNewButton = new JButton("Post Tweet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				user.accept(new CountTweetsVisitor());
				admin.incrementNumTweets();
				if(postTweetTextBox.getText().contains("good") || 
				   postTweetTextBox.getText().contains("nice") ||
				   postTweetTextBox.getText().contains("amazing")) {
					admin.incrementNumPositiveTweets();
					user.accept(new PositiveTweetsVisitor());
				}
				user.postTweet(postTweetTextBox.getText());
			}
		});
		
		btnNewButton.setBounds(330, 169, 110, 21);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Follow User");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Integer userHashKey = followUserTextField.getText().hashCode();
				if(user.toString().hashCode() == userHashKey) {
					JOptionPane.showMessageDialog(null, "Error: You cannot follow yourself");
				}
				else if(followingCheck(followUserTextField.getText())) {
					JOptionPane.showMessageDialog(null, "Error: You are already following this user");
				}
				else if(currentUserSet.containsKey(userHashKey)) {
					user.followUser(currentUserSet.get(followUserTextField.getText().hashCode()));
					currentUserSet.get(followUserTextField.getText().hashCode()).attach(user);
					following.addElement("- " + followUserTextField.getText());
				}
				else {
					JOptionPane.showMessageDialog(null, "Error: User not found");
				}
			}
			private boolean followingCheck(String userInput) {
				for(User a : user.getFollowing()) {
					if(userInput.equals(a.toString())) {
						return true;
					}
				}
				return false;
			}
		});
		btnNewButton_1.setBounds(330, 34, 110, 21);
		add(btnNewButton_1);
		
		postTweetTextBox = new JTextField();
		postTweetTextBox.setText("Message");
		postTweetTextBox.setBounds(224, 170, 96, 19);
		add(postTweetTextBox);
		postTweetTextBox.setColumns(10);
		
		followUserTextField = new JTextField();
		followUserTextField.setText("User ID");
		followUserTextField.setBounds(224, 35, 96, 19);
		add(followUserTextField);
		followUserTextField.setColumns(10);
		
		following.addElement("(Current Following)");
		for(User a : user.getFollowing()) {
			following.addElement("- " + a.toString());
		}
		followingList = new JList(following);
		followingList.setBounds(10, 65, 430, 95);
		JScrollPane scrollingFollowing = new JScrollPane(followingList);
		add(followingList);
		add(scrollingFollowing);
		
		tweetsList.addElement("(News Feed)");
		for(String tweet : tweets) {
			tweetsList.addElement("- " + tweet);
		}
		newsFeedList = new JList(tweetsList);
		newsFeedList.setBounds(10, 195, 430, 95);
		final JScrollPane scrollingNewsFeed = new JScrollPane(newsFeedList);
		add(newsFeedList);
		add(scrollingNewsFeed);
	}
}