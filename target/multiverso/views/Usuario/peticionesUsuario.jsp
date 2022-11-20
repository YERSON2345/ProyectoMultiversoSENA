<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<!DOCTYPE html>
		<html lang="en">

		<head>
			<title>Fitness Pricing tables Flat Responsive Widget Template :: w3layouts</title>

			<!-- Meta-Tags -->
			<meta name="viewport" content="width=device-width, initial-scale=1">
			<meta charset="utf-8">
			<meta name="keywords"
				content="Fitness Pricing tables a Responsive Web Template, Bootstrap Web Templates, Flat Web Templates, Android Compatible Web Template, Smartphone Compatible Web Template, Free Webdesigns for Nokia, Samsung, LG, Sony Ericsson, Motorola Web Design">
			<script>
				addEventListener("load", function () {
					setTimeout(hideURLbar, 0);
				}, false);

				function hideURLbar() {
					window.scrollTo(0, 1);
				}
			</script>
			<script type="text/javascript">
				function confirmar() {
					var respuesta = confirm("¿Esta totalmente seguro que desea darle acceso al usuario?");
					if (respuesta == true) {
						return true;
					}
					else {
						return false;
					}
				}
			</script>
			<script type="text/javascript">
				function eliminar() {
					var respuesta = confirm("Si rechaza la petición el usuario se eliminar de los registros,¿Desea rechazar la petición?");
					if (respuesta == true) {
						return true;
					}
					else {
						return false;
					}
				}
			</script>
						    <script type="text/javascript"src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>
							<script type="text/javascript"> emailjs.init('KiDnSc8K2cdR70JBU')</script>
			<!-- //Meta-Tags -->

			<!-- css files -->
			<link rel="stylesheet" href="assets/css/usuario.css" type="text/css" media="all" /> <!-- Style-CSS -->
			<link rel="stylesheet" href="css/font-awesome.css"> <!-- Font-Awesome-Icons-CSS -->
			<!-- //css files -->

			<!-- web-fonts -->
			<link
				href="//fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i&amp;subset=latin-ext"
				rel="stylesheet">
			<!-- //web-fonts -->

		</head>

		<body>
			<!--header-->

			<!--//header-->
			<!--main-->
			<!-- pricing plans -->
			<c:forEach var="usuario" items="${datos}">
				<div class="pricing">
					<div class="w3l-pricing-grids">
						<div class="agileits-pricing-grid first">
							<div class="pricing_grid">
								<div class="wthree-pricing-info pricing-top">
									<h3>Petición Pendiente</h3>
									<p><span>${usuario.getNombreUsuario()}
										</span><span>${usuario.getApellidoUsuario()}</span></p>
								</div>
								<div class="pricing-bottom">
									<div class="pricing-bottom-bottom">
										<p><span class="fa fa-check"></span>Número de documento:
											<span>${usuario.getNoDocUsuario()}</span></p>
										<p><span class="fa fa-check"></span>Tipo de documento:
											<span>${usuario.getTipoDocUsuario()}</span></p>
										<p><span class="fa fa-check"></span>Correo electronico:
											<span>${usuario.getCorreoUsuario()}</span></p>
										<c:if test="${usuario.getIdRol() == 1}">
											<p><span class="fa fa-check"></span>Rol: <span>Gerente</span></p>
										</c:if>
										<c:if test="${usuario.getIdRol() == 2}">
											<p><span class="fa fa-check"></span>Rol: <span>Operador</span></p>
										</c:if>

									</div>
									<div class="buy-button">
										<form id="Form">
											<input type="hidden" value="${usuario.getNombreUsuario()}" name="Nombre">
											<input type="hidden" value="${usuario.getApellidoUsuario()}" name="Apellido">
											<input type="hidden" value="${usuario.getNoDocUsuario()}" name="noDocumento">
											<input type="hidden" value="${usuario.getCorreoUsuario()}" name="Correo">
	
											<center>
												<button class="buy-button" id="button" type="submit">Enviar notificación</button>
											</center>
	
									</form>
										<a class="popup-with-zoom-anim"
											href="usuario?condicion=cambioEstado&id=${usuario.getNoDocUsuario()}&estado=true"
											onclick="return confirmar()">Aceptar</a>
										<a class="btn btn-warning"
											href="usuario?condicion=eliminar&id=${usuario.getNoDocUsuario()}"
											onclick="return eliminar()">Rechazar</a>
									</div>

								</div>
							</div>
						</div>
					</div>
				</div>
				</div>
			</c:forEach>
			<div class="pricing">
				<div class="w3l-pricing-grids">
					<div class="agileits-pricing-grid first">
						<div class="pricing_grid">
							<div class="wthree-pricing-info pricing-top">
								<h3>Petición no aceptada</h3>
								<p><span>Yerson Bohorquez</span></p>
							</div>
							<div class="pricing-bottom">
								<div class="pricing-bottom-bottom">
									<p><span class="fa fa-check"></span>Número de documento: <span>110173174</span></p>
									<p><span class="fa fa-check"></span>Tipo de documento: <span>CC</span></p>
									<p><span class="fa fa-check"></span>Correo electronico:
										<span>Yerson.Bohorqueza14@gmail.com</span></p>
									<p><span class="fa fa-check"></span>Rol: <span>Gerente</span></p>
								</div>
								<div class="buy-button">
									<a class="popup-with-zoom-anim" href="#small-dialog">Aceptar</a>
									<a class="btn btn-warning" href="#small-dialog">Rechazar</a>
								</div>

							</div>
						</div>
					</div>
				</div>
			</div>
			</div>
			<!-- //pricing plans -->
			<!--//main-->
			<!--footer-->
			<div class="footer">
				<p>&copy; 2018 Fitness Pricing Tables. All Rights Reserved | Design By <a
						href="http://w3layouts.com">W3layouts</a></p>
			</div>
			<!--//footer-->

			<!--pop-up-grid-->

			<!--pop-up-grid-->

			<!-- jquery -->
			<script src="assets/js/jquery-2.1.4.min.js"></script>
			<!-- //jquery -->

			<!-- Pop-up for pricing tables -->
			<script src="assets/js/jquery.magnific-popup.js" type="text/javascript"></script>
			<script>
				$(document).ready(function () {
					$('.popup-with-zoom-anim').magnificPopup({
						type: 'inline',
						fixedContentPos: false,
						fixedBgPos: true,
						overflowY: 'auto',
						closeBtnInside: true,
						preloader: false,
						midClick: true,
						removalDelay: 300,
						mainClass: 'my-mfp-zoom-in'
					});

				});
			</script>
			<!-- //Pop-up for pricing tables -->
			<script src="assets/js/correoPeticiones.js"></script>
		</body>

		</html>