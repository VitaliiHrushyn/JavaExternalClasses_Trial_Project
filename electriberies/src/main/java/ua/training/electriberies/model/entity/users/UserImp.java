package ua.training.electriberies.model.entity.users;

public class UserImp implements User {
	
	private int id;
	private String login;
	private String password;
	private UserRole role;	
	
	private UserImp() {
		super();
	}

	public UserImp(int id, String login, String password, UserRole role) {
		super();
		this.id = id;
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
