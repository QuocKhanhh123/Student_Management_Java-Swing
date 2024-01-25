package Model;

import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
	List<Student> list_Student = new ArrayList<Student>();

	public int add(Student student) {
		list_Student.add(student);
		return 1;
	}
	
	public List<Student> getAllStudent() {
		return list_Student;
	}
	public int delStudent(String id) {
		for (Student student : list_Student) {
			if(student.getStudentID().equalsIgnoreCase(id)) {
				list_Student.remove(student);
				return 1;
			}
		}
		return -1;
	}
	public Student getStudentByID(String id) {
		for (Student student : list_Student) {
			if(student.getStudentID().equalsIgnoreCase(id)) {
				return student;
			}
		}
		return null;
	}
	public int updateStudentByID(Student st) {
		for (Student student : list_Student) {
			if(student.getStudentID().equalsIgnoreCase(st.getStudentID())) {
				student.setFullName(st.getFullName());
				student.setBirthDay(st.getBirthDay());
				student.setAddress(st.getAddress());
				student.setImage(st.getImage());
				student.setGender(st.isGender());
				return 1;
			}
		}
		return -1;
	}
	
}
