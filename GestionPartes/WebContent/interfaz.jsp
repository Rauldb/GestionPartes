<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; utf-8">
<title>Sistema de gestion de partes</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script>
    $(document).ready(function() {
    $('#curso').change(function(event) {    	
        var $curso=$("select#curso").val();
          $.post('ListaAlumnos',{curso:$curso},function(data) {   
        	  var $select = $('#alumnos');        
               $select.find('option').remove();                          
               $select.append(data);      
                    });
            });
       
    });          
</script>
</head>
<body>
<h1>AJAX calls to Servlet using JQuery and JSON</h1>
Selecciona curso:
<select id="curso">
<option>Selecciona curso</option>
<option value="1daw">1daw</option>
<option value="2daw">2daw</option>
</select>
<br/>
<br/>
Selecciona alumnos
<select id="alumnos">
<option>Selecciona alumnos</option>
</select>
</body>
</html>