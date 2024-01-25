package View;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.JobAttributes;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Student;
import Model.StudentDAO;

import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.SpringLayout;
import javax.swing.border.LineBorder;

public class StudentDiaLog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtStudentID;
	private JTextField txtFullName;
	private JTextField txtBirthday;
	private JLabel lblImage;
	private JTable table;
	private JTable tbStudent;
	private JRadioButton jbtMale;
	private JRadioButton jbtFemale;
	private JTextArea textAddress;

	SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
	StudentDAO dao = new StudentDAO();
	String strImage = null;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			StudentDiaLog dialog = new StudentDiaLog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reset() {
		txtStudentID.setText("");
		txtFullName.setText("");
		txtBirthday.setText("");
		textAddress.setText("");
		jbtMale.isSelected();
		lblImage.setText("IMAGE");
		lblImage.setIcon(null);
		strImage = null;
	}

	public boolean validateForm() {
		if (txtStudentID.getText().isEmpty() || txtFullName.getText().isEmpty() || txtBirthday.getText().isEmpty()
				|| textAddress.getText().isEmpty()) {
			return false;
		}
		return true;
	}

	public Student getModel() throws ParseException {
		Student student = new Student();
		student.setStudentID(txtStudentID.getText());
		student.setFullName(txtFullName.getText());
		boolean gender = false;
		if (jbtMale.isSelected()) {
			gender = true;
		}
		student.setGender(gender);
		student.setAddress(textAddress.getText());
		student.setBirthDay(df.parse(txtBirthday.getText()));
		if (strImage == null) {
			student.setImage("No avata");
		} else {
			student.setImage(strImage);
		}
		return student;
	}

	public void fillDataTable() {
		DefaultTableModel model = (DefaultTableModel) tbStudent.getModel();
		model.setRowCount(0); // clear table
		for (Student student : dao.getAllStudent()) {
			Object rowData[] = new Object[6];
			rowData[0] = student.getStudentID();
			rowData[1] = student.getFullName();
			rowData[2] = df.format(student.getBirthDay());
			rowData[3] = student.isGender() ? "MALE" : "FEMALE";
			rowData[4] = student.getAddress();
			rowData[5] = student.getImage();
			model.addRow(rowData);
		}
	}

	public void setModel(Student student) {
		txtStudentID.setText(student.getStudentID());
		txtFullName.setText(student.getFullName());
		txtBirthday.setText(df.format(student.getBirthDay()));
		textAddress.setText(student.getAddress());
		if (student.isGender()) {
			jbtMale.isSelected();
		} else {
			jbtFemale.isSelected();
		}
		// load image
		if (student.getImage().equalsIgnoreCase("No avata")) {
			lblImage.setText("No Avata");
			lblImage.setIcon(null);

		} else {
			lblImage.setText("");
			ImageIcon imIcon = new ImageIcon(getClass().getResource("/Image/" + student.getImage()));
			Image img = imIcon.getImage().getScaledInstance(lblImage.getWidth(), lblImage.getY(), 0);
			lblImage.setIcon(imIcon);
		}

	}

	/**
	 * Create the dialog.
	 */
	public StudentDiaLog() {
		setTitle("Student Management");
		
		setIconImage(Toolkit.getDefaultToolkit().getImage(StudentDiaLog.class.getResource("/Image/graduated.png")));
		setBounds(100, 100, 709, 655);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(new Color(225, 240, 255));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			lblNewLabel = new JLabel("STUDENT MANAGEMENT");
			lblNewLabel.setBounds(229, 10, 258, 40);
			lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 20));
			contentPanel.add(lblNewLabel);
		}

		JLabel lblNewLabel_1 = new JLabel("STUDENT ID:");
		lblNewLabel_1.setBounds(33, 91, 109, 29);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("FULL NAME:");
		lblNewLabel_1_1.setBounds(33, 144, 109, 29);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_2 = new JLabel("BIRTHDAY:");
		lblNewLabel_1_2.setBounds(33, 197, 109, 29);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_1_2);

		JLabel lblNewLabel_1_2_1 = new JLabel("GENDER:");
		lblNewLabel_1_2_1.setBounds(33, 251, 109, 29);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_1_2_1);

		jbtMale = new JRadioButton("MALE");
		jbtMale.setBounds(142, 255, 68, 21);
		jbtMale.setBackground(new Color(225, 240, 255));
		jbtMale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jbtMale.isSelected()) {
					jbtFemale.setSelected(false);
				}
			}
		});
		jbtMale.setSelected(true);
		jbtMale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(jbtMale);

		txtStudentID = new JTextField();
		txtStudentID.setBounds(142, 91, 276, 29);
		txtStudentID.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(txtStudentID);
		txtStudentID.setColumns(10);

		txtFullName = new JTextField();
		txtFullName.setBounds(142, 144, 276, 29);
		txtFullName.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtFullName.setColumns(10);
		contentPanel.add(txtFullName);

		txtBirthday = new JTextField();
		txtBirthday.setBounds(142, 197, 276, 29);
		txtBirthday.setBorder(new LineBorder(new Color(0, 0, 0)));
		txtBirthday.setColumns(10);
		contentPanel.add(txtBirthday);

		jbtFemale = new JRadioButton("FEMALE");
		jbtFemale.setBounds(234, 255, 103, 21);
		jbtFemale.setBackground(new Color(225, 240, 255));
		jbtFemale.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (jbtFemale.isSelected()) {
					jbtMale.setSelected(false);
				}
			}
		});
		jbtFemale.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(jbtFemale);

		JLabel lblNewLabel_1_2_1_1 = new JLabel("ADDRESS:");
		lblNewLabel_1_2_1_1.setBounds(33, 309, 109, 29);
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		contentPanel.add(lblNewLabel_1_2_1_1);

		textAddress = new JTextArea();
		textAddress.setBounds(33, 348, 385, 89);
		textAddress.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(textAddress);

		lblImage = new JLabel("IMAGE");
		lblImage.setBounds(457, 91, 212, 218);
		lblImage.setBackground(new Color(240, 240, 240));
		lblImage.setForeground(new Color(255, 0, 0));
		lblImage.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblImage.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					JFileChooser jfc = new JFileChooser("E:\\Pictures");
					jfc.showOpenDialog(null);
					File file = jfc.getSelectedFile();
					Image img = ImageIO.read(file);
					strImage = file.getName();
					lblImage.setText("");
					int width = lblImage.getWidth();
					int height = lblImage.getHeight();
					lblImage.setIcon(new ImageIcon(img.getScaledInstance(width, height, 0)));
				} catch (IOException e1) {
					System.out.println("Error: " + e.toString());
				}

			}
		});
		lblImage.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		contentPanel.add(lblImage);

		JButton btnAdd = new JButton("ADD");
		btnAdd.setBounds(441, 347, 109, 40);
		btnAdd.setBorder(new LineBorder(new Color(128, 255, 255), 2));
		btnAdd.setBackground(new Color(213, 213, 213));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnAdd.setIcon(new ImageIcon(StudentDiaLog.class.getResource("/Image/add-group (1).png")));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(btnAdd);

		JButton btnSave = new JButton("SAVE");
		btnSave.setBounds(560, 348, 112, 40);
		btnSave.setBorder(new LineBorder(new Color(255, 255, 168), 2));
		btnSave.setBackground(new Color(213, 213, 213));
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					try {
						Student student = getModel();
						if (dao.add(student) > 0) {
							JOptionPane.showMessageDialog(btnSave, "Save successful !");
							fillDataTable();
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnSave, "Please enter complete information !");
				}
			}
		});
		btnSave.setIcon(new ImageIcon(StudentDiaLog.class.getResource("/Image/save.png")));
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(btnSave);

		JButton btnEdit = new JButton("EDIT");
		btnEdit.setBounds(441, 397, 109, 40);
		btnEdit.setBorder(new LineBorder(new Color(174, 255, 174), 2));
		btnEdit.setBackground(new Color(213, 213, 213));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (validateForm()) {
					try {
						Student sv = getModel();
						if (dao.updateStudentByID(sv) > 0) {
							JOptionPane.showMessageDialog(btnEdit, "Update information student successfull !");
							fillDataTable();
						}
					} catch (ParseException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else {
					JOptionPane.showMessageDialog(btnEdit, "Please enter complete information !");
				}
			}
		});
		btnEdit.setIcon(new ImageIcon(StudentDiaLog.class.getResource("/Image/edit.png")));
		btnEdit.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(btnEdit);

		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(560, 397, 112, 40);
		btnDelete.setBorder(new LineBorder(new Color(255, 119, 119), 2));
		btnDelete.setBackground(new Color(213, 213, 213));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(txtStudentID.getText().isEmpty()) {
					JOptionPane.showMessageDialog(btnDelete, "You haven't entered an ID to delete !");
				}
				else {
					if(dao.delStudent(txtStudentID.getText()) > 0) {
						JOptionPane.showMessageDialog(btnDelete, "Delete student successful !");
						fillDataTable();
					}
					else {
						JOptionPane.showMessageDialog(btnDelete, "No student found !");
					}
				}
			}
		});
		btnDelete.setIcon(new ImageIcon(StudentDiaLog.class.getResource("/Image/delete.png")));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 12));
		contentPanel.add(btnDelete);

		table = new JTable();
		table.setBounds(78, 535, 1, 1);
		contentPanel.add(table);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(33, 467, 639, 104);
		scrollPane.setBorder(new LineBorder(new Color(0, 0, 0)));
		contentPanel.add(scrollPane);

		tbStudent = new JTable();
		tbStudent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int id = tbStudent.rowAtPoint(e.getPoint());
				String studentId = tbStudent.getValueAt(id, 0).toString();
				Student student = dao.getStudentByID(studentId);
				setModel(student);
			}
		});
		scrollPane.setViewportView(tbStudent);
		tbStudent.setModel(new DefaultTableModel(
				new Object[][] { { null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, { null, null, null, null, null, null },
						{ null, null, null, null, null, null }, },
				new String[] { "STUDENT ID", "FULL NAME", "BIRTHDAY", "GENDER", "ADDRESS", "IMAGE" }));
		
		JButton btnNewButton = new JButton("EXIT");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new JFMainForm().setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBackground(new Color(231, 231, 231));
		btnNewButton.setBorder(new LineBorder(new Color(255, 204, 204), 2));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnNewButton.setIcon(new ImageIcon(StudentDiaLog.class.getResource("/Image/exit-door.png")));
		btnNewButton.setBounds(582, 581, 113, 37);
		contentPanel.add(btnNewButton);
		setLocationRelativeTo(null);
	}
}
