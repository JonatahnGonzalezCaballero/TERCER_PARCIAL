<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Copias</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.mi
n.css">
</head>
<body>
	<header>
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
		</nav>
	</header>
	<br>
	<div class="container col-md-5">
		<div class="card">
			<div class="card-body">
				<c:if test="${copiasm != null}">
					<form action="updateCopias" method="post">
				</c:if>
				<c:if test="${copiasm == null}">
					<form action="insertCopias" method="post">
				</c:if>
				<caption>
					<h2>
						<c:if test="${copiasm != null}">
 EDITAR COPIAS
 </c:if>
						<c:if test="${copiasm == null}">
 INSERTAR NUEVA COPIA
 </c:if>
					</h2>
				</caption>
				<c:if test="${copiasm != null}">
					<input type="hidden" name="n_copia"
						value="<c:out
value='${copiasm.n_copia}' />" />
				</c:if>
				<fieldset class="form-group">
					<label>DETERIORADA</label> <input type="text"
						value="<c:out value='${copiasm.deteriorada}' />" class="form-control"
						name="deteriorada" required="required">
				</fieldset>
				<fieldset class="form-group">
					<label>FORMATO</label> <input type="text"
						value="<c:out value='${copiasm.formato}' />" class="form-control"
						name="formato">
				</fieldset>
				<fieldset class="form-group">
					<label>PRECIO_ALQUILER</label> <input type="text"
						value="<c:out value='${copiasm.precio_alquiler}' />" class="form-control"
						name="precio_alquiler">
				</fieldset>
				<button type="submit" class="btn btn-danger">Save</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>