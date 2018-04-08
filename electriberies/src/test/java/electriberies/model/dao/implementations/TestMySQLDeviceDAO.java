package electriberies.model.dao.implementations;

import java.sql.Connection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ua.training.electriberies.model.dao.implementations.MySQLDAOFactory;
import ua.training.electriberies.model.dao.interfaces.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.DeviceDAO;
import ua.training.electriberies.model.entity.devices.Device;

public class TestMySQLDeviceDAO {
	
	@Test
	public void testGetAll() throws Exception {
	    DAOFactory daoFactory = new MySQLDAOFactory();
	    List<Device> devices;
	    try (Connection connection = daoFactory.getConnection()) {
	        DeviceDAO deviceDAO = daoFactory.getDeviceDAO(connection);
	        devices = deviceDAO.getAll();
	    }	    
	    Assert.assertNotNull(devices);
	    Assert.assertTrue(devices.size() > 0);
	    
	//    System.out.println("testGetAll: " + devices);
	}
	
	@Test
	public void testGetById() throws Exception {
	    DAOFactory daoFactory = new MySQLDAOFactory();
	    Device device;
	    try (Connection connection = daoFactory.getConnection()) {
	        DeviceDAO deviceDAO = daoFactory.getDeviceDAO(connection);
	        device = deviceDAO.getById(20);
	    }	    
	    Assert.assertNotNull(device);
	    
//	    System.out.println("testGetById: " + device);
	}

}
