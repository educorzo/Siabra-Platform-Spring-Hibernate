window.onload= initPage;

function initPage(){
	activarIluminacionMisPaginasWeb();
}

function validarUrl(value, idDiv, idSpan){
	var div=document.getElementById(idDiv);
	var span=document.getElementById(idSpan);
	var valido=true;
	if(!(!value || value.length === 0) && !isURL(value)){
		div.className="form-group has-error";
		span.innerHTML="Enter a valid Url. "+span.innerHTML;
		valido=false;
	}
	else if(div.className=="form-group has-error"){
		if(!(!value || value.length === 0)){
			div.className="form-group has-success";
			span.innerHTML=span.innerHTML.replace("Enter a valid Url. ","");
		}else{
			div.className="form-group";
			span.innerHTML=span.innerHTML.replace("Enter a valid Url. ","");
		}
	}
	else{
		if(!(!value || value.length === 0)){
			div.className="form-group has-success";
		}else{
			div.className="form-group";
		}
	}
	return valido;
}

function activarIluminacionMisPaginasWeb(){
	var d=document.getElementById("webs");
	d.className= d.className +"active";
}

function isURL(s) {    
	var regexp =/((([A-Za-z]{3,9}:(?:\/\/)?)(?:[\-;:&=\+\$,\w]+@)?[A-Za-z0-9\.\-]+|(?:www\.|[\-;:&=\+\$,\w]+@)[A-Za-z0-9\.\-]+)((?:\/[\+~%\/\.\w\-_]*)?\??(?:[\-\+=&;%@\.\w_]*)#?(?:[\.\!\/\\\w]*))?)/
    return regexp.test(s);    
}

function validaWebsites() {
	var facebook = document.getElementById("id_facebook").value;
	var twitter = document.getElementById("id_twitter").value;
	var linkedin = document.getElementById("id_linkedin").value;
	var webPersonal = document.getElementById("id_webPersonal").value;
	var webProfesional = document.getElementById("id_webProfesional").value;
	var validado = true;
	if (!validarUrl(facebook,'div_facebook','help_facebook')) {
		validado = false
	}
	if (!validarUrl(twitter,'div_twitter','help_twitter')) {
		validado = false
	}
	if (!validarUrl(linkedin,'div_linkedin','help_linkedin')) {
		validado = false
	}
	if (!validarUrl(webPersonal,'div_webPersonal','help_webPersonal')) {
		validado = false
	}
	if (!validarUrl(webProfesional,'div_webProfesional','help_webProfesional')) {
		validado = false
	}
	if (validado) {
		$.post("http://localhost:8080/siabra/paginas/registro", {
			'facebook' : facebook,
			'twitter' : twitter,
			'linkedin' : linkedin,
			'webPersonal' : webPersonal,
			'webProfesional':webProfesional
		}).done(function(data) {
			if(data.Status=="Exito"){
				$("#id_alert").removeClass("alert alert-danger").addClass("alert alert-success");
				$("#id_alert").text("Data successfuly modified.");
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
}