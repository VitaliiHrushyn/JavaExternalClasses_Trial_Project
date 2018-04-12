package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

import ua.training.electriberies.model.NotUniqueLoginException;
import ua.training.electriberies.model.entity.users.UserRole;
import ua.training.electriberies.model.service.UserService;

public class RegistrationCommand implements Command {
	
	private String regLogin;
	private String regPassword;
	private String regConfirmPassword;

	@Override
	public String execute(HttpServletRequest request) {
		
		regLogin = request.getParameter("reglogin");
		regPassword = request.getParameter("regpassword");
		regConfirmPassword = request.getParameter("regconfirmpassword");
			
		try {
			if (validateLoginAndPassword()) {
				doRegistration();
			}
		} catch (NotUniqueLoginException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
		return "/app/logout";
	}		

	private boolean validateLoginAndPassword() throws NotUniqueLoginException {
		if (UserService.getUserByLogin(regLogin) != null) {
			throw new NotUniqueLoginException(regLogin + " : such user already exists.");
		}
		if (regPassword.equals(regConfirmPassword)) {
			return true;
		}
			return false;
	}

	private void doRegistration() {
		UserService.createUser(regLogin, regPassword, UserRole.USER);
	}	

}
