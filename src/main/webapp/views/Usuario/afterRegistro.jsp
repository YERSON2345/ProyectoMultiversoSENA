<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Mensaje de confirmación de registro</title>
    <link rel="stylesheet" href="assets/css/confirmacion.css">
    <script type="text/javascript"src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>
    <script type="text/javascript"> emailjs.init('KiDnSc8K2cdR70JBU')</script>
<body>
    
    <div class="content">
        <div class="text">
            <h1>¡Te has registrado correctamente!.</h1>
            <h3>Su petición de registro será revisada y su gerente le estará notificando</h3>
        </div>
        <c:forEach var="usuario" items="${datos}">
        <form id="Form">
        <input type="hidden" value="${usuario.getNombreUsuario()}" name="Nombre">
        <input type="hidden" value="${usuario.getApellidoUsuario()}" name="Apellido">
        <input type="hidden" value="${usuario.getNoDocUsuario()}" name="noDocumento">
        <input type="hidden" value="${usuario.getCorreoUsuario()}" name="Correo">

        <div class="text">
            <p>¡Presiona el siguiente boton para recibir un correo con tus datos compilados!.</p>
        </div>
        <center>
        <button class="btn-accept" id="button" type="submit">Continuar</button>
        </center>
    </div>
</form>
</c:forEach>
<script src="assets/js/correoRegistro.js"></script>
</body>
</html>