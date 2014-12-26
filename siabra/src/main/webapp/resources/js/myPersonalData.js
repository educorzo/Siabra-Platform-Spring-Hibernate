/**
 * 
 */
window.onload = initPage;

function initPage() {
	var d = document.getElementById("datos");
	d.className = d.className + "active";
}

function isEmail(email) {
	var re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

function validarEmail(value, idDiv, idSpan) {
	var div = document.getElementById(idDiv);
	var span = document.getElementById(idSpan);
	var valido = true;
	if (!(!value || value.length === 0) && !isEmail(value)) {
		div.className = "form-group has-error";
		span.innerHTML = "Enter a valid email. " + span.innerHTML;
		valido = false;
	} else if (div.className == "form-group has-error") {
		if (!(!value || value.length === 0)) {
			div.className = "form-group has-success";
			span.innerHTML = span.innerHTML
					.replace("Enter a valid email. ", "");
		} else {
			div.className = "form-group";
			span.innerHTML = span.innerHTML
					.replace("Enter a valid email. ", "");
		}
	} else {
		if (!(!value || value.length === 0)) {
			div.className = "form-group has-success";
		} else {
			div.className = "form-group";
		}
	}
	return valido;
}

function save() {
	var name = document.getElementById("id_name").value;
	var lastName = document.getElementById("id_lastName").value;
	var email = document.getElementById("id_email").value;
	var dni = document.getElementById("id_dni").value;
	var pais = document.getElementById("id_pais").value;
	var telefono = document.getElementById("id_telefono").value;
	var direccion = document.getElementById("id_direccion").value;
	var profesion = document.getElementById("id_profesion").value;
	var empresa = document.getElementById("id_empresa").value;
	var estatus = document.getElementById("id_estatus").value;
	var nacimiento = document.getElementById("id_nacimiento").value;
	var comentario = document.getElementById("id_comentario").value;
	var validado = true;
	if (!validarEmail(email, 'div_email', 'help_email')) {
		validado = false
	}
	if (validado) {
		$.post("http://localhost:8080/siabra/datos/registro", {
			'name' : name,
			'lastName' : lastName,
			'email' : email,
			'dni' : dni,
			'pais' : pais,
			'telefono' : telefono,
			'direccion' : direccion,
			'profesion' : profesion,
			'empresa' : empresa,
			'estatus' : estatus,
			'nacimiento' : nacimiento,
			'comentario' : comentario
		}).done(
				function(data) {
					if (data.Status == "Exito") {
						console.log(data);
						$("#id_alert").removeClass("alert alert-danger").addClass("alert alert-success");
						$("#id_alert").text("Data successfuly modified.");
					} else {
						$("#id_alert").removeClass("alert alert-success").addClass("alert alert-danger");
						$("#id_alert").text("Upps something wrong happens.");
					}
				}).fail(
				function() {
					$("#id_alert").removeClass("alert alert-success").addClass("alert alert-danger");
					$("#id_alert").text("Upps something wrong happens.");
				});
	}// IF

}