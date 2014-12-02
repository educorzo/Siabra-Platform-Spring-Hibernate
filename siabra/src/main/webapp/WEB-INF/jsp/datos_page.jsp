<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mis datos Personales</title>
</head>
<body>
	<form name='datosPersonalesForm' action="/siabra/datos/registro" method='POST'>
		<table>
			<tr>
				<td>First name:</td>
				<td><input type='text' name='nombre'
					value='<c:out value="${model.nombre}"></c:out>'></td>
			</tr>
			<tr>
				<td>Last name:</td>
				<td><input type='text' name='apellidos'
					value='<c:out value="${model.apellidos}"></c:out>'></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><input type='text' name='email'
					value='<c:out value="${model.email}"></c:out>'></td>
			</tr>
			<tr>
				<td>ID number:</td>
				<td><input type='text' name='dni'
					value='<c:out value="${model.dni}"></c:out>'></td>
			</tr>
			<tr>
				<td>Country:</td>
				<td><input type='text' name='pais'
					value='<c:out value="${model.pais}"></c:out>'></td>
			</tr>
			<tr>
				<td>Telephone number:</td>
				<td><input type='text' name='telefono'
					value='<c:out value="${model.telefono}"></c:out>'></td>
			</tr>
			<tr>
				<td>Address:</td>
				<td><input type='text' name='direccion'
					value='<c:out value="${model.direccion}"></c:out>'></td>
			</tr>
			<tr>
				<td>Profession:</td>
				<td><input type='text' name='profesion'
					value='<c:out value="${model.profesion}"></c:out>'></td>
			</tr>
			<tr>
				<td>Company:</td>
				<td><input type='text' name='empresa'
					value='<c:out value="${model.empresa}"></c:out>'></td>
			</tr>
			<tr>
				<td>Status:</td>
				<td><input type='text' name='estatus'
					value='<c:out value="${model.estatus}"></c:out>'></td>
			</tr>
			<tr>
				<td>Birthday:</td>
				<td><input type='date' name='nacimiento'
					value='<c:out value="${model.nacimiento}"></c:out>'></td>
			</tr>
			<tr>
				<td>Comment:</td>
				<td><input type='text' name='comentario'
					value='<c:out value="${model.comentario}"></c:out>'></td>
			</tr>

			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
				<td><input name="reset" type="reset" /></td>
			</tr>
		</table>

	</form>
</body>
</html>