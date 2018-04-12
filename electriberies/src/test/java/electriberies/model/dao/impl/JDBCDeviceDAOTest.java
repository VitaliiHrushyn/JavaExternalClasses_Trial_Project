package electriberies.model.dao.impl;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ua.training.electriberies.model.dao.DAOFactory;
import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.entity.devices.Device;

public class JDBCDeviceDAOTest {
	
	private DAOFactory daoFactory = DAOFactory.getInstance();
	
	@Test
	public void testGetAll() throws Exception {
	    List<Device> devices;
	    try (GenericDAO<Device> deviceDAO = daoFactory.createDeviceDAO()) {
	        devices = deviceDAO.getAll();
	    }	    
	    Assert.assertNotNull(devices);
	    Assert.assertTrue(devices.size() > 0);
	}
	
	@Test
	public void testGetById() throws Exception {
	    Device device;
	    try (GenericDAO<Device> deviceDAO = daoFactory.createDeviceDAO()) {
	        device = deviceDAO.getById(20);
	    }	    
	    Assert.assertNotNull(device);
	}

}
