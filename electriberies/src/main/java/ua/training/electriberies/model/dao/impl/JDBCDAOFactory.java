package ua.training.electriberies.model.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.training.electriberies.model.dao.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.entity.users.User;

public class JDBCDAOFactory extends DAOFactory {
	
	private static final String DRIVER = MySQLConnectionConstants.MYSQL_DRIVER_NAME;
	private static final String URL = MySQLConnectionConstants.MYSQL_CONNECTION_URL;
	private static final String USERNAME = MySQLConnectionConstants.MYSQL_CONNECTION_USERNAME;
	private static final String PASSWORD = MySQLConnectionConstants.MYSQL_CONNECTION_PASSWORD;
	
	public JDBCDAOFactory() {}

	private Connection getConnection() {
		try {
		    Class.forName(DRIVER);
		    return DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} 
		catch (ClassNotFoundException | SQLException e) {
		    throw new RuntimeException(e);
		}
	}	
	
	@Override
	public GenericDAO<Device> createDeviceDAO() {
		return new JDBCDeviceDAO(getConnection());
	}

	@Override
	public GenericDAO<User> createUserDAO() {
		return new JDBCUserDAO(getConnection());
	}		

}
