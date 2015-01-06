<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin</title>
</head>
<body>
	<header>
		<%@ include file="menu.jsp" %>
	</header>
	
	<section>
	</section>
		</body></br>
		<form method="post">
			Write a new </br></br>
			<input type="text" name="title" placeholder="Title"/> </br> </br>
			<textarea rows="8" cols="50" name="content" placeholder="Content"></textarea> </br> </br>
			<input type="submit" value="Post"/>
		</form>
		<c:forEach items="" var="user">
		</c:forEach>
	<footer>
	</footer>
</html>