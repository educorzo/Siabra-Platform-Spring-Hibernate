<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
 <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="<c:url value="/resources/Bootstrap/css/bootstrap.min.css" />"
	media="screen" rel="stylesheet">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="<c:url value="/resources/Bootstrap/js/bootstrap.min.js" />"></script>
<jsp:include page="/resources/templates/header.jsp"></jsp:include>
<title>Mis datos Personales</title>
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}
</style>
</head>
<body>
<div class="container theme-showcase" role="main">
		<div class="jumbotron">
Welcome <c:out value="${model.username}"></c:out>!
<br/>
This is the main page!
</div>
</div>

</body>
</html>