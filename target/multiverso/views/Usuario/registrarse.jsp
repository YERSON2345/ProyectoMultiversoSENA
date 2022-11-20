<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
  <%
  if(session.getAttribute("Gerente") != null || session.getAttribute("Operador") != null) {
    System.out.println("Ya has iniciado sesión");
    response.sendRedirect("usuario?condicion=dashboard");
  }else{
%>
    <!doctype html>
    <html lang="en">

    <head>
      <!-- Required meta tags -->
      <meta charset="utf-8">
      <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

      <!-- Bootstrap CSS -->
      <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">
      <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:300,400,700&display=swap">
      <link href="https://unpkg.com/ionicons@4.5.10-0/dist/css/ionicons.min.css" rel="stylesheet">
      <link href="assets/css/perobueno.css" rel="stylesheet" type="text/css" />
      
      <title>Registrarse</title>
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
              <h1 class="font-weight-bold">Crea tu cuenta gratis</h1>

              <p class="text-muted mb5">Ingresa la siguiente información para registrarte</p>
              <form class="needs-validation" action="usuario" method="post" novalidate id="signupForm">
                <div class="form-group mb-3">
                  <label class="font-weight-bold">Número de documento <span class="text-danger">*</span> </label>
                  <input type="number" min="100000000" max="2200000000" class="form-control" id="validationCustom20"
                    name="noDocumento" placeholder="Ingresa tu número de documento" required>
                  <div class="invalid-feedback">
                    El número de documento no es valido (Minimo 9 caracteres - Maximo 10 caracteres).
                  </div>
                  <div class="valid-feedback">
                    El número de documento es valido!
                  </div>

                </div>
                <div class="form-group mb-3">
                  <label for="validationCustom04" class="font-weight-bold">Tipo de documento <span
                      class="text-danger">*</span> </label>
                  <select class="form-select" id="validationCustom04" name="tipoDocumento" required>
                    <option selected disabled value="">Seleccione</option>
                    <option value="TI">TI</option>
                    <option value="CC">CC</option>>
                  </select>
                  <div class="invalid-feedback">
                    Por favor, selecciona el tipo de documento.
                  </div>
                </div>
                <div class="form-row mb-2">
                  <div class="form-group col-md-6">
                    <label class="font-weight-bold" for="validationCustom02">Nombre<span class="text-danger">*</span>
                    </label>
                    <input type="text" class="form-control" id="validationCustom02" placeholder="Tu nombre"
                      name="Nombre" required>
                    <div class="invalid-feedback">
                      Por favor, introduce tú nombre.
                    </div>
                    <div class="valid-feedback">
                      Nombre valido!
                    </div>
                  </div>

                  <div class="form-group col-md-6">
                    <label for="validationCustom02" class="font-weight-bold">Apellido<span
                        class="text-danger">*</span></label>
                    <input type="text" class="form-control" id="validationCustomUsername" placeholder="Tu Apellido"
                      name="Apellido" required>
                    <div class="invalid-feedback">
                      Por favor, introduce tú Apellido.
                    </div>
                    <div class="valid-feedback">
                      Apellido valido!
                    </div>
                  </div>

                </div>
                <div class="form-group mb-3">
                  <label class="font-weight-bold">Correo electronico<span class="text-danger">*</span> </label>
                  <div class="input-group has-validation">
                    <span class="input-group-text" id="inputGroupPrepend">@</span>
                    <input type="email" class="form-control" id="validationCustomUsername"
                      placeholder="Ingresa tu correo" name="Correo" aria-describedby="inputGroupPrepend" required>
                    <div class="invalid-feedback">
                      Introduce un correo electronico valido (example@gmail.com).
                    </div>
                    <div class="valid-feedback">
                      El correo es valido!
                    </div>
                  </div>
                </div>
                <div class="form-group mb-3">
                  <label class="font-weight-bold">Contraseña <span class="text-danger">*</span> </label>
                  <input type="password" class="form-control" id="validationCustom01"
                    placeholder="Ingresa tu contraseña" minlength="8" maxlength="100" name="Contrasena" required>
                  <div class="valid-feedback">
                    Contraseña Valida!
                  </div>
                  <div class="invalid-feedback">
                    La contraseña debe contar con minimo 8 caracteres.
                  </div>
                </div>
                <div class="form-group mb-3">
                  <label for="validationCustom04" class="font-weight-bold">Rol <span class="text-danger">*</span>
                  </label>
                  <select class="form-select" id="validationCustom04" name="rol" required>
                    <option selected disabled value="">Seleccione</option>
                    <c:forEach var="rol" items="${rol}">
                      <option value="${rol.getIdRol()}">${rol.getTiporol()}</option>
                    </c:forEach>
                  </select>
                  <div class="valid-feedback">

                  </div>
                  <div class="invalid-feedback">
                    Por favor, selecciona el rol que deseas desempeñar en el sistema.
                  </div>
                </div>
                <div class="form-group mb-3">
                  <div class="form-check">
                    <input class="form-check-input" type="checkbox" value="" id="invalidCheck" required>
                    <label class="form-check-label" for="invalidCheck">
                      Aceptar <a href="">terminos y condiciones</a>
                    </label>
                    <div class="invalid-feedback">
                      Por favor, acepta los terminos y condiciones.
                    </div>
                  </div>
                </div>
                <div class="form-group mb-3">
                  <button class="btn btn-primary" type="submit" name="condicion" value="insertar">Registrarse</button>
                </div>
              </form>
              <br>
              <small class="d-inline-block text-muted">¿Ya tienes cuenta?<a href="usuario?condicion=login">Iniciar
                  sesion</a></small>
              <br>
            </div>
          </div>
        </div>
      </section>
      <script>
        // Example starter JavaScript for disabling form submissions if there are invalid fields
        (function () {
          'use strict'

          // Fetch all the forms we want to apply custom Bootstrap validation styles to
          var forms = document.querySelectorAll('.needs-validation')

          // Loop over them and prevent submission
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
      <!-- Optional JavaScript; choose one of the two! -->
      <script type="text/javascript"src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>
      <script type="text/javascript"> emailjs.init('KiDnSc8K2cdR70JBU')</script>
      <script src="assets/js/correoRegistro.js"></script>
      <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://code.jquery.com/jquery-1.12.4.min.js"
        integrity="sha384-nvAa0+6Qg9clwYCGGPpDQLVpLNn0fRaROjHqs13t4Ggj3Ez50XnGQqc/r8MhnRDZ"
        crossorigin="anonymous"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
      <script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
        integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
        crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.19.0/dist/jquery.validate.js"></script>

      <!-- Option 2: Separate Popper and Bootstrap JS -->
      <!--
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
    -->
    </body>

    </html>
    <%        
  } 
  %>