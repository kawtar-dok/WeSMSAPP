package my.wesms.menu;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;

import org.w3c.dom.events.MouseEvent;

import ma.wesms.login.Login;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseMotionAdapter;

public class Menu extends JFrame {

	private JPanel contentPane;

private Image img=new ImageIcon(Login.class.getResource("images/home.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
private Image img=new ImageIcon(Login.class.getResource("images/mess.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
private Image img=new ImageIcon(Login.class.getResource("images/cont.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
private Image img=new ImageIcon(Login.class.getResource("images/sim.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
private Image img=new ImageIcon(Login.class.getResource("images/set.png")).getImage().getScaledInstance(30,30,Image.SCALE_SMOOTH);
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Menu frame = new Menu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Menu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 624);
		setUndecorated(true);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new LineBorder(new Color(0, 139, 139), 2));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBounds(0, 0, 356, 624);
		panelMenu.setBackground(new Color(95, 158, 160));
		contentPane.add(panelMenu);
		
		JLabel labelicon1 = new JLabel("New label");
		labelicon1.setBounds(10, 11, 336, 118);
		ImageIcon icone=new ImageIcon(this.getClass().getResource("/home.png"));
		panelMenu.setLayout(null);
		labelicon1.setIcon(icone);
		panelMenu.add(labelicon1);
		
		JPanel panelHome = new JPanel();
		panelHome.addMouseListener(new PanelButtonMousseAdapter(panelHome));
		panelHome.setBackground(new Color(245, 245, 245));
		panelHome.setBounds(0, 150, 356, 60);
		panelMenu.add(panelHome);
		panelHome.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("HOME");
		lblNewLabel.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblNewLabel.setBounds(116, 11, 108, 36);
		panelHome.add(lblNewLabel);
		
		JLabel labelicone1 = new JLabel("");
		labelicone1.setBounds(63, 11, 43, 38);
		ImageIcon icone1=new ImageIcon(this.getClass().getResource("/homolog.png"));
		labelicone1.setIcon(icone1);
		panelHome.add(labelicone1);
		
		JPanel panelMess = new JPanel();
		panelMess.addMouseListener(new PanelButtonMouseAdapter(panelMess));
		panelMess.setBackground(new Color(245, 245, 245));
		panelMess.setBounds(0, 213, 356, 60);
		panelMenu.add(panelMess);
		panelMess.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("MESSAGES");
		lblNewLabel_1.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblNewLabel_1.setBounds(93, 13, 133, 36);
		panelMess.add(lblNewLabel_1);
		
		JLabel labelicone2 = new JLabel("");
		labelicone2.setBounds(55, 11, 37, 38);
		ImageIcon icone2=new ImageIcon(this.getClass().getResource("/mess.png"));
		labelicone2.setIcon(icone2);
		panelMess.add(labelicone2);
		
		JPanel panelCont = new JPanel();
		panelMess.addMouseListener(new PanelButtonMouseAdapter(panelMess));
		panelCont.setBackground(new Color(245, 245, 245));
		panelCont.setBounds(0, 276, 356, 60);
		panelMenu.add(panelCont);
		panelCont.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("CONTACTS");
		lblNewLabel_2.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblNewLabel_2.setBounds(93, 11, 131, 36);
		panelCont.add(lblNewLabel_2);
		
		JLabel labelicone3 = new JLabel("");
		labelicone3.setBounds(41, 9, 42, 38);
		ImageIcon icone3=new ImageIcon(this.getClass().getResource("/cont.png"));
		labelicone3.setIcon(icone3);
		panelCont.add(labelicone3);
		
		JPanel panelSim = new JPanel();
		panelSim.addMouseListener(new PanelButtonMouseAdapter(panelSim));
		panelSim.setBackground(new Color(245, 245, 245));
		panelSim.setBounds(0, 341, 356, 60);
		panelMenu.add(panelSim);
		panelSim.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("SIM CARD");
		lblNewLabel_3.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblNewLabel_3.setBounds(92, 11, 121, 36);
		panelSim.add(lblNewLabel_3);
		
		JLabel labelicone4 = new JLabel("");
		labelicone4.setBounds(56, 11, 26, 38);
		ImageIcon icone4=new ImageIcon(this.getClass().getResource("/card.png"));
		labelicone4.setIcon(icone4);
		panelSim.add(labelicone4);
		
		JPanel panelSet = new JPanel();
		panelSet.addMouseListener(new PanelButtonMouseAdapter(panelSet));
		panelSet.setBackground(new Color(245, 245, 245));
		panelSet.setBounds(0, 405, 356, 60);
		panelMenu.add(panelSet);
		panelSet.setLayout(null);
		
		JLabel lblNewLabel_4 = new JLabel("SETTINGS");
		lblNewLabel_4.setFont(new Font("Segoe UI Historic", Font.BOLD, 23));
		lblNewLabel_4.setBounds(95, 11, 108, 36);
		panelSet.add(lblNewLabel_4);
		
		JLabel labelicone5 = new JLabel("");
		labelicone5.setBounds(56, 11, 29, 36);
		ImageIcon icone5=new ImageIcon(this.getClass().getResource("/set.png"));
		labelicone5.setIcon(icone5);
		panelSet.add(labelicone5);
	}
	private class PanelButtonMouseAdapter extends MouseAdapter{
		JPanel panel;
		public PanelButtonMouseAdapter(JPanel panel) {
			this.panel=panel;
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			panel.setBackground(new Color(245, 245, 245));
		}
		@Override
		public void mouseExited(MouseEvent e) {
			panel.setBackground(new Color(245, 245, 245));
		}
		@Override
		public void mousePressed(MouseEvent e) {
			panel.setBackground(new Color(245, 245, 245));
		}
		@Override
		public void mouseReleased(MouseEvent e) {
			panel.setBackground(new Color(245, 245, 245));
		}
	}
}
