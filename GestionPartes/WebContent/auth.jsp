<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%@include file="conexion.jsp"%>


	<c:set var="user" value="${param.usuario }" scope="session" />

	<sql:query dataSource="${conexion}" var="infousuario">
	
		select * from usuarios where nombre = ?;
		<sql:param value="${param['usuario']}"></sql:param>


	</sql:query>
	<c:forEach var="row" items="${infousuario.rows}">
	</c:forEach>
	
	<c:choose>
		
		<c:when test="${infousuario.rows[0].pass eq param.pass }">
		
		<c:out value="Tienes acceso"></c:out>
		<c:set var ="auth" value="yes" scope="session" />
		<c:set var="nombreCompleto" value="${infousuario.rows[0].nombrecompleto}" scope="session" /> 
		<c:redirect url="interfaz.jsp">
		</c:redirect>
		
		
		
		
		</c:when>
		
		<c:otherwise>
		
		<c:set var="reintenta" value="<a href='login.html'> intentarlo</a>" ></c:set>
	<c:out  escapeXml="false" value="Contraseña o usuario incorrecto , vuelva a ${reintenta}"></c:out>		
		</c:otherwise>
	
	
	</c:choose>








</body>
</html>