<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/anytime.5.1.2.min.css">
<link rel="stylesheet" href="css/tablas.css">  
<link rel="stylesheet" href="css/consultar.css">
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="js/anytime.5.1.2.min.js"></script>
<title>Consulta de partes</title>

<script>

	$(document).ready(function () {
		
		var $currentYear=null;
		var $fechaUnica = null;
		var $fechaRango1 = null;
		var $fechaRango2 = null;		
		
		$("input[name='criterio']:radio").change( function () {
			
			AnyTime.noPicker("fechaUnica");
			AnyTime.noPicker("fechaRango1");
			AnyTime.noPicker("fechaRango2");
			
			
			
			switch ($("input[name='criterio']:checked").val()) {
			
			case 'fecha':
				$("#campos").html("");
				$("#campos").append("Fecha a consultar <input type='text' id='fechaUnica'>");
				AnyTime.picker("fechaUnica");
				break;
			case 'rango':
				$("#campos").html("");
				$("#campos").append("Fecha inicial <input type='text' id='fechaRango1'>");
				$("#campos").append("Fecha final <input type='text' id='fechaRango2'>");
				AnyTime.picker("fechaRango1");
				AnyTime.picker("fechaRango2");								
				break;
			case 'currentYear':
				$("#campos").html("");
				$("#campos").append("Consultar partes en el año actual :");
				var d = new Date;
				$("#campos").append("<p id='currentYear'>"+ d.getFullYear()+"</p>");						
				break;			
			}
			
		});
		
		$("#enviar").click(function () {
			
			$currentYear = $("#currentYear").html();
			$fechaUnica = $("#fechaUnica").val();
			$fechaRango1 = $("#fechaRango1").val();
			$fechaRango2 = $("#fechaRango2").val();	
			
			
			$.get("ConsultaPartes" , {currentYear : $currentYear ,
				fechaUnica : $fechaUnica , fechaRango1 : $fechaRango1 ,
				fechaRango2 : $fechaRango2} , function (data) {
					
					$("#resultados").html(data);
					
				});
			
		});
		
		
	});

</script>


</head>
<body>

<c:if test = "${sessionScope.auth != 'yes' }" > 
		<c:redirect url="login.html" />
	</c:if>

<div id = "seleccion">
Fecha <input name="criterio" type="radio" value="fecha">
Rango <input name="criterio" type="radio" value="rango">
Año Actual <input name="criterio" type="radio" value="currentYear"> 
</div>

<div id="campos"></div>
<button id="enviar"> Consultar </button>
<div id="resultados"></div>
</body>
</html>