package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

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
		
		
		String path = "/app/logout";
	
		if (validateLoginAndPassword()) {
			doRegistration(path);
		} else {
			interruptRegisteration(path);
		}	
		
		return path;
	}	
	

	private boolean validateLoginAndPassword() {
		if (UserService.getUserByLogin(regLogin) == null && regPassword.equals(regConfirmPassword)) {
			return true;
		} else {
			return false;
		}
	}

	private void doRegistration(String path) {
		UserService.createUser(regLogin, regPassword, UserRole.USER);
		
	}
	
	private void interruptRegisteration(String path) {
		// TODO	
	}

}
