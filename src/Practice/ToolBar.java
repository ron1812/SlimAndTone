package Practice;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ToolBar extends JPanel {

	JButton hello;
	
	JButton bye;
	
	public ToolBar() {
		hello=new JButton("Hello");
		bye=new JButton("Bye");
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		
		add(hello);
		add(bye);
	}
}
