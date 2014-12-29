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
<script src="<c:url value="/resources/js/myPerfilCreado.js" />"></script>
<jsp:include page="/resources/templates/header.jsp"></jsp:include>
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}

#id_alert {
	min-width: 250px;
	width: 50%;
}
</style>
</head>
<body>
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h1>My profile.</h1>
			<h4>Only a permission profile is possible at the moment. This
				profile has the following description:</h4>
			<h5>${description}</h5>
			<h4>And it requires the following permissions :</h4>
			<c:if test="${not empty list}">
				<ul>
					<c:forEach var="listValue" items="${list}">
						<li>${listValue}</li>
					</c:forEach>
				</ul>
			</c:if>
			<h4>To share this profile please use the following code:</h4>
			<h5>${codigo}</h5>
			<h4>If you want to delete the existing profile, press 'Next'.</h4>
			<button class="btn btn-danger" data-toggle="modal"
				data-target="#myModal">Next</button>
			<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
				aria-labelledby="myModalLabel" aria-hidden="true">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal"
								aria-hidden="true">×</button>
							<h4 class="modal-title" id="myModalLabel">Delete profile</h4>
						</div>
						<div id="id_modal_body" class="modal-body">Are you sure you want to delete the
							profile?</div>
						<div id="id_footer" class="modal-footer">
							 <button type="button" class="btn btn-danger" name="eliminar" onClick="eliminar()">Yes</button>
							<button type="button" class="btn btn-default" data-dismiss="modal">No</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
		</div>
	</div>
</body>
</html>