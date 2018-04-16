package ua.training.electriberies.model.dao;

import java.util.ResourceBundle;

import ua.training.electriberies.model.dao.impl.JDBCDAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.entity.users.User;

public abstract class DAOFactory {
	
	private static DAOFactory daoFactory;
	
	public static DAOFactory getInstance() {
		if (daoFactory == null) {
			synchronized (DAOFactory.class) {
				if (daoFactory == null) {
					DAOFactory temp = new JDBCDAOFactory();
					daoFactory = temp;
				}				
			}
		}
		return daoFactory;
	}
	
	public abstract GenericDAO<Device> createDeviceDAO();
	
	public abstract GenericDAO<User> createUserDAO();
	
}
