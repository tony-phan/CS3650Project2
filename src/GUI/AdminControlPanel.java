package GUI;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import composite.User;
import composite.UserGroup;
import composite.Users;

import java.awt.Insets;

public class AdminControlPanel extends JPanel {
	
	private static AdminControlPanel instance;
	private JTextField addUserTextBox;
	private JTextField addGroupTextBox;
	private int numUsers = 0;
	private int numUserGroups = 0;
	private int numTweets = 0;
	private int numPositiveTweets = 0;
	private UserTree tree;
	HashMap<Integer, User> individualUsers = new HashMap<Integer, User>();
	HashMap<Integer, Users> groupUsers = new HashMap<Integer, Users>();
	
	public static AdminControlPanel getInstance() {
		if(instance == null) {
			instance = new AdminControlPanel();
		}
		return instance;
	}
	
	private AdminControlPanel() {
		setLayout(null);
		
		tree = new UserTree();
		tree.setPreferredSize(new Dimension(300, 150));
		
		JButton btnNewButton = new JButton("Add User");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User newUser = null;
				if(individualUsers.containsKey(addUserTextBox.getText().hashCode())) {
                    JOptionPane.showMessageDialog(null, "Error: User already exists");
                }
                else {
                    newUser = new User(addUserTextBox.getText());
                }
				
				if(newUser == null) { }
                else if(tree.addUsers(newUser) == null){
                    JOptionPane.showMessageDialog(null, "Error: Cannot add user into tree");
                }
                else {
                    try {
                        individualUsers.put(newUser.toString().hashCode(), newUser);
                        ++numUsers;
                    }
                    catch (Exception exception) {}
                }
			}
		});
		btnNewButton.setBounds(356, 10, 115, 21);
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 0;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		addUserTextBox = new JTextField();
		addUserTextBox.setText("User ID");
		addUserTextBox.setBounds(250, 11, 96, 19);
		GridBagConstraints gbc_addUserTextBox = new GridBagConstraints();
		gbc_addUserTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_addUserTextBox.gridx = 7;
		gbc_addUserTextBox.gridy = 0;
		add(addUserTextBox, gbc_addUserTextBox);
		addUserTextBox.setColumns(10);
		
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 38, 0, 0, 0, 0, 0, 0, 0, 0};
		setLayout(gridBagLayout);
		GridBagConstraints g = new GridBagConstraints();
		g.weighty = 1;
		g.gridy = 2;
		g.fill = GridBagConstraints.VERTICAL;
		
		JButton btnNewButton_2 = new JButton("Open User View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User selectedUser = (User)tree.getCurrentNode();
				if(selectedUser != null) {
					UserPanelGUI userPanelGUI = new UserPanelGUI(selectedUser, individualUsers, selectedUser.getTweets());
					userPanelGUI.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error: Panels cannot be opened for UserGroups");
				}
			}
		});
		btnNewButton_2.setBounds(250, 96, 221, 21);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 0;
		add(btnNewButton_2, gbc_btnNewButton_2);
		GridBagConstraints gbc_tree = new GridBagConstraints();
		gbc_tree.insets = new Insets(0, 0, 5, 0);
		gbc_tree.gridx = 9;
		gbc_tree.gridy = 0;
		add(tree, gbc_tree);
		
		JButton btnNewButton_1 = new JButton("Add Group");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 Users newGroup = null;
	             if(groupUsers.containsKey(addGroupTextBox.getText().hashCode())) {
	            	 JOptionPane.showMessageDialog(null, "This userGroup already exists");
	             }
	             else {
	            	 newGroup = new UserGroup(addGroupTextBox.getText());
	             }
	             if(newGroup == null) { }
	             else if(tree.addUsers(newGroup) == null){
	                 JOptionPane.showMessageDialog(null, "Can not add Users to a User");
	             }
	             else {
	                 try {
	                	 groupUsers.put(newGroup.toString().hashCode(), newGroup);
	                     ++numUserGroups;
	                 }
	                 catch (NullPointerException exception) {}
	             }
			}
		});
		btnNewButton_1.setBounds(356, 55, 115, 21);
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 0;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		addGroupTextBox = new JTextField();
		addGroupTextBox.setText("Group ID");
		addGroupTextBox.setBounds(250, 56, 96, 19);
		GridBagConstraints gbc_addGroupTextBox = new GridBagConstraints();
		gbc_addGroupTextBox.insets = new Insets(0, 0, 5, 5);
		gbc_addGroupTextBox.gridx = 1;
		gbc_addGroupTextBox.gridy = 1;
		add(addGroupTextBox, gbc_addGroupTextBox);
		addGroupTextBox.setColumns(10);
		
		JButton btnNewButton_4 = new JButton("Show # of Tweets");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "# of Tweets: " + numTweets);
			}
		});
		
		JButton btnNewButton_6 = new JButton("Show % of Positive Tweets");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "% of Positive Tweets: " + numPositiveTweets);
			}
		});
		btnNewButton_6.setBounds(271, 325, 200, 21);
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_6.gridx = 2;
		gbc_btnNewButton_6.gridy = 1;
		add(btnNewButton_6, gbc_btnNewButton_6);
		btnNewButton_4.setBounds(271, 299, 200, 21);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 3;
		gbc_btnNewButton_4.gridy = 1;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Show # of Users");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "# of Users: " + numUsers);
			}
		});
		
		JButton btnNewButton_5 = new JButton("Show # of Groups");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "# of Groups: " + numUserGroups);
			}
		});
		btnNewButton_5.setBounds(271, 268, 200, 21);
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_5.gridx = 2;
		gbc_btnNewButton_5.gridy = 2;
		add(btnNewButton_5, gbc_btnNewButton_5);
		btnNewButton_3.setBounds(271, 237, 200, 21);
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridx = 3;
		gbc_btnNewButton_3.gridy = 2;
		add(btnNewButton_3, gbc_btnNewButton_3);
	}
	
	public void incrementNumTweets() {
		++numTweets;
	}
	
	public void incrementNumPositiveTweets() {
		++numPositiveTweets;
	}
}