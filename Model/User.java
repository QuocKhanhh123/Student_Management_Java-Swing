package Model;

public class User {
	private String userName;
	private String passWord;
	private boolean role;

	public User() {

	}

	public User(String userName, String passWord, boolean role) {
		super();
		this.userName = userName;
		this.passWord = passWord;
		this.role = role;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public boolean isRole() {
		return role;
	}

	public void setRole(boolean role) {
		this.role = role;
	}

}
