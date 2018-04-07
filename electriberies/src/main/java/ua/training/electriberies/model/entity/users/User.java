package ua.training.electriberies.model.entity.users;

public interface User {
	
	void setLogin(String login);
	
	String getLogin();
	
	void setPassword(String password);
	
	String getPassword();
	
	void setRole(UserRole role);
	
	UserRole getRole();	

}
