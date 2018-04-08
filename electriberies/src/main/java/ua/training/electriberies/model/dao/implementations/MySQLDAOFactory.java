package ua.training.electriberies.model.dao.implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static ua.training.electriberies.model.dao.MySQLConnectionConstants.*;
import ua.training.electriberies.model.dao.interfaces.*;

public class MySQLDAOFactory implements DAOFactory {	
	
	public MySQLDAOFactory() {}

	public Connection getConnection() throws SQLException {
		try {
		    Class.forName(JDBC_DRIVER_NAME);
		} 
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} 
		return DriverManager.getConnection(CONNECTION_URL, CONNECTION_USERNAME, CONNECTION_PASSWORD);
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
