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
				<c:out value="${ item.price }"/> Euros </br>
				<c:out value="${ item.description }"/> </br>
				<a href="/JWeb/Product?id=${ item.id }"><button>Info</button></a>
				</br></br>
			</c:forEach>
		</p>
	</section>
	
	<footer>
	</footer>
</html>