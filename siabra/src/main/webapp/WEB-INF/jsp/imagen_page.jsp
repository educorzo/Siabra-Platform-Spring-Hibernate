<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>Mi imagen Page</title>
</head>
<body>
	<form name='imagenForm' action="/siabra/imagen/registro" method='POST' enctype="multipart/form-data">
		<input type="file" name="file"/> <input name="submit" type="submit"
			value="submit" />
	</form>
</body>
</html>