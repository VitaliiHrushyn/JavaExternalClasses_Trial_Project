package ua.training.electriberies.model.dao.interfaces;

import java.sql.SQLException;
import java.util.List;

import ua.training.electriberies.model.entity.users.User;

public interface UserDAO {
	
	User create();
	
	User getById(int id) throws SQLException;
	
	void update(User user);
	
	void delete(User user);
	
	List<User> getAll() throws SQLException;

}
