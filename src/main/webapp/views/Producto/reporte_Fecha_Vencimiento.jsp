<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reporte de productos a vencerse</title>
    <!-- El script de la librería-->
    <script src="assets/reportes/js/html2pdf.bundle.min.js"></script>
    <!--Nuestro script, que se encarga de crear el PDF usando la librería-->
    <script src="assets/reportes/js/script.js"></script>
    <!-- Algunos estilos -->
    <link rel="stylesheet" href="assets/reportes/css/style.css">

</head>
<center><img src="assets/reportes/img/multiversoo.jpeg" alt="Una imagen" width="250px"><br><h1>Reporte de productos con bajo stock</h1></center>
<body>
    <table>
        <thead>
            <tr>
                <th>Nombre del producto</th>
                <th>Cantidad</th>
                <th>Descripción</th>
                <th>Fecha de vencimiento</th>
                <th>Fecha actual</th>
                <th>Días restantes</th>

            </tr>
        </thead>
        <tbody>
          <c:forEach var="producto" items="${productosFecha}">
            <tr>
              <td>
                ${producto.getNombreProducto()}
              </td>

              <td>
                ${producto.getCantidadProducto()}
              </td>

              <td>
                ${producto.getObservacionesProducto()}
              </td>

              <td>
                ${producto.getfechaVencimiento()}
              </td>
              <td>
                ${producto.getfecha_actual()}
              </td>
              <td>
                ${producto.getDIFERENCIA_DIAS()} 
              </td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    
    <hr>
    <center>
        <h3>Reportes generados propiedad de la empresa MULTIVERSO</h3>
        <h3>Todos los derechos de autor 2021</h3>
        <a href="producto?accion=listar"> <button
            class="button button2"
            type="button">Regresar
            </button></a>
        <button id="btnCrearPdf"class="button button3">Generar PDF</button>
        <c:forEach var="producto" items="${fecha}">
        <h3>Fecha: ${producto.getfecha_actual()}</h3>
        </c:forEach>
    </center>
</body>  
</html>