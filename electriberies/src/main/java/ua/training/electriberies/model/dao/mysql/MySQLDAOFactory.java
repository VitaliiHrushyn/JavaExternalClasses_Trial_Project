package ua.training.electriberies.model.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.training.electriberies.model.dao.common_interfaces.*;
import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.entity.users.User;

public class MySQLDAOFactory implements DAOFactory {
	
	private static final String DRIVER = MySQLConnectionConstants.JDBC_DRIVER_NAME;
	private static final String URL = MySQLConnectionConstants.CONNECTION_URL;
	private static final String USERNAME = MySQLConnectionConstants.CONNECTION_USERNAME;
	private static final String PASSWORD = MySQLConnectionConstants.CONNECTION_PASSWORD;
	
	public MySQLDAOFactory() {}

	public Connection getConnection() throws SQLException {
		try {
		    Class.forName(DRIVER);
		} 
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} 
		return DriverManager.getConnection(URL, USERNAME, PASSWORD);
	}
	
	@Override
	public GenericDAO<Device> getDeviceDAO(Connection connection) {
		return new MySQLDeviceDAO(connection);
	}

	@Override
	public GenericDAO<User> getUserDAO(Connection connection) {
		return new MySQLUserDAO(connection);
	}	

}
