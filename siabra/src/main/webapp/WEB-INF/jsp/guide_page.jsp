<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="<c:url value="/resources/js/prueba.js" />"></script>
<link
	href="<c:url value="/resources/Bootstrap/css/bootstrap.min.css" />"
	media="screen" rel="stylesheet">
<script src="//code.jquery.com/jquery.min.js"></script>
<script src="<c:url value="/resources/Bootstrap/js/bootstrap.min.js" />"></script>
<jsp:include page="/resources/templates/header.jsp"></jsp:include>
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
    <h1>Dev guide.</h1>
    <h3>Link your apps with SIABRA in a simple and secure way.</h3>
    <h4>Temporary, the guide is just in Spanish. Para poder realizar la conexión con SIABRA, la aplicación ha de estar registrada en el sistema. Una vez registrada la app, se proporcionaran unas claves de conexión OAuth.</h4>
    <h4>SIABRA utiliza el protocolo OAuth 1.0.a. , descrito en la siguiente dirección <a href="http://oauth.net/core/1.0a/">link</a>.</h4>
    <h4>Si su aplicación reconoce usuarios por medio de captura de imagenes, deberá hacerlo a traves de <a href="https://developer.vuforia.com/getting-started-overview">VUFORIA</a>.

    Para poder reconocer esas imagenes (usuarios), deberá conectarse a nuestra base de datos, utilizando las siguientes claves (No confundir con las claves OAuth):</h4>
    <h5>Access Key: <b>4632896f497793047720b28ada76626be5eb0ea1</b></h5>
    <h5>Secret Key: <b>5271118083066b1cb03dc59ba7d87fe6152f464c</b></h5>

    <h4>Para poder conectar con nuestro servidor necesitara utilizar las siguientes direcciones:</h4>
    <h5>Obtener request token: http://siabra.pythonanywhere.com/oauth/request_token/</h5>
    <h5>Obtener access token: http://siabra.pythonanywhere.com/oauth/access_token/</h5>
    <h5>Autorizar aplicación: http://siabra.pythonanywhere.com/oauth/authorize/</h5>

    <h4>Accede a nuestros recursos con SIABRA REST API:</h4>


           <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Comprobar si todo funciona.</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/check/</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Notifica que los tokens siguen activos.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Ninguno.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Si se ha tenido éxito devuelve el siguiente  JSON:
{‘Exito’:’Sus tokens siguen activos’}
En caso de error se devuelve información sobre este con clave “Detail”
</td>
            </tr>
        </tbody>
    </table>
</div>

 <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Obtener perfiles aceptados.</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/perfil/list/</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Devuelve una lista con el nombre del creador y el código de todos los perfiles aceptados por el usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Ninguno.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un  objeto JSON compuesto de una clave numérica (orden de elemento) y los valores username (creador del perfil) y código del perfil.
Ej: {"0": ["edu", "1234"], "1": ["pepe", "12345"]}
</td>
            </tr>
        </tbody>
    </table>
</div>




      <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Obtener información de un perfil</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/perfil/show/codigo:codigo</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Devuelve la información de un perfil dado un código :codigo de perfil.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Como parámetro GET se pasa la clave “codigo” y el código del perfil.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un objeto JSON con las siguientes claves: “usuario” (dueño del perfil),”permisos”, “codigo” , “descripcion” y “agregado”(Con valor True si el usuario ya tenia agregado el perfil).
Ej. {'agregado': 'True', 'descripcion': 'Un perfil para hacer pruebas de todo tipo. ','permisos': ['apellidos', 'comentario', 'webProfesional'],'usuario': 'pepe'}
</td>
            </tr>
        </tbody>
    </table>
</div>

       <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Obtener información del usuario</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/user/show/</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Devuelve todos los datos relacionados  del usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Ninguno.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un objeto JSON con todos los elementos del usuario.
Ej. {'apellidos': 'Peña','comentario': 'Hola !','direccion': 'los metales','dni': ‘1111111B','email': 'pepepena@gmail.com','empresa': 'Sigma','estatus': 'casado','facebook': 'www.facebook.com/pepePena','linkedin': 'www.linkedin.com/josePena','nacimiento':'1920-10-18','nombre': 'Jose','pais': 'España','profesion': 'vendedor','telefono': '0034958153120','twitter': 'www.twitter.com/pepePena','webPersonal': 'www.pepe.wordpress.com','webProfesional': ''}
</td>
            </tr>
        </tbody>
    </table>
</div>

        <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Obtener información de otro usuario</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/user/other/username:nick</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Devuelve todos los datos disponibles del usuario :nick.
En caso de que el usuario autenticado y el usuario :nick hayan acordado un perfil se mostraran los datos acordados. Si no lo hicieron, se devolverán los datos públicos de :nick.
</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Como parámetro get se pasa la clave “username” y el nombre del usuario(nick).</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un objeto JSON con los elementos del usuario.En caso de que algún dato no este disponible, no aparecerá en el objeto.
En caso de que no exista el usuario, se devuelve un objeto JSON con clave “Error” y un mensaje de error.
Ej.{‘apellidos’:’pena’,’email’:’pepepena@gmail.com’}
Ej.{‘Error’: ’Usuario no activo’}
</td>
            </tr>
        </tbody>
    </table>
</div>

      <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Añadir perfil</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>POST</th>
            <th>/perfil/new/</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Añade un perfil existente a la lista de perfiles del  usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Recibe un objeto con clave “codigo” y el código del perfil.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Confirmando que se ha tenido éxito la modificación, se devuelve un objeto JSON con clave “codigo” y el código del perfil añadido. En caso de que no se haya podido añadir, se devuelve un objeto JSON con clave “Error” y un mensaje de error.
Ej. {‘codigo’:’2d2efff44’}
Ej. {‘Error’:’El perfil no existe’}
</td>
            </tr>
        </tbody>
    </table>
</div>

      <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Cancelar perfil</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>POST</th>
            <th>/perfil/cancel/codigo:codigo</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Elimina un perfil existente de la lista de perfiles del usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Recibe un objeto con clave “codigo” y el código del perfil a eliminar.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Confirmando que se ha tenido éxito la modificación, se devuelve un objeto JSON con clave “Exito”. En caso de que no se haya podido añadir, se devuelve un objeto JSON con clave “Error” y un mensaje de error.
Ej. {‘Exito’:’Perfil cancelado’}
Ej. {‘Error’:’No existe un perfil con ese codigo’}
</td>
            </tr>
        </tbody>
    </table>
</div>

     <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Obtener permisos por palabras</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/permisos/show/words</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Devuelve los permisos del usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Ninguno.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un objeto JSON con un elemento con clave “permisos” cuyo valor es una lista de todos los elementos que son posibles ver.
Ej. {'permisos': ['comentario', 'dni', 'empresa', 'facebook', 'nacimiento', 'pais', 'telefono', 'webPersonal']}
</td>
            </tr>
        </tbody>
    </table>
</div>
          <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Modificar permisos por palabras</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>POST</th>
            <th>/permisos/modify/words</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Modifica los permisos del usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Una lista con clave ‘permisos’ con todos los elementos que se requieren visualizar.
Ej de la lista: [comentario,dni,webPersonal]
</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un objeto JSON con un elemento con clave “permisos” cuyo valor es una lista de todos los elementos que son posibles ver(los mismos elementos que se han solicitado). En caso de error , se devuelve un objeto JSON con clave Error .
Ej. {'permisos': ['comentario', 'dni', 'webPersonal']}
Ej. {‘Error’:’Formato incorrecto’}
</td>
            </tr>
        </tbody>
    </table>
</div>


	            <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Mostrar permisos por codigo</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>GET</th>
            <th>/permisos/show/code</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Devuelve los permisos del usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Ninguno.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Devuelve un objeto JSON con una cadena de unos y ceros con clave  “permisos”. La posición representa el elemento que será posible o no visualizar. La relación entre elemento y posición es alfabética, por lo que en la primera posición estará el primer elemento ordenado alfabéticamente, como es “apellidos” y el ultimo elemento haría relación a  “webProfesional”. Un uno significaría que seria posible visualizarlo y un cero que no.
Ej. {‘permisos’:’000000000000000000’}
</td>
            </tr>
            <tr>
                <td>Comentario</td>
                <td>Si en futuras versiones se añaden nuevos elementos, la cadena variara.</td>
            </tr>
        </tbody>
    </table>
</div>
	       <div class="panel panel-default">
  <!-- Default panel contents -->
  <div class="panel-heading">Modificar permisos por codigo</div>
  <!-- Table -->
 <table class="table">
    <thead>
        <tr>
            <th>POST</th>
            <th>/permisos/modify/code</th>

        </tr>
    </thead>
        <tbody>
            <tr>
                <td>Descripción</td>
                <td>Modifica los permisos del usuario autenticado.</td>
            </tr>
	    <tr>
                <td>Parametro de entrada</td>
                <td>Recibe una cadena de 17 elementos compuesta de ceros y unos con clave “permisos”. Cada posición hace referencia a un elemento que se puede o no visualizar. Los elementos están ordenados alfabéticamente, por lo que la primera posición corresponderá a “apellidos” y la ultima a “webProfesional”.</td>
            </tr>
	    <tr>
                <td>Parametro de salida</td>
                <td>Confirmando que se ha tenido éxito la modificación, se devuelve un objeto JSON con clave “permisos” y la cadena de permisos modificada.
Ej. {‘permisos’:’11111111111111111’}
</td>
            </tr>
            <tr>
                <td>Comentario</td>
                <td>Si en futuras versiones se añaden nuevos elementos, la cadena variara.</td>
            </tr>
        </tbody>
    </table>
</div>


    </div>
	</div>
</body>
</html>