package my.wesms.MyRepertoirContact;

import java.awt.EventQueue;

import java.sql.*;
//1er chose apre avoir cee la bd wesms and the contact table is to connect between bd and our source code so that's why m caling this librairy
//2eme installer mysql connector for java 

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//Limport java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;


public class MyRepertoirContact{

	private JFrame frame;
	private JTextField txtfirstname;
	private JTextField txtlastname;
	private JTextField txtnum;
	private JTextField txtdate;
	private JTextField txtadressemail;
	private JTextField txtvillepays;
	private JTable table;
	private JTextField txtnamesearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyRepertoirContact window = new MyRepertoirContact();
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
	public MyRepertoirContact() {
		initialize();
		connect();
		table_load();
	}

	
	Connection con;
	PreparedStatement pst;//using java.sql.*;
	ResultSet rs;
	
	
	//methode de conecxion
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost/wesms","root","");//Statement st = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
		}/*catch(ClassNotFoundException ex)
		{
			//System.out.println("class not found ");
			ex.printStackTrace();
		}*/
		catch(SQLException ex)
		{
			
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}
	//after writing the save methode
	
	
    public void table_load() {
		try {
			pst= con.prepareStatement("select * from contact");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));//rs2xml.jar download: we need to download this file.
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(95, 158, 160));
		frame.setBounds(100, 100, 1007, 573);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Contact Directory");
		lblNewLabel.setForeground(new Color(240, 255, 240));
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 32));
		lblNewLabel.setBounds(345, 23, 305, 37);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registration", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(38, 86, 452, 289);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(20, 36, 104, 14);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Last name");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1.setBounds(20, 71, 124, 14);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Numero Tele");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1.setBounds(20, 110, 124, 14);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Date of birth");
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1.setBounds(20, 146, 124, 14);
		panel.add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("adresse mail");
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1.setBounds(20, 182, 104, 14);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("ville/Pays");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1_1_1_1_1_1.setBounds(20, 214, 104, 14);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		txtfirstname = new JTextField();
		txtfirstname.setBounds(164, 36, 165, 23);
		panel.add(txtfirstname);
		txtfirstname.setColumns(10);
		
		txtlastname = new JTextField();
		txtlastname.setBounds(164, 71, 165, 23);
		panel.add(txtlastname);
		txtlastname.setColumns(10);
		
		txtnum = new JTextField();
		txtnum.setColumns(10);
		txtnum.setBounds(164, 109, 165, 23);
		panel.add(txtnum);
		
		txtdate = new JTextField();
		txtdate.setColumns(10);
		txtdate.setBounds(164, 145, 165, 23);
		panel.add(txtdate);
		
		txtadressemail = new JTextField();
		txtadressemail.setColumns(10);
		txtadressemail.setBounds(164, 181, 165, 23);
		panel.add(txtadressemail);
		
		txtvillepays = new JTextField();
		txtvillepays.setColumns(10);
		txtvillepays.setBounds(164, 213, 165, 23);
		panel.add(txtvillepays);
		
		JButton btnNewButton = new JButton("Save");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String firstname,lastname,adressemail,villepays,date;
				String  num;
				
				firstname = txtfirstname.getText();
				lastname = txtlastname.getText();
				num = txtnum.getText();
				date = txtdate.getText();
				adressemail = txtadressemail.getText();
				villepays = txtvillepays.getText();
				
				try {
					pst=con.prepareStatement("instert into contact(firstname,lastname,numerotele,dateofbirth,adressemail,villepays)values(?,?,?,?,?,?);");
					pst.setString(1, firstname);
					pst.setString(2, lastname);
					pst.setString(3, num);
					pst.setString(4, date);
					pst.setString(5, adressemail);
					pst.setString(6, villepays);
					JOptionPane.showMessageDialog(null,"New Record Added ! yeah !!!");
					table_load();
					txtfirstname.setText("");
					txtlastname.setText("");
					txtnum.setText("");
					txtdate.setText("");
					txtadressemail.setText("");
					txtvillepays.setText("");
				}catch(SQLException e1) {
					e1.printStackTrace();
				}
				
				
			}
		});
		btnNewButton.setBounds(91, 386, 97, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Exit");
		btnNewButton_1.setBounds(228, 386, 97, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("clear");
		btnNewButton_2.setBounds(367, 386, 103, 23);
		frame.getContentPane().add(btnNewButton_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(32, 452, 422, 73);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Contact Name :");
		lblNewLabel_1_1_2.setBounds(27, 33, 101, 15);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_1.add(lblNewLabel_1_1_2);
		
		txtnamesearch = new JTextField();
		txtnamesearch.setBounds(150, 31, 125, 20);
		txtnamesearch.setColumns(10);
		panel_1.add(txtnamesearch);
		
		JButton btnNewButton_5 = new JButton("Search");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_5.setBounds(305, 30, 89, 23);
		panel_1.add(btnNewButton_5);
		
		JScrollPane table_1 = new JScrollPane();
		table_1.setBounds(532, 83, 440, 289);
		frame.getContentPane().add(table_1);
		
		table = new JTable();
		table_1.setViewportView(table);
		
		JButton btnNewButton_3 = new JButton("Update");
		btnNewButton_3.setBounds(599, 448, 89, 23);
		frame.getContentPane().add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("Delete");
		btnNewButton_4.setBounds(787, 448, 89, 23);
		frame.getContentPane().add(btnNewButton_4);
	}
}