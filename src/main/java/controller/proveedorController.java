package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.proveedorDao;
import model.proveedorVo;

public class proveedorController extends HttpServlet {
  proveedorDao rd = new proveedorDao();
  proveedorVo r = new proveedorVo();

  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doGet");
    String condicion = req.getParameter("condicion");

    switch (condicion) {

      case "consultarProveedor":
        listar(req, resp);
        break;
      case "formulario":
        abrirformulario(req, resp);
        break;
      case "eliminar":
        eliminar(req, resp);
        break;
      case "cambioEstado":
        estado(req, resp);
      case "editar":
        editar(req, resp);
        break;
      case "index":
        home(req, resp);
        break;
      default:
        System.out.println("No se encontro respuesta a su petición");
        break;
    }
  }

  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doPost");
    String a = req.getParameter("condicion");

    switch (a) {
      case "insertar":
        Insertar(req, resp);
        break;
      case "editarProveedor":
        Editar(req, resp);
    }

  }

  private void abrirformulario(HttpServletRequest req, HttpServletResponse resp) {
    try {
      req.getRequestDispatcher("views/proveedor/insertarProveedor.jsp").forward(req, resp);
      System.out.println("El formulario ha sido abierto correctamente");
    } catch (Exception e) {
      System.out.println("El formulario NO ha sido abierto" + e.getMessage().toString());
    }
  }

  private void home(HttpServletRequest req, HttpServletResponse resp) {
    try {
      req.getRequestDispatcher("index.jsp").forward(req, resp);

    } catch (Exception e) {

      System.out.println("Error");
    }
  }

  private void Insertar(HttpServletRequest req, HttpServletResponse resp) {

    if (req.getParameter("nombreProveedor") != null) {
      r.setNombreProveedor(req.getParameter("nombreProveedor"));
    }
    if (req.getParameter("empresaProveedor") != null) {
      r.setEmpresaProveedor(req.getParameter("empresaProveedor"));
    }
    if (req.getParameter("Estado") != null) {
      r.setEstadoProveedor(true);
    } else {
      r.setEstadoProveedor(false);
    }
    try {
      rd.insertar(r);
      listar(req, resp);
    } catch (Exception e) {
      System.out.println("Error en la inserción del registro " + e.getMessage().toString());
    }
  }

  private void Editar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("nombreProveedor") != null) {
      r.setNombreProveedor(req.getParameter("nombreProveedor"));
    }
    if (req.getParameter("empresaProveedor") != null) {
      r.setEmpresaProveedor(req.getParameter("empresaProveedor"));
    }
    try {
      rd.actualizar(r);
      System.out.println("Editar el registro de genero");
      listar(req, resp);
    } catch (Exception e) {
      System.out.println("Error al editar del registro " + e.getMessage().toString());
    }
  }

  private void listar(HttpServletRequest req, HttpServletResponse resp) {
    try {
      List genero = rd.listar();
      req.setAttribute("datos", genero);
      req.getRequestDispatcher("views/proveedor/consultarProveedor.jsp").forward(req, resp);
      System.out.println("Datos listados correctamente");
    } catch (Exception e) {
      System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
  }

  private void estado(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("id") != null) {
      r.setIdProveedor(Integer.parseInt(req.getParameter("id")));// Cambiar de string a int
    }
    if (req.getParameter("estado") != null) {
      r.setEstadoProveedor(Boolean.parseBoolean(req.getParameter("estado")));// Cambiar de string a boolean
    }
    try {
      rd.cambiarEstado(r.getEstadoProveedor(), r.getIdProveedor());
      System.out.println("El estado se cambio exitosamente");
      listar(req, resp);
    } catch (Exception e) {
      System.out.println("Error en el cambio de estado " + e.getMessage().toString());
    }
  }

  private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("id") != null) {
      r.setIdProveedor(Integer.parseInt(req.getParameter("id")));// Cambiar de string a int
    }
    try {
      List genero = rd.listarProveedor(r.getIdProveedor());
      req.setAttribute("datos", genero);
      req.getRequestDispatcher("views/proveedor/editarProveedor.jsp").forward(req, resp);// direccion de vista
      System.out.println("Datos listados correctamente para la edicion");
    } catch (Exception e) {
      System.out.println("Hay problemas al listar los datos " + e.getMessage().toString());
    }
  }

  private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if (req.getParameter("id") != null) {
      r.setIdProveedor(Integer.parseInt(req.getParameter("id")));
    }
    try {
      rd.eliminar(r.getIdProveedor());
      ;
      System.out.println("El registro se ha eliminado correctamente");
      listar(req, resp);
    } catch (Exception e) {
      System.out.println("Error al eliminar el resgistro" + e.getMessage().toString());
    }
  }
}
