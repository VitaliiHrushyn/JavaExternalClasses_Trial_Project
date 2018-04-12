package ua.training.electriberies.model.dao.impl;

public interface MySQLConnectionConstants {
	
	String MYSQL_CONNECTION_URL = "jdbc:mysql://localhost/electriberies"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	String MYSQL_CONNECTION_USERNAME = "root";
	String MYSQL_CONNECTION_PASSWORD = "root";
	String MYSQL_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

}
