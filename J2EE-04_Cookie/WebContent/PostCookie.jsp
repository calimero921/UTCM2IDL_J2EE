<!DOCTYPE html>
<html>
<head>
	<title>Hello World</title>
</head>
<body>
<jsp:include page="header.inc"></jsp:include>
	<h1>Gestion des cookies</h1>
	<form action="SetCookie" method="post">
		Login    : <input type="text" name="login"/><br>
		Password : <input type="password" name="password"/><br>
		<input type="submit" name="submit" value="valider"/><br>
	</form>
<jsp:include page="footer.inc"></jsp:include>
</body>
</html>