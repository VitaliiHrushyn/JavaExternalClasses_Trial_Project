package ua.training.electriberies.model.dao.interfaces;

public interface QueryConstants {
	
	String GET_DEVICE_BY_ID_QUERY = "SELECT * FROM devices WHERE iddevices = ?;";
	String GET_ALL_DEVICES_QUERY = "SELECT * FROM devices;";
	
	String DEVICE_CLASS_NAME_COLUMN = "classname";
	String DEVICE_ID_COLUMN = "iddevices";
	String DEVICE_NAME_COLUMN = "name";
	String DEVICE_POWER_COLUMN = "power";
	String DEVICE_VOLTAGE_COLUMN = "voltage";
	String DEVICE_SWITCHED_COLUMN = "switched";
	String DEVICE_LOCATION_COLUMN = "location";
	
	
	String GET_USER_BY_ID_QUERY = "SELECT * FROM users WHERE userid = ?;";
	String GET_USER_BY_LOGIN_QUERY = "SELECT * FROM users WHERE login = ?;";
	String GET_ALL_USERS_QUERY = "SELECT * FROM users;";
	String INSERT_USER_QUERY ="INSERT INTO users (login, password, role) values (?, ?, ?)";
	String DELETE_USER_QUERY = "DELETE FROM users WHERE userid = ?";
	String UPDATE_USER_QUERY = "UPDATE users SET login = ?, password = ?, role = ?  WHERE userid = ?;";
	
	String USER_ID_COLUMN = "userid";
	String USER_LOGIN_COLUMN = "login";
	String USER_PASSWORD_COLUMN = "password";
	String USER_ROLE_COLUMN = "role";
	
	
	

}
