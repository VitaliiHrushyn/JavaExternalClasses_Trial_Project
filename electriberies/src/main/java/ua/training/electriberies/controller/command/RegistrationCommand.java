package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

public class RegistrationCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		String reglogin = request.getParameter("reglogin");
		String regpassword = request.getParameter("regpassword");
		String regconfirmPassword = request.getParameter("regconfirmPassword");
		
		request.setAttribute("reglogin", reglogin);
		
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
