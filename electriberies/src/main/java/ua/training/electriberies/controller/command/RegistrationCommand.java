package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirmPassword");
		
		request.setAttribute("login", login);
		
		if (checkLoginPassword()) {
			return "/registrationSuccess.jsp";
		} else {
			return "/registrationFail.jsp";
		}		
	}

	private boolean checkLoginPassword() {
		// TODO Auto-generated method stub
		return true;
	}

}
