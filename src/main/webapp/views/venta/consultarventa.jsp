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

			<link rel="preconnect" href="https://fonts.gstatic.com">
			<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

			<title>Consultar Venta</title>
			<link rel="stylesheet" href="assets/css/app.css">
			<link rel="stylesheet" href="assets/css/jquery.dataTables.min.css">
			<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap" rel="stylesheet">

			<!-- Dark-mode (CSS) -->
			<link rel="stylesheet" href="assets/css/dark-mode.css">
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
							<li class="sidebar-item active">
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
											<i class="align-middle" data-feather="package"></i>
											<c:forEach var="producto" items="${productossss}">
											<span class="indicator">${producto.getcantidad()}</span>
										</c:forEach>
										</div>
									</a>
									<div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0"
										aria-labelledby="alertsDropdown">
										<c:forEach var="producto" items="${productossss}">
										<div class="dropdown-menu-header">
											${producto.getcantidad()}-Notifications
										</div>
										</c:forEach>
										<div class="list-group">
											<a href="#" class="list-group-item">
												<div class="row g-0 align-items-center">
													<c:forEach var="producto" items="${productosss}">
														<div class="col-2">
															<i class="text-warning" data-feather="bell"></i>
														</div>
														<div class="col-8">
															<div class="text-dark">Producto Con Baja Cantidad</div>
															<div class="text-muted small mt-1">El producto ${producto.getNombreProducto()} tiene ${producto.getCantidadProducto()} de cantidad.
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

								
						<div class="navbar-collapse collapse">
							<ul class="navbar-nav navbar-align">
								<li class="nav-item dropdown">
									<a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown"
										data-bs-toggle="dropdown">
										<div class="position-relative">
											<i class="align-middle" data-feather="calendar"></i>
											<c:forEach var="producto" items="${productoss}">
												<span class="indicator">${producto.getcantidadRegistros()}</span>
											</c:forEach>
										</div>
									</a>
									<div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0"
										aria-labelledby="alertsDropdown">
										<c:forEach var="producto" items="${productoss}">
											<div class="dropdown-menu-header">
												${producto.getcantidadRegistros()}-Notifications
											</div>
										</c:forEach>
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
										<img src="assets/img/avatar.jpeg" class="avatar img-fluid rounded me-1"
											alt="Charles Hall" /> <span class="text-dark">${Gerente.nombreUsuario} ${Gerente.apellidoUsuario}</span>
											<span class="text-dark">${Operador.nombreUsuario} ${Operador.apellidoUsuario}</span>
									</a>
									<div class="dropdown-menu dropdown-menu-end">
										
										<div class="dropdown-divider"></div>
										<a class="dropdown-item" href="srvUsuario?accion=cerrar">Log out</a>
									</div>
								</li>
							</ul>
						</div>
					</nav>

					<main class="content">
						<div class="container-fluid p-0">

							<h1 class="h3 mb-3">Consultar Ventas</h1>
							<a href="#">									
								<button class="modo" id="modo">
								<span id="span1"></span>
								<span id="span2"></span>
								<span id="span3"></span>
								<span id="span4"></span>
								Modo ☀️/☽
							</button></a>
							<div class="" id="prueba">
								<div class="row">
									<div class="col-12">
										<div class="card">
											<div class="card-header">
												<div class="datatable-container">
													<div class="header-tools">
														<div class="tools">
															<ul>
																<li>
																	<br><br>
																</li>
															</ul>
														</div>
													</div>

													<table class="datatable" id="datatable">
														<thead>
															<tr>
																<th>
																	<p class="white"></p>
																</th>
																<th>
																	<p class="white">Cantidad vendida</p>
																</th>
																<th>
																	<p class="white">Precio Total</p>
																</th>
																<th>
																	<p class="white">Producto</p>
																</th>
																<th>
																	<p class="white">No doc Cliente</p>
																</th>
																<th>
																	<p class="white">Nombre del cliente</p>
																</th>
																<th>
																	<p class="white">Cantidad del Producto</p>
																</th>
																<th>
																	<p class="white">Acciones</p>
																</th>
															</tr>
														</thead>

														<tbody>
															<c:forEach var="ventas" items="${ventas}">
																<tr>
																	<td>
																		<p class="white"></p>
																	</td>
																	<td>
																		<p class="white">${ventas.getCantidadVendida()}
																		</p>
																	</td>
																	<td>
																		<p class="white">${ventas.getPrecioTotal()}</p>
																	</td>
																	<td>
																		<p class="white">${ventas.getNombreProducto()}
																		</p>
																	</td>
																	<td>
																		<p class="white">${ventas.getNoDocCliente()}</p>
																	</td>
																	<td>
																		<p class="white">${ventas.getNombreCliente()}
																		</p>
																	</td>
																	<td>
																		<p class="white">${ventas.getcantidadProducto()}
																		</p>
																	</td>
																	<td class="text-left">
																		<p class="white">
																			<a
																				href="ventas?condicion=editar&id=${ventas.getIdDetalleVenta()}&cantidadActualProducto=${ventas.getcantidadProducto()}&cantidadDescontada=${ventas.getCantidadVendida()}">
																				<button
																					class="btn btn-primary">Actualizar</button>
																			</a>
																		</p>
																	</td>
																</tr>
															</c:forEach>
														</tbody>
													</table>
												</div>
											</div>
											<div class="card-body">
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</main>

					<footer class="footer">
						<div class="container-fluid">
							<div class="row text-muted">
								<div class="col-6 text-start">
									<p class="mb-0">
										<a class="text-muted" href="#" target="_blank"><strong>Multiverso</strong></a>
										&copy;
									</p>
								</div>
							</div>
						</div>
					</footer>
				</div>
			</div>

			<!-- Estilos de tabla -->
			<style>
				.dataTables_length {
					padding-left: 30px;
					padding-top: 15px;
					width: 45%;
				}

				.dataTables_filter {
					margin-right: 15px;
					float: right;
					width: 30%;
				}

				.datatable-container .dataTables_wrapper .dataTables_filter label input {
					margin-top: 10px;
					width: 75%;
					background-color: var(--dt-input-background-color);
					box-sizing: border-box;
					border-radius: var(--dt-border-radius);
					border: solid 1px var(--dt-border-color);
					color: var(--dt-input-color);
				}

				.dataTables_info {
					padding-left: 15px;
					padding-top: 10px;
					padding-bottom: 10px;
				}

				.dataTables_paginate {
					float: left;
					padding-bottom: 15px;
					padding-right: 30px;
					padding-top: 30px;

				}

				select {
					font-size: 16px;
					width: 60px;
					font-family: 'Verdana', sans-serif;
					font-weight: 400;
					color: #444;
					line-height: 1.3;
					max-width: 100%;
					box-sizing: border-box;
					border: 0px solid #aaa;
					box-shadow: 0 1px 0 1px rgba(0, 0, 0, .03);
					border-radius: .3em;
					-moz-appearance: none;
					-webkit-appearance: none;
					appearance: none;
					background-color: #fff;
					background-image: url('data:image/svg+xml;charset=US-ASCII,%3Csvg%20xmlns%3D%22http%3A%2F%2Fwww.w3.org%2F2000%2Fsvg%22%20width%3D%22292.4%22%20height%3D%22292.4%22%3E%3Cpath%20fill%3D%22%23007CB2%22%20d%3D%22M287%2069.4a17.6%2017.6%200%200%200-13-5.4H18.4c-5%200-9.3%201.8-12.9%205.4A17.6%2017.6%200%200%200%200%2082.2c0%205%201.8%209.3%205.4%2012.9l128%20127.9c3.6%203.6%207.8%205.4%2012.8%205.4s9.2-1.8%2012.8-5.4L287%2095c3.5-3.5%205.4-7.8%205.4-12.8%200-5-1.9-9.2-5.5-12.8z%22%2F%3E%3C%2Fsvg%3E'),
						linear-gradient(to bottom, #ffffff 0%, #f7f7f7 100%);
					background-repeat: no-repeat, repeat;
					background-position: right .7em top 50%, 0 0;
					background-size: .65em auto, 100%;
				}

				.datatable-container {
					width: 900px;
				}

				/* Botón de dark-mode */
				.modo {
					position: relative;
					display: inline-block;
					padding: 15px 30px;
					color: #fff;
					background-color: #000;
					letter-spacing: 4px;
					font-size: 12px;
					text-decoration: none;
					overflow: hidden;
					transition: 0.5s;
				}

				.modo:hover {
					background: white;
					color: #000;
					box-shadow: 0 0 10px gray, 0 0 40px gray, 0 0 80px gray;
					transition: 3.5s;
				}

				.modo span {
					position: absolute;
					display: block;
				}

				#span1 {
					top: 0;
					left: -100%;
					width: 100%;
					height: 2px;
					background: linear-gradient(90deg, transparent, #a945c7);
				}

				.modo:hover #span1 {
					left: 100%;
					transition: 1s;
				}

				#span3 {
					bottom: 0;
					right: -100%;
					width: 100%;
					height: 2px;
					background: linear-gradient(270deg, transparent, #a945c7);
				}

				.modo:hover #span3 {
					right: 100%;
					transition: 1s;
					transition-delay: 0.5s;
				}

				#span2 {
					top: -100%;
					right: 0;
					width: 2px;
					height: 100%;
					background: linear-gradient(180deg, transparent, #a945c7);
				}

				.modo:hover #span2 {
					top: 100%;
					transition: 1s;
					transition-delay: 0.25s;
				}

				#span4 {
					bottom: -100%;
					left: 0;
					width: 2px;
					height: 100%;
					background: linear-gradient(360deg, transparent, #a945c7);
				}

				.modo:hover #span4 {
					bottom: 100%;
					transition: 1s;
					transition-delay: 0.75s;
				}


				:root {
					--primary-color: white;
					--secondary-color: #2a3338;
					--highlight-color: #3282b8;

					--dt-status-available-color: greenyellow;
					--dt-status-away-color: lightsalmon;
					--dt-status-offline-color: lightgray;

					--dt-padding: 12px;
					--dt-padding-s: 6px;
					--dt-padding-xs: 2px;

					--dt-border-radius: 3px;

					--dt-background-color-container: #1f232b;
					--dt-border-color: var(--secondary-color);
					--dt-bg-color: var(--highlight-color);
					--dt-text-color: var(--primary-color);
					--dt-bg-active-button: var(--highlight-color);
					--dt-text-color-button: var(--primary-color);
					--dt-text-color-active-button: var(--primary-color);
					--dt-hover-cell-color: var(--highlight-color);
					--dt-even-row-color: var(--secondary-color);
					--dt-focus-color: var(--highlight-color);
					--dt-input-background-color: var(--secondary-color);
					--dt-input-color: var(--primary-color);
				}

				/* ICONOS */

				.material-icons {
					font-size: 16px;
				}

				/* HEADER (ENCABEZADO) */

				.datatable-container {
					font-family: 'Noto Sans', sans-serif;
					background-color: var(--dt-background-color-container);
					border-radius: var(--dt-border-radius);
					color: var(--dt-text-color);
					width: 850px;
					margin: 0 auto;
					font-size: 12px;
				}

				.datatable-container .header-tools {
					border-bottom: 1px solid black;
					padding: var(--dt-padding);
					display: flex;
					align-items: baseline;
				}

				.datatable-container .header-tools .tools {
					width: 70%;
				}

				.datatable-container .header-tools .tools ul {
					margin: 0;
					padding: 0;
					display: flex;
					justify-content: start;
					align-items: baseline;
				}

				.datatable-container .header-tools .tools ul li {
					display: inline-block;
					margin: 0 var(--dt-padding-xs);
					align-items: baseline;
				}

				/* FOOTER (PIES) */

				.datatable-container .footer-tools {
					padding: var(--dt-padding);
					display: flex;
					align-items: baseline;
				}

				.datatable-container .footer-tools .list-items {
					width: 50%;
				}

				.datatable-container .footer-tools .pages {
					margin-left: auto;
					margin-right: 0;
					width: 50%;
				}

				.datatable-container .footer-tools .pages ul {
					margin: 0;
					padding: 0;
					display: flex;
					align-items: baseline;
					justify-content: flex-end;
				}

				.datatable-container .footer-tools .pages ul li {
					display: inline-block;
					margin: 0 var(--dt-padding-xs);
				}

				/* TABLA (CUERPO) */

				.datatable-container .datatable {
					border-collapse: collapse;
					width: 100%;
				}

				.datatable-container .datatable,
				.datatable-container .datatable th,
				.datatable-container .datatable td {
					padding: var(--dt-padding) var(--dt-padding);
				}

				.datatable-container .datatable th {
					font-weight: bolder;
					text-align: left;
					border-bottom: 1px solid black;
				}

				.datatable-container .datatable td {
					border-bottom: 1px solid black;
				}

				.datatable-container .datatable tbody tr:nth-child(even) {
					background-color: var(--dt-even-row-color);
				}

				.datatable-container .datatable tbody tr:hover {
					background-color: var(--dt-hover-cell-color);
				}

				/* COLUMNA ESTADO */

				.datatable-container .datatable tbody tr .available::after,
				.datatable-container .datatable tbody tr .away::after,
				.datatable-container .datatable tbody tr .offline::after {
					display: inline-block;
					vertical-align: middle;
				}

				.datatable-container .datatable tbody tr .available::after {
					content: 'Online';
					color: var(--dt-status-available-color);
				}

				.datatable-container .datatable tbody tr .away::after {
					content: 'Away';
					color: var(--dt-status-away-color);
				}

				.datatable-container .datatable tbody tr .offline::after {
					content: 'Offline';
					color: var(--dt-status-offline-color);
				}

				.datatable-container .datatable tbody tr .available::before,
				.datatable-container .datatable tbody tr .away::before,
				.datatable-container .datatable tbody tr .offline::before {
					content: '';
					display: inline-block;
					width: 10px;
					height: 10px;
					margin-right: 10px;
					border-radius: 50%;
					vertical-align: middle;
				}

				.datatable-container .datatable tbody tr .available::before {
					background-color: var(--dt-status-available-color);
				}

				.datatable-container .datatable tbody tr .away::before {
					background-color: var(--dt-status-away-color);
				}

				.datatable-container .datatable tbody tr .offline::before {
					background-color: var(--dt-status-offline-color);
				}
			</style>

			<script src="assets/js/app.js"></script>
			<script src="assets/js/jquery-3.3.1.min.js"></script>

			<!-- Datatables -->
			<script type="text/javascript" charset="utf8"
				src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.js"></script>

			<script>
				$(document).ready(function () {
					$('#datatable').DataTable({
						language: {
							processing: "Cargando...",
							search: "Buscar:",
							lengthMenu: "Hay un total de _MENU_ tablas en el menú.",
							info: "Hay _START_ de _END_ resultados ahora mismo (cantidad total de resultados _TOTAL_).",
							infoEmpty: "Hay 0 de 0 tablas ahora mismo",
							infoFiltered: "(La cantidad máxima de tablas es _MAX_)",
							infoPostFix: "",
							loadingRecords: "Carga en curso...",
							zeroRecords: "No hemos podidos encontrar ningún resultado a su busqueda.",
							emptyTable: "No hemos encontrado ningún resultado.",
							paginate: {
								first: "Siguiente",
								previous: "Atrás",
								next: "Siguiente",
								last: "Dernier"
							},
							aria: {
								sortAscending: ": activer pour trier la colonne par ordre croissant",
								sortDescending: ": activer pour trier la colonne par ordre décroissant"
							}
						}
					});
				});
			</script>
			<!-- Compiled and minified JavaScript -->
			<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
			<!-- Darkmode -->
			<script src="assets/js/dark-mode.js"></script>

		</body>

		</html>