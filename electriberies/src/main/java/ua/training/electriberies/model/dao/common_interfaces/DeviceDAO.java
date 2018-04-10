package ua.training.electriberies.model.dao.common_interfaces;

import java.sql.SQLException;
import java.util.List;

import ua.training.electriberies.model.entity.devices.Device;

@Deprecated
public interface DeviceDAO {
	
	Device create() throws SQLException;
	
	Device getById(int id);
	
	void update(Device device) throws SQLException;
	
	void delete(Device device) throws SQLException;
	
	List<Device> getAll();


}
