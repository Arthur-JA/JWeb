<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Inscription</title>
</head>
<body>
	<header>
		<%@ include file="menu.jsp" %>
	</header>

	<section>
		<form method="post" action="/">
			<p>
       			<label for="login">Login</label> : <input type="text" name="login" id="login" /></br>
       			<label for="password">Password</label> : <input type="password" name="password" id="password" /></br>
       			<label for="email">Email</label> : <input type="email" name="email" id="email" /></br>
       			<input type="submit" value="Login"/>
       			
   			</p>
		</form>
	</section>

	<footer>
	
	</footer>
</body>
</html>