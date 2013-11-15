package controlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ChainePage1
 */
@WebServlet("/ChainePage1")
public class ChainePage1 extends HttpServlet {

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		/*
		out.println("Inclusion");		
		RequestDispatcher rd = request.getRequestDispatcher("ChainePage2");
		rd.include(request, response);
		*/
		out.println("Redirection");		
		RequestDispatcher rd = request.getRequestDispatcher("ChainePage2");
		rd.forward(request, response);
		
		out.println("traitement ChainePage1");		
	}
}
