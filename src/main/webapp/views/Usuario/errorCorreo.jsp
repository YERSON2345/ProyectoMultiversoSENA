<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Correo Duplicado</title>
    <link rel="stylesheet" href="assets/css/confirmacion.css">
    <script type="text/javascript"src="https://cdn.jsdelivr.net/npm/@emailjs/browser@3/dist/email.min.js"></script>
    <script type="text/javascript"> emailjs.init('KiDnSc8K2cdR70JBU')</script>
<body>
    
    <div class="content">
        <div class="text">
            <h1>¡Ya hay un usuario registrado con este correo!.</h1>
            <h3>Vuelve a intentar registrate con un correo diferente</h3>
        </div>
        <center>
            <a href="usuario?condicion=formulario"></a>
            <button class="btn-accept">Regresar</button>
        </center>
<script src="assets/js/correoRegistro.js"></script>
</body>
</html>