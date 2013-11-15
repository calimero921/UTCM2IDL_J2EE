package controlers;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Placement
 */
@WebServlet("/Placement")
public class Placement extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	int montant;
	float taux;
	int duree;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		Enumeration<String> fields = request.getParameterNames();
		
		while(fields.hasMoreElements()){
			String chaine = fields.nextElement();
			
			if (chaine.equals("montant")) this.montant = Integer.parseInt(request.getParameter(chaine));
			if (chaine.equals("taux")) this.taux = Float.parseFloat(request.getParameter(chaine));
			if (chaine.equals("duree")) this.duree = Integer.parseInt(request.getParameter(chaine));
		}

		float result[][] = new float[this.duree + 1][3];
		result[0][0] = montant;
		result[0][1] = 0;
		result[0][2] = 0;

		for (int i = 1; i <= duree;i++){
			result[i][1] = result[i-1][0] * (this.taux/100);
			result[i][2] = result[i-1][2] + result[i][1];
			result[i][0] = result[i-1][0] + result[i][1];
		}
		
		request.setAttribute("result", result);
		
		RequestDispatcher rd = request.getRequestDispatcher("SetInfo.jsp");
		rd.forward(request, response);
	}
}
