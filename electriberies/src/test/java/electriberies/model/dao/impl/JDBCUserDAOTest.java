package electriberies.model.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ua.training.electriberies.model.dao.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.users.User;
import ua.training.electriberies.model.entity.users.UserImpl;
import ua.training.electriberies.model.entity.users.UserRole;

public class JDBCUserDAOTest {
	
	/**
	 * You should have a record in table users with userid mentioned in this constant 
	 */
	private static final int TESTED_USER_ID = 1;
	
	private static final String UPDATED_LOGIN = "admin";
	
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	/**
	 * This testing method creates and then deletes user to/from DB to avoid adding to DB invalid users
	 * @throws Exception - please help me to find the cause of this throws statement
	 */	
	@Test
	public void testCreateAndDelete() throws Exception {
	    User user = new UserImpl("testLogin", "testPassword", UserRole.valueOf("USER"));
	    try (GenericDAO<User> userDAO = daoFactory.createUserDAO()) {
	    		User createdUser = userDAO.create(user);
	    	Assert.assertNotNull(createdUser);
	    		User deletedUsed = userDAO.delete(createdUser);
	    	Assert.assertNotNull(deletedUsed);	    	
	    }	    
	}
	
	@Test
	public void testGetAll() throws Exception {
	    List<User> users;
	    try (GenericDAO<User> userDAO = daoFactory.createUserDAO()) {
	        users = userDAO.getAll();
	    }	    
	    Assert.assertNotNull(users);
	    Assert.assertTrue(users.size() > 0);
	}
	
	@Test
	public void testGetById() throws Exception {
	    try (GenericDAO<User> userDAO = daoFactory.createUserDAO()) {
	    	Assert.assertNotNull(userDAO.getById(TESTED_USER_ID));
	    }	    
	}
	
	@Test
	public void testUpdate() throws Exception {
	//	User user = new UserImpl("testLogin", "testPassword", UserRole.valueOf("USER"));
	    try (GenericDAO<User> userDAO = daoFactory.createUserDAO()) {
	    		User updatingUser = userDAO.getById(TESTED_USER_ID);
	    		updatingUser.setLogin(UPDATED_LOGIN);
	    	Assert.assertNotNull(userDAO.update(updatingUser));  	
	    }	
	}

}
