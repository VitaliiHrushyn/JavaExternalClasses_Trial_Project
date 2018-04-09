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
		
		session.setAttribute("message", "registration isn't working yet");
		
		String path = "redirect:/registration.jsp";
	
		if (checkUniqueLogin()) {
			doRegistration();
		} else {
			interruptRegisteration();
		}	
		
		return path;
	}
	
	

	private boolean checkUniqueLogin() {
		if (UserService.getUserByLogin(regLogin) == null) {
			return true;
		} else {
			return false;
		}
	}

	private void doRegistration() {
		
		
	}
	
	private void interruptRegisteration() {
		request.setAttribute("message", "Something went wrong via registration, try again");		
	}

}
