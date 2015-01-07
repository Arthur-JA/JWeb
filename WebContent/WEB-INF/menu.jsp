<style type="text/css">
h1 {
	color:blue;
	font-size:60px;
	text-decoration: overline;
	margin-left:50px;
}
div {
	margin-left:1100px;
}
a {
	font-size:25px;
	margin-left:50px;
}
p {
	margin-left:50px;
}
h2 {
	margin-left:50px;
	text-decoration: underline;
}
</style>


<h1>TossaShop</h1>
<div>
			<c:if test="${!empty sessionScope.login }">
				Connected as ${ sessionScope.login } 
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