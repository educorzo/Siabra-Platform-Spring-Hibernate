<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="<c:url value="/resources/js/jqueryAjax.js" />"></script>
<title>Custom Login Page</title>
</head>
<body onload='document.loginForm.j_username.focus();'>
	<h3>Custom Login Page</h3>

	<%
		String errorString = (String) request.getAttribute("error");
		if (errorString != null && errorString.trim().equals("true")) {
			out.println("Incorrect login name or password. Please retry using correct login name and password.");
		}
	%>

	<form name='loginForm' action="<c:url value='j_spring_security_check' />" method='POST'>

		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>
	</form>
	
		<table>
			<tr>
				<td>User:</td>
				<td><input type='text' id="username" name='username' value=''></td>
			</tr>

			<tr>
				<td>Email:</td>
				<td><input type='text' id="email" name='email' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' id="password" name='password1' value=''></td>
			</tr>
			<tr>
				<td>Repita password:</td>
				<td><input type='password' id="password2" name='password2' value=''></td>
			</tr>

			<tr>
				<td><input name="submit" type="submit" value="submit" onClick="validaRegistro()" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>
	</form>
</body>
</html>