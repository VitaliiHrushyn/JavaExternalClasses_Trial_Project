package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class LogoutCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		System.out.println("logout");
		return "/index.jsp";
	}
	

}
