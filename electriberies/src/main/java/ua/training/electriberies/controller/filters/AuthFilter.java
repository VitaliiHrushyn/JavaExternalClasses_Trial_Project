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
		final String regLogin;
		final String regPassword;
		final UserRole role;
		
		final HttpSession session = request.getSession();
		
//		session.setMaxInactiveInterval(30);
		
		
		role = (UserRole) session.getAttribute("role");
		
		System.out.println("inner role " + role);
		
		if (role != null) {
			chain.doFilter(request, response);
		} else {
					
			
			if (UserService.isUserExists(request.getParameter("login"), request.getParameter("password"))) {
				session.setAttribute("role", UserService.getUserByLogin(request.getParameter("login")).getRole());
				session.setAttribute("login", request.getParameter("login"));
				session.setAttribute("message", "you've succesfuly entered to profile");
				System.out.println("login role " + role);
			}
			if (request.getParameter("regLogin") != null && request.getParameter("regPassword") != null) {
				session.setAttribute("role", UserRole.REGISTRANT);
				System.out.println("registr role " + role);
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
				path = "/app/registration";
			} 
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
