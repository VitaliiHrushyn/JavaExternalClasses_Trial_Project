package ua.training.electriberies.model.dao.interfaces;

import java.util.List;

import ua.training.electriberies.model.entity.users.User;

public interface UserDAO {
	
	User create();
	
	User read(int id);
	
	void update(User user);
	
	void delete(User user);
	
	List<User> getAll();

}
