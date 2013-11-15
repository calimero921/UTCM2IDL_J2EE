package controlers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SetCookie
 */
@WebServlet("/SetCookie")
public class SetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String login = "";
	String password = "";
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.login = request.getParameter("login");
		this.password = request.getParameter("password");
	
		Cookie l = new Cookie("login_cookie", this.login);
		Cookie p = new Cookie("password_cookie", this.password);
		p.setMaxAge(20);
			
		response.addCookie(l);
		response.addCookie(p);

		RequestDispatcher rd = request.getRequestDispatcher("GetCookie.jsp");
		rd.forward(request, response);
	}
}
