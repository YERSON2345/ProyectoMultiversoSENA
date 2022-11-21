package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.usuarioDao;
import model.usuarioVo;
import model.rolDao;
import model.rolVo;
import model.productoDao;
import model.productoVo;

public class usuarioController extends HttpServlet {
  
    usuarioDao rd= new usuarioDao();
    usuarioVo r= new usuarioVo();

    rolDao rv= new rolDao();
    rolVo rb= new rolVo();

    productoVo p=new productoVo();
    productoDao pd=new productoDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      System.out.println("Entro al doGet");
      String condicion = req.getParameter("condicion");
  
      switch(condicion){
  
        case "consultarUsuario":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listar(req,resp);
        break;
        case "abrirPeticion":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        abrirVista(req, resp);
        break;
        case "listarPeticion":
        listarPeticiones(req, resp);
        break;
        case "formulario":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        consultarRol(req, resp);
        abrirformulario(req,resp);
        break;
        case "login":
        abrirlogin(req,resp);
        break;
        case "eliminar":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        eliminar(req, resp);
        break;
        case "dashboard":
        Dashboard(req, resp);
        break;
        case "cambioEstado":
        estado(req,resp);
        case "editar":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        editar(req, resp);
        case "index":
        home(req, resp);
        break;
        case "error403":
        error403(req, resp);
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
          String a=req.getParameter("condicion");
  
          switch(a){
              case "insertar":
                Insertar(req,resp);
              break;
              case "editarUsuario":
                Editar(req, resp);
          }
  
    }
    //Redirección al dashboard
    private void Dashboard(HttpServletRequest req, HttpServletResponse resp) {
      try {
        req.getRequestDispatcher("index-dashboard.jsp").forward(req, resp);
        System.out.println("El dashboard ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El dashboard NO ha sido abierto"+e.getMessage().toString());
      }
    }
    //Error 403(Sin permisos)
    private void error403(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
         req.getRequestDispatcher("views/Errores/error403.jsp").forward(req,resp);
      
      } catch (Exception e) {
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
          List listardias=pd.cantidad();
          System.out.println("cantidad:" +p.getcantidad());
          req.setAttribute("productossss", listardias);
          System.out.println("Cantidad registros melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }

  private void cantidadProducto(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=pd.cantidadProducto();
          System.out.println("cantidad Producto:" +p.getCantidadProducto());
          req.setAttribute("productosss", listardias);
          System.out.println("Cantidad Producto listado melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }

  private void cantidadDias(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=pd.cantidadDias();
          System.out.println("diferencia dias:" +p.getcantidadRegistros());
          req.setAttribute("productoss", listardias);
          System.out.println("Dias listados melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }

       private void listarDias(HttpServletRequest req, HttpServletResponse resp){
      try{
          List listardias=pd.listarDias();
          System.out.println("diferencia dias:" +p.getDIFERENCIA_DIAS());
          req.setAttribute("productos", listardias);
          System.out.println("Dias listados melo");
      } catch (Exception e){
          System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
      }
   }

    private void abrirformulario(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        req.getRequestDispatcher("views/Usuario/registrarse.jsp").forward(req,resp);
        System.out.println("El formulario ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
      }
    }

    private void recuperar(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        req.getRequestDispatcher("views/Usuario/recuperarC.jsp").forward(req,resp);
        System.out.println("El formulario ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
      }
    }


    private void abrirVista(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        req.getRequestDispatcher("views/Usuario/page-Usuario.jsp").forward(req,resp);
        System.out.println("El Menu a sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El menu NO ha sido abierto"+e.getMessage().toString());
      }
    }
    private void abrirlogin(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        req.getRequestDispatcher("views/Usuario/loginUsuario.jsp").forward(req,resp);
        System.out.println("El login ha sido abierto correctamente");
      } catch (Exception e) {
        System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
      }
    }
    private void consultarRol(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        List album=rv.listar();
        req.setAttribute("rol", album);
        System.out.println("Datos de roles listados correctamente");      
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
    
    private void Insertar(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException  {
  
      if(req.getParameter("Nombre")!=null){
          r.setNombreUsuario(req.getParameter("Nombre"));
      }
      if(req.getParameter("Apellido")!=null){
        r.setApellidoUsuario(req.getParameter("Apellido"));
      }
      if(req.getParameter("tipoDocumento")!=null){
      r.setTipoDocUsuario(req.getParameter("tipoDocumento"));
      }
      if(req.getParameter("Correo")!=null){
      r.setCorreoUsuario(req.getParameter("Correo"));
      }
      if(req.getParameter("noDocumento")!=null){
      r.setNoDocUsuario(Integer.parseInt(req.getParameter("noDocumento")));
      }
      if(req.getParameter("Contrasena")!=null){
      r.setContrasenaUsuario(req.getParameter("Contrasena"));
      }
      if(req.getParameter("rol")!=null){
      r.setIdRol(Integer.parseInt(req.getParameter("rol")));
      }
      r.setEstadoUsuario(false);
      try {
          rd.insertar(r);
          System.out.println("Registro insertado correctamente");
          List album=rd.listarUsuario(r.getNoDocUsuario());
          req.setAttribute("datos", album);
          req.getRequestDispatcher("views/Usuario/afterRegistro.jsp").forward(req, resp);
      } catch (Exception e) {
          System.out.println("Error en la inserción del registro "+e.getMessage().toString());
       
      }
  }
  
  private void Editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("Nombre")!=null){
      r.setNombreUsuario(req.getParameter("Nombre"));
    }
    if(req.getParameter("Apellido")!=null){
    r.setApellidoUsuario(req.getParameter("Apellido"));
    }
    if(req.getParameter("tipoDocumento")!=null){
    r.setTipoDocUsuario(req.getParameter("tipoDocumento"));
    }
    if(req.getParameter("Correo")!=null){
    r.setCorreoUsuario(req.getParameter("Correo"));
    }
    if(req.getParameter("noDocumento")!=null){
    r.setNoDocUsuario(Integer.parseInt(req.getParameter("noDocumento")));
    }
    if(req.getParameter("Contrasena")!=null){
    r.setContrasenaUsuario(req.getParameter("Contrasena"));
    }
    if(req.getParameter("rol")!=null){
    r.setIdRol(Integer.parseInt(req.getParameter("rol")));
    }
    if(req.getParameter("Estado")!=null){
      r.setEstadoUsuario(true);
    }
  else{
      r.setEstadoUsuario(false);
  }
    try {
        rd.actualizar(r);
        System.out.println("Editar el registro de genero");
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listar(req, resp);
  
    } catch (Exception e) {
        System.out.println("Error al editar del registro "+e.getMessage().toString());
    }
  }
  
    private void listar(HttpServletRequest req, HttpServletResponse resp){
      try {
        List album=rd.listar();
        req.setAttribute("datos", album);
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        req.getRequestDispatcher("views/Usuario/consultarUsuario.jsp").forward(req, resp);
        System.out.println("Datos listados correctamente");      
      } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
      }
    }
//Listar peticiones
    private void listarPeticiones(HttpServletRequest req, HttpServletResponse resp){
      try {
        List album=rd.listarPorEstado();
        req.setAttribute("datos", album);
        listarDias(req,resp);
        req.getRequestDispatcher("views/Usuario/peticionesUsuario.jsp").forward(req, resp);
        System.out.println("Datos de peticiones listados correctamente");      
      } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
      }
    }

    private void estado(HttpServletRequest req, HttpServletResponse resp) {
      if(req.getParameter("id")!=null){
          r.setNoDocUsuario(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
      }
      if(req.getParameter("estado")!=null){
          r.setEstadoUsuario(Boolean.parseBoolean(req.getParameter("estado")));//Cambiar de string a boolean
      }
      try {
          rd.cambiarEstado(r.getEstadoUsuario(), r.getNoDocUsuario());
          System.out.println("El estado se cambio exitosamente");
          cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
          listarPeticiones(req, resp);
      } catch (Exception e) {
          System.out.println("Error en el cambio de estado "+e.getMessage().toString());
      }
  }
  
    private void editar(HttpServletRequest req, HttpServletResponse resp) {
      if(req.getParameter("id")!=null){
          r.setNoDocUsuario(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
      }
      try {
          List album=rd.listarUsuario(r.getNoDocUsuario());
          req.setAttribute("datos", album);
          cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
          req.getRequestDispatcher("views/Usuario/editarUsuario.jsp").forward(req, resp);//direccion de vista
          System.out.println("Datos listados correctamente para la edicion");
      } catch (Exception e) {
          System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
      }
  }
  
    private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
      if(req.getParameter("id")!=null){
          r.setNoDocUsuario(Integer.parseInt(req.getParameter("id")));
      }
      try {
          rd.eliminar(r.getNoDocUsuario());;
          System.out.println("El registro se ha eliminado correctamente");
          cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
          listarPeticiones(req, resp);
      } catch (Exception e) {
          System.out.println("Error al eliminar el resgistro"+e.getMessage().toString());
      }
  }
  }
  