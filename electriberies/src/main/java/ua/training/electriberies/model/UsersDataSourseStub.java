package ua.training.electriberies.model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UsersDataSourseStub {
	
	static private List<User> users = new CopyOnWriteArrayList<>();
	
	/*Making one admin to work with*/
	static {
		users.add(new User("admin", "admin", User.Role.ADMIN));
	}
	
	public static User getUserByLogin(String login) {
		for (User user : users) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}
	
	public static void addUser(User user) {
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


}
