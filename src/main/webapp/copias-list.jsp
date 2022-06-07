<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Copias</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
<body>
	<header>
	<div>
	<img class="mx-auto d-block" src="https://thevideoclub.tv/wp-content/themes/videoclub/img/logo_videoclub_extra.png" width="200" height="200"/>
	</div>
		<nav class="navbar navbar-expand-lg navbar-dark bg-danger">
			<div>
				<a href="copias-list.jsp" class="navbar-brand"> ADMINISTRAR
					COPIAS </a>
			</div>
			<ul class="navbar-nav">
				
				<li><a href="<%=request.getContextPath()%>/listCopias"
					class="nav-link">VER COPIAS</a></li>
				<li><a href="<%=request.getContextPath()%>/new_copias"
					class="nav-link">INSERTAR COPIAS</a></li>
			</ul>
			
			<div>
				<a href="peliculas-list.jsp" class="navbar-brand"> ADMINISTRAR
					PELICULAS </a>
			</div>
			<div>
				<a href="user-list.jsp" class="navbar-brand"> ADMINISTRAR
					CLIENTES </a>
			</div>
			
		</nav>
	</header>
	<br>
	<div class="row">
		<!-- <div class="alert alert-success"
*ngIf='message'>{{message}}</div> -->
		<div class="container">
			<h3 class="text-center">LISTA DE COPIAS</h3>
			<hr>
			<div class="container text-center">
				<a href="<%=request.getContextPath()%>/new_copias" class="btn
btn btn-outline-danger center">INSERTAR
					NUEVA COPIA</a>
			</div>
			<br>
			<table class="table  table-hover">
				<thead>
					<tr>
						<th># COPIA</th>
						<th>DETERIORADA</th>
						<th>FORMATO</th>
						<th>PRECIO ALQUILER</th>
					</tr>
				</thead>
				<tbody>
					<!-- for (Todo todo: todos) { -->
					<c:forEach var="copiasm" items="${listCopias}">
						<tr >
							<td class="table-warning"><c:out value="${copiasm.n_copia}" /></td>
							<td class="table-danger"><c:out value="${copiasm.deteriorada}" /></td>
							<td class="table-danger"><c:out value="${copiasm.formato}" /></td>
							<td class="table-danger"><c:out value="${copiasm.precio_alquiler}" /></td>
							<td class="table-success"><a href="editCopias?n_copia=<c:out value='${copiasm.n_copia}' />">EDITAR</a>
								&nbsp;&nbsp;&nbsp;&nbsp; <a href="deleteCopias?n_copia=<c:out
value='${copiasm.n_copia}' />">ELIMINAR</a></td>
						</tr>
					</c:forEach>
					<!-- } -->
				</tbody>
				
			</table>
		</div>
	</div>
</body>
</html>
