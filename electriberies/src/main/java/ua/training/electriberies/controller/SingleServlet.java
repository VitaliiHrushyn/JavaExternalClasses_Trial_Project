package ua.training.electriberies.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.training.electriberies.controller.command.*;

/**
 * Servlet implementation class SingleServlet
 */
@WebServlet("/app/*")
public class SingleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	Map<String, Command> commands;

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		commands = new HashMap<>();
		commands.put("index", new IndexCommand());
		commands.put("login", new LoginCommand());
		commands.put("logout", new LogoutCommand());
		commands.put("finddevice", new FindDevicesCommand());
		commands.put("showdevices", new ShowDeviceCommand());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] URIArr = request.getRequestURI().split("/");
		String commandName = URIArr[URIArr.length - 1];
		String path = commands.getOrDefault(commandName, (r)->commands.get("index").execute(request)).execute(request);
		
		request.getRequestDispatcher(path).forward(request, response);
	}

}
