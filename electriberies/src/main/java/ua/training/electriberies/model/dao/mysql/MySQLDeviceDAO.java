package ua.training.electriberies.model.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ua.training.electriberies.model.dao.common_interfaces.GenericDAO;
import ua.training.electriberies.model.dao.common_interfaces.QueryConstants;
import ua.training.electriberies.model.entity.devices.*;

public class MySQLDeviceDAO implements GenericDAO<Device> {
	
	private static final String GET_BY_ID = QueryConstants.GET_DEVICE_BY_ID_QUERY;
	private static final String GET_ALL = QueryConstants.GET_ALL_DEVICES_QUERY;

	private static final String CLASS_NAME = QueryConstants.DEVICE_CLASS_NAME_COLUMN;
	private static final String ID = QueryConstants.DEVICE_ID_COLUMN;
	private static final String NAME = QueryConstants.DEVICE_NAME_COLUMN;
	private static final String POWER = QueryConstants.DEVICE_POWER_COLUMN;
	private static final String VOLTAGE = QueryConstants.DEVICE_VOLTAGE_COLUMN;
	private static final String SWITCHED = QueryConstants.DEVICE_SWITCHED_COLUMN;
	private static final String LOCATION = QueryConstants.DEVICE_LOCATION_COLUMN;

	
	private Connection connection;

	public MySQLDeviceDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public boolean insert(Device device) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Device getById(int id) {
		Device device = null;
		
		try(PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				device = makeDevice(rs);
			}
		} catch (SQLException|InstantiationException | 
					IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}			
			return device;			
	}

	private Device makeDevice(ResultSet rs)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException {
		Device device = (Device) Class.forName(rs.getString(CLASS_NAME)).newInstance();
		device.setId(rs.getInt(ID));
		device.setName(rs.getString(NAME));
		device.setPower(rs.getInt(POWER));
		device.setVoltage(rs.getInt(VOLTAGE));
		device.setSwitched(rs.getBoolean(SWITCHED));
		device.setLocation(rs.getString(LOCATION));
		return device;
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
	public List<Device> getAll() {
		List<Device> devices = new LinkedList<>();
		try(PreparedStatement statement = connection.prepareStatement(GET_ALL)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				devices.add(makeDevice(rs));
			}
		} catch (SQLException |InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return devices;
	}
	
}
