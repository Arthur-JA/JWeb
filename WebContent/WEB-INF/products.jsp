<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Products</title>
</head>
<body>
	<header>
		<%@ include file="menu.jsp" %>
	</header>
	
	<section>
		<p>
			<c:forEach items="${ products }" var="item">
				<c:out value="${ item.name }"/> -  
				<c:out value="${ item.price }"/> </br> Euros
				<c:out value="${ item.description }"/> </br>
				<form action="/JWeb/Product"> <input type="submit" value="Info"/> </form> 
				</br></br>
			</c:forEach>
		</p>
	</section>
	
	<footer>
	</footer>
</html>