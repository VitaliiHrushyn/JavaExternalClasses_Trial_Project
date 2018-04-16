package ua.training.electriberies.model.dao.interfaces;

public interface QueryConstants {
	
	String GET_DEVICE_BY_ID_QUERY = "get.device.by.id";
	String GET_ALL_DEVICES_QUERY = "get.all.devices";
	
	String DEVICE_CLASS_NAME_COLUMN = "device.class.name";
	String DEVICE_ID_COLUMN = "device.id";
	String DEVICE_NAME_COLUMN = "device.name";
	String DEVICE_POWER_COLUMN = "device.power";
	String DEVICE_VOLTAGE_COLUMN = "device.voltage";
	String DEVICE_SWITCHED_COLUMN = "device.switched";
	String DEVICE_LOCATION_COLUMN = "device.location";
	
	String GET_USER_BY_ID_QUERY = "get.user.by.id";
	String GET_USER_BY_LOGIN_QUERY = "get.user.by.login";
	String GET_ALL_USERS_QUERY = "get.all.users";
	String INSERT_USER_QUERY ="insert.user";
	String DELETE_USER_QUERY = "delete.user";
	String UPDATE_USER_QUERY = "update.user";
	
	String USER_ID_COLUMN = "user.id";
	String USER_LOGIN_COLUMN = "user.login";
	String USER_PASSWORD_COLUMN = "user.password";
	String USER_ROLE_COLUMN = "user.role";
	
}
