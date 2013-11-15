package controlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CheckServlet
 */
@WebServlet("/CheckServlet")
public class CheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		Enumeration<String> fields = request.getParameterNames();
		
		while(fields.hasMoreElements()){
			String chaine = fields.nextElement();
			out.println("Parametre : name =>" + chaine +"<, value =>"+ request.getParameter(chaine) + "<");
		}		

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		
		Enumeration<String> fields = request.getParameterNames();
		
		while(fields.hasMoreElements()){
			String chaine = fields.nextElement();
			out.println("Parametre : name =>" + chaine +"<, value =>"+ request.getParameter(chaine) + "<");
		}		

	}

}
