<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="css/anytime.5.1.2.min.css">  
  <link rel="stylesheet" href="css/formulario.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="js/anytime.5.1.2.min.js"></script>
  
  <script>
      $(document).ready(function() {
    	  
    	  var $conductas = "";
    	  AnyTime.picker("datepicker");
    	  
      $('#curso').change(function(event) {
          var $curso=$("select#curso").val();
            $.get('ListaAlumnos',{curso:$curso},function(data) {
          	  var $select = $('#alumnos');
                 $select.find('option').remove();
                 $select.append("<option> Selecciona Alumno </option>")
                 $select.append(data);
                      });
              });
      
      $.get('ListaLugares' , function (data) {
    	 var $select = $('#lugar');    	
    	 $select.append(data);
      });
      
      $.get('ListaCursos' , function (data) {
    	  var $select = $('#curso');
    	  $select.append(data);    	  
      });
      
      $.get('ListaConductas' , function (data) {
    	  
    	  $("#antesDeConducta").after(data);
    	  
    	   $(".selectcond").change(function(event) {

    		     if ( $(this).val() != "pordefecto") {

    		     var $cond;
    		     switch ($(this).attr('id')) {
    		       case "leves":
    		       $cond = "<p class='leve'>"+$(this).val()+"<button type='button'> X </button></p>";
    		         break;
    		      case "generales":
    		       $cond = "<p class='general'>"+$(this).val()+"<button type='button'> X </button></p>";
    		       break;
    		       case "graves":
    		       $cond = "<p class='grave'>"+$(this).val()+"<button type='button'> X </button></p>";
    		       break;

    		     }

    		     $conductas += $(this).val()+",";
    		     $("#conductas").append($cond);

    		     }
    		     $("p > button").click(function(event) {
    		       $(this).parent().remove();

    		     });
    	  
      });
      
     

   });
          $("#enviar").click(function(event) {
              
              var $nombreProfesor = $("#nombrecompleto").html();
              var $curso = $("#curso").val();
              var $nombreAlumno = $("#alumnos").val();
              var $lugar = $("#lugar").val();
              var $fecha = $("#datepicker").val();
              var $detalles = $("#detalles").val();
              
              //alert($nombreProfesor+$curso+$nombreAlumno+$lugar+$fecha+$detalles+$conductas);
              
               $.post("InsertaParte" , {nombreProfesor : $nombreProfesor ,
            	   curso : $curso , nombreAlumno : $nombreAlumno ,
            	   lugar : $lugar , fecha : $fecha ,
            	   detalles : $detalles , conductas : $conductas }
               , function (data) {
            	   
            	   alert(data);
            	   
               });
               
               
              
              
              
              
              
              
          });
          
          



 });

  </script>
</head>
<body>


	<c:if test = "${sessionScope.auth != 'yes' }" > 
		<c:redirect url="login.html" />
	</c:if>

<div id="wrapper">
  <h1>Sistema de gestion de partes IES La Marisma </h1>
  <p id="nombrecompleto" style="margin:0;padding:0;">${sessionScope.nombreCompleto}</p>
<div id="main">



<p>Selecciona curso:<select id="curso">
<option value="pordefecto">Selecciona curso</option>
</select></p>

<p>Selecciona alumnos<select id="alumnos">
<option>Selecciona Alumno</option>
</select></p>

<div class="clear"> </div>


<p> Fecha  <input type="text" id="datepicker"> </p>
<p> Lugar
<select id="lugar">
  <option> Seleccione Lugar </option>  
</select> </p>

<div id="antesDeConducta" class="clear"> </div>

<div class="clear"></div>
<p style="float:none"> Conductas seleccionadas </p>
<div id="conductas">

</div>

<div class="clear"></div>

<p style="text-align:center"> Detalles </p>
<textarea id="detalles" style="resize:none;width:70%;height:150px;"> </textarea>
<button id="enviar"> Enviar </button>

</div>

</div>

</body>
</html>