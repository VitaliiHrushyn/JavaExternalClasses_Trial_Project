package ua.training.electriberies.model.dao.implementations;

import java.sql.Connection;
import java.util.List;

import ua.training.electriberies.model.dao.interfaces.UserDAO;
import ua.training.electriberies.model.entity.users.User;

public class MySQLUserDAO implements UserDAO {

	public MySQLUserDAO(Connection connection) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public User create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
