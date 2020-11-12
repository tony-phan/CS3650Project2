import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTree;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import java.awt.event.ActionEvent;

public class AdminPanel extends JPanel {
	
	private JTextField userIDField;
	private JTextField groupIDField;	
	private static AdminPanel instance = null;
	private Map<Integer, User> currentIndividualUsers = new HashMap<Integer, User>();
	private Map<Integer, Users> currentUserGroups = new HashMap<Integer, Users>();
	private int numTweets = 0;
	private int numPositiveTweets = 0;
	private UserTree treeView;

	
	public static AdminPanel getInstance() {
		if(instance == null) {
			instance = new AdminPanel();
		}
		return instance;
	}
	
	private void updateNumPositiveTweets() {
		numPositiveTweets++;
	}
	
	/**
	 * Create the panel.
	 */
	public AdminPanel() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 38, 0, 0, 214, 39, 60, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		userIDField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.insets = new Insets(0, 0, 5, 5);
		gbc_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField.gridx = 10;
		gbc_textField.gridy = 0;
		add(userIDField, gbc_textField);
		userIDField.setColumns(10);
		
		JButton btnNewButton = new JButton("Add user");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				User newUser = null;
				if(currentIndividualUsers.containsKey(userIDField.getText().hashCode())) {
					JOptionPane.showMessageDialog(null, "Error: This user exists.");
				}
				else {
					newUser = new User(userIDField.getText());
				}
				
				if(treeView.addUser(newUser) == null) {
					JOptionPane.showMessageDialog(null, "Error: Unable to add user");
				}
				else if(newUser == null) {
				}
				else {
					currentIndividualUsers.put(newUser.toString().hashCode(), newUser);
				}
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton.gridx = 11;
		gbc_btnNewButton.gridy = 0;
		add(btnNewButton, gbc_btnNewButton);
		
		treeView = new UserTree();
		treeView.setPreferredSize(new Dimension(250, 100));
		setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.weighty = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.VERTICAL;
        add(treeView, gbc);
		
		groupIDField = new JTextField();
		GridBagConstraints gbc_textField_1 = new GridBagConstraints();
		gbc_textField_1.insets = new Insets(0, 0, 5, 5);
		gbc_textField_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_1.gridx = 10;
		gbc_textField_1.gridy = 1;
		add(groupIDField, gbc_textField_1);
		groupIDField.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("Add Group");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Users newGroup = null;
				if(currentUserGroups.containsKey(groupIDField.getText().hashCode())) {
					JOptionPane.showMessageDialog(null, "Error: This group exists");
				}
				else {
					newGroup = new UserGroup(groupIDField.getText());
				}
				
				if(treeView.addUser(newGroup) == null) {
					JOptionPane.showMessageDialog(null, "Error: Unable to add user group");
				}
				else if(newGroup == null) {
				}
				else {
					currentUserGroups.put(newGroup.toString().hashCode(), newGroup);
				}

			}
		});
		GridBagConstraints gbc_btnNewButton_1 = new GridBagConstraints();
		gbc_btnNewButton_1.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_1.gridx = 11;
		gbc_btnNewButton_1.gridy = 1;
		add(btnNewButton_1, gbc_btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Open User View");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				User selectedUser = (User)treeView.getCurrentNode();
				if(selectedUser != null) {
					UserPanelGUI userGUI = new UserPanelGUI(selectedUser, currentIndividualUsers);
					userGUI.setVisible(true);
				}
				else {
					JOptionPane.showMessageDialog(null, "Error: Unable to open user view for a UserGroup");
				}
			}
		});
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.gridwidth = 3;
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.gridx = 10;
		gbc_btnNewButton_2.gridy = 2;
		add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton_4 = new JButton("Show Group Total");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Total # of Groups: " + currentUserGroups.values().size());
			}
		});
		
		JButton btnNewButton_5 = new JButton("Show User total");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Total # of Users: " + currentIndividualUsers.values().size());
			}
		});
		GridBagConstraints gbc_btnNewButton_5 = new GridBagConstraints();
		gbc_btnNewButton_5.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_5.gridx = 9;
		gbc_btnNewButton_5.gridy = 8;
		add(btnNewButton_5, gbc_btnNewButton_5);
		GridBagConstraints gbc_btnNewButton_4 = new GridBagConstraints();
		gbc_btnNewButton_4.gridwidth = 2;
		gbc_btnNewButton_4.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_4.gridx = 11;
		gbc_btnNewButton_4.gridy = 8;
		add(btnNewButton_4, gbc_btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("Show Message Total");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "Total # of Tweets: " + numTweets);
			}
		});
		GridBagConstraints gbc_btnNewButton_6 = new GridBagConstraints();
		gbc_btnNewButton_6.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_6.gridx = 9;
		gbc_btnNewButton_6.gridy = 9;
		add(btnNewButton_6, gbc_btnNewButton_6);
		
		JButton btnNewButton_3 = new JButton("Show % of positive messages");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JOptionPane.showMessageDialog(null, "# of Positive Tweets: " + numPositiveTweets);
			}
		});
		GridBagConstraints gbc_btnNewButton_3 = new GridBagConstraints();
		gbc_btnNewButton_3.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton_3.gridwidth = 3;
		gbc_btnNewButton_3.gridx = 10;
		gbc_btnNewButton_3.gridy = 9;
		add(btnNewButton_3, gbc_btnNewButton_3);

	}

}
