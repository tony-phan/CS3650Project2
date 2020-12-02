package GUI;
import java.awt.*;
import javax.swing.JFrame;

public class AdminControlPanelGUI extends JFrame {
	
	AdminControlPanel adminPanel;
	
	public AdminControlPanelGUI() {
		super("Admin Control Panel");
		setLayout(new BorderLayout());
		
		adminPanel = AdminControlPanel.getInstance();

		Container c = getContentPane();
		
		c.add(adminPanel, BorderLayout.CENTER);
	}
}