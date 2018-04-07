package ua.training.electriberies.controller.command;

import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;

public interface Command {
	
	String execute(HttpServletRequest request) throws ClassNotFoundException, InstantiationException, IllegalAccessException, SQLException;

}
