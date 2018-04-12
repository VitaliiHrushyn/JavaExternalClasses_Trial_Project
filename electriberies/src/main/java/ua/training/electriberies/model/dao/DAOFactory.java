package ua.training.electriberies.model.dao;

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
					daoFactory = new JDBCDAOFactory();
				}				
			}
		}
		return daoFactory;
	}
	
	public abstract GenericDAO<Device> createDeviceDAO();
	
	public abstract GenericDAO<User> createUserDAO();
	
}
