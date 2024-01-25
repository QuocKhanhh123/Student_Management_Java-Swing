package View;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Model.SubjectDAO;
import Model.SubjectModel;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.border.LineBorder;

public class Subject extends JFrame {

	private JPanel txt;
	private JTextField txtName;
	private JTextField txtSubjectID;
	private JLabel lblStatus;

	SubjectDAO subDao = new SubjectDAO();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Subject frame = new Subject();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void reset() {
		txtSubjectID.setText("");
		txtName.setText("");
	}

	public SubjectModel getModel() {
		SubjectModel subject = new SubjectModel();
		subject.setSubjectID(txtSubjectID.getText().trim());
		subject.setSubjectName(txtName.getText().trim());
		return subject;
	}

	public boolean validateForm() {
		if (txtName.getText().isEmpty() || txtSubjectID.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	/**
	 * Create the frame.
	 */
	public Subject() {
		super("Subject Management");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Subject.class.getResource("/Image/education.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 314);
		txt = new JPanel();
		txt.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(txt);
		txt.setLayout(null);

		JLabel lblNewLabel = new JLabel("SUBJECT MANAGEMENT");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(206, 10, 223, 33);
		txt.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("SUBJECT ID: ");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(49, 65, 96, 26);
		txt.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("SUBJECT NAME: ");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(49, 117, 115, 26);
		txt.add(lblNewLabel_1_1);

		txtName = new JTextField();
		txtName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtName.setBounds(167, 113, 285, 33);
		txt.add(txtName);
		txtName.setColumns(10);

		txtSubjectID = new JTextField();
		txtSubjectID.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtSubjectID.setColumns(10);
		txtSubjectID.setBounds(167, 65, 285, 33);
		txt.add(txtSubjectID);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setBorder(new LineBorder(new Color(255, 255, 193), 2));
		btnAdd.setIcon(new ImageIcon(Subject.class.getResource("/Image/add-file.png")));
		btnAdd.setBackground(new Color(240, 240, 240));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnAdd.setBounds(167, 163, 121, 38);
		txt.add(btnAdd);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBorder(new LineBorder(new Color(121, 188, 255), 2));
		btnSave.setIcon(new ImageIcon(Subject.class.getResource("/Image/save-data.png")));
		btnSave.setBackground(new Color(240, 240, 240));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					SubjectModel subjectModel = getModel();
					if (subDao.add(subjectModel) > 0) {
						JOptionPane.showMessageDialog(btnSave, "Save successfull !");
						lblStatus.setText("Save successfull !");
						lblStatus.setForeground(Color.RED);
					}
				} else {
					JOptionPane.showMessageDialog(btnSave, "Please enter complete information !");
				}
			}
		});
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnSave.setBounds(331, 163, 121, 38);
		txt.add(btnSave);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBorder(new LineBorder(new Color(255, 157, 157), 2));
		btnDelete.setIcon(new ImageIcon(Subject.class.getResource("/Image/delete.png")));
		btnDelete.setBackground(new Color(240, 240, 240));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = txtSubjectID.getText();
				int pos = subDao.delete(find);
				if (pos >= 0) {
					JOptionPane.showMessageDialog(btnDelete, "Delete successfull !");
					lblStatus.setText("Delete successfull !");
				} else {
					JOptionPane.showMessageDialog(btnDelete, "Not found !");
				}
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnDelete.setBounds(462, 108, 121, 38);
		txt.add(btnDelete);

		lblStatus = new JLabel("STATUS:");
		lblStatus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblStatus.setBounds(10, 236, 269, 26);
		txt.add(lblStatus);

		JButton btnExit = new JButton("EXIT");
		btnExit.setBorder(new LineBorder(new Color(255, 189, 222), 2));
		btnExit.setIcon(new ImageIcon(Subject.class.getResource("/Image/exit-door.png")));
		btnExit.setBackground(new Color(240, 240, 240));
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFMainForm().setVisible(true);
				dispose();
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnExit.setBounds(501, 229, 96, 38);
		txt.add(btnExit);

		JButton btnFind = new JButton("FIND");
		btnFind.setBorder(new LineBorder(new Color(255, 255, 255), 2));
		btnFind.setIcon(new ImageIcon(Subject.class.getResource("/Image/find-clipboard.png")));
		btnFind.setBackground(new Color(240, 240, 240));
		btnFind.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String find = txtSubjectID.getText();
				SubjectModel sub = subDao.findSubjectByID(find);
				if (sub != null) {
					txtName.setText(sub.getSubjectName());
				} else {
					JOptionPane.showMessageDialog(btnFind, "Not found !");
				}
			}
		});
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnFind.setBounds(462, 60, 121, 38);
		txt.add(btnFind);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(Subject.class.getResource("/Image/hinh-nen-powerpoint-don-gian-5.jpg")));
		lblNewLabel_2.setBounds(0, 0, 618, 277);
		txt.add(lblNewLabel_2);
		setLocationRelativeTo(null);
	}
}
