<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Peliculas</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
</head>
<body>
	<header>
		<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
			<div>
				<a href="peliculas-list.jsp" class="navbar-brand"> ADMINISTRAR
					PELICULAS </a>
			</div>
			<ul class="navbar-nav">
				<li><a href="<%=request.getContextPath()%>/listPeliculas"
					class="nav-link">VER PELICULAS</a></li>
				<li><a href="<%=request.getContextPath()%>/new_peliculas"
					class="nav-link">INSERTAR PELICULAS</a></li>
			</ul>
			
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${peliculasm != null}">
					<form action="updatePeliculas" method="post">
				</c:if>
				<c:if test="${peliculasm == null}">
					<form action="insertPeliculas" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${peliculasm != null}">
 EDITAR PELICULAS
 </c:if>
						<c:if test="${peliculasm == null}">
 INSERTAR NUEVA PELICULA
 </c:if>
					</h2>
				</caption>
				<c:if test="${peliculasm != null}">
					<input type="hidden" name="id_pelicula"
						value="<c:out
value='${peliculasm.id_pelicula}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>TITULO</label> <input type="text"
						value="<c:out value='${peliculasm.titulo}' />" class="form-control"
						name="titulo" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>AÑO</label> <input type="text"
						value="<c:out value='${peliculasm.anio}' />" class="form-control"
						name="anio">
				</fieldset>
				<fieldset class="form-group">
					<label>CRITICA</label> <input type="text"
						value="<c:out value='${peliculasm.critica}' />" class="form-control"
						name="critica">
				</fieldset>
				<button type="submit" class="btn btn-primary">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>