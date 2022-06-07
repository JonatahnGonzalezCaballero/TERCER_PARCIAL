<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Peliculas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
<body>
	<header>
	<div>
	<img class="mx-auto d-block" src="https://thevideoclub.tv/wp-content/themes/videoclub/img/logo_videoclub_extra.png" width="200" height="200"/>
	</div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div>
				<a href="peliculas-list.jsp" class="navbar-brand"> ADMINISTRAR
					PELICULAS </a>
			</div>
			<ul class="navbar-nav">
				
				<li><a href="<%=request.getContextPath()%>/listPeliculas"
					class="nav-link">VER PELICULAS</a></li>
				<li><a href="<%=request.getContextPath()%>/new_peliculas"
					class="nav-link">INSERTAR PELICULA</a></li>
			</ul>
			
			<div>
				<a href="user-list.jsp" class="navbar-brand"> ADMINISTRAR
					CLIENTES </a>
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
			<h3 class="text-center">LISTA DE PELICULAS</h3>
			<hr>
			<div class="container text-center">
				<a href="<%=request.getContextPath()%>/new_peliculas" class="btn
btn btn-outline-primary center">INSERTAR
					NUEVA PELICULA</a>
			</div>
			<br>
			<table class="table  table-hover">
				<thead>
					<tr>
						<th>ID</th>
						<th>TITULO</th>
						<th>AÑO</th>
						<th>CRTICA</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="peliculasm" items="${listPeliculas}">
						<tr>
							<td class="table-warning"><c:out value="${peliculasm.id_pelicula}" /></td>
							<td class="table-primary"><c:out value="${peliculasm.titulo}" /></td>
							<td class="table-primary"><c:out value="${peliculasm.anio}" /></td>
							<td class="table-primary"><c:out value="${peliculasm.critica}" /></td>
							<td class="table-success"><a href="editPeliculas?id_pelicula=<c:out value='${peliculasm.id_pelicula}' />">EDITAR</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="deletePeliculas?id_pelicula=<c:out
value='${peliculasm.id_pelicula}' />">ELIMINAR</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
				
			</table>
		</div>
	</div>
</body>
</html>