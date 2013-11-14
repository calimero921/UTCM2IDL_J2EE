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

	String firstName = "";
	String lastName = "";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
		out.println("traitement GET");
        out.println("Hello World, " + this.firstName +" "+ this.lastName);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
		out.println("traitement POST");
        out.println("Hello World, " + this.firstName +" "+ this.lastName);
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		String firstName = "";
		String lastName = "";
		
        PrintWriter out = resp.getWriter();
		out.println("traitement Service");
		out.println("Serveur = " + req.getServerName());
		out.println("Port = " + req.getServerPort());
		out.println("Session = " + req.getSession());
		out.println("Methode = " + req.getMethod());

		Enumeration<String> fields = req.getParameterNames();
		
		while(fields.hasMoreElements()){
			String chaine = fields.nextElement();
			out.println("Parametre : name =>" + chaine +"<, value =>"+ req.getParameter(chaine) + "<");
			
			if (chaine.equals("prenom")) this.firstName = req.getParameter(chaine);
			if (chaine.equals("nom")) this.lastName = req.getParameter(chaine);
		}		
        
        if (req.getMethod().equals("GET")) doGet(req, resp);
        if (req.getMethod().equals("POST")) doPost(req, resp);
	}
}
