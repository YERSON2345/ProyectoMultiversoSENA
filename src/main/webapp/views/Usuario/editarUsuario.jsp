<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar Usuario</title>
</head>
<body>
    
    <h1>Editar Usuario</h1>

    <c:forEach var="usuario" items="${datos}">
        <form action = "usuario" method="post">
            <div>
                <label>Nombre</label>
                    <input type="text" name="Nombre" value="${usuario.getNombreUsuario()}"required>
            </div>
            <br>
            <div>
                <label>Apellido</label>
                    <input type="text" name="Apellido"value="${usuario.getApellidoUsuario()}" required>
            </div>
            <br>
            <div>
                <label>Contraseña</label>
                    <input type="password" name="Contrasena" value="${usuario.getContrasenaUsuario()}"required>
                </div>
            <br>
            <div>
                <label>Correo</label>
                    <input type="text" name="Correo" value="${usuario.getCorreoUsuario()}"required>
                </div>
            <br>
            <div>
            <label>Rol</label>
            <select name="rol" >
                <option value="1">Gerente</option>
                <option value="2">Operador</option>
            </select>
        </div>
        <br>
            <label>Estado</label>
            <div>
                <input type="checkbox" name="Estado" value="${usuario.getIdRol()}" checked>
                <label>Activo</label>
            </div>
            <br>
            <button class="btn btn-md btn-black" type="submit" id="form-submit" name="condicion" value="editarUsuario">Enviar</button>
        </form>
    </c:forEach>

</body>
</html>