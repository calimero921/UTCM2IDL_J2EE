package controlers;

import java.io.IOException;

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
       
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.login = request.getParameter("login");
		this.password = request.getParameter("password");
	
		Cookie l = new Cookie("login_cookie", this.login);
		Cookie p = new Cookie("password_cookie", this.password);
		
		response.addCookie(l);
		response.addCookie(p);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.login = request.getParameter("login");
		this.password = request.getParameter("password");
	
		Cookie l = new Cookie("login_cookie", this.login);
		Cookie p = new Cookie("password_cookie", this.password);
		
		response.addCookie(l);
		response.addCookie(p);
	}
}
