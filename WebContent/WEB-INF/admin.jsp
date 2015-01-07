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
		<form method="post">
			Write a news </br></br>
			<input type="text" name="title" placeholder="Title"/> </br> </br>
			<textarea rows="8" cols="50" name="content" placeholder="Content"></textarea> </br> </br>
			<input type="submit" value="Post"/>
		</form>
		</br></br></br>
		Users :
		</br></br>
		<c:forEach items="${ users }" var="user">
			<c:out value="${ user.name }"/> - <c:out value="${ user.email }"/> - <c:out value="${ user.registrationDate }"/> - <c:out value="${ user.role }"/> </br></br>
		</c:forEach>
		</br></br></br>
		Add new product :
		<form method="post">
			<input type="text" name="name" placeholder="Name"/> </br> </br>
			<input type="number" name="price" placeholder="Price"/> Euros </br> </br>
			<textarea rows="8" cols="50" name="description" placeholder="Description"></textarea> </br> </br>
			<input type="submit" value="Add"/>
		</form>
	</section>
</body>
		
</html>