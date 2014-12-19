/**
 * 
 */
window.onload= initPage;

function initPage(){
	activarIluminacionMisPaginasWeb();
}

function validarUrl(value, idDiv, idSpan){
	var div=document.getElementById(idDiv);
	var span=document.getElementById(idSpan);
	if(!(!value || value.length === 0) && !isURL(value)){
		div.className="form-group has-error";
		span.innerHTML="Enter a valid Url. "+span.innerHTML;
	}
	else if(div.className=="form-group has-error"){
		div.className="form-group has-success";
		span.innerHTML=span.innerHTML.replace("Enter a valid Url. ","");
	}
	else{
		div.className="form-group has-success";
	}
}

function activarIluminacionMisPaginasWeb(){
	var d=document.getElementById("webs");
	d.className= d.className +"active";
}

function isURL(s) {    
	var regexp =/((([A-Za-z]{3,9}:(?:\/\/)?)(?:[\-;:&=\+\$,\w]+@)?[A-Za-z0-9\.\-]+|(?:www\.|[\-;:&=\+\$,\w]+@)[A-Za-z0-9\.\-]+)((?:\/[\+~%\/\.\w\-_]*)?\??(?:[\-\+=&;%@\.\w_]*)#?(?:[\.\!\/\\\w]*))?)/
    return regexp.test(s);    
}