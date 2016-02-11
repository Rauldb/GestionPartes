<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="css/anytime.5.1.2.min.css">  
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="js/anytime.5.1.2.min.js"></script>
<title>Eliminar partes</title>

<script>


$(document).ready(function () {
	
	AnyTime.picker("fecha");
	
	$("#enviar").click(function () {
		
		$fecha = $("#fecha").val();
		
		$.post('EliminaParte' , {fecha : $fecha} , function (data) {
			
			
			
		});
		
	});
	
	
	
	
});




</script>

</head>
<body>

	<c:if test = "${sessionScope.auth != 'yes' }" > 
		<c:redirect url="login.html" />
	</c:if>
	
	<p>Eliminar partes en una fecha :</p>
	
	<input type="text" id="fecha">
	
	<button type="button" id="enviar"> Eliminar </button>

</body>
</html>