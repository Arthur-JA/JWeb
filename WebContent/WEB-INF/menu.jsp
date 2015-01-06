<ul>
	<li>
		<p>
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
		</p>
	</li>
	<li><a href="/JWeb/Inscription">Inscription</a></li>
	<li><a href="/JWeb/">Home</a></li>
	<li><a href="/JWeb/Products">Products</a></li>
	<li><a href="/JWeb/Admin/">Admin</a></li>
</ul>