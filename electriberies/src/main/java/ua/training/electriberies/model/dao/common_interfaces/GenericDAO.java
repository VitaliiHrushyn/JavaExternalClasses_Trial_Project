package ua.training.electriberies.model.dao.common_interfaces;

import java.sql.SQLException;
import java.util.List;

public interface GenericDAO<T> {
	
//	T create() throws SQLException;
	
	T getById(int id);
	
	void update(T user) throws SQLException;
	
	void delete(T user) throws SQLException;
	
	List<T> getAll();

	boolean insert(T entety);

}
