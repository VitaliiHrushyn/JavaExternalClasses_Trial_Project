package ua.training.electriberies.model.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import ua.training.electriberies.model.dao.common_interfaces.DAOFactory;
import ua.training.electriberies.model.dao.common_interfaces.UserDAO;
import ua.training.electriberies.model.dao.mysql.MySQLDAOFactory;
import ua.training.electriberies.model.entity.users.User;

public class UserService {
	
	private static DAOFactory daoFactory = new MySQLDAOFactory();	
	
	
	public static List<User> getAllUsers() {
		List<User> users = null;
	    try (Connection connection = daoFactory.getConnection()) {
	        UserDAO userDAO = daoFactory.getUserDAO(connection);
	        users = userDAO.getAll();
	    } catch (SQLException e) {
			e.printStackTrace();
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
	
}
