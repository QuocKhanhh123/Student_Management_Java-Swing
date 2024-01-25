package Model;

import java.util.ArrayList;
import java.util.List;

public class UserDIO {
	List<User> listUser = new ArrayList<User>();
	
	public UserDIO() {
		listUser.add(new User("PhanKhanh", "12345",true));
		listUser.add(new User("PhanHoang", "12345",true));
		listUser.add(new User("PhanNgan", "12345",true));
		listUser.add(new User("PhanDan", "12345",true));
		listUser.add(new User("PhanDuc", "12345",true));
		
	}
	public boolean checkLogin(String name, String passWord) {
		for (User user : listUser) {
			if(user.getUserName().equals(name) && user.getPassWord().equals(passWord)) {
				return true;
			}
		}
		return false;
	}
}
