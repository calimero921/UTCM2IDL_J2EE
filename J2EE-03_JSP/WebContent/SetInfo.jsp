<%@page import="java.text.DecimalFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Information placement</title>
</head>
<body>
	Montant  : <%= request.getParameter("montant") %><br>
	Taux     : <%= request.getParameter("taux") %><br>
	Durée    : <%= request.getParameter("duree") %><br>
	<br>
<table border="2">
	<tr>
		<td align="center" width="100">Année</td>
		<td align="center" width="100">Montant</td>
		<td align="center" width="100">Intérêt</td>
		<td align="center" width="100">Cumulé</td>
	</tr>
	<tr>
	<%
	String index;
	float result[][] = (float[][]) request.getAttribute("result");
	
	for (int i = 1; i <= Integer.parseInt(request.getParameter("duree")); i++){
		out.println("</tr>");
		index = "000" + String.valueOf(i);
		index = index.substring(index.length()-3);
		out.println("<td align=\"center\">" + index + "</td>");
		out.println("<td align=\"right\">" + String.format("%.2f",result[i][0]) + "</td>");
		out.println("<td align=\"right\">" + String.format("%.2f",result[i][1]) + "</td>");
		out.println("<td align=\"right\">" + String.format("%.2f",result[i][2]) + "</td>");
		out.println("</tr>");
	}
	%>
</table>
</body>
</html>