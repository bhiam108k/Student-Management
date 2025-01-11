import java.awt.EventQueue;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import javax.swing.border.EmptyBorder;


public class bhimahome extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JComboBox<String> departmentBox;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
       /* EventQueue.invokeLater(() -> {
            try {
                bhimahome frame = new bhimahome();
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });*/
    }

    /**
     * Create the frame.
     */
    public bhimahome() {
        setTitle("Student Information");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 450, 300);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblNewLabel = new JLabel("Student Roll Number:");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel.setBounds(24, 35, 143, 14);
        contentPane.add(lblNewLabel);

        textField = new JTextField();
        textField.setBounds(192, 34, 197, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_1 = new JLabel("Student Name:");
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(24, 74, 134, 30);
        contentPane.add(lblNewLabel_1);

        textField_1 = new JTextField();
        textField_1.setBounds(192, 81, 193, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_2 = new JLabel("Student Class Name:");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_2.setBounds(24, 127, 134, 14);
        contentPane.add(lblNewLabel_2);

        textField_2 = new JTextField();
        textField_2.setBounds(192, 126, 193, 20);
        contentPane.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Department:");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_3.setBounds(24, 168, 125, 14);
        contentPane.add(lblNewLabel_3);

        departmentBox = new JComboBox<>(fetchDepartments().toArray(new String[0]));
        departmentBox.setBounds(192, 168, 197, 20);
        contentPane.add(departmentBox);

        JButton btnNewButton = new JButton("Submit");
        btnNewButton.addActionListener(e -> saveStudent());
        btnNewButton.setBounds(10, 227, 89, 23);
        contentPane.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Clear");
        btnNewButton_1.addActionListener(e -> clearFields());
        btnNewButton_1.setBounds(173, 227, 89, 23);
        contentPane.add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("Exit");
        btnNewButton_2.addActionListener(e -> System.exit(0));
        btnNewButton_2.setBounds(322, 227, 89, 23);
        contentPane.add(btnNewButton_2);
    }
    private HashMap<String, Integer> departmentMap = new HashMap<>();

    // Fetch department names from the department table
    private ArrayList<String> fetchDepartments() {
        ArrayList<String> departments = new ArrayList<>();
        try (Connection con = DatabaseConnection.getConnection();
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT dept_id, dept_Name FROM department")) {
        	 while (rs.next()) {
                 int id = rs.getInt("dept_id");
                 String name = rs.getString("dept_Name");
                 String display = id + " - " + name;

                 departments.add(display);
                // departmentMap.put(display, id); // Map display string to dept_id
             }
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error fetching departments: " + e.getMessage());
        }
        return departments;
    }

    // Save student details to the student table
    private void saveStudent() {
        String rollNo = textField.getText().trim();
        String name = textField_1.getText().trim();
        String studentClass = textField_2.getText().trim();
        String department = (String) departmentBox.getSelectedItem(); // Get selected department

        // Validate that all fields are filled
        if (rollNo.isEmpty() || name.isEmpty() || studentClass.isEmpty() || department == null || department.isEmpty()) {
            JOptionPane.showMessageDialog(this, "All fields are required!");
            return;
        }

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     "INSERT INTO Studence (Student_RollNo, Student_name, Student_class, Department) VALUES (?, ?, ?, ?)")) {
            ps.setString(1, rollNo);       // Set Roll Number
            ps.setString(2, name);         // Set Student Name
            ps.setString(3, studentClass); // Set Class
            ps.setString(4, department);   // Set Department
            ps.executeUpdate();            // Execute the query
            JOptionPane.showMessageDialog(this, "Student record added successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error: " + e.getMessage());
        }
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        departmentBox.setSelectedIndex(0);
    }


    // Clear input fields
    private void clearFields() {
        textField.setText("");
        textField_1.setText("");
        textField_2.setText("");
        departmentBox.setSelectedIndex(0);
    }
}

// Supporting Database Connection Class
class DatabaseConnection {
    public static Connection getConnection() {
        Connection con = null;
        try {
            String url = "jdbc:mysql://localhost:3306/imca"; // Replace with your database name
            String user = "root"; 
            String password = "Mahadev@1234"; // Replace with your password
            con = DriverManager.getConnection(url, user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

	public static Connection getConnection(String string) {
		// TODO Auto-generated method stub
		return null;
	}
}
