package my.wesms.homepage;
import ma.wesms.login.*;
import my.wesms.Inscriptionpage.*;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;

import ma.wesms.login.Login;

public class Home {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home window = new Home();
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
	public Home() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1002, 551);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Sing in");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login info = new Login();
				Login.main(null);
				frame.setVisible(false);
			}
		});
		btnNewButton.setBounds(146, 372, 112, 39);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnSingUp = new JButton("Sing up");
		btnSingUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Inscription info = new Inscription();
				Inscription.main(null);
				frame.setVisible(false);
				
			}
		});
		btnSingUp.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnSingUp.setBounds(584, 372, 112, 39);
		frame.getContentPane().add(btnSingUp);
		
		JLabel lblNewLabel = new JLabel("Home");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(367, 25, 234, 64);
		frame.getContentPane().add(lblNewLabel);
	}

}
