import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class wellcome extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		/*EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					wellcome frame = new wellcome();
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
	public wellcome() {
		setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 16));
		setTitle("Wellcome Student");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 504, 354);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 222, 173));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Wellcome ! ");
		lblNewLabel.setBounds(205, 11, 92, 27);
		lblNewLabel.setFont(new Font("Yu Gothic Medium", Font.BOLD, 16));
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Add Students Details");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 EventQueue.invokeLater(() -> {
			            try {
			                bhimahome frame = new bhimahome();
			                frame.setVisible(true);
			            } catch (Exception ex) {
			                ex.printStackTrace();
			            }
			        });
				
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton.setBounds(47, 48, 381, 38);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Add Department Details");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							department frame = new department();
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_1.setBounds(47, 119, 378, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("View Students Details");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 EventQueue.invokeLater(new Runnable() {
			            public void run() {
			                try {
			                    MyswingProgram3 frame = new MyswingProgram3();
			                    frame.setVisible(true);
			                } catch (Exception e) {
			                    e.printStackTrace();
			                }
			            }
			        });
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_2.setBounds(47, 188, 378, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);			
				}
		});
		btnNewButton_3.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 15));
		btnNewButton_3.setBounds(190, 264, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
