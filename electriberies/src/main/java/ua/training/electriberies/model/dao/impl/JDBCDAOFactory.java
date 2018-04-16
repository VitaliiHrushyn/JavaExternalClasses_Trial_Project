package ua.training.electriberies.model.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

import static ua.training.electriberies.model.dao.ConnectionConstants.*;

import ua.training.electriberies.model.dao.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.entity.users.User;

public class JDBCDAOFactory extends DAOFactory {
	
	private static final String DATA_BASE_BUNDLE_NAME = "db_connection";
	private final ResourceBundle dataBaseBundle;
	
	public JDBCDAOFactory() {
		this.dataBaseBundle = ResourceBundle.getBundle(DATA_BASE_BUNDLE_NAME);
	}

	private Connection getConnection() {
		try {
		    Class.forName(dataBaseBundle.getString(DATA_BASE_DRIVER_NAME));
		    return DriverManager.getConnection(
		    							dataBaseBundle.getString(CONNECTION_URL), 
		    							dataBaseBundle.getString(CONNECTION_USERNAME), 
		    							dataBaseBundle.getString(CONNECTION_PASSWORD)
		    							);
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
