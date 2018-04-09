package ua.training.electriberies.model.dao.mysql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import ua.training.electriberies.model.dao.common_interfaces.QueryConstants;
import ua.training.electriberies.model.dao.common_interfaces.UserDAO;
import ua.training.electriberies.model.entity.users.User;
import ua.training.electriberies.model.entity.users.UserImp;
import ua.training.electriberies.model.entity.users.UserRole;

public class MySQLUserDAO implements UserDAO {
	
	private static final String GET_BY_ID = QueryConstants.GET_USER_BY_ID;
	private static final String GET_ALL = QueryConstants.GET_ALL_USERS_QUERY;

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
	public User getById(int id) throws SQLException {
		PreparedStatement statement = connection.prepareStatement(GET_BY_ID);
		statement.setInt(1, id);
		ResultSet rs = statement.executeQuery();
	//	User user = null;
		rs.next();
		User user = makeUser(rs);		
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
	public List<User> getAll() throws SQLException {
		PreparedStatement statement = connection.prepareStatement(GET_ALL);
		List<User> users = new ArrayList<>();
		ResultSet rs = statement.executeQuery();
		while(rs.next()) {
			User user = makeUser(rs);			
			users.add(user);	
		}
			return users;
	}

}
