package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		request.getSession().removeAttribute("role");		
		return "/index.jsp";
	}
	

}
