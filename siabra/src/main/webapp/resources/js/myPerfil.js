/**
 * 
 */
window.onload = initPage;

function initPage() {
	var d = document.getElementById("perfil");
	d.className = d.className + "active";
}

function savePerfil(){
	var permisos= checksToString();
	var descripcion= document.getElementById("id_descripcion").value;
	$.post("/siabra/perfil/registro", {
		'descripcion' : descripcion,
		'permisos' : permisos,
	}).done(function(data) {
		if(data.Status=="Exito"){
			//$("#id_alert").removeClass("alert alert-danger").addClass("alert alert-success");
			//$("#id_alert").text("Data successfuly modified.");
			window.location.href='/siabra/perfil';
		}	
		else{
			$("#id_alert").removeClass("alert alert-success").addClass("alert alert-danger");
			$("#id_alert").text("Upps something wrong happens.");
		}
	}).fail(function() {
		$("#id_alert").removeClass("alert alert-success").addClass("alert alert-danger");
		$("#id_alert").text("Upps something wrong happens.");
	  });
}

function checksToString(){
	var permisos="";
	permisos=checkToString(permisos,"id_apellidos");
	permisos=checkToString(permisos,"id_comentario");
	permisos=checkToString(permisos,"id_direccion");
	permisos=checkToString(permisos,"id_dni");
	permisos=checkToString(permisos,"id_email");
	permisos=checkToString(permisos,"id_empresa");
	permisos=checkToString(permisos,"id_estatus");
	permisos=checkToString(permisos,"id_facebook");
	permisos=checkToString(permisos,"id_linkedin");
	permisos=checkToString(permisos,"id_nacimiento");
	permisos=checkToString(permisos,"id_nombre");
	permisos=checkToString(permisos,"id_pais");
	permisos=checkToString(permisos,"id_profesion");
	permisos=checkToString(permisos,"id_telefono");
	permisos=checkToString(permisos,"id_twitter");
	permisos=checkToString(permisos,"id_webPersonal");
	permisos=checkToString(permisos,"id_webProfesional");
	return permisos;
}

function checkToString(string,value){
	string= document.getElementById(value).checked ? string.concat("1") :string.concat("0");
	return string;
}
