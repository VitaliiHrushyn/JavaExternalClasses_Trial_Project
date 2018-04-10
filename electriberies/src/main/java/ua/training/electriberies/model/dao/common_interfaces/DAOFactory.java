package ua.training.electriberies.model.dao.common_interfaces;

import java.sql.Connection;
//import java.sql.SQLException;
import java.sql.SQLException;

import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.entity.users.User;

public interface DAOFactory {
	
	Connection getConnection() throws SQLException;
	
	GenericDAO<Device> getDeviceDAO(Connection connection);
	
	GenericDAO<User> getUserDAO(Connection connection);

}
