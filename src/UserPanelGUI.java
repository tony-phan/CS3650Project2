import java.awt.BorderLayout;
import java.awt.Container;
import java.util.Map;

import javax.swing.JFrame;

public class UserPanelGUI extends JFrame {
	
	UserGUI userPanel;
	
	public UserPanelGUI(User user, Map<Integer, User> currentUsers) {
		super("User Panel");
		
		setLayout(new BorderLayout());
        setSize(600, 450);
		
		userPanel = new UserGUI(user, currentUsers);

		Container c = getContentPane();
		
		c.add(userPanel, BorderLayout.CENTER);
	}
}
