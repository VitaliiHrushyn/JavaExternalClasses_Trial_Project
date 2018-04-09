package ua.training.electriberies.model.dao.mysql;

public interface MySQLConnectionConstants {
	
	String CONNECTION_URL = "jdbc:mysql://localhost/electriberies"
			+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";	
	String CONNECTION_USERNAME = "root";
	String CONNECTION_PASSWORD = "root";
	String JDBC_DRIVER_NAME = "com.mysql.cj.jdbc.Driver";

}
