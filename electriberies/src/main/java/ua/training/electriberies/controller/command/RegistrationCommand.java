package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ua.training.electriberies.model.dao.implementations.UserDAOStub;
import ua.training.electriberies.model.entity.users.UserImp;
import ua.training.electriberies.model.entity.users.UserRole;

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
	
		if (checkUniqueLogin()) {
			doRegistration();
		} else {
			interruptRegisteration();
		}	
		
		return "/registration.jsp";
	}
	
	

	private boolean checkUniqueLogin() {
		for (String login : UserDAOStub.getAllLogins()) {
			if (regLogin.equals(login)) {
				return false;
			}
		}
		return true;
	}

	private void doRegistration() {
		if (!regPassword.equals(regConfirmPassword)) {
			interruptRegisteration();
		} else {
			UserDAOStub.addUser(new UserImp(regLogin, regPassword, UserRole.USER));
			request.setAttribute("message", "User " + regLogin + " has been successfuly registred");
			session.setAttribute("role", UserRole.USER);
		}
		
		
	}
	
	private void interruptRegisteration() {
		request.setAttribute("message", "Something went wrong via registration, try again");		
	}

}
