import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class AdminControlPanelGUI extends JFrame {
	
	AdminPanel adminPanel;
	
	public AdminControlPanelGUI() {
		super("Admin Control Panel");
		setLayout(new BorderLayout());
		
		adminPanel = AdminPanel.getInstance();

		Container c = getContentPane();
		
		c.add(adminPanel, BorderLayout.CENTER);
	}
}
