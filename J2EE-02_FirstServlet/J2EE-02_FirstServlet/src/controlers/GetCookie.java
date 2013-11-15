package controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GetCookie
 */
@WebServlet("/GetCookie")
public class GetCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	String login = "";
	String password = "";

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		Cookie[] listeCookies = request.getCookies();
		for (Cookie c : listeCookies){
			out.println("Cookie : Name " + c.getName() +" "+ c.getValue());

			if (c.getName().equals("login_cookie")) this.login = c.getValue();
			if (c.getName().equals("password_cookie")) this.password = c.getValue();
		}
		out.println("traitement service");
		out.println("Hello World, " + this.login +" "+ this.password);
	}
}
