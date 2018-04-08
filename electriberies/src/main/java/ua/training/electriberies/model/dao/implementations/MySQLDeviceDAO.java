package ua.training.electriberies.model.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ua.training.electriberies.model.dao.interfaces.DeviceDAO;
import ua.training.electriberies.model.entity.devices.*;

import static ua.training.electriberies.model.dao.QueryConstants.*;

public class MySQLDeviceDAO implements DeviceDAO {
	
	private Connection connection;

	public MySQLDeviceDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public Device create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device getById(int id) throws SQLException, InstantiationException, 
								IllegalAccessException, ClassNotFoundException {
		PreparedStatement statement = connection.prepareStatement(GET_DEVICE_BY_ID_QUERY);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			Device device = (Device) Class.forName(rs.getString(DEVICE_CLASS_NAME_COLUMN)).newInstance();
			device.setId(rs.getInt(DEVICE_ID_COLUMN));
			device.setName(rs.getString(DEVICE_NAME_COLUMN));
			device.setPower(rs.getInt(DEVICE_POWER_COLUMN));
			device.setVoltage(rs.getInt(DEVICE_VOLTAGE_COLUMN));
			device.setSwitched(rs.getBoolean(DEVICE_SWITCHED_COLUMN));
			device.setLocation(rs.getString(DEVICE_LOCATION_COLUMN));			
		
			return device;
			
		} else {
			return null;
		}
		
	}

	@Override
	public void update(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Device device) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Device> getAll() throws SQLException, ClassNotFoundException, 
								InstantiationException, IllegalAccessException {
		List<Device> devices = new LinkedList<>();
		PreparedStatement statement = connection.prepareStatement(GET_ALL_DEVICES_QUERY);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			Device device = (Device) Class.forName(rs.getString(DEVICE_CLASS_NAME_COLUMN)).newInstance();
			device.setId(rs.getInt(DEVICE_ID_COLUMN));
			device.setName(rs.getString(DEVICE_NAME_COLUMN));
			device.setPower(rs.getInt(DEVICE_POWER_COLUMN));
			device.setVoltage(rs.getInt(DEVICE_VOLTAGE_COLUMN));
			device.setSwitched(rs.getBoolean(DEVICE_SWITCHED_COLUMN));
			device.setLocation(rs.getString(DEVICE_LOCATION_COLUMN));
			
			devices.add(device);
		}
		return devices;
	}
	
}
