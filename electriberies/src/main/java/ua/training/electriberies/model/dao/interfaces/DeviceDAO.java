package ua.training.electriberies.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import ua.training.electriberies.model.entity.devices.Device;

public interface DeviceDAO {
	
	Device create() throws SQLException;
	
	Device getById(int id) throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException;
	
	void update(Device device) throws SQLException;
	
	void delete(Device device) throws SQLException;
	
	List<Device> getAll() throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException;


}
