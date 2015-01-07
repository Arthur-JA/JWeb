<style type="text/css">
h1 {
	color:blue;
	font-size:60px;
	text-decoration: overline;
}
div {
	margin-left:1100px;
}
a {
	font-size:25px;
	margin-left:30px;
}
body {
	margin-left:50px;
}
section {
	margin-top:50px;
}
h2 {
	text-decoration: underline;
}
em {
	font-size:20px;
}
</style>


<h1>TossaShop</h1>
<div>
			<c:if test="${!empty sessionScope.login }">
				<em>Welcome 	</em> ${ sessionScope.login } 
				<a href="/JWeb?state=logout">Log out</a>
			</c:if>
			<c:if test="${empty sessionScope.login }">
				<form method="post" action="/JWeb/">
					<input type="text" name="login" id="login" placeholder="Login" requiered/>
					<input type="password" name="password" placeholder="Password" requiered/>
					<input type="submit" value="Login"/>
				</form>
				
			</c:if>
</div>
<nav>

	<c:if test="${ empty login }">
	<a href="/JWeb/Inscription">Inscription</a>
	</c:if>
	<a href="/JWeb/">Home</a>
	<a href="/JWeb/Products">Products</a>
	<c:if test="${ isAdmin eq true }">
	<a href="/JWeb/Admin/">Admin</a>
	</c:if>

</nav>