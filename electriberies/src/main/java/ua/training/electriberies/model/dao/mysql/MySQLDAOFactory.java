package ua.training.electriberies.model.dao.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.training.electriberies.model.dao.common_interfaces.*;

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
	public DeviceDAO getDeviceDAO(Connection connection) {
		return new MySQLDeviceDAO(connection);
	}

	@Override
	public UserDAO getUserDAO(Connection connection) {
		return new MySQLUserDAO(connection);
	}	

}
