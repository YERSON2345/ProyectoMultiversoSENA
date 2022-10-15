<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css" integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
    <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap">
    <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
    <link href="assets/css/login.css" rel="stylesheet" type="text/css"/>
    <title>Login</title>
  </head>
  <body>
    <section class="contact-box">
        <div class="row no-gutters bg-dark">
            <div class="col-xl-5 col-lg-12 register-bg">
                <div class="position-absolute testimonial p-4">
                    <p class="lead text-decoration-none">Bienvenido a</p>
                    <h3 class="font-weight-bold text-decoration-none">MULTIVERSO </h3>
                </div>
            </div>
            <div class="col-xl-7 col-lg-12 d-flex">
                <div class="container aling-self-center p-6">
                    <h1 class="font-weight-bold">Inicia tu cuenta</h1>
                    <div class="form-group">
                        <button class="btn btn-outline-dark d-inline-block text-light mr-2 mb-3"><i class="icon ion-logo-google lead aling-middle mr-2  width-100"></i>Goggle</button>
                        <button class="btn btn-outline-dark d-inline-block text-light mb-3"><i class="icon ion-logo-facebook lead aling-middle mr-2 width-100"></i>Facebook</button>
                    </div>
                    <p class="text-muted mb5">Ingresa la siguiente información para ingresar</p>
                    <form action="srvUsuario" method="POST" id="signupForm">
                        <div class="form-group mb-3">
                            <label class="font-weight-bold">Correo electronico <span class="text-danger">*</span> </label>
                            <input type="email" class="form-control" placeholder="Ingresa tu correo" name="Correo">
                        </div>
                    <div class="form-group mb-3">
                        <label class="font-weight-bold">Contraseña <span class="text-danger">*</span> </label>
                        <input type="password" class="form-control" placeholder="Ingresa tu contraseña" name="Contrasena">
                    </div>
                    <div class="form-group mb-5">
                        <div class="form-check">
                            <input class="form-check-input" type="checkbox">
                            <label class="form-check-label text-muted">Aceptar terminos y condiciones</label>
                        </div>
                    </div>
                    <input type="submit" name="accion" value="verificar" class="btn btn-primary btn-block"/>
                </form>
                <br>
                <small class="d-inline-block text-muted">¿No tienes cuenta?<a href="">Registrate aqui</a></small>
                <br>
                </div>
            </div>
        </div>
    </section>

    <!-- Optional JavaScript; choose one of the two! -->

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://code.jquery.com/jquery-1.12.4.min.js" integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ" crossorigin="anonymous"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>
   <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>
   <script src="assets/js/funciones.js" type="text/JavaScript"></script>

    <!-- Option 2: Separate Popper and Bootstrap JS -->
    <!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
  </body>
</html>
