 package slim_and_tone;

import java.awt.*;

import javax.swing.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Login extends javax.swing.JFrame{

	private JFrame frame;
	private JTextField usrNameInpt;
	private JPasswordField passwordInpt;
	private Statement stat;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Exception 
	 */
	public Login() throws Exception {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	private void initialize() throws Exception {
		//Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/slimandtone_schema?useSSL=false";
		Connection con = DriverManager.getConnection(url, "root", "1807Rohan");
		
		stat=con.createStatement();

		frame = new JFrame();
		//frame.setVisible(true);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		JButton LoginBtn = new JButton("login");
		LoginBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql="SELECT * from slimandtone_schema.adminlogininfo where userName= '"+usrNameInpt.getText()+"' and password= '"+passwordInpt.getText()+"'";
				
				ResultSet rs = null;
				try {
					rs = stat.executeQuery(sql);
				} catch (SQLException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
				try {
					if(rs.next()) {
						usrNameInpt.setText(null);
						passwordInpt.setText(null);
						//close();
						frame.setVisible(false);
						//JOptionPane.showMessageDialog(null, "Welcome "+usrNameInpt.getText()+" to our app");
						
						HomePage hp=new HomePage();
						hp.newScreen();
					}else {
					usrNameInpt.setText(null);
					passwordInpt.setText(null);
					JOptionPane.showMessageDialog(null, "Invalid credentials");
					}
				} catch (HeadlessException e1) {
					e1.printStackTrace();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			
			}
		});
		LoginBtn.setBounds(149, 187, 125, 39);
		frame.getContentPane().add(LoginBtn);
		
		JLabel username = new JLabel("Username");
		username.setHorizontalAlignment(SwingConstants.CENTER);
		username.setBounds(44, 42, 104, 39);
		frame.getContentPane().add(username);
		
		usrNameInpt = new JTextField();
		usrNameInpt.setBounds(158, 51, 173, 20);
		frame.getContentPane().add(usrNameInpt);
		usrNameInpt.setColumns(10);
		
		JLabel password = new JLabel("Password");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		password.setBounds(44, 101, 104, 29);
		frame.getContentPane().add(password);
		
		passwordInpt = new JPasswordField();
		passwordInpt.setBounds(158, 105, 173, 20);
		frame.getContentPane().add(passwordInpt);
	}
	
	private void close() {
		WindowEvent we=new WindowEvent(this, WindowEvent.WINDOW_CLOSING);
		Toolkit.getDefaultToolkit().getSystemEventQueue().postEvent(we);
		
	}
}
