<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/menu.css">
<title>Interfaz SGP</title>
</head>
<body>

	<c:if test = "${sessionScope.auth != 'yes' }" > 
		<c:redirect url="login.html" />
	</c:if>
	
	<div id="wrapper">
	
	<a href="insertar.jsp"><button type="button"> Crear nuevo parte </button></a> 
	<a href="consultar.jsp"><button type="button" > Consultar partes </button></a>
	<a href="eliminar.jsp"><button type="button"> Eliminar partes</button></a>
	
	</div>

</body>
</html>