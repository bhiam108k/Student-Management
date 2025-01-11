import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.SystemColor;

public class Signupm extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signupm frame = new Signupm();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});*/
	}

	/**
	 * Create the frame.
	 */
	public Signupm() {
		setBackground(new Color(255, 51, 102));
		setFont(new Font("Times New Roman", Font.PLAIN, 16));
		setTitle("Signup-Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 494, 321);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(153, 180, 209));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("First Name :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel.setBounds(10, 25, 98, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Last Name :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(10, 62, 86, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mobile No. :");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_2.setBounds(10, 96, 86, 14);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password :");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_3.setBounds(10, 179, 86, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fname=textField.getText();
				String lname=textField_1.getText();
				String mobno=textField_2.getText();
				String usename=textField_3.getText();
				String pss=passwordField.getText();
				
				 if (fname.isEmpty() || lname.isEmpty() || mobno.isEmpty() || usename == null ||pss.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "All fields are required!");
			            return;
			        }
				
				
				try {
					
					
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imca","root","Mahadev@1234");
					PreparedStatement pstm=conn.prepareStatement("INSERT INTO User  (First_Name,Last_Name,Mobile_NO,User_Name,Password) VALUES(?,?,?,?,?)");
					
					    pstm.setString(1, fname);
					    pstm.setString(2,lname);
					    pstm.setString(3, mobno);
					    pstm.setString(4, usename);
					    pstm.setString(5, pss);
					    pstm.executeUpdate();
					    JOptionPane.showMessageDialog(contentPane, "Registration Sucessfull ");
					    
					    textField.setText("");
					    textField_1.setText("");
					    textField_2.setText("");
					    textField_3.setText("");
					    passwordField.setText("");
					    
					    System.exit(0);
	    
					    	    
				}
				catch (SQLException ex) 
				{      
				  ex.printStackTrace(); 
				  
				  }
		
			}
				
			
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnNewButton.setBounds(173, 212, 89, 23);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(148, 23, 196, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(148, 54, 196, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(148, 94, 196, 20);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(148, 177, 189, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_4 = new JLabel("User Name :");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_4.setBounds(10, 135, 86, 14);
		contentPane.add(lblNewLabel_4);
		
		textField_3 = new JTextField();
		textField_3.setBounds(148, 133, 196, 20);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}
}
