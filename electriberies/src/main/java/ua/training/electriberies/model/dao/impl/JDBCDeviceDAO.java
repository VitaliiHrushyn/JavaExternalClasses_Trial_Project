package ua.training.electriberies.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import ua.training.electriberies.model.dao.interfaces.QueryConstants;
import ua.training.electriberies.model.entity.devices.*;

public class JDBCDeviceDAO implements GenericDAO<Device> {
	
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

	public JDBCDeviceDAO(Connection connection) {
		this.connection = connection;
	}
	
	@Override
	public Device create(Device entity) {
		return null;
	}

	@Override
	public Device getById(int id) {
		Device device = null;
		
		try(PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				device = extractDevice(rs);
			}
		} catch (SQLException|InstantiationException | 
					IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}			
			return device;			
	}

	private Device extractDevice(ResultSet rs)
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
	public List<Device> getAll() {
		List<Device> devices = new ArrayList<>();
		try(PreparedStatement statement = connection.prepareStatement(GET_ALL)) {
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				devices.add(extractDevice(rs));
			}
		} catch (SQLException |InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
		return devices;
	}

	@Override
	public Device update(Device device) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Device delete(Device device) {
		// TODO Auto-generated method stub
		return null;
	}	
	
	@Override
	public void close() {
		try {
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
	}
	
}
