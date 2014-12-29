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
<script src="<c:url value="/resources/js/myPerfil.js" />"></script>
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
			<h3>Create a profile to agree with other people any permission.</h3>
			<h4>Once your profile is created, a code would be generated and
				this profile will not be able to be modified. Although, you could
				delete it and create a new one.</h4>
				<div class="form-group">
					<label class="control-label" for="id_descripcion">Description</label>
					<textarea class="form-control" cols="40" id="id_descripcion"
						name="descripcion" placeholder="Description" rows="10" title=""></textarea>
				</div>
				<h5>Mark the element you would like to see:</h5>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_nombre"><input class="" id="id_nombre"
									name="nombre" type="checkbox"> Name</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_apellidos"><input class=""
									id="id_apellidos" name="apellidos" type="checkbox">
									Surname</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_dni"><input class="" id="id_dni"
									name="dni" type="checkbox"> ID number</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_direccion"><input class=""
									id="id_direccion" name="direccion" type="checkbox">
									Address</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_telefono"><input class=""
									id="id_telefono" name="telefono" type="checkbox">
									Telephone number</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_email"><input class="" id="id_email"
									name="email" type="checkbox"> Email</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_estatus"><input class="" id="id_estatus"
									name="estatus" type="checkbox"> Status</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_pais"><input class="" id="id_pais"
									name="pais" type="checkbox"> Country</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_facebook"><input class=""
									id="id_facebook" name="facebook" type="checkbox">
									Facebook</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_twitter"><input class="" id="id_twitter"
									name="twitter" type="checkbox"> Twitter</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_linkedin"><input class=""
									id="id_linkedin" name="linkedin" type="checkbox">
									Linkedin</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_webPersonal"><input class=""
									id="id_webPersonal" name="webPersonal" type="checkbox">
									Personal web</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_profesion"><input class=""
									id="id_profesion" name="profesion" type="checkbox">
									Profession</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_empresa"><input class="" id="id_empresa"
									name="empresa" type="checkbox"> Company</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_webProfesional"><input class=""
									id="id_webProfesional" name="webProfesional" type="checkbox">
									Professional web</label>
							</div>
						</div>
					</div>
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_comentario"><input class=""
									id="id_comentario" name="comentario" type="checkbox">
									Comment</label>
							</div>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-md-3">
						<div class="form-group">
							<div class="checkbox">
								<label for="id_nacimiento"><input class=""
									id="id_nacimiento" name="nacimiento" type="checkbox">
									Birthday</label>
							</div>
						</div>
					</div>
				</div>
				<p>
					<input type="submit" class="btn btn-success" value="Save" onClick="savePerfil()" name="Confirmar">
				</p>
				<div id="id_alert" role="alert"></div>
		</div>
	</div>
</body>
</html>