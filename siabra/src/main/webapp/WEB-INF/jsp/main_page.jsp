<%@ page isELIgnored="false"%>
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
			<h1>Welcome!</h1>
			<h3>Using SIABRA you would recognize and be recognized by other
				users.</h3>
			<h4>Privacity is our priority.</h4>
			<h4>Upload the personal information you like and/or create a
				permission profile.</h4>
			<h4>Through your permission profile other users could require
				some of your personal information. Accept it if you think is
				convenient. You can also decide what information is shown to the
				rest of the users.</h4>
			<h4>
				Download the Android App if you want to add and delete permission
				profiles and also to know what is the information you are showing in
				every moment <a href="/media/SIABRA_Privacity.apk">SIABRA
					Privacity</a> (Min. Android GingerBread 2.3.3) .
			</h4>
			<h4>
				If you want to recognize other users , use the following app <a
					href="/media/SIABRA_Discover.apk">SIABRA Discover</a> (Min. Android
				IceCreamSandwich 4.0.0).
			</h4>
			<h4>If you are a developer, do not forget that you can also link
				your application to SIABRA. Go to the Developer section if you want
				to know more.</h4>
		</div>
	</div>

</body>
</html>