package slim_and_tone;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.ArrayList;

import javax.swing.GroupLayout;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JScrollPane;

import slim_and_tone.menu.MenuItem;

public class HomePage {

	private JFrame frame;
	
	JPanel menus;

	/**
	 * Launch the application.
	 */
	public static void newScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage window = new HomePage();
					window.frame.setVisible(true);
					//window.frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					window.execute();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private void execute() {
		ImageIcon img=new ImageIcon(getClass().getResource("/slim_and_tone/menu/addmember.png"));
		
		//subMennu
		MenuItem subMenuItem1=new MenuItem(img, "new");
		MenuItem subMenuItem2=new MenuItem(img, "2 Member");
		MenuItem subMenuItem3=new MenuItem(img, "3 Member");
		
		MenuItem menuItem1=new MenuItem(img, "Add Member",subMenuItem1,subMenuItem2,subMenuItem3);
		MenuItem menuItem2=new MenuItem(img, "Add Member");
		MenuItem menuItem3=new MenuItem(img, "Add Member");
		addMenu(menuItem1,menuItem2,menuItem3);
	}
	
	private void addMenu(MenuItem...items ) {
		for(int i=0;i<items.length;i++) {
			menus.add(items[i]);
			ArrayList<MenuItem> subItems=items[i].getSubItems();
			for(MenuItem m:subItems) {
				addMenu(m);
			}
		}
		menus.revalidate();
	}
	/**
	 * Create the application.
	 */
	public HomePage() {
		//frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		//frame.getContentPane().setEnabled(false);
		//frame.getContentPane().setLayout(null);
		
		JPanel header = new JPanel();
		header.setBounds(0, 0, 434, 39);
		header.setBackground(Color.DARK_GRAY);
		header.setLayout(new BorderLayout(0, 0));
		header.setMaximumSize(new Dimension(Integer.MAX_VALUE,39));
		
		frame.getContentPane().add(header);
		
		
		JPanel menu = new JPanel();
		menu.setBounds(0, 37, 82, 224);
		menu.setBackground(Color.YELLOW);
		menu.setLayout(null);
		menu.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));
		
		frame.getContentPane().add(menu);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 82, 224);
		scrollPane.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));
		
		menu.add(scrollPane);
		menu.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));
		
		menus = new JPanel();
		menus.setLayout(new BoxLayout(menus, BoxLayout.Y_AXIS));
		//menus.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));
		scrollPane.setViewportView(menus);
		
		JPanel body = new JPanel();
		body.setBackground(Color.PINK);
		body.setBounds(79, 37, 355, 224);
		//body.setMaximumSize(new Dimension(Integer.MAX_VALUE,224));
		//frame.getContentPane().add(body);
		
		frame.setMaximumSize(new Dimension(Integer.MAX_VALUE,Integer.MAX_VALUE));
		
	}
}
