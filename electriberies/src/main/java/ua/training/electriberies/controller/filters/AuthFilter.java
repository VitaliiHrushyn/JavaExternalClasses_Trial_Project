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
//		final String regLogin;
//		final String regPassword;
//		final String regConfirmPassword;
		final UserRole role;
		
		final HttpSession session = request.getSession();
		
//		session.setMaxInactiveInterval(30);
		
		login = request.getParameter("login");
		password = request.getParameter("password");
//		regLogin = request.getParameter("reglogin");
//		regPassword = request.getParameter("regpassword");
//		regConfirmPassword = request.getParameter("regconfirmpassword");

		System.out.println(session.getAttribute("role"));
		
		role = (UserRole) session.getAttribute("role");
		
//		System.out.println(role);
		
		if (role != null) {
			chain.doFilter(request, response);
		} else {
			
//			System.out.println("else");
					
//			if (regLogin != null && regPassword != null && regPassword.equals(regConfirmPassword)) {
//				session.setAttribute("role", UserRole.REGISTRANT);
//				System.out.println("registrant filter");
//				}
			if (login != null && password != null && UserService.isUserExists(login, password)) {
				session.setAttribute("role", UserService.getUserByLogin(login).getRole());
				session.setAttribute("login", login);
				session.setAttribute("message", "you've succesfuly entered to profile");
			}
			moveToProfile((UserRole) session.getAttribute("role"), request, response);
		}
		
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
				path = "/app/login";
			} 
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
