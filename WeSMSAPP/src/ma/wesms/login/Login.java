package ma.wesms.login;
import my.wesms.MyRepertoirContact.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JPanel;

public class Login {

	private JFrame frame;
	private JFrame frmLoginSystem;
	private JTextField txtUsername;
	private JLabel lblNewLabel_2;
	private JTextField txtPassword;

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
	 */
	public Login() {
		initialize();
	}
	
	Connection con;
	PreparedStatement pst;
	ResultSet rs;
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 153, 153));
		frame.getContentPane().setForeground(new Color(255, 200, 0));
		frame.getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 24));
		frame.setBounds(100, 100, 901, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Authentification");
		lblNewLabel.setBounds(406, 67, 366, 48);
		lblNewLabel.setForeground(new Color(25, 25, 112));
		lblNewLabel.setBackground(new Color(165, 42, 42));
		lblNewLabel.setFont(new Font("Stencil", Font.BOLD | Font.ITALIC, 34));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username :");
		lblNewLabel_1.setBounds(358, 187, 146, 34);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(lblNewLabel_1);
		
		txtUsername = new JTextField();
		txtUsername.setBounds(568, 194, 224, 27);
		frame.getContentPane().add(txtUsername);
		txtUsername.setColumns(10);
		
		lblNewLabel_2 = new JLabel("Password :");
		lblNewLabel_2.setBounds(358, 257, 146, 34);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 24));
		frame.getContentPane().add(lblNewLabel_2);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(568, 266, 224, 25);
		txtPassword.setColumns(10);
		frame.getContentPane().add(txtPassword);
		
		JButton btnNewButton = new JButton("login");
		btnNewButton.setBounds(549, 406, 126, 34);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String username = txtUsername.getText() ;
				String password = txtPassword.getText() ;
				
				if(username.isEmpty() && password.isEmpty()) {
					JOptionPane.showMessageDialog(null,"Cannot blank username and password !!" );
				}
				
				else {
				
					try {
						Class.forName("con.mysql.jbdc.Driver");
						con=DriverManager.getConnection("jdbc:mysql://localhost/wesms","root","");
						
						pst= con.prepareStatement("select * from login where username=? and password=?");
					
						pst.setString(1, username);
						pst.setString(2, password);
						
						rs = pst.executeQuery();
						if(rs.next()) {
							JOptionPane.showMessageDialog(null,"Login Success !!" );
							MyRepertoirContact info = new MyRepertoirContact();
						    MyRepertoirContact.main(null);
							frame.setVisible(false);
						}
						else {
							JOptionPane.showMessageDialog(null,"Login Failed !!" );
							txtUsername.setText("");
							txtPassword.setText("");
							txtUsername.requestFocus();
						}
					} catch (SQLException e1) {
						
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						
						e1.printStackTrace();
					}
				}
			
		}
	});	
		
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(350, 406, 126, 34);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			txtUsername.setText(null);
			txtPassword.setText(null);
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(731, 406, 126, 34);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			  frmLoginSystem=new JFrame("Exit");
			 if(JOptionPane.showConfirmDialog(frmLoginSystem, "Confirm if you want to exit","Login Systems",JOptionPane.YES_NO_OPTION)==JOptionPane.YES_NO_OPTION) {
				  System.exit(0);
					  
				  }
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 16));
		frame.getContentPane().add(btnExit);
		
		JLabel label = new JLabel("New label");
		label.setBounds(22, 147, 224, 122);
		ImageIcon icon=new ImageIcon(this.getClass().getResource("/sms.png"));
		label.setIcon(icon);
		frame.getContentPane().add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 887, 56);
		panel.setBackground(new Color(25, 25, 112));
		frame.getContentPane().add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(91, 55, 81, 481);
		panel_1.setBackground(new Color(0, 102, 153));
		frame.getContentPane().add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(385, 106, 378, 2);
		frame.getContentPane().add(panel_2);
		
		JLabel label2 = new JLabel("New label");
		label2.setBounds(299, 184, 49, 48);
		ImageIcon icone=new ImageIcon(this.getClass().getResource("/user.png"));
		label2.setIcon(icone);
		frame.getContentPane().add(label2);
		
		JLabel label3 = new JLabel("New label");
		label3.setBounds(299, 254, 49, 48);
		ImageIcon icones=new ImageIcon(this.getClass().getResource("/pass.png"));
		label3.setIcon(icones);
		frame.getContentPane().add(label3);
	}
}
