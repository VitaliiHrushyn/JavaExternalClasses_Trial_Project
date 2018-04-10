package electriberies.model.dao.implementations;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ua.training.electriberies.model.dao.common_interfaces.DAOFactory;
import ua.training.electriberies.model.dao.common_interfaces.GenericDAO;
import ua.training.electriberies.model.dao.mysql.MySQLDAOFactory;
import ua.training.electriberies.model.entity.users.User;

public class TestMySQLUserDAO {
	
	@Test
	public void testGetAll() throws Exception {
	    DAOFactory daoFactory = new MySQLDAOFactory();
	    List<User> users;
	    try (Connection connection = daoFactory.getConnection()) {
	    	GenericDAO<User> userDAO = daoFactory.getUserDAO(connection);
	        users = userDAO.getAll();
	    }	    
	    Assert.assertNotNull(users);
	    Assert.assertTrue(users.size() > 0);
	    
	//    System.out.println("testGetAll: " + users);
	}
	
	@Test
	public void testGetById() throws Exception {
	    DAOFactory daoFactory = new MySQLDAOFactory();
	    User user;
	    try (Connection connection = daoFactory.getConnection()) {
	    	GenericDAO<User> userDAO = daoFactory.getUserDAO(connection);
	        user = userDAO.getById(1);
	    }	    
	    Assert.assertNotNull(user);
	    
//	    System.out.println("testGetById: " + user);
	}

}
