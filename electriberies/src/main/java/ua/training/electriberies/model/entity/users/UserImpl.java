package ua.training.electriberies.model.entity.users;

public class UserImpl implements User {
	
	private int id;
	private String login;
	private String password;
	private UserRole role;	
	
	public UserImpl() {
		super();
	}

	public UserImpl(int id, String login, String password, UserRole role) {
		super();
		this.id = id;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	public UserImpl(String login, String password, UserRole role) {
		super();
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getId() {
		return id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserRole getRole() {
		return role;
	}

	public void setRole(UserRole role) {
		this.role = role;
	}
}
