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
<script src="<c:url value="/resources/js/myWebsites.js" />"></script>
<jsp:include page="/resources/templates/header.jsp"></jsp:include>
<style type="text/css">
body {
	padding-top: 80px;
	padding-bottom: 40px;
}
input[type=text] {
min-width: 250px;
width: 50%;
}
#id_alert{
min-width: 250px;
width: 50%;
}
</style>
</head>
<body role="document">
	<div class="container theme-showcase" role="main">
		<div class="jumbotron">
			<h1>My websites.</h1>
			<h4>Remember that any of the fields are mandatory.</h4>
				<div id="div_facebook" class="form-group">
					<label class="control-label" for="id_facebook">Facebook</label>
					 <input
						class="form-control" id="id_facebook" maxlength="90"
						name="facebook" placeholder="Facebook"
						title="Ex.www.facebook.com/NameSurname" type="text"
						value='<c:out value="${model.facebook}"></c:out>'
						onchange="validarUrl(value,'div_facebook','help_facebook')">
					<span class="help-block" id="help_facebook">Ex.www.facebook.com/NameSurname
					</span>
				</div>
				<div class="form-group" id="div_twitter">
					<label class="control-label" for="id_twitter">Twitter</label> <input
						class="form-control" id="id_twitter" maxlength="90" name="twitter"
						placeholder="Twitter" title="Ex.www.twitter.com/NameSurname"
						type="text" value='<c:out value="${model.twitter}"></c:out>'
						onchange="validarUrl(value,'div_twitter','help_twitter')">
					<span class="help-block" id="help_twitter">Ex.www.twitter.com/NameSurname
					</span>
				</div>
				<div class="form-group" id="div_linkedin">
					<label class="control-label" for="id_linkedin">LinkedIn</label> <input
						class="form-control" id="id_linkedin" maxlength="90"
						name="twitter" placeholder="Linkedin"
						title="Ex.www.linkedin.com/NameSurname" type="text"
						value='<c:out value="${model.linkedin}"></c:out>'
						onchange="validarUrl(value,'div_linkedin','help_linkedin')">
					<span class="help-block" id="help_linkedin">Ex.www.linkedin.com/NameSurname
					</span>
				</div>
				<div class="form-group" id="div_webPersonal">
					<label class="control-label" for="id_webPersonal">Personal
						web</label> <input class="form-control" id="id_webPersonal" maxlength="90"
						name="webPersonal" placeholder="Personal web"
						title="Ex.www.wordpress.com/pepe" type="text"
						value='<c:out value="${model.webPersonal}"></c:out>'
						onchange="validarUrl(value,'div_webPersonal','help_webPersonal')">
					<span class="help-block" id="help_webPersonal">Ex.www.wordpress.com/pepe</span>
				</div>
				<div class="form-group" id="div_webProfesional">
					<label class="control-label" for="id_webProfesional">Profesional
						web</label> <input class="form-control" id="id_webProfesional"
						maxlength="90" name="webProfesional" placeholder="Profesional web"
						title="Ex.www.biosearch.com" type="text"
						value='<c:out value="${model.webProfesional}"></c:out>'
						onchange="validarUrl(value,'div_webProfesional','help_webProfesional')">
					<span class="help-block" id="help_webProfesional">Ex.www.biosearch.com</span>
				</div>
				<div class="form-group" id="div_Save">
				<input type="submit" value="Save" class="btn btn-success" onClick="validaWebsites()">
				</div>
				<div id="id_alert" role="alert"></div>
				
		</div>
	</div>

</body>
</html>