package ua.training.electriberies.model.dao.implementations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import ua.training.electriberies.model.dao.interfaces.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.DeviceDAO;
import ua.training.electriberies.model.dao.interfaces.UserDAO;

public class MySQLDAOFactory implements DAOFactory{
	
	private static final String URL = "jdbc:mysql://localhost/electriberies"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC"
			;
	
	private static final String USERNAME = "root";
	private static final String PASSWORD = "root";
	
	public MySQLDAOFactory() {
	}

	public Connection getConnection() throws SQLException {
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    // TODO Auto-generated catch block
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
