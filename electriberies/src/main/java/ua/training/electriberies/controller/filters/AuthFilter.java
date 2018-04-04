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

import ua.training.electriberies.model.User;
import ua.training.electriberies.model.UsersDataSourseStub;

@WebFilter(urlPatterns="/*")
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
		final User.Role role;
		
		final HttpSession session = request.getSession();
		session.setMaxInactiveInterval(30);
		
		login = request.getParameter("login");
		password = request.getParameter("password");

		role = (User.Role) session.getAttribute("role");
					
		if (role != null) {
			chain.doFilter(request, response);
		} else {			
			if (UsersDataSourseStub.isUserExists(login, password)) {
				session.setAttribute("role", UsersDataSourseStub.getUserByLogin(login).getRole());
			}
			moveAhead((User.Role) session.getAttribute("role"), request, response);
		}		
	}

	private void moveAhead(User.Role role, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = "/index.jsp";
		if (role != null) {
			if (role.equals(User.Role.ADMIN)) {
				path = "/login.jsp";
			}
			if (role.equals(User.Role.USER)) {
				path = "/login.jsp";
			}
		}
		request.getRequestDispatcher(path).forward(request, response);	
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {}

}
