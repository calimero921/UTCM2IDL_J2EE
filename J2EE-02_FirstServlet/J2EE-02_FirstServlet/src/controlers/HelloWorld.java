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
 * Servlet implementation class HelloWorld
 */
@WebServlet("/HelloWorld")
public class HelloWorld extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String firstName = "";
		String lastName = "";
		
		Enumeration<String> fields = req.getAttributeNames();
		
		while(fields.hasMoreElements()){
			if (fields.toString().equals("prenom")) firstName = req.getParameter(fields.toString());
			if (fields.toString().equals("nom")) lastName = req.getParameter(fields.toString());
		}		
		
        PrintWriter out = resp.getWriter();
        out.println("Hello World, " + firstName +" "+ lastName);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		super.doPost(req, resp);
	}
}
