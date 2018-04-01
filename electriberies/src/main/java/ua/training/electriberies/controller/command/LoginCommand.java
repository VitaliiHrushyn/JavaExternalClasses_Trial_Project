package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

public class LoginCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return "/login.jsp";
	}

}
