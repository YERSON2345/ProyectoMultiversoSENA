package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.productoDao;
import model.salidasDao;
import model.salidasVo;

public class salidasController extends HttpServlet {
  salidasDao rd= new salidasDao();
  salidasVo r= new salidasVo();

  productoDao pd = new productoDao();



  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    System.out.println("Entro al doGet");
    String condicion = req.getParameter("condicion");

    switch(condicion){

      case "consultarSalidas":
      listar(req,resp);
      break;
      case "formulario":
      listarDetalleProducto(req,resp);
      break;
      case "eliminar":
      devolverExistencias(req, resp);
      eliminar(req, resp);
      break;
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
            case "editarSalida":
              Editar(req, resp);
        }

  }

  private void abrirformulario(HttpServletRequest req, HttpServletResponse resp)
  {
    try {
      req.getRequestDispatcher("views/Salidas/agregarSalidas.jsp").forward(req,resp);
      System.out.println("El formulario ha sido abierto correctamente");
    } catch (Exception e) {
      System.out.println("El formulario NO ha sido abierto"+e.getMessage().toString());
    }
  }
  private void listarDetalles(HttpServletRequest req, HttpServletResponse resp){
    try {
      List genero=rd.listarDetalleSalidas();
      req.setAttribute("datos", genero);
      System.out.println("Datos listados correctamente");      
    } catch (Exception e) {
      System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
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
    if(req.getParameter("cantidad")!=null){
        r.setCantidadSalida(Integer.parseInt(req.getParameter("cantidad")));
    }
    if(req.getParameter("motivo")!=null){
        r.setMotivoSalidas(req.getParameter("motivo"));
    }
    if(req.getParameter("idProducto")!=null){
      r.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
    }
    try {

      int cantidadProducto=Integer.parseInt(req.getParameter("cantidadProducto"));
      int cantidadSalidas=Integer.parseInt(req.getParameter("cantidad"));
      int idProducto = Integer.parseInt(req.getParameter("idProducto"));
      salidasVo resultado = new salidasVo();
      req.setAttribute("area", resultado.restarExistencias(cantidadProducto,cantidadSalidas)); 
      int resultados = resultado.restarExistencias(cantidadProducto,cantidadSalidas);
      int resultadoss = resultados;
        rd.registrar(r);
        rd.actualizarExistencias(resultadoss ,idProducto);
        listarSalidas(req,resp);
    } catch (Exception e) {
        System.out.println("Error en la inserción del registro "+e.getMessage().toString());
    }
}

private void Editar(HttpServletRequest req, HttpServletResponse resp) {
if(req.getParameter("cantidad")!=null){
    r.setCantidadSalida(Integer.parseInt(req.getParameter("cantidad")));
    }
if(req.getParameter("motivo")!=null){
    r.setMotivoSalidas(req.getParameter("motivo"));
}
if(req.getParameter("nombreProducto")!=null){
  r.setNombreProducto(req.getParameter("nombreProducto"));
}
  try {
      rd.actualizar(r);
      int cantidadAntigua=Integer.parseInt(req.getParameter("cantidadProducto"));
      int cantidadProducto=Integer.parseInt(req.getParameter("cantidadSalidas"));
      int cantidadSalidas=Integer.parseInt(req.getParameter("cantidad"));
      int idProducto = Integer.parseInt(req.getParameter("idProducto"));
      salidasVo resultado = new salidasVo();
      req.setAttribute("area", resultado.restarExistencias(cantidadProducto,cantidadSalidas)); 
      int resultados = resultado.actualizarExistencias(cantidadProducto,cantidadSalidas,cantidadAntigua);
      int resultadoss = resultados;
        rd.actualizarExistencias(resultadoss ,idProducto);
      System.out.println("Editar el registro de cliente");
      listar(req, resp);

  } catch (Exception e) {
      System.out.println("Error al editar del registro "+e.getMessage().toString());
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
    salidasVo resultado = new salidasVo();
    req.setAttribute("area", resultado.sumarExistencias(cantidadProducto,cantidadSalidas)); 
    int resultados = resultado.sumarExistencias(cantidadProducto,cantidadSalidas);
    int resultadoss = resultados;
      rd.actualizarExistenciasP(resultadoss ,nombreProducto);
      listar(req, resp);
  } catch (Exception e) {
      System.out.println("Error en la inserción del registro "+e.getMessage().toString());
  }
}


  private void listar(HttpServletRequest req, HttpServletResponse resp){
    try {
      List genero=rd.listar();
      req.setAttribute("salidas", genero);
      req.getRequestDispatcher("views/Salidas/consultarSalidas.jsp").forward(req, resp);
      System.out.println("Datos listados correctamente");      
    } catch (Exception e) {
      System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
  }
  private void listarSalidas(HttpServletRequest req, HttpServletResponse resp){
    try{
        List productolistar=pd.listar();
        req.setAttribute("producto", productolistar);
        req.getRequestDispatcher("views/Producto/salidasStock.jsp").forward(req, resp);
        System.out.println("Datos listados melo");
    } catch (Exception e){
        System.out.println("estas armandoproblemas" + e.getMessage().toString());
    }
 }
  private void listarDetalleProducto(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setIdProducto(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
    }
    try {
        List genero=rd.listarDetalleCompras(r.getIdProducto());
        req.setAttribute("salir", genero);
        req.getRequestDispatcher("views/Producto/agregarSalidas.jsp").forward(req, resp);//direccion de vista
        System.out.println("Datos listados correctamente para la edicion");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

  private void editar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
        r.setIdSalida(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
    }
    try {
      int cantidadActualProducto=Integer.parseInt(req.getParameter("cantidadActualProducto"));
      int cantidadDescontada=Integer.parseInt(req.getParameter("cantidadDescontada"));
      salidasVo resultado = new salidasVo();
      req.setAttribute("area", resultado.sumarExistencias(cantidadActualProducto,cantidadDescontada)); 
      int resultados = resultado.sumarExistencias(cantidadActualProducto,cantidadDescontada);
      int resultadoss = resultados;
      
        List genero=rd.listarGenero(r.getIdSalida(),resultadoss);
        req.setAttribute("datos", genero);
        req.getRequestDispatcher("views/Salidas/editarSalidas.jsp").forward(req, resp);//direccion de vista
        System.out.println("Datos listados correctamente para la edicion");
    } catch (Exception e) {
        System.out.println("Hay problemas al listar los datos "+e.getMessage().toString());
    }
}

  private void eliminar(HttpServletRequest req, HttpServletResponse resp) {
    if(req.getParameter("id")!=null){
      r.setIdSalida(Integer.parseInt(req.getParameter("id")));//Cambiar de string a int
  }
    try {
        rd.eliminar(r.getIdSalida());
        listar(req, resp);
        System.out.println("El registro se ha eliminado correctamente");
    } catch (Exception e) {
        System.out.println("Error al eliminar el resgistro"+e.getMessage().toString());
    }
}
}