package slim_and_tone.menu;

import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.Icon;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuItem extends JPanel {

	/**
	 * Create the panel.
	 */
	JLabel lblicon ;
	
	JLabel lblMenuItem;
	
	private final ArrayList<MenuItem> subItems=new ArrayList<MenuItem>();
	
	public ArrayList<MenuItem> getSubItems() {
		return subItems;
	}

	private boolean showing=false;
	
	public MenuItem(Icon icon,String menuName,MenuItem...subItems) {
		
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*
				 * System.out.println("button id"+e.getID());
				 * System.out.println("button name"+e.getButton());
				 */if(showing) {
	        	   HideMenu();
	        	   showing=false;
	           }else {
	        	   showMenu();
	        	   showing=true;
	           }
			}
		});
		
		InitComponents();
		lblicon.setIcon(icon);
		
		lblMenuItem.setText(menuName);
		lblMenuItem.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
		
		
		this.setSize(new Dimension(Integer.MAX_VALUE, 45));
		this.setMaximumSize(new Dimension(Integer.MAX_VALUE,45));
		this.setMinimumSize(new Dimension(Integer.MAX_VALUE,45));
		
		for(int i=0;i<subItems.length;i++) {
			this.subItems.add(subItems[i]);
		}

	}
	
	private void showMenu() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=0;i<subItems.size();i++) {
					sleep();
					subItems.get(i).setVisible(true);
				}
				
			}

		}).start();
	}

	private void HideMenu() {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i=subItems.size()-1;i>=0;i--) {
					sleep();
					subItems.get(i).setVisible(false);
				}
				
			}

		}).start();
	}

	private void sleep() {
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private void InitComponents() {
		setLayout(null);
		
		lblicon = new JLabel();
		//lblicon.setForeground(Color.WHITE);
		//lblicon.setBackground(Color.YELLOW);
		lblicon.setBounds(0, 0, 29, 39);
       // lblicon.resize(new Dimension(Integer.MAX_VALUE,45));
		add(lblicon);
		
		lblMenuItem = new JLabel();
		lblMenuItem.setHorizontalAlignment(SwingConstants.LEFT);
		//lblMenuItem.setBackground(Color.BLACK);
		//lblMenuItem.setBackground(Color.BLACK);
		lblMenuItem.setBounds(39, 0, 81, 39);
		
		add(lblMenuItem);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 60, 120, 2);
		add(separator);
		
	}
}
