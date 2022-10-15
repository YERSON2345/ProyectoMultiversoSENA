package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.clienteDao;
import model.clienteVo;

public class clienteController extends HttpServlet {
  clienteDao rd= new clienteDao();
  clienteVo r= new clienteVo();


  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doGet");
    String condicion = req.getParameter("condicion");

    switch(condicion){

      case "consultarCliente":
      listar(req,resp);
      break;
      case "formulario":
      abrirformulario(req,resp);
      break;
      case "eliminar":
      eliminar(req, resp);
      break;
      case "cambioEstado":
      estado(req,resp);
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
        String a=req.getParameter("condicion");

        switch(a){
            case "insertar":
              Insertar(req,resp);
            break;
            case "editarCliente":
              Editar(req, resp);
        }

  }

  private void abrirformulario(HttpServletRequest req, HttpServletResponse resp)
  {
    try {
      req.getRequestDispatcher("views/Cliente/agregarCliente.jsp").forward(req,resp);
      System.out.println("El formulario ha sido abierto correctamente");
    } catch (Exception e) {
      System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
    }
  }

  private void home(HttpServletRequest req, HttpServletResponse resp)
  {
    try {
      req.getRequestDispatcher("index.jsp").forward(req,resp);

    } catch (Exception e) {

      System.out.println("Error");
    }
  }
  
  private void Insertar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("tipoDocCliente")!=null){
        r.setTipoDocCliente(req.getParameter("tipoDocCliente"));
    }
    if(req.getParameter("noDocCliente")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("noDocCliente")));
        }
    if(req.getParameter("nombreCliente")!=null){
        r.setNombreCliente(req.getParameter("nombreCliente"));
    }
    if(req.getParameter("apellidoCliente")!=null){
        r.setApellidoCliente(req.getParameter("apellidoCliente"));
    }
    if(req.getParameter("telefonoCliente")!=null){
        r.setTelefonoCliente(Integer.parseInt(req.getParameter("telefonoCliente")));
    }
    if(req.getParameter("correoCliente")!=null){
        r.setCorreoCliente(req.getParameter("correoCliente"));
    }
    if(req.getParameter("direccionDestinoVenta")!=null){
        r.setDireccionDestinoVenta(req.getParameter("direccionDestinoVenta"));
    }
    if(req.getParameter("frecuenciaCliente")!=null){
        r.setFrecuenciaCliente(true);
    }
    else{
        r.setFrecuenciaCliente(false);
    }
    try {
        rd.insertar(r);
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }
}

private void Editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("id")));
        }
    if(req.getParameter("nombreCliente")!=null){
        r.setNombreCliente(req.getParameter("nombreCliente"));
    }
    if(req.getParameter("apellidoCliente")!=null){
        r.setApellidoCliente(req.getParameter("apellidoCliente"));
    }
    if(req.getParameter("telefonoCliente")!=null){
        r.setTelefonoCliente(Integer.parseInt(req.getParameter("telefonoCliente")));
    }
    if(req.getParameter("correoCliente")!=null){
        r.setCorreoCliente(req.getParameter("correoCliente"));
    }
    if(req.getParameter("direccionDestinoVenta")!=null){
        r.setDireccionDestinoVenta(req.getParameter("direccionDestinoVenta"));
    }
    if(req.getParameter("frecuenciaCliente")!=null){
        r.setFrecuenciaCliente(true);
    }
    else{
        r.setFrecuenciaCliente(false);
    }
  try {
      rd.actualizar(r);
      System.out.println("Editar el registro de cliente");
      listar(req, resp);

  } catch (Exception e) {
      System.out.println("Error al editar del registro "+e.getMessage().toString());
  }
}

  private void listar(HttpServletRequest req, HttpServletResponse resp){
    try {
      List genero=rd.listar();
      req.setAttribute("datos", genero);
      req.getRequestDispatcher("views/Cliente/consultarCliente.jsp").forward(req, resp);
      System.out.println("Datos listados correctamente");      
    } catch (Exception e) {
      System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
  }
  private void estado(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
    }
    if(req.getParameter("estado")!=null){
        r.setFrecuenciaCliente(Boolean.parseBoolean(req.getParameter("estado")));//Cambiar de string a boolean
    }
    try {
        rd.cambiarEstado(r.getFrecuenciaCliente(), r.getNoDocCliente());
        System.out.println("El estado se cambio exitosamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error en el cambio de estado "+e.getMessage().toString());
    }
}

  private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
    }
    try {
        List genero=rd.listarGenero(r.getNoDocCliente());
        req.setAttribute("datos", genero);
        req.getRequestDispatcher("views/Cliente/editarCliente.jsp").forward(req, resp);//direccion de vista
        System.out.println("Datos listados correctamente para la edicion");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

  private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setNoDocCliente(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
    }
    try {
        rd.eliminar(r.getNoDocCliente());;
        System.out.println("El registro se ha eliminado correctamente");
        listar(req, resp);
    } catch (Exception e) {
        System.out.println("Error al eliminar el resgistro"+e.getMessage().toString());
    }
}
}



