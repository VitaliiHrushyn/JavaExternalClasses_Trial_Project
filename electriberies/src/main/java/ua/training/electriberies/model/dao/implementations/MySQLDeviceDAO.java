package ua.training.electriberies.model.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import ua.training.electriberies.model.dao.interfaces.DeviceDAO;
import ua.training.electriberies.model.entity.devices.*;


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
		String sql = "SELECT * FROM devices WHERE iddevices = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		if (rs.next()) {
			Device device = (Device) Class.forName(rs.getString("classname")).newInstance();
			device.setId(rs.getInt("iddevices"));
			device.setName(rs.getString("name"));
			device.setPower(rs.getInt("power"));
			device.setVoltage(rs.getInt("voltage"));
			device.setSwitched(rs.getBoolean("switched"));
			device.setLocation(rs.getString("location"));			
		
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
		String sql = "SELECT * FROM devices";
		PreparedStatement statement = connection.prepareStatement(sql);
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			Device device = (Device) Class.forName(rs.getString("classname")).newInstance();
			device.setId(rs.getInt("iddevices"));
			device.setName(rs.getString("name"));
			device.setPower(rs.getInt("power"));
			device.setVoltage(rs.getInt("voltage"));
			device.setSwitched(rs.getBoolean("switched"));
			device.setLocation(rs.getString("location"));
			
			devices.add(device);
		}
		return devices;
	}
	
}
