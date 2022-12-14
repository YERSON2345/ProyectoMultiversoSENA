package controller;

import java.io.IOException;
import java.util.List;

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
        listar(req,resp);
        break;
        case "formulario":
        consultarproducto(req, resp);
        consultarnodoccliente(req,resp);
        abrirformulario(req,resp);
        break;
        case "eliminar":
        eliminar(req, resp);
        break;
        case "editar":
        editar(req, resp);
        break;
        case "index":
        home(req, resp);
        break;
        case "dashboard":
        dashboard(req,resp);
        break;
        default:
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

    private void dashboard(HttpServletRequest req, HttpServletResponse resp) {
      try {
        req.getRequestDispatcher("index-dashboard.jsp").forward(req, resp);
        System.out.println("El dashboard ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El dashboard NO ha sido abierto"+e.getMessage().toString());
      }
    }

    private void abrirformulario(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
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
      if(req.getParameter("idProducto")!=null){
        r.setIdProductoFK(Integer.parseInt(req.getParameter("idProducto")));
      }
      if(req.getParameter("noDocCliente")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("noDocCliente")));
      }
      try {
          rd.insertar(r);
          System.out.println("Registro insertado correctamente");
          List ventas=rd.listar();
          req.setAttribute("ventas", ventas);
          req.getRequestDispatcher("views/venta/consultarventa.jsp").forward(req, resp);
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
        System.out.println("Editar el registro de venta");
        listar(req, resp);
  
    } catch (Exception e) {
        System.out.println("Error al editar del registro "+e.getMessage().toString());
    }
  }
  
    private void listar(HttpServletRequest req, HttpServletResponse resp){
      try {
        List ventas=rd.listar();
        req.setAttribute("ventas", ventas);
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
          List ventas=rd.listarVenta(r.getIdDetalleVenta());
          req.setAttribute("ventas", ventas);
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
          listar(req, resp);
      } catch (Exception e) {
          System.out.println("Error al eliminar el resgistro"+e.getMessage().toString());
      }
   }
}
  