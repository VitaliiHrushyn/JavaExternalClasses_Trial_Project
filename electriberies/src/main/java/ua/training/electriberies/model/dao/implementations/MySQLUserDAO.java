package ua.training.electriberies.model.dao.implementations;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.training.electriberies.model.dao.interfaces.UserDAO;
import ua.training.electriberies.model.entity.devices.Device;
import ua.training.electriberies.model.entity.users.User;
import ua.training.electriberies.model.entity.users.UserImp;
import ua.training.electriberies.model.entity.users.UserRole;

public class MySQLUserDAO implements UserDAO {
	
	private Connection connection;

	public MySQLUserDAO(Connection connection) {
		this.connection = connection;
	}

	@Override
	public User create() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getById(int id) throws SQLException {
		String sql = "SELECT * FROM users WHERE userid = ?;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
		User user = null;
		rs.next();
			int userid = rs.getInt("userid");
			String login = rs.getString("login");
			String password = rs.getString("password");
			String role = rs.getString("role");
			
			user = new UserImp(userid, login, password, UserRole.valueOf(role));	
		
			return user;
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
	public List<User> getAll() throws SQLException {
		String sql = "SELECT * FROM users;";
		PreparedStatement statement = connection.prepareStatement(sql);
		List<User> users = new ArrayList<>();
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			int userid = rs.getInt("userid");
			String login = rs.getString("login");
			String password = rs.getString("password");
			String role = rs.getString("role");
			
			users.add(new UserImp(userid, login, password, UserRole.valueOf(role)));	
		}
			return users;
	}

}
