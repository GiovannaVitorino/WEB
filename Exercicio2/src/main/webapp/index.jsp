<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Página de Login</title>
<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<section>
		<h1>Página de login</h1>
		<p>Insira seu email e senha</p>
		<form action="UserServlet" method="post">
			<label for="login">Email:</label> <input type="text" name="login"
				id="login"> <label for="password">Senha:</label> <input
				type="text" name="password" id="password"> <input
				type="submit">
		</form>
	</section>
</body>
</html>