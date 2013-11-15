<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Gestion des cookies</title>
</head>
<body>
<jsp:include page="header.inc"></jsp:include>
<%
	String login = "";
	String password = "";
	String name;
	
	Cookie[] l = request.getCookies();
	
	for(int i=0; i < l.length; i++){
		name = l[i].getName();
		if (name.equals("login_cookie")) {
			login = l[i].getValue();
		}
		if (name.equals("password_cookie")) {
			password = l[i].getValue();
		}
	}
	if (login.length()>0 && password.length()>0) {
		out.println("<br>");
		out.println("Bonjour, " + login +"<br>");
		out.println("Votre mot de passe est "+ password + "<br>");
		out.println("<a href=\"GetCookie.jsp\">Recharge la page</a><br>");
	} else {
		out.println("<br>");
		out.println("Désolé,<br>");
		out.println("Identification impossible, cookie absent<br>");
		out.println("<a href=\"GetCookie.jsp\">Recharge la page</a><br>");
	}
%>
<jsp:include page="footer.inc"></jsp:include>
</body>
</html>