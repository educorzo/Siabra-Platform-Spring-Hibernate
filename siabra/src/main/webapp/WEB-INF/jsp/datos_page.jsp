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
			<h1>My personal data.</h1>
			<h3>Introduce your personal data.</h3>
			<form style="display: inline;" name='datosPersonalesForm'
				action="/siabra/datos/registro" method='POST'>
				<div class="form-group">
					<label class="control-label" for="id_name">Name</label> <input
						class="form-control" id="id_name" maxlength="90" name="name"
						placeholder="name" type="text"
						value='<c:out value="${model.name}"></c:out>' onchange="cambio()">
					<span class="help-block">Ex. Pepe </span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_lastName">Last name</label> <input
						class="form-control" id="id_lastName" maxlength="90"
						name="lastName" placeholder="Last name" type="text"
						value='<c:out value="${model.apellidos}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						Pena </span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_email">Email</label> <input
						class="form-control" id="id_email" maxlength="90" name="email"
						placeholder="Email" type="text"
						value='<c:out value="${model.email}"></c:out>' onchange="cambio()">
					<span class="help-block">Ex. Email</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_dni">ID number</label> <input
						class="form-control" id="id_dni" maxlength="90" name="dni"
						placeholder="DNI" type="text"
						value='<c:out value="${model.dni}"></c:out>' onchange="cambio()">
					<span class="help-block">Ex. 12342561G</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_pais">Country</label> <input
						class="form-control" id="id_pais" maxlength="90" name="pais"
						placeholder="Country" type="text"
						value='<c:out value="${model.country}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						Spain</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_telefono">Phone number</label>
					<input class="form-control" id="id_telefono" maxlength="90"
						name="telefono" placeholder="Phone number" type="text"
						value='<c:out value="${model.telefono}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						00341234512345</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_direccion">Address</label> <input
						class="form-control" id="id_address" maxlength="90"
						name="direccion" placeholder="Address" type="text"
						value='<c:out value="${model.direccion}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						C/Andalucia n23</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_profesion">Profession</label>
					<input class="form-control" id="id_address" maxlength="90"
						name="profesion" placeholder="Profession" type="text"
						value='<c:out value="${model.profesion}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						Community manager</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_empresa">Company</label> <input
						class="form-control" id="id_empresa" maxlength="90"
						name="profesion" placeholder="Company" type="text"
						value='<c:out value="${model.empresa}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						Biosearch</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_estatus">Status</label> <input
						class="form-control" id="id_estatus" maxlength="90" name="estatus"
						placeholder="Status" type="text"
						value='<c:out value="${model.estatus}"></c:out>'
						onchange="cambio()"> <span class="help-block">Ex.
						Single</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_nacimiento">Birthday</label> <input
						class="form-control" id="id_nacimiento" name="nacimiento"
						placeholder="Birthday" title="Ex.dd/mm/YYYY"
						value='<c:out value="${model.nacimiento}"></c:out>' type="text">
					<span class="help-block">Ex.dd/mm/YYYY</span>
				</div>
				<div class="form-group">
					<label class="control-label" for="id_comentario">Comment</label> <input
						class="form-control" id="id_comentario" maxlength="50"
						name="comentario" placeholder="Comment"
						title="Ex. Hi! I'm using SIABRA." type="text"
						value='<c:out value="${model.comentario}"></c:out>'> <span
						class="help-block">Ex. Hi! I'm using SIABRA.</span>
				</div>
				<input type="submit" class="btn btn-success" value="Save"
					name="Confirmar">
			</form>
		</div>
	</div>
</body>
</html>