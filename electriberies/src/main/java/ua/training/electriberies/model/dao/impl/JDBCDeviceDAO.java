package ua.training.electriberies.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import ua.training.electriberies.model.dao.interfaces.GenericDAO;
import static ua.training.electriberies.model.dao.interfaces.QueryConstants.*;
import ua.training.electriberies.model.entity.devices.*;

public class JDBCDeviceDAO implements GenericDAO<Device> {
 
	private static final String QUERY_BUNDLE_NAME = "db_queries";
	private static final String COLUMN_BUNDLE_NAME = "db_columns";
	
	private ResourceBundle queryBundle;
	private ResourceBundle columnBundle;	
	
	private Connection connection;
	

	public JDBCDeviceDAO(Connection connection) {
		this.connection = connection;
		this.queryBundle = ResourceBundle.getBundle(QUERY_BUNDLE_NAME);
		this.columnBundle = ResourceBundle.getBundle(COLUMN_BUNDLE_NAME);
		
	}
	
	@Override
	public Device create(Device entity) {
		return null;
	}

	@Override
	public Device getById(int id) {
		Device device = null;
		
		try(PreparedStatement statement = connection.prepareStatement(
														queryBundle.getString(GET_DEVICE_BY_ID_QUERY))) {
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
		Device device = (Device) Class.forName(
				rs.getString(columnBundle.getString(DEVICE_CLASS_NAME_COLUMN))
												).newInstance();
		device.setId(rs.getInt(columnBundle.getString(DEVICE_ID_COLUMN)));
		device.setName(rs.getString(columnBundle.getString(DEVICE_NAME_COLUMN)));
		device.setPower(rs.getInt(columnBundle.getString(DEVICE_POWER_COLUMN)));
		device.setVoltage(rs.getInt(columnBundle.getString(DEVICE_VOLTAGE_COLUMN)));
		device.setSwitched(rs.getBoolean(columnBundle.getString(DEVICE_SWITCHED_COLUMN)));
		device.setLocation(rs.getString(columnBundle.getString(DEVICE_LOCATION_COLUMN)));
		return device;
	}
	
	@Override
	public List<Device> getAll() {
		List<Device> devices = new ArrayList<>();
		try(PreparedStatement statement = 
				connection.prepareStatement(queryBundle.getString(GET_ALL_DEVICES_QUERY))) {
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
