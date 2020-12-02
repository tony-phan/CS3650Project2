package GUI;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;

import composite.User;

public class UserPanelGUI extends JFrame {
	
	UserPanel userPanel;
	
	public UserPanelGUI(User user, HashMap<Integer, User> currentUserSet, List<String> tweets) {
		super("User Panel");
		setLayout(new BorderLayout());
		setVisible(true);
		UserPanelGUI currentPanel = this;
		
		userPanel = new UserPanel(user, currentUserSet, tweets);
		JButton updateTweetsButton = new JButton("Get Tweets Updates");
		
		Container c = getContentPane();
		
		c.add(userPanel, BorderLayout.CENTER);
		c.add(updateTweetsButton, BorderLayout.SOUTH);
		updateTweetsButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				UserPanelGUI newPanel = new UserPanelGUI(user, currentUserSet, tweets);
				newPanel.setVisible(true);
				currentPanel.dispose();
			}
		});
	}
}