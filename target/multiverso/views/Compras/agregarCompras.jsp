<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

		<!DOCTYPE html>
		<html lang="en">

		<head>
			<meta charset="utf-8">
			<meta http-equiv="X-UA-Compatible" content="IE=edge">
			<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
			<meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
			<meta name="author" content="AdminKit">
			<meta name="keywords"
				content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">

			<!-- GOOGLE FONTs -->
			<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
			<!-- FONT AWESOME -->
			<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
				integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
				crossorigin="anonymous">
			<!-- ANIMATE CSS -->
			<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
			<link rel="preconnect" href="https://fonts.gstatic.com">
			<link rel="shortcut icon" href="../img/icons/icon-48x48.png" />

			<link rel="canonical" href="https://demo-basic.adminkit.io/pages-blank.html" />

			<!-- fecha vencimiento(CSS) -->
			<link rel="stylesheet" href="assets/css/fecha_vencimiento.css">

			<link rel="stylesheet" href="assets/css/filter.css">

			<title>Añadir Compra</title>

			<link href="assets/css/app.css" rel="stylesheet">
			<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">
		</head>

		<body>
			<div class="wrapper">
				<nav id="sidebar" class="sidebar js-sidebar">
					<div class="sidebar-content js-simplebar">
						<a class="sidebar-brand" href="index.jsp">
							<span class="align-middle">MULTIVERSO</span>
						</a>
						<ul class="sidebar-nav">
							<li class="sidebar-header">
								Inicio
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="ventas?condicion=dashboard">
									<i class="align-middle" data-feather="home"></i> <span
										class="align-middle">Inicio</span>
								</a>
							</li>
							<li class="sidebar-header">
								Usuarios
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="usuario?condicion=abrirPeticion">
									<i class="align-middle" data-feather="user-plus"></i> <span
										class="align-middle">Peticiones</span>
								</a>
								<a class="sidebar-link" href="usuario?condicion=consultarUsuario">
									<i class="align-middle" data-feather="users"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Producto
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="producto?accion=Add_Producto">
									<i class="align-middle" data-feather="clipboard"></i> <span
										class="align-middle">Agregar</span>
								</a>
							</li>
							<li class="sidebar-item">
								<a class="sidebar-link" href="producto?accion=listar">
									<i class="align-middle" data-feather="package"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Tipo de producto
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="tipoProducto?accion=Add_TipoProducto">
									<i class="align-middle" data-feather="plus"></i> <span
										class="align-middle">Agregar</span>
								</a>
							</li>
							<li class="sidebar-item">
								<a class="sidebar-link" href="tipoProducto?accion=listar">
									<i class="align-middle" data-feather="folder"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Compras
							</li>
							<li class="sidebar-item">
								<a class="sidebar-link" href="compras?accion=listar">
									<i class="align-middle" data-feather="database"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Ventas
							</li>
							<li class="sidebar-item">
								<a class="sidebar-link" href="ventas?condicion=consultarventa">
									<i class="align-middle" data-feather="database"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Cliente
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="cliente?condicion=formulario">
									<i class="align-middle" data-feather="user"></i> <span
										class="align-middle">Agregar</span>
								</a>
							</li>
							<li class="sidebar-item">
								<a class="sidebar-link" href="cliente?condicion=consultarCliente">
									<i class="align-middle" data-feather="list"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Proveedor
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="proveedor?condicion=formulario">

									<i class="align-middle" data-feather="truck"></i> <span
										class="align-middle">Agregar</span>
								</a>
							</li>
							<li class="sidebar-item">
								<a class="sidebar-link" href="proveedor?condicion=consultarProveedor">
									<i class="align-middle" data-feather="archive"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>
							<li class="sidebar-header">
								Salidas
							</li>

							<li class="sidebar-item">
								<a class="sidebar-link" href="salidas?condicion=consultarSalidas">
									<i class="align-middle" data-feather="database"></i> <span
										class="align-middle">Consultar</span>
								</a>
							</li>

						</ul>

						<div class="sidebar-cta">
							<div class="sidebar-cta-content">
								<div class="mb-3 text-sm">
								</div>
								<div class="d-grid">
									<a href="usuario?condicion=formulario" class="btn btn-primary">Cerrar sesión</a>
								</div>
							</div>
						</div>
					</div>
				</nav>
				<div class="main">
					<nav class="navbar navbar-expand navbar-light navbar-bg">
						<a class="sidebar-toggle js-sidebar-toggle">
							<i class="hamburger align-self-center"></i>
						</a>

						<div class="navbar-collapse collapse">
							<ul class="navbar-nav navbar-align">
								<li class="nav-item dropdown">
									<a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown"
										data-bs-toggle="dropdown">
										<div class="position-relative">
											<i class="align-middle" data-feather="bell"></i>
											<span class="indicator">!</span>
										</div>
									</a>
									<div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0"
										aria-labelledby="alertsDropdown">
										<div class="dropdown-menu-header">
											 New Notifications
										</div>
										<div class="list-group">
											<a href="#" class="list-group-item">
												<div class="row g-0 align-items-center">
													<c:forEach var="producto" items="${productos}">
														<div class="col-2">
															<i class="text-danger" data-feather="alert-circle"></i>
														</div>
														<div class="col-8">
															<div class="text-dark">Producto A Vencerse</div>
															<div class="text-muted small mt-1">El producto
																${producto.getNombreProducto()} está a
																${producto.getDIFERENCIA_DIAS()} días de vencerse.
															</div>
														</div>
														<br>
														<hr>
													</c:forEach>
												</div>
											</a>
											</div>
									</div>
								</li>
								<li class="nav-item dropdown">
									<a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#"
										data-bs-toggle="dropdown">
										<i class="align-middle" data-feather="settings"></i>
									</a>

									<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#"
										data-bs-toggle="dropdown">
										<img src="assets/img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1"
											alt="Charles Hall" /> <span class="text-dark">Nicolas Peraza</span>
									</a>
									<div class="dropdown-menu dropdown-menu-end">
										<a class="dropdown-item" href="pages-profile.html"><i class="align-middle me-1"
												data-feather="user"></i> Profile</a>
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="usuario?condicion=formulario">Log out</a>
									</div>
								</li>
							</ul>
						</div>
					</nav>

					<div class="content">

						<div class="contact-wrapper animated bounceInUp">
							<div class="contact-form">
								<h3>Agregar Compras</h3>
								<form action="compras" method="post" class="needs-validation" novalidate>
									<c:forEach var="compras" items="${compras}">
									ID Producto: ${compras.getIdProducto()}<br>
									Nombre Producto: ${compras.getNombreProducto()}<br>
                                    Observaciones: ${compras.getObservacionesProducto()}<br>
      								Precio: ${compras.getprecioProducto()}<br>
      								Cantidad: ${compras.getcantidadProducto()}<br>
	  								Tipo Producto: ${compras.getNombreTipoProducto()}<br>
									<p>
										<input type="hidden" name="cantidadProducto"  class="form-control" value="${compras.getcantidadProducto()}">
										<input type="hidden" name="idProducto"  class="form-control" value="${compras.getIdProducto()}">

									</c:forEach>
									<div class="form-group">
										<label for="validationCustom01 observaciones" class="font-weight-bold">N°
											Orden<span class="text-danger">*</span></label>
										<div class="col-sm-10">
											<input type="number" id="validationCustom01" name="noOrdenCompra"
												placeholder="N° Orden" class="form-control" required>
											<div class="valid-feedback">
												¡Numero de Orden insertado con éxito!
											</div>
											<div class="invalid-feedback">
												Por favor, coloque el Numero de Orden.
											</div>
										</div>
									</div>
									</p>
									<p>
									<div class="form-group dropdown">
										<label for="validationCustom01 observaciones" class="font-weight-bold">Fecha De
											la compra<span class="text-danger">*</span>
										<div class="col-sm-10">
												<input type="date" name="fecha" id="validationCustom01" placeholder="Fecha De la compra" class="form-control">									  
											<div class="valid-feedback">
												¡Fecha de La Compra insertado con éxito!
											</div>
											<div class="invalid-feedback">
												Por favor, coloque la Fecha de La Compra.
											</div>
										</div>
									</div>
									<br>
									<div class="form-group dropdown">
										<label for="validationCustom01 observaciones" class="font-weight-bold">Precio
											del Proveedor<span class="text-danger">*</span>
										<div class="col-sm-10">
												<input type="number" name="precioProveedor" id="validationCustom01" placeholder="Precio Del Proveedor" class="form-control" required>
											  </div>
											<div class="valid-feedback">
												¡Precio del Proveedor insertado con éxito!
											</div>
											<div class="invalid-feedback">
												Por favor, coloque Precio del Proveedor.
											</div>
										</div>
									</div>
									</p>
									<br>
									<p>
									<div class="form-group">
										<label for="validationCustom01 observaciones" class="font-weight-bold">Cantidad
											Del Producto<span class="text-danger">*</span></label>
										<div class="col-sm-10">
											<input type="number" id="validationCustom01" name="entradaCompras"
												placeholder="Cantidad De la Compra" class="form-control" required>
											<div class="valid-feedback">
												¡Cantidad del Producto insertado con éxito!
											</div>
											<div class="invalid-feedback">
												Por favor, coloque la Cantidad del Producto.
											</div>
										</div>
									</div>
									</p>
									<p>
									</p>
									
									<div class="col-md-3">
										<label class="form-label">Proveedro del
											Producto</label>
										<select class="form-select select" id="noDocCliente "
											name="idProveedor">
											<option selected disabled value="">Seleccione</option>
											<c:forEach var="idProveedor" items="${idProveedor}">
												<option value="${idProveedor.getIdProveedor()}">
													${idProveedor.getNombreProveedor()}</option>
											</c:forEach>
										</select>
										<br>
										<p>También puedes buscar por acá</p>
					  					<input type="text" id="input-prueba">
									</div>
									<p>
									</p>
									<p class="block">
										<button class="btn btn-primary width-100" name="accion"
											value="Registrar">Enviar</button>
									</p>
								</form>
							</div>
						</div>

					</div>

					<footer class="footer">
						<div class="container-fluid">
							<div class="row text-muted">
								<div class="col-6 text-start">
									<p class="mb-0">
										<a class="text-muted" href="https://adminkit.io/"
											target="_blank"><strong>Multiverso</strong></a> &copy;
									</p>
								</div>
							</div>
						</div>
					</footer>
				</div>
			</div>

			<script src="assets/js/app.js"></script>

			<script>
				(function () {
					'use strict'

					var forms = document.querySelectorAll('.needs-validation')

					Array.prototype.slice.call(forms)
						.forEach(function (form) {
							form.addEventListener('submit', function (event) {
								if (!form.checkValidity()) {
									event.preventDefault()
									event.stopPropagation()
								}

								form.classList.add('was-validated')
							}, false)
						})
				})()
			</script>

			<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
			<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js"></script>
			<script src="assets/js/fecha_vencimiento.js"></script>

			<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
			<script src="assets/js/filter.js"></script>

		</body>