package ua.training.electriberies.model.service;

import java.util.List;

import ua.training.electriberies.model.dao.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.users.User;
import ua.training.electriberies.model.entity.users.UserImpl;
import ua.training.electriberies.model.entity.users.UserRole;

public class UserService {
	
	private static DAOFactory daoFactory = DAOFactory.getInstance();	
	
	public static List<User> getAllUsers() {
		List<User> users = null;
	    try (GenericDAO<User> userDAO = daoFactory.createUserDAO()) {
	        users = userDAO.getAll();
	    } catch (Exception e) {
	    	throw new RuntimeException(e);
		}		
		return users; 
	}
	
	public static User getUserByLogin(String login) {
		for (User user : getAllUsers()) {
			if (user.getLogin().equals(login)) {
				return user;
			}
		}
		return null;
	}

	public static boolean isUserExists(String login, String password) {
		User user = getUserByLogin(login);
		if (user == null) {
			return false;
		} else {
			return	user.getPassword().equals(password);
		}		
	}
	
	public static void createUser(String login, String password, UserRole role) {
		User user = new UserImpl(login, password, role);
		
		try (GenericDAO<User> userDAO = daoFactory.createUserDAO()) {
	        userDAO.create(user);
	    } catch (Exception e) {
			throw new RuntimeException(e);
		}	
	}
	
}
