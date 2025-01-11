import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class LoginPage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() { 
			public void run() {
				try {
					LoginPage frame = new LoginPage();
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
	public LoginPage() {
		setFont(new Font("Dialog", Font.BOLD, 14));
		setForeground(new Color(0, 128, 128));
		setTitle("Login Page");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 300);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("UserName :");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel.setBounds(46, 42, 108, 31);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Password :");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		lblNewLabel_1.setBounds(46, 105, 85, 14);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(164, 48, 231, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(164, 103, 231, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String username=textField.getText();
				String pass=passwordField.getText();
				
				 if (username.isEmpty() || pass.isEmpty()) {
			            JOptionPane.showMessageDialog(null, "Username and Password cannot be empty!");
			            return;
			        }

			        // Validate the username and password with the database
			        if (validateLogin(username, pass)) {
			            JOptionPane.showMessageDialog(contentPane, "Login Successful! Welcome, " + username + "!");
			            // Proceed to the next page or functionality
			            
			            
			            
			            
				        EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									wellcome frame = new wellcome();
									frame.setVisible(true);
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
				        
			            
			            
			            
			        } else {
			            JOptionPane.showMessageDialog(null, "Invalid Username or Password. Please try again.");
			        }
			        
			        
			        textField.setText("");
					passwordField.setText("");
			        
			      
			        
			        
			        
			    }
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(42, 187, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Sign-Up");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Signupm frame = new Signupm();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(282, 189, 102, 23);
		contentPane.add(btnNewButton_1);
	}
	
	private boolean validateLogin(String username, String pass) {
	    boolean isValid = false;

	    // Database credentials
	    /*final String DB_URL = "jdbc:mysql://localhost:3306/imca";
	    final String DB_USER = "root";
	    final String DB_PASSWORD = "Mahadev@1234";*/

	    // Query to check login credentials
	   // String query = "SELECT * FROM User WHERE User_Name = ? AND Password = ?";

	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/imca", "root",  "Mahadev@1234");
	         PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM User WHERE User_Name = ? AND Password = ?")) {

	        // Set the parameters for the query
	        pstmt.setString(1, username);
	        pstmt.setString(2, pass);

	        // Execute the query
	        ResultSet rs = pstmt.executeQuery();

	        // Check if the result set contains a matching user
	        if (rs.next()) {
	            isValid = true;
	        }

	    } catch (SQLException ex) {
	        ex.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Database Error: " + ex.getMessage());
	    }

	    return isValid;
	}

}
