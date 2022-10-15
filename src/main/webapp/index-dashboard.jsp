<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<meta name="description" content="Responsive Admin &amp; Dashboard Template based on Bootstrap 5">
	<meta name="author" content="AdminKit">
	<meta name="keywords" content="adminkit, bootstrap, bootstrap 5, admin, dashboard, template, responsive, css, sass, html, theme, front-end, ui kit, web">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- GOOGLE FONTs -->
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    <!-- FONT AWESOME -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!-- ANIMATE CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="shortcut icon" href="img/icons/icon-48x48.png" />

	<link rel="canonical" href="https://demo-basic.adminkit.io/pages-blank.html" />

	<!-- Contenido dashboard -->
	<link rel="stylesheet" href="assets/css/style.css">

	<title>Inicio</title>

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

			<li class="sidebar-item active">
				<a class="sidebar-link" href="ventas?condicion=dashboard">
	  <i class="align-middle" data-feather="home"></i> <span class="align-middle">Inicio</span>
	</a>
			</li>
			<li class="sidebar-header">
				Usuarios
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="usuario?condicion=abrirPeticion">
	  <i class="align-middle" data-feather="user-plus"></i> <span class="align-middle">Peticiones</span>
	</a>
	<a class="sidebar-link" href="usuario?condicion=consultarUsuario">
		<i class="align-middle" data-feather="users"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Producto
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="producto?accion=Add_Producto">
	  <i class="align-middle" data-feather="clipboard"></i> <span class="align-middle">Agregar</span>
	</a>
			</li>
			<li class="sidebar-item">
	<a class="sidebar-link" href="producto?accion=listar">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Tipo de producto
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="tipoProducto?accion=Add_TipoProducto">
					<i class="align-middle" data-feather="clipboard"></i> <span class="align-middle">Agregar</span>
				</a>
						</li>
						<li class="sidebar-item">
				<a class="sidebar-link" href="tipoProducto?accion=listar">
					<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
				  </a>
						</li>
			<li class="sidebar-header">
				Compras
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="compras?accion=Add_Compras">
	  <i class="align-middle" data-feather="shopping-cart"></i> <span class="align-middle">Agregar</span>
	</a>
	<a class="sidebar-link" href="compras?accion=listar">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Ventas
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="ventas?condicion=formulario">
	  <i class="align-middle" data-feather="dollar-sign"></i> <span class="align-middle">Agregar</span>
	</a>
	<a class="sidebar-link" href="ventas?condicion=consultarventa">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Cliente
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="cliente?condicion=formulario">
	  <i class="align-middle" data-feather="user"></i> <span class="align-middle">Agregar</span>
	</a>
	<a class="sidebar-link" href="cliente?condicion=consultarCliente">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Proveedor
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="proveedor?condicion=formulario">

	  <i class="align-middle" data-feather="truck"></i> <span class="align-middle">Agregar</span>
	</a>
			</li>
		<li class="sidebar-item">
	<a class="sidebar-link" href="proveedor?condicion=consultarProveedor">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Salidas
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="#">
	  <i class="align-middle" data-feather="truck"></i> <span class="align-middle">Agregar</span>
	</a>
	<a class="sidebar-link" href="#">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>

		</ul>

		<div class="sidebar-cta">
			<div class="sidebar-cta-content">
				<div class="mb-3 text-sm">
				</div>
				<div class="d-grid">
					<a href="usuario?condicion=formulario" class="btn btn-primary">Cerrar seión</a>
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
							<a class="nav-icon dropdown-toggle" href="#" id="alertsDropdown" data-bs-toggle="dropdown">
								<div class="position-relative">
									<i class="align-middle" data-feather="bell"></i>
									<span class="indicator">4</span>
								</div>
							</a>
							<div class="dropdown-menu dropdown-menu-lg dropdown-menu-end py-0" aria-labelledby="alertsDropdown">
								<div class="dropdown-menu-header">
									4 New Notifications
								</div>
								<div class="list-group">
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-danger" data-feather="alert-circle"></i>\multiverso\usuario
											</div>
											<div class="col-10">
												<div class="text-dark">Update completed</div>
												<div class="text-muted small mt-1">Restart server 12 to complete the update.</div>
												<div class="text-muted small mt-1">30m ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-warning" data-feather="bell"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">Lorem ipsum</div>
												<div class="text-muted small mt-1">Aliquam ex eros, imperdiet vulputate hendrerit et.</div>
												<div class="text-muted small mt-1">2h ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-primary" data-feather="home"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">Login from 192.186.1.8</div>
												<div class="text-muted small mt-1">5h ago</div>
											</div>
										</div>
									</a>
									<a href="#" class="list-group-item">
										<div class="row g-0 align-items-center">
											<div class="col-2">
												<i class="text-success" data-feather="user-plus"></i>
											</div>
											<div class="col-10">
												<div class="text-dark">New connection</div>
												<div class="text-muted small mt-1">Christina accepted your request.</div>
											<div class="text-muted small mt-1">14h ago</div>
											</div>
										</div>
									</a>
								</div>
								<div class="dropdown-menu-footer">
									<a href="#" class="text-muted">Show all notifications</a>
								</div>
							</div>
						</li>
						<li class="nav-item dropdown">
							<a class="nav-icon dropdown-toggle d-inline-block d-sm-none" href="#" data-bs-toggle="dropdown">
                <i class="align-middle" data-feather="settings"></i>
              </a>

							<a class="nav-link dropdown-toggle d-none d-sm-inline-block" href="#" data-bs-toggle="dropdown">
                 <img src="assets/img/avatar.jpg" alt="" class="avatar img-fluid rounded me-1" /> <span class="text-dark">Nicolas Peraza</span>
              </a>
							<div class="dropdown-menu dropdown-menu-end">
								<a class="dropdown-item" href="pages-profile.html"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
								<div class="dropdown-divider"></div>
								<a class="dropdown-item" href="register.html">Log out</a>
							</div>
						</li>
					</ul>
				</div>
			</nav>

			         <!-- Logo Area -->
        <hr>
        <div class="logo-area text-center">
            <div class="container h-100">
                <div class="row h-100 align-items-center">
                    <div class="col-12">
                        <a href="index.jsp" class="original-logo"><img src="assets/img/multiversoo.jpeg" alt=""></a>
                    </div>
                </div>
            </div>
        </div>
        <hr>

        <div class="container">
            <div class="row">
                <div class="col-12 col-lg-9">
                    <!-- Single Blog Area  -->
                    <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.2s" data-wow-duration="1000ms">
                        <div class="row align-items-center">
                            <div class="col-12 col-md-6">
                                <div class="single-blog-thumbnail">
                                    <img src="assets/img/multiversoo.jpeg" alt="">
                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <!-- Blog Content -->
                                <div class="single-blog-content">
                                    <div class="line"></div>
                                    <a href="#" class="post-tag">¿Cómo agregar?</a>
                                    <h4><a href="#" class="post-headline">Está es una guía de como agregar datos</a></h4>
                                    <p>Curabitur venenatis efficitur lorem sed tempor. Integer aliquet tempor cursus. Nullam vestibulum convallis risus vel condimentum. Nullam auctor lorem in libero luctus, vel volutpat quam tincidunt.</p>
                                    <div class="post-meta">
                                        <p>By <a href="#">Michael Correa</a></p>
                                        <p>3 comments</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Single Blog Area  -->
                    <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.3s" data-wow-duration="1000ms">
                        <div class="row align-items-center">
                            <div class="col-12 col-md-6">
                                <div class="single-blog-thumbnail">
                                    <img src="assets/img/multiversoo.jpeg" alt="">
                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <!-- Blog Content -->
                                <div class="single-blog-content">
                                    <div class="line"></div>
                                    <a href="#" class="post-tag">¿Cómo ver datos en una tabla?</a>
                                    <h4><a href="#" class="post-headline">Está es una guía de como ver datos en una tabla</a></h4>
                                    <p>Curabitur venenatis efficitur lorem sed tempor. Integer aliquet tempor cursus. Nullam vestibulum convallis risus vel condimentum. Nullam auctor lorem in libero luctus, vel volutpat quam tincidunt.</p>
                                    <div class="post-meta">
                                        <p>By <a href="#">Michael Correa</a></p>
                                        <p>3 comments</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.5s" data-wow-duration="1000ms">
                        <div class="row align-items-center">
                            <div class="col-12 col-md-6">
                                <div class="single-blog-thumbnail">
                                    <img src="assets/img/multiversoo.jpeg" alt="">
                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <!-- Blog Content -->
                                <div class="single-blog-content">
                                    <div class="line"></div>
                                    <a href="#" class="post-tag">¿Cómo usar la página?</a>
                                    <h4><a href="#" class="post-headline">Está es una guía para usar bien la página</a></h4>
                                    <p>Curabitur venenatis efficitur lorem sed tempor. Integer aliquet tempor cursus. Nullam vestibulum convallis risus vel condimentum. Nullam auctor lorem in libero luctus, vel volutpat quam tincidunt.</p>
                                    <div class="post-meta">
                                        <p>By <a href="#">Michael Correa</a></p>
                                        <p>3 comments</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Single Blog Area  -->
                    <div class="single-blog-area blog-style-2 mb-50 wow fadeInUp" data-wow-delay="0.6s" data-wow-duration="1000ms">
                        <div class="row align-items-center">
                            <div class="col-12 col-md-6">
                                <div class="single-blog-thumbnail">
                                    <img src="assets/img/multiversoo.jpeg" alt="">
                                </div>
                            </div>
                            <div class="col-12 col-md-6">
                                <!-- Blog Content -->
                                <div class="single-blog-content">
                                    <div class="line"></div>
                                    <a href="#" class="post-tag">¿Quién es Multiverso?</a>
                                    <h4><a href="#" class="post-headline">Sobre Multiverso</a></h4>
                                    <p>Curabitur venenatis efficitur lorem sed tempor. Integer aliquet tempor cursus. Nullam vestibulum convallis risus vel condimentum. Nullam auctor lorem in libero luctus, vel volutpat quam tincidunt.</p>
                                    <div class="post-meta">
                                        <p>By <a href="#">Michael Correa</a></p>
                                        <p>3 comments</p>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <!-- Load More -->
                    <div class="load-more-btn mt-100 wow fadeInUp" data-wow-delay="0.7s" data-wow-duration="1000ms">
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

</body>

</html>