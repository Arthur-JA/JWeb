<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>

<body>
	<header>
		<%@ include file="menu.jsp" %>
	</header>
	
	<section>
		<p>
			</br>
			News </br></br>
			<c:forEach items="${ news }" var="item">
				<c:out value="${ item.title }"/> </br>
				<c:out value="${ item.lastModificationUser.name }"/> - <c:out value="${ item.creationDate }"/></br>
				<c:out value="${ item.content }"/> </br> --------------------------- </br></br>
			</c:forEach>
		</p>
	</section>
	
	<footer>
	</footer>
</body>
</html>