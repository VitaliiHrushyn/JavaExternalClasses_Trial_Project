package ua.training.electriberies.model.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.training.electriberies.model.dao.common_interfaces.QueryConstants;
import ua.training.electriberies.model.dao.common_interfaces.GenericDAO;
import ua.training.electriberies.model.entity.users.User;
import ua.training.electriberies.model.entity.users.UserImp;
import ua.training.electriberies.model.entity.users.UserRole;

public class MySQLUserDAO implements GenericDAO<User> {
	
	private static final String GET_BY_ID = QueryConstants.GET_USER_BY_ID_QUERY;
	private static final String GET_ALL = QueryConstants.GET_ALL_USERS_QUERY;
	private static final String INSERT_USER = QueryConstants.INSERT_USER_QUERY;

	private static final String ID = QueryConstants.USER_ID_COLUMN;
	private static final String LOGIN = QueryConstants.USER_LOGIN_COLUMN;
	private static final String PASSWORD = QueryConstants.USER_PASSWORD_COLUMN;
	private static final String ROLE = QueryConstants.USER_ROLE_COLUMN;
	
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
	public User getById(int id) {
		User user = null;
		
		try(PreparedStatement statement = connection.prepareStatement(GET_BY_ID)) {
			statement.setInt(1, id);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				user = makeUser(rs);	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		
		return user;
	}

	private User makeUser(ResultSet rs) throws SQLException {
		int userid = rs.getInt(ID);
		String login = rs.getString(LOGIN);
		String password = rs.getString(PASSWORD);
		String role = rs.getString(ROLE);
		
		return new UserImp(userid, login, password, UserRole.valueOf(role));
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
		List<User> users = new ArrayList<>();
		
		try(PreparedStatement statement = connection.prepareStatement(GET_ALL)) {
			ResultSet rs = statement.executeQuery();
			while(rs.next()) {
				User user = makeUser(rs);			
				users.add(user);	
			}
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}		
		
		return users;
	}

}
