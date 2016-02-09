<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="UTF-8">
  <title>Document</title>
  <link rel="stylesheet" href="https://ajax.googleapis.com/ajax/libs/jqueryui/1.11.4/themes/smoothness/jquery-ui.css">
  <link rel="stylesheet" href="css/anytime.5.1.2.css">  
  <link rel="stylesheet" href="css/formulario.css">
  <script src="http://code.jquery.com/jquery-latest.min.js"></script>
  <script src="js/anytime.5.1.2.js"></script>
  
  <script>
      $(document).ready(function() {
    	  
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
      
      $.get('ListaLugares' , {} ,  function (data) {
    	 var $select = $('#lugar');
    	 $select.append(data);
      });
      
     
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

     $("#conductas").append($cond);

     }
     $("p > button").click(function(event) {
       $(this).parent().remove();

     });

   });
          $("#enviar").click(function(event) {
              
              $nombreProfesor = $("#nombrecompleto").html();
              $curso = $("#curso").html();
              $nombreAlumno = $("#alumnos").html();
              $lugar = $("#lugar").html();
              $fecha = $("#datepicker").html();
              
              
          });
          
          



 });

  </script>
</head>
<body>
<div id="wrapper">
  <h1>Sistema de gestion de partes IES La Marisma </h1>
  <p id="nombrecompleto" style="margin:0;padding:0;"><%= request.getParameter("nombrecompleto") %></p>
<div id="main">


<form action = "GuardaParte" method="post">
<p>Selecciona curso:<select id="curso">
<option value="pordefecto">Selecciona curso</option>
<option value="1daw">1daw</option>
<option value="2daw">2daw</option>
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

<div class="clear"> </div>

<p class="conducta"> Conductas leves <br><select class="selectcond" id="leves">
  <option value="pordefecto"> Seleccione conducta </option>
  <option> Vestimenta Inadecuada </option>
  <option> Traer objetos peligrosos al centro </option>
</select> </p>




<p class="conducta"> Conductas generales leves<br> <select class="selectcond" id="generales">
  <option value="pordefecto"> Seleccione conducta </option>
  <option> Dificultar el estudio a sus compañeros </option>
  <option> Conductas o gestos obscenos </option>
</select> </p>


<p class="conducta"> Conductas graves<br> <select class="selectcond" id="graves">
  <option value="pordefecto"> Seleccione conducta </option>
  <option> Vejaciones o humillaciones </option>
  <option> Amenazas o coacciones </option>
</select> </p>

<div class="clear"></div>
<p style="float:none"> Conductas seleccionadas </p>
<div id="conductas">

</div>

<div class="clear"></div>

<p style="text-align:center"> Detalles </p>
<textarea id="detalles" style="resize:none;width:70%;height:150px;"> </textarea>
<input type="submit">  <input type="reset">
</form>
</div>

</div>

</body>
</html>