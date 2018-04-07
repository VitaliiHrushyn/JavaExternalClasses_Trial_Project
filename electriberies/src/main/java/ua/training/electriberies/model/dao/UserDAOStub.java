package ua.training.electriberies.model.dao;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import ua.training.electriberies.model.entity.users.UserImp;
import ua.training.electriberies.model.entity.users.UserRole;

public class UserDAOStub {
	
	static private List<UserImp> users = new CopyOnWriteArrayList<>();
	
	/*Making one admin to work with*/
	static {
		users.add(new UserImp("admin", "admin", UserRole.ADMIN));
	}
	
	public static UserImp getUserByLogin(String login) {
		for (UserImp user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}
	
	public static void addUser(UserImp user) {
		users.add(user);
	}
	
	public static boolean isUserExists(String login, String password) {
		if (getUserByLogin(login) != null) {
			if (getUserByLogin(login).getPassword().equals(password)) {
				return true;
			}
		}
		return false;
	}
	
	public static String[] getAllLogins() {
		String[] logins = new String[users.size()];
		int i = 0;
		for (UserImp user : users) {
			logins[i++] = user.getLogin();
		}
		return logins;
	}


}
