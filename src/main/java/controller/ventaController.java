package controller;

import java.io.IOException;
import java.util.List;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.clienteDao;
import model.clienteVo;
import model.productoDao;
import model.productoVo;
import model.ventaDao;
import model.ventaVo;

public class ventaController extends HttpServlet {
  
    ventaDao rd= new ventaDao();
    ventaVo r= new ventaVo();

    clienteDao c= new clienteDao();
    clienteVo co= new clienteVo();

    productoDao p= new productoDao();
    productoVo po= new productoVo();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Entro al doGet");
      String condicion = req.getParameter("condicion");
  
      switch(condicion){
  
        case "consultarventa":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listar(req,resp);
        break;
        case "cosultarvp":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listarfunciones(req,resp);
        case "formulario":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        consultarnodoccliente(req,resp);
        listarProductos(req, resp);
        break;
        case "eliminar":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        devolverExistencias(req, resp);
        eliminar(req, resp);
        break;
        case "editar":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        editar(req, resp);
        break;
        case "index":
        home(req, resp);
        break;
        case "dashboard":
        dashboard(req,resp);
        break;
        case "ExportarPDF":
        ExportarPDF(req,resp);
        break;
        default:
        error404(req,resp);
        System.out.println("No se encontro respuesta a su petición");
        break;
      }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Entro al doPost");
          String condicion=req.getParameter("condicion");
  
          switch(condicion){
              case "insertar":
                Insertar(req,resp);
              break;
              case "editarventa":
                Editar(req, resp);
              break;
          }
    }
    //Error 404(Sin repuesta)
    private void error404(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        req.getRequestDispatcher("views/Errores/error404.jsp").forward(req,resp);
  
      } catch (Exception e) {
      }
    }

    private void cantidad(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=p.cantidad();
          System.out.println("cantidad:" +po.getcantidad());
          req.setAttribute("productossss", listardias);
          System.out.println("Dias listados melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }

  private void cantidadProducto(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=p.cantidadProducto();
          System.out.println("cantidad Producto:" +po.getCantidadProducto());
          req.setAttribute("productosss", listardias);
          System.out.println("Dias listados melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }


    private void cantidadDias(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=p.cantidadDias();
          System.out.println("diferencia dias:" +po.getcantidadRegistros());
          req.setAttribute("productoss", listardias);
          System.out.println("Dias listados melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }
    private void listarDias(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=p.listarDias();
          System.out.println("diferencia dias:" +po.getDIFERENCIA_DIAS());
          req.setAttribute("productos", listardias);
          System.out.println("Dias listados melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }
    private void dashboard(HttpServletRequest req, HttpServletResponse resp) {
      try {
        req.getRequestDispatcher("index-dashboard.jsp").forward(req, resp);
        System.out.println("El dashboard ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El dashboard NO ha sido abierto"+e.getMessage().toString());
      }
    }

    private void ExportarPDF(HttpServletRequest req, HttpServletResponse resp)
    {
      try {

      } catch (Exception e) {
         System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
      }
    }

private void listarProductos(HttpServletRequest req, HttpServletResponse resp) {
  if(req.getParameter("id")!=null){
      r.setidProductoFK(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
  }

  try {
      List genero=rd.listarProductoVentas(r.getidProductoFK());
      req.setAttribute("ventas", genero);
      cantidad(req,resp);
        cantidadProducto(req,resp);
      cantidadDias(req,resp);
      listarDias(req,resp);
      req.getRequestDispatcher("views/venta/agregarventa.jsp").forward(req, resp);//direccion de vista
      System.out.println("Datos listados correctamente para la edicion");
  } catch (Exception e) {
      System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
  }
}


    private void listarfunciones(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        cantidad(req,resp);
        cantidadProducto(req,resp);
        listarDias(req,resp);
        cantidadDias(req,resp);
        req.getRequestDispatcher("views/venta/actualizarVenta.jsp").forward(req,resp);
        System.out.println("El formulario ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
      }
    }

    private void abrirformulario(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        req.getRequestDispatcher("views/venta/agregarventa.jsp").forward(req,resp);
        System.out.println("El formulario ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
      }
    }

    private void consultarproducto(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List producto=p.listar();
            req.setAttribute("producto", producto);
            System.out.println("Datos del producto listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void consultarnodoccliente(HttpServletRequest req, HttpServletResponse resp) {
        try {
            List noDocCliente=c.listar();
            req.setAttribute("noDocCliente", noDocCliente);
            System.out.println("Datos de número de documento cliente listados correctamente");
        } catch (Exception e) {
            System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
        }
    }

    private void home(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        req.getRequestDispatcher("index.jsp").forward(req,resp);
  
      } catch (Exception e) {
      }
    }
    
    private void Insertar(HttpServletRequest req, HttpServletResponse resp) {
  
      if(req.getParameter("cantidadVendida")!=null){
        r.setCantidadVendida(Integer.parseInt(req.getParameter("cantidadVendida")));
      }
      if(req.getParameter("precioTotal")!=null){
      r.setPrecioTotal(Integer.parseInt(req.getParameter("precioTotal")));
      }
      if(req.getParameter("idProductoFK")!=null){
        r.setidProductoFK(Integer.parseInt(req.getParameter("idProductoFK")));
      }
      if(req.getParameter("noDocCliente")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("noDocCliente")));
      }
      try {
        // Actualizar stock de ventas a producto
        int cantidadProducto=Integer.parseInt(req.getParameter("cantidadProducto"));
        int cantidadSalidas=Integer.parseInt(req.getParameter("cantidadVendida"));
        int idProducto = Integer.parseInt(req.getParameter("idProducto"));
        ventaVo resultado = new ventaVo();
        req.setAttribute("area", resultado.restarExistencias(cantidadProducto,cantidadSalidas)); 
        int resultados = resultado.restarExistencias(cantidadProducto,cantidadSalidas);
        int resultadoss = resultados;

          rd.insertar(r);
          rd.ActualizarStock(resultadoss, idProducto);
          System.out.println("Registro insertado correctamente");
          cantidad(req,resp);
        cantidadProducto(req,resp);
          cantidadDias(req,resp);
          listarDias(req,resp);
          listar(req, resp);
      } catch (Exception e) {
          System.out.println("Error en la inserción del registro "+e.getMessage().toString());
      }
  }
  
  private void Editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("cantidadVendida")!=null){
      r.setCantidadVendida(Integer.parseInt(req.getParameter("cantidadVendida")));
    }
    if(req.getParameter("precioTotal")!=null){
    r.setPrecioTotal(Integer.parseInt(req.getParameter("precioTotal")));
    }
    try {
      rd.actualizar(r);
      int cantidadAntigua=Integer.parseInt(req.getParameter("cantidadProducto"));
      int cantidadProducto=Integer.parseInt(req.getParameter("cantidadVendida"));
      int cantidadSalidas=Integer.parseInt(req.getParameter("cantidadSalidas"));
      int idProducto = Integer.parseInt(req.getParameter("idProducto"));
      ventaVo resultado = new ventaVo();
      req.setAttribute("area", resultado.restarExistencias(cantidadProducto,cantidadSalidas)); 
      int resultados = resultado.actualizarExistencias(cantidadSalidas,cantidadProducto,cantidadAntigua);
      int resultadoss = resultados;
        rd.ActualizarStock(resultadoss, idProducto);
        System.out.println("Editar el registro de venta");
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listar(req, resp);
  
    } catch (Exception e) {
        System.out.println("Error al editar el registro "+e.getMessage().toString());
    }
  }
  
    private void listar(HttpServletRequest req, HttpServletResponse resp){
      try {
        List ventas=rd.listar();
        req.setAttribute("ventas", ventas);
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        req.getRequestDispatcher("views/venta/consultarventa.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");      
      } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
      }
    }
  
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
      if(req.getParameter("id")!=null){
          r.setIdDetalleVenta(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
      }
      try {
      int cantidadActualProducto=Integer.parseInt(req.getParameter("cantidadActualProducto"));
      int cantidadDescontada=Integer.parseInt(req.getParameter("cantidadDescontada"));
      ventaVo resultado = new ventaVo();
      int resultados = resultado.sumarExistencias(cantidadActualProducto,cantidadDescontada);
      int resultadoss = resultados;

        List ventas=rd.listarVenta(r.getIdDetalleVenta(),resultadoss);
          req.setAttribute("ventas", ventas);
          cantidad(req,resp);
        cantidadProducto(req,resp);
          cantidadDias(req,resp);
          listarDias(req,resp);
          req.getRequestDispatcher("views/venta/editarventa.jsp").forward(req, resp);//direccion de vista
          System.out.println("Datos listados correctamente para la edicion");
      } catch (Exception e) {
          System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
      }
  }
  
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
      if(req.getParameter("id")!=null){
          r.setIdDetalleVenta(Integer.parseInt(req.getParameter("id")));
      }
      try {
          rd.eliminar(r.getIdDetalleVenta());
          System.out.println("El registro se ha eliminado correctamente");
          cantidad(req,resp);
        cantidadProducto(req,resp);
          cantidadDias(req,resp);
          listarDias(req,resp);
          listar(req, resp);
      } catch (Exception e) {
          System.out.println("Error al eliminar el resgistro"+e.getMessage().toString());
      }
   }
   private void devolverExistencias(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("nombreP")!=null){
        r.setNombreProducto(req.getParameter("nombreP"));
    }
    if(req.getParameter("cantidadS")!=null){
        r.setCantidadSalida(Integer.parseInt(req.getParameter("cantidadS")));
    }
    if(req.getParameter("cantidadP")!=null){
      r.setCantidadSalida(Integer.parseInt(req.getParameter("cantidadP")));
    }
    try {
  
      int cantidadProducto=Integer.parseInt(req.getParameter("cantidadP"));
      int cantidadSalidas=Integer.parseInt(req.getParameter("cantidadS"));
      String nombreProducto = req.getParameter("nombreP");
      ventaVo resultado = new ventaVo();
      req.setAttribute("area", resultado.sumarExistencias(cantidadProducto,cantidadSalidas)); 
      int resultados = resultado.sumarExistencias(cantidadProducto,cantidadSalidas);
      int resultadoss = resultados;
        rd.actualizarExistenciasP(resultadoss ,nombreProducto);
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }
  }
}
  