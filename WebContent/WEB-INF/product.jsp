<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Product</title>
</head>
<body>
	<header>
		<%@ include file="menu.jsp" %>
	</header>
	
	<section>
	</section>
		<c:out value="${ product.name }"/> - <c:out value="${ product.price }"/> Euros </br></br>
		<c:out value="${ product.description }"/> </br></br></br></br>
		Comments:
		</br></br></br>
		<c:forEach items="${ product.comments }" var="comment">
			<c:out value="${ comment.author.name }"/> - <c:out value="${ comment.creationDate }"/></br></br>
			<c:out value="${ comment.content }"/></br></br></br></br>
		</c:forEach>
		<c:if test="${!empty sessionScope.login }">
			<form method = "post">
				<textarea rows="5" cols="50" name="comment" placeholder="Comment here"></textarea> </br> </br>
				<input type="submit" value="Post"/>
			</form>
		</c:if>
		<c:if test="${empty sessionScope.login }">
			You need to login to comment.
		</c:if>
	<footer>
	</footer>
	</body>
</html>