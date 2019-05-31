package Practice;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;


public class MainFrame extends JFrame {

	private JButton jb;
	//private JTextArea ja;
	private ToolBar tool;
	private TextPanel ja;
	
	public MainFrame() {
		super("Hello World");

		setLayout(new BorderLayout());

		tool=new ToolBar();
        jb=new JButton("click me");
		ja=new TextPanel();
				

		add(tool,BorderLayout.NORTH);
		add(jb,BorderLayout.SOUTH);
		add(ja,BorderLayout.CENTER);
		
		jb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ja.appendText("Hello Jessy\n");
				
			}
		});
		
		setSize(600,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
		
		
		

	}
}
