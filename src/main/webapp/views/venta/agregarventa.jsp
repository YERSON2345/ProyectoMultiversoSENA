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

    <!-- GOOGLE FONTs -->
    <link href="https://fonts.googleapis.com/css?family=Quicksand" rel="stylesheet">
    <!-- FONT AWESOME -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.1/css/all.css" integrity="sha384-50oBUHEmvpQ+1lW4y57PTFmhCaXp0ML5d60M1M7uH2+nqUivzIebhndOJK28anvf" crossorigin="anonymous">
    <!-- ANIMATE CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/animate.css/3.7.0/animate.min.css">
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link rel="shortcut icon" href="../img/icons/icon-48x48.png" />
	<!-- BOOSTRAP VALIDACIÓN -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" ></script>

	<link rel="canonical" href="https://demo-basic.adminkit.io/pages-blank.html" />

	<title>Añadir Venta</title>

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
		<i class="align-middle" data-feather="package"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Tipo de producto
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="tipoProducto?accion=Add_TipoProducto">
					<i class="align-middle" data-feather="plus"></i> <span class="align-middle">Agregar</span>
				</a>
						</li>
						<li class="sidebar-item">
				<a class="sidebar-link" href="tipoProducto?accion=listar">
					<i class="align-middle" data-feather="folder"></i> <span class="align-middle">Consultar</span>
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

			<li class="sidebar-item active">
				<a class="sidebar-link" href="ventas?condicion=formulario">
	  <i class="align-middle" data-feather="dollar-sign"></i> <span class="align-middle">Agregar</span>
	</a>
			</li>
			<li class="sidebar-item">
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
			</li>
			<li class="sidebar-item">
	<a class="sidebar-link" href="cliente?condicion=consultarCliente">
		<i class="align-middle" data-feather="list"></i> <span class="align-middle">Consultar</span>
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
		<i class="align-middle" data-feather="archive"></i> <span class="align-middle">Consultar</span>
	  </a>
			</li>
			<li class="sidebar-header">
				Salidas
			</li>

			<li class="sidebar-item">
				<a class="sidebar-link" href="salidas?condicion=formulario">
	  <i class="align-middle" data-feather="x-square"></i> <span class="align-middle">Agregar</span>
	</a>
			</li>

	<a class="sidebar-link" href="salidas?condicion=consultarSalidas">
		<i class="align-middle" data-feather="database"></i> <span class="align-middle">Consultar</span>
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
												<i class="text-danger" data-feather="alert-circle"></i>
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
                <img src="assets/img/avatars/avatar.jpg" class="avatar img-fluid rounded me-1" alt="Charles Hall" /> <span class="text-dark">Nicolas Peraza</span>
              </a>
							<div class="dropdown-menu dropdown-menu-end">
								<a class="dropdown-item" href="pages-profile.html"><i class="align-middle me-1" data-feather="user"></i> Profile</a>
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
                <h3>Agregar venta</h3>
                <form action="ventas" method="post" class="needs-validation" novalidate>


					<div class="form-group">
							<label for="cantidadVendida validationCustom01" class="col-sm-2 control-label">Cantidad vendida</label>
						<div class="col-sm-10">
							<input placeholder="Cantidad vendida (10, 20, 30, ...)" type="text" id="cantidadVendida validationCustom01" name="cantidadVendida" class="form-control" required>
		
							<div class="valid-feedback">
							  ¡Cantidad colocado con éxito!
							</div>
							<div class="invalid-feedback">
							  Por favor, coloque la cantidad vendida.
							</div>
						</div>
					</div>

				<div class="form-group">
						<label for="precioTotal validationCustom02" class="col-sm-2 control-label">Precio total</label>
					<div class="col-sm-10">
						<input placeholder="$10.000, $5.000, ..." type="text" id="precioTotal validationCustom02" name="precioTotal" class="form-control" required>
	
						<div class="valid-feedback">
						  ¡Precio colocado con éxito!
						</div>
						<div class="invalid-feedback">
						  Por favor, coloque el precio total.
						</div>
					</div>
				</div>

				<div class="col-md-3">
					<label for="validationCustom04" class="form-label">Producto</label>
					<select class="form-select" id="idProducto validationCustom04" name="idProducto" required>
						<option selected disabled value="">Seleccione</option>
						<c:forEach var="producto" items="${producto}">
                            <option value="${producto.getIdProducto()}">${producto.getNombreProducto()}</option>
                    	</c:forEach>
					</select>
					<div class="valid-feedback">
					¡Todo correcto!
					</div>
					  <div class="invalid-feedback">
					  Por favor, elija un producto.
					  </div>
				  </div>

				  <div class="col-md-3">
					<label for="validationCustom04" class="form-label">Cliente</label>
					<select class="form-select" id="noDocCliente validationCustom04" name="noDocCliente" required>
						<option selected disabled value="">Seleccione</option>
						<c:forEach var="noDocCliente" items="${noDocCliente}">
							<option value="${noDocCliente.getNoDocCliente()}">${noDocCliente.getNombreCliente()}</option>
						</c:forEach>
					</select>
					<div class="valid-feedback">
					¡Todo correcto!
					</div>
					  <div class="invalid-feedback">
					  Por favor, elija un cliente.
					  </div>
				  </div>

				  
				  <div class="col-12">
					<div class="form-check">
					  <input class="form-check-input" type="checkbox" value="Acepto las condiciones" id="invalidCheck" name="condiciones" required>
					<label class="form-check-label" for="invalidCheck">
						Acepta los términos y condiciones
					</label>
					<div class="valid-feedback">
					  Correcto!
					</div>
					<div class="invalid-feedback">
					  Por favor, acepte los términos y condiciones.
					</div>
			  </div>
			
                    <p class="block">
                        <button class="btn btn-primary width-100" name="condicion" value="insertar">Agregar ventas</button>
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
								<a class="text-muted" href="https://adminkit.io/" target="_blank"><strong>Multiverso</strong></a> &copy;
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
		<!-- Validaciones -->
	   <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" ></script>
		<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" ></script>

</body>

</html>