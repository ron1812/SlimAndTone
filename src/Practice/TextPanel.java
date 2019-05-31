package Practice;

import java.awt.BorderLayout;
import java.awt.TextArea;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class TextPanel extends JPanel {

	private TextArea ta;
	
	public TextPanel() {
		ta=new TextArea();
		setLayout(new BorderLayout());
		
		add(new JScrollPane(ta),BorderLayout.CENTER);
	}
	
	public void appendText(String text) {
		ta.append(text);
	}
}
