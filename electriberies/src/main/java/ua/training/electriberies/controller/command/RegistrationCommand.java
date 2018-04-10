package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.electriberies.model.entity.users.UserImp;
import ua.training.electriberies.model.entity.users.UserRole;
import ua.training.electriberies.model.service.UserService;

public class RegistrationCommand implements Command {
	
	private String regLogin;
	private String regPassword;
	private String regConfirmPassword;
	private HttpServletRequest request;
	private HttpSession session;

	@Override
	public String execute(HttpServletRequest request) {
		
		System.out.println("-------registration------");
		
		
		this.request = request;
		this.session = request.getSession();
		regLogin = request.getParameter("reglogin");
		regPassword = request.getParameter("regpassword");
		regConfirmPassword = request.getParameter("regconfirmpassword");
		
		
		String path = "/app/logout";
	
		if (validateLoginAndPassword()) {
			doRegistration(path);
		} else {
			interruptRegisteration(path);
		}	
		System.out.println("registr path= " + path);
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
	//	session.setAttribute("role", UserRole.USER);
	//	session.setAttribute("login", regLogin);
	//	path = "/view/profile.jsp";
		
	}
	
	private void interruptRegisteration(String path) {
		request.setAttribute("message", "Something went wrong via registration, try again");		
	}

}
