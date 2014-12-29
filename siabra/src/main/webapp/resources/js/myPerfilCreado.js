/**
 * 
 */
window.onload = initPage;

function initPage() {
	var d = document.getElementById("perfil");
	d.className = d.className + "active";
}

function eliminar(){
	$.get("/siabra/perfil/eliminar")
	.done(function(data) {
		if(data.Status=="Exito"){
			$("#id_footer").empty();
			$("#id_modal_body").empty();
			$(".close").empty();
			$("#myModal").attr("backdrop","static");
			$("#myModal").attr("keyboard","false");
			jQuery('<div/>', {
			    text: 'Profile successfully deleted',
			    role:'alert',
			    id:'id_alert'
			}).appendTo("#id_modal_body");
			jQuery('<div/>', {
			    text: 'Wait few seconds please.'
			}).appendTo("#id_footer");
			 setTimeout("window.location.href='/siabra/perfil'",5000);
		}	
		else{
			 alert( "Upps something wrong happens" );
		}
	}).fail(function() {
		 alert( "Upps something wrong happens." );
	  });
	
}