<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/prueba.js" />"></script>
<link
	href="<c:url value="/resources/Bootstrap/css/bootstrap.min.css" />"
	media="screen" rel="stylesheet">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="<c:url value="/resources/Bootstrap/js/bootstrap.min.js" />"></script>
<jsp:include page="/resources/templates/header.jsp"></jsp:include>
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
			<h1>My image.</h1>
			<h2>Upload the image that allow you to be recognized.</h2>
			<form name='imagenForm' action="/siabra/imagen/registro"
				method='POST' enctype="multipart/form-data">
				<input type="file" name="file" /> <input type="submit" value="Save"
					class="btn btn-success">
			</form>
		</div>
	</div>
</body>
</html>