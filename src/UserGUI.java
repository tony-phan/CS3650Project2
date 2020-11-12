import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.Map;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class UserGUI extends JPanel {
	private JTextField userIDField;
	private JTextField tweetMessageField;
	AdminPanel admin = AdminPanel.getInstance();
	
	/**
	 * Create the panel.
	 */
	public UserGUI(User user, Map<Integer, User> currentIndividualUsers) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{4, 87, 0, 133, 72, 7, 83, 102, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 1, 262, 21, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		setLayout(gridBagLayout);
		
		JButton btnNewButton = new JButton("Follow User");
		btnNewButton.addActionListener(new ActionListener() {
			Integer userIdentifier = userIDField.getText().hashCode();
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(user.toString().hashCode() == userIdentifier) {
					JOptionPane.showMessageDialog(null, "Error: Following yourself is not allowed.");
				}
				else if(currentIndividualUsers.containsKey(userIdentifier)) {
					user.follow(currentIndividualUsers.get(userIDField.getText().hashCode()));
					currentIndividualUsers.get(userIDField.getText().hashCode()).attach(user);
					JOptionPane.showMessageDialog(null, "User successfully followed");
				}
				else if(followingChecker(userIDField.getText())) {
					JOptionPane.showMessageDialog(null, "Error: You are already following this user");
				}
				else {
					JOptionPane.showMessageDialog(null, "Error: User not found");
				}
			}
			// returns false if not following, true otherwise
			private boolean followingChecker(String userIdentifier) {
				for(Users follower : user.getFollowing()) {
					if(userIdentifier.equals(follower.getName())) {
						return true;
					}
				}
				return false;
			}
		});
		
		userIDField = new JTextField();
		GridBagConstraints gbc_userIDField = new GridBagConstraints();
		gbc_userIDField.insets = new Insets(0, 0, 5, 5);
		gbc_userIDField.gridx = 3;
		gbc_userIDField.gridy = 0;
		add(userIDField, gbc_userIDField);
		userIDField.setColumns(10);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 6;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("List View (Current Following)");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 3;
		gbc_lblNewLabel_3.gridy = 2;
		add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("Post Tweet");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JLabel lblNewLabel_1 = new JLabel("Tweet Message");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.gridwidth = 2;
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 2;
		gbc_lblNewLabel_1.gridy = 7;
		add(lblNewLabel_1, gbc_lblNewLabel_1);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 6;
		gbc_btnNewButton_1.gridy = 7;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JList list = new JList();
		GridBagConstraints gbc_list = new GridBagConstraints();
		gbc_list.insets = new Insets(0, 0, 5, 5);
		gbc_list.gridx = 0;
		gbc_list.gridy = 8;
		add(list, gbc_list);
		
		JList list_1 = new JList();
		GridBagConstraints gbc_list_1 = new GridBagConstraints();
		gbc_list_1.insets = new Insets(0, 0, 5, 5);
		gbc_list_1.gridx = 0;
		gbc_list_1.gridy = 8;
		add(list_1, gbc_list_1);
		
		JLabel lblNewLabel = new JLabel("User ID");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 8;
		add(lblNewLabel, gbc_lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel("List View (News Feed)");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 9;
		add(lblNewLabel_2, gbc_lblNewLabel_2);
		
		tweetMessageField = new JTextField();
		GridBagConstraints gbc_tweetMessageField = new GridBagConstraints();
		gbc_tweetMessageField.insets = new Insets(0, 0, 5, 5);
		gbc_tweetMessageField.gridx = 0;
		gbc_tweetMessageField.gridy = 10;
		add(tweetMessageField, gbc_tweetMessageField);
		tweetMessageField.setColumns(10);
	}
}