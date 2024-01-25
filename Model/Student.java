package Model;

import java.util.Date;

public class Student {
	private String studentID;
	private String fullName;
	private Date birthDay;
	private boolean gender;
	private String address;
	private String image;

	public Student() {

	}
	
	public Student(String studentID, String fullName, Date birthDay, boolean gender, String address, String image) {
		super();
		this.studentID = studentID;
		this.fullName = fullName;
		this.birthDay = birthDay;
		this.gender = gender;
		this.address = address;
		this.image = image;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

}
