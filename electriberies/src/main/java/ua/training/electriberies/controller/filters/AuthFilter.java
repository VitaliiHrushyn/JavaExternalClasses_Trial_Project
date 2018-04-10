package ua.training.electriberies.controller.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ua.training.electriberies.model.entity.users.User;
import ua.training.electriberies.model.entity.users.UserRole;
import ua.training.electriberies.model.service.UserService;

@WebFilter(urlPatterns="/app/*")
public class AuthFilter implements Filter {

	@Override
	public void destroy() {}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;
		
		final String login;
		final String password;
		final String regLogin;
		final String regPassword;
		final String regConfirmPassword;
		final User user;
		
		final HttpSession session = request.getSession();
		
//		session.setMaxInactiveInterval(30);
		
		login = request.getParameter("login");
		password = request.getParameter("password");
		regLogin = request.getParameter("reglogin");
		regPassword = request.getParameter("regpassword");

	//	System.out.println(session.getAttribute("role"));
		
		user = (User) session.getAttribute("user");
		
//		System.out.println(role);
		
		if (user != null) {
			
		} 
		else if (regLogin != null && regPassword != null) {					
			User newUser = UserService.makeUser(regLogin, regPassword, regConfirmPassword);
			session.setAttribute("user", newUser);
		} 
		else if (login != null && password != null) { 
			User existingUser = UserService.getUserIfExists(login, password)
			session.setAttribute("user", existingUser);
		}
			chain.doFilter(request, response);;
		
		
	}

	private void moveToProfile(UserRole role, HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			
		String path = "/app/logout";
		if (role != null) {
			if (role.equals(UserRole.ADMIN)) {
				path = "/app/login";
			}
			if (role.equals(UserRole.USER)) {
				path = "/app/login";
			}
			if (role.equals(UserRole.REGISTRANT)) {
				path = "/app/registration";
			} 
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
