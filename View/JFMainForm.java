package View;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class JFMainForm extends JFrame {

	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFMainForm frame = new JFMainForm();
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
	public JFMainForm() {
		super("Form");
		setIconImage(Toolkit.getDefaultToolkit().getImage(JFMainForm.class.getResource("/Image/school.png")));
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 820, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 225, 196));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("STUDENT MANAGEMENT PROGRAM");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(226, 21, 354, 43);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(JFMainForm.class.getResource("/Image/School-icon.png")));
		lblNewLabel_1.setBounds(139, 127, 536, 343);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("Student Management");
		btnNewButton.setIcon(new ImageIcon(JFMainForm.class.getResource("/Image/graduate.png")));
		btnNewButton.setBorder(new LineBorder(new Color(255, 128, 128), 2));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StudentDiaLog dia = new StudentDiaLog();
				dia.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBackground(new Color(228, 228, 228));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(179, 74, 190, 42);
		contentPane.add(btnNewButton);
		
		
		JButton btnGradeManagement = new JButton("Subject Management");
		btnGradeManagement.setIcon(new ImageIcon(JFMainForm.class.getResource("/Image/education.png")));
		btnGradeManagement.setBorder(new LineBorder(new Color(128, 255, 255), 2));
		btnGradeManagement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Subject sub = new Subject();
				sub.setVisible(true);
				dispose();
			}
		});
		btnGradeManagement.setBackground(new Color(228, 228, 228));
		btnGradeManagement.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGradeManagement.setBounds(417, 75, 190, 42);
		contentPane.add(btnGradeManagement);
		setLocationRelativeTo(null);
	}
}
