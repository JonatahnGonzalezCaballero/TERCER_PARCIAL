<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Clientes</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
<body>
	<header>
	<div>
	<img class="mx-auto d-block" src="https://thevideoclub.tv/wp-content/themes/videoclub/img/logo_videoclub_extra.png" width="200" height="200"/>
	</div>
	
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<div>
				<a href="user-list.jsp" class="navbar-brand"> ADMINISTRAR
					CLIENTES </a>
			</div>
			<ul class="navbar-nav">
				
				<li><a href="<%=request.getContextPath()%>/listUser"
					class="nav-link">VER CLIENTES</a></li>
				<li><a href="<%=request.getContextPath()%>/new"
					class="nav-link">INSERTAR CLIENTES</a></li>
			</ul>
			
			<div>
				<a href="peliculas-list.jsp" class="navbar-brand"> ADMINISTRAR
					PELICULAS </a>
			</div>
			<div>
				<a href="copias-list.jsp" class="navbar-brand"> ADMINISTRAR
					COPIAS </a>
			</div>
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success"
*ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">LISTA DE CLIENTES</h3>
			<hr>
			<div class="container text-center">
				<a href="<%=request.getContextPath()%>/new" class="btn
btn btn-outline-dark center">INSERTAR
					NUEVO CLIENTE</a>
			</div>
			<br>
			<table class="table  table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>NOMBRE</th>
						<th>E-MAIL</th>
						<th>DIRECCION</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="user" items="${listUser}">
						<tr>
							<td class="table-warning"><c:out value="${user.id}" /></td>
							<td class="table-dark"><c:out value="${user.name}" /></td>
							<td class="table-dark"><c:out value="${user.email}" /></td>
							<td class="table-dark"><c:out value="${user.country}" /></td>
							<td class="table-success"><a href="edit?id=<c:out value='${user.id}' />">EDITAR</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out
value='${user.id}' />">ELIMINAR</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
				
			</table>
		</div>
	</div>
</body>
</html>
