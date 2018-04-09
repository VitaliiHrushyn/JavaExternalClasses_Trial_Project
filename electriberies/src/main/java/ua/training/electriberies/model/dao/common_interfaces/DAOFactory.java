package ua.training.electriberies.model.dao.common_interfaces;

import java.sql.Connection;
//import java.sql.SQLException;
import java.sql.SQLException;

public interface DAOFactory {
	
	Connection getConnection() throws SQLException;
	
	DeviceDAO getDeviceDAO(Connection connection);
	
	UserDAO getUserDAO(Connection connection);

}
