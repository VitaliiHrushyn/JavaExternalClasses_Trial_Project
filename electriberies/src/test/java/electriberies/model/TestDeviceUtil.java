package electriberies.model;

import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import ua.training.electriberies.model.DeviceUtil;
import ua.training.electriberies.model.entity.devices.Device;


public class TestDeviceUtil {	
	
	@Test
	public void testShowAllDevices() {
	
	List<Device> devices = null;
	try {
		devices = DeviceUtil.showAllDevises();
	} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    	    
    Assert.assertNotNull(devices);
    Assert.assertTrue(devices.size() > 0);
    	}

}
