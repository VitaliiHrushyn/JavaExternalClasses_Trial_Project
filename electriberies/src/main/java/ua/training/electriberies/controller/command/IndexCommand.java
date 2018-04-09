package ua.training.electriberies.controller.command;

import javax.servlet.http.HttpServletRequest;

@Deprecated
public class IndexCommand implements Command {

	@Override
	public String execute(HttpServletRequest request) {
		return "redirect:/index.jsp";
	}

}
