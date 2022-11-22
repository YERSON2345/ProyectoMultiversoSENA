<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<% if (session.getAttribute("Gerente") !=null || session.getAttribute("Operador") !=null) { %>
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
				<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

				<!-- GOOGLE FONTs -->
				<link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
				<!-- FONT AWESOME -->
				<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css"
					integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf"
					crossorigin="anonymous">
				<!-- ANIMATE CSS -->
				<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
				<link rel="preconnect" href="https://fonts.gstatic.com">
				<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

				<link rel="canonical" href="https://demo-basic.adminkit.io/pages-blank.html" />

				<!-- Contenido dashboard -->
				<link rel="stylesheet" href="assets/css/style.css">

				<title>Inicio</title>

				<link href="assets/css/app.css" rel="stylesheet">
				<link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;600&display=swap"
					rel="stylesheet">

				<!-- CDN Sweet alert(CSS) -->
				<link rel="stylesheet" href="assets/css/sweetalert.css">
				<!-- Función de leer más y leer menos (CSS) -->
				<link rel="stylesheet" href="assets/css/leer-mas-y-menos.css">

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

								<li class="sidebar-item active">
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
										<i class="align-middle" data-feather="database"></i> <span
											class="align-middle">Consultar</span>
									</a>
								</li>
								<li class="sidebar-header">
									Tipo de producto
								</li>

								<li class="sidebar-item">
									<a class="sidebar-link" href="tipoProducto?accion=Add_TipoProducto">
										<i class="align-middle" data-feather="clipboard"></i> <span
											class="align-middle">Agregar</span>
									</a>
								</li>
								<li class="sidebar-item">
									<a class="sidebar-link" href="tipoProducto?accion=listar">
										<i class="align-middle" data-feather="database"></i> <span
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
									<a class="sidebar-link" href="cliente?condicion=consultarCliente">
										<i class="align-middle" data-feather="database"></i> <span
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
										<i class="align-middle" data-feather="database"></i> <span
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
										<a href="srvUsuario?accion=cerrar" class="btn btn-primary">Cerrar sesión</a>
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
										<a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#"
											data-bs-toggle="dropdown">
											<i class="align-middle" data-feather="settings"></i>
										</a>

										<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#"
											data-bs-toggle="dropdown">
											<img src="assets/img/avatar.jpeg" class="avatar img-fluid rounded me-1"
												alt="Charles Hall" /> <span class="text-dark">${Gerente.nombreUsuario}
												${Gerente.apellidoUsuario}</span>
											<span class="text-dark">${Operador.nombreUsuario}
												${Operador.apellidoUsuario}</span>
										</a>
										<div class="dropdown-menu dropdown-menu-end">

											<div class="dropdown-divider"></div>
											<a class="dropdown-item" href="srvUsuario?accion=cerrar">Log out</a>
										</div>
									</li>
								</ul>
							</div>
						</nav>

						<!-- Logo Area -->
						<hr>
						<div class="logo-area text-center">
							<div class="container h-100">
								<h1 class="h3 mb-3">Bienvenido ${Gerente.nombreUsuario} ${Gerente.apellidoUsuario}
									${Operador.nombreUsuario} ${Operador.apellidoUsuario} </h1>
								<div class="row h-100 align-items-center">
									<div class="col-12">
										<a href="index.jsp" class="original-logo"><img src="assets/img/multiversoo.jpeg"
												alt=""><br><br></a>
									</div>
								</div>
							</div>
						</div>
						<hr>

						<br>
						<div class="container">
							<div class="row">
								<div class="col-12 col-lg-9">
									<h1>Ayuda para uar la página</h1><br>
									<!-- Single Blog Area  -->
									<div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.2s"
										data-wow-duration="1000ms">
										<div class="row align-items-center">
											<div class="col-12 col-md-6">
												<div class="single-blog-thumbnail">
													<video
														style="width: 400px; height:300px; float:right; margin-left:50px;"
														src="assets/img/videos/registrar-relaciones.mp4"
														controls></video>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<!-- Blog Content -->
												<div class="single-blog-content">
													<div class="line"></div>
													<a href="#" class="post-tag">¿Cómo agregar en tablas de varios
														datos?</a>
													<div>
														<input type="checkbox" class="read-more-state" id="post-1" />
														<h4><a href="#" class="post-headline">Está es una guía de como
																agregar datos de varias tablas</a></h4>
														<p class="read-more-wrap">En este video se muestra como se
															agregan datos de diferentes tablas.<br>
															Resumen del video:<br>
															1. Se buscan la tabla que se quiere agregar, los datos que
															se necesiten de otras tablas.<br>
															2. Se busca la tabla de la cual se necesitan los datos.<br>
															3. Encuentra la tabla y llena todos los datos que te pida
															para poder registrar un nuevo dato.<br>
															4. Regresa a la tabla y revisa si los datos, a ver si son
															coherentes con los agregados en la anterior tabla.<br></p>
														<br>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<!-- Single Blog Area  -->
									<div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.3s"
										data-wow-duration="1000ms">
										<div class="row align-items-center">
											<div class="col-12 col-md-6">
												<div class="single-blog-thumbnail">
													<video
														style="width: 400px; height:300px; float:right; margin-left:50px;"
														src="assets/img/videos/registrar-producto.mp4" controls></video>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<!-- Blog Content -->
												<div class="single-blog-content">
													<div class="line"></div>
													<a href="#" class="post-tag">¿Cómo agregar en tabla de producto?</a>
													<div>
														<input type="checkbox" class="read-more-state" id="post-1" />
														<h4><a href="#" class="post-headline">Está es una guía de como
																agregar en la tabla de producto</a></h4>
														<p class="read-more-wrap">En este video se muestra como agregar
															un nuevo producto.<br>
															Resumen del video:<br>
															1. Se buscan la tabla de producto, y se llenan los datos que
															se necesitan.<br>
															2. Se ve que halla un tipo de producto, si no agregar
															uno.<br>
															3. Si el producto vence se activa el botón de "Si el
															producto vence, click
															acá" y si no vence, se omite esa parte.<br>
															4. Por último se envían los datos.<br></p>
														<br>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.5s"
										data-wow-duration="1000ms">
										<div class="row align-items-center">
											<div class="col-12 col-md-6">
												<div class="single-blog-thumbnail">
													<video
														style="width: 400px; height:300px; float:right; margin-left:50px;"
														src="assets/img/videos/agregar-compra-venta-salida.mp4" controls></video>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<!-- Blog Content -->
												<div class="single-blog-content">
													<div class="line"></div>
													<a href="#" class="post-tag">¿Cómo agregar compra/venta/salida?</a>
													<div>
														<input type="checkbox" class="read-more-state" id="post-1" />
														<h4><a href="#" class="post-headline">Está es una guía de como
																agregar una compra/venta/salida</a></h4>
														<p class="read-more-wrap">En este video se muestra como se
															agregan una compra/venta/salida.<br>
															Resumen del video:<br>
															1. Antes de registrar una compra/venta/salida se debe tener
															registrado un producto y que este activo el producto.<br>
															2. Dependiendo de lo que se quiere registrar se buscan los
															datos de otras tablas que se necesiten.<br>
															3. Une vez con todos los datos que se necesiten rellenar
															todos los datos y registrar la compra/venta/salida.<br>
														</p>
														<br>
													</div>
												</div>
											</div>
										</div>
									</div>
									<br>
									<!-- Single Blog Area  -->
									<div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.6s"
										data-wow-duration="1000ms">
										<div class="row align-items-center">
											<div class="col-12 col-md-6">
												<div class="single-blog-thumbnail">
													<video
														style="width: 400px; height:300px; float:right; margin-left:50px;"
														src="assets/img/videos/Fecha V-Bajo S.mp4" controls></video>
												</div>
											</div>
											<div class="col-12 col-md-6">
												<!-- Blog Content -->
												<div class="single-blog-content">
													<div class="line"></div>
													<a href="#" class="post-tag">¿Cómo saber si un producto tiene bajo
														stock o fecha de vencimiento cercana?</a>
													<div>
														<input type="checkbox" class="read-more-state" id="post-1" />
														<h4><a href="#" class="post-headline">Está es una para saber si
																un producto tiene bajo stock o fecha de vencimiento
																cercana.</a></h4>
														<p class="read-more-wrap">En este video se muestra como saber si
															un producto tiene bajo stock o fecha de vencimiento
															cercana..<br>
															Resumen del video:<br>
															1. Si el producto tiene menos de 30 días de diferencia a la fecha actual saldra una notificación en la parte superior en el icono de el calendario el cual mostrará el producto con los días restantes para que venza.<br>
															2. Si el producto tiene menos de 10 cantidades saldra una notificación en la parte superior en el icono de la caja la cual mostrará la cantidad que halla de ese producto.<br></p>
														<br>
													</div>
												</div>
											</div>
										</div>
									</div>
								</div>

								<p></p>
								<p></p>
								<p></p>

								<!-- Load More -->
								<div class="load-more-btn mt-100 wow fadeInUp" data-wow-delay="0.7s"
									data-wow-duration="1000ms">
									<a href="#" class="btn original-btn">Read More</a>
								</div>
							</div>

							<!-- jQuery (Necessary for All JavaScript Plugins) -->
							<script src="assets/js/dashboard/jquery/jquery-2.2.4.min.js"></script>
							<!-- Popper js -->
							<script src="assets/js/dashboard/popper.min.js"></script>
							<!-- Bootstrap js -->
							<script src="assets/js/dashboard/bootstrap.min.js"></script>
							<!-- Plugins js -->
							<script src="assets/js/dashboard/plugins.js"></script>
							<!-- Active js -->
							<script src="assets/js/dashboard/active.js"></script>
							<!-- Plantilla anterior -->
							<script src="assets/js/app.js"></script>
							<!-- CDN SweetAlers(JavaScript) -->
							<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
							<!-- Alertas dashboard -->
							<script src="assets/js/alertas/alertadashboard.js"></script>

			</body>

			</html>

			<% } else { System.out.println("No ha iniciado sesión"); response.sendRedirect("usuario?condicion=login"); }
				%>