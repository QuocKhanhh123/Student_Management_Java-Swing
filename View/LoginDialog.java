package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.Color;
import javax.swing.border.SoftBevelBorder;

import Model.UserDIO;

import javax.swing.border.BevelBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.CompoundBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;
import java.awt.Toolkit;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtUserName;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public boolean checkValideteForm() {
		if(txtUserName.getText().isEmpty() || passwordField.getText().isEmpty()) {
			return false;
		}
		return true;
	}
	public void reset(){
		txtUserName.setText("");
		passwordField.setText("");
	}
	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setTitle("Login");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LoginDialog.class.getResource("/Image/loginItem.png")));
		
		setBounds(100, 100, 698, 389);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(255, 255, 255));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JLabel lblNewLabel = new JLabel("SYSTEM LOGIN");
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			lblNewLabel.setBounds(268, 22, 159, 41);
			contentPanel.add(lblNewLabel);
		}
		
		JButton btnLogin = new JButton("LOGIN");
		btnLogin.setIcon(new ImageIcon(LoginDialog.class.getResource("/Image/log-in.png")));
		btnLogin.setBorder(new LineBorder(new Color(128, 255, 255), 2));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(checkValideteForm()) {
					String name = txtUserName.getText();
					String passWord = new String(passwordField.getPassword());
					UserDIO user = new UserDIO();
					if(user.checkLogin(name, passWord)) {
						JFMainForm main = new JFMainForm();
						main.setVisible(true);
						dispose();
					}
					else {
						JOptionPane.showMessageDialog(btnLogin, "Invalid name or password !");
					}
				}
				else {
					JOptionPane.showMessageDialog(btnLogin, "You haven't entered a name or password !");
				}
					
			}
		});
		btnLogin.setBackground(new Color(233, 233, 233));
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLogin.setBounds(251, 251, 159, 48);
		contentPanel.add(btnLogin);
		
		JButton btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnCancel.setIcon(new ImageIcon(LoginDialog.class.getResource("/Image/forbidden.png")));
		btnCancel.setBorder(new LineBorder(new Color(255, 128, 128), 2));
		btnCancel.setBackground(new Color(233, 233, 233));
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBounds(456, 251, 159, 48);
		contentPanel.add(btnCancel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(209, 209, 233));
		panel.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel.setBounds(253, 97, 362, 129);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		txtUserName = new JTextField();
		txtUserName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtUserName.setBounds(115, 22, 224, 29);
		panel.add(txtUserName);
		txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtUserName.setColumns(10);
		{
			JLabel lblNewLabel_2 = new JLabel("User name:");
			lblNewLabel_2.setBounds(20, 22, 96, 29);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		{
			JLabel lblNewLabel_2 = new JLabel("Password:");
			lblNewLabel_2.setBounds(20, 79, 96, 29);
			panel.add(lblNewLabel_2);
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 16));
		}
		
		passwordField = new JPasswordField();
		passwordField.setBorder(new LineBorder(new Color(0, 0, 0)));
		passwordField.setBounds(115, 79, 224, 29);
		panel.add(passwordField);
		passwordField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBorder(null);
		lblNewLabel_1.setIcon(new ImageIcon(LoginDialog.class.getResource("/Image/login.png")));
		lblNewLabel_1.setBounds(62, 89, 130, 137);
		contentPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_3.setIcon(new ImageIcon(LoginDialog.class.getResource("/Image/blue.png")));
		lblNewLabel_3.setBounds(0, 0, 684, 352);
		contentPanel.add(lblNewLabel_3);
		setLocationRelativeTo(null);
	}
}
