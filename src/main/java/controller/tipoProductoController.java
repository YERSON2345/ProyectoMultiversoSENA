package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.tipoProductoDao;
import model.tipoProductoVo;

public class tipoProductoController extends HttpServlet{
    
    tipoProductoVo t=new tipoProductoVo();
    tipoProductoDao td=new tipoProductoDao();

    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
    System.out.println("Entro al doGet");
    String a=req.getParameter("accion");

    switch(a){
        case"listar":
        listar(req,resp);
        break;
        case"editar":
        editar(req, resp);
        break;
        case "estadoTipoProducto":
        estado(req, resp);
        break;
        case"eliminar":
        eliminar(req,resp);
        break;
        case"visualizar":
        visualizar(req, resp);
        break;
        case "Add_TipoProducto":
        req.getRequestDispatcher("views/tipoProducto/agregarTipoProducto.jsp").forward(req, resp);
        break;
    }
    //
    
    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        System.out.println("entro al doPost");
        String a=req.getParameter("accion");


        switch(a){
            case "Registrar":
            add(req,resp);
            break;
            case"Editar":
            edit(req,resp);
            break;

        }
    }

    private void add(HttpServletRequest req, HttpServletResponse resp){

        if(req.getParameter("nombre")!=null){
            t.setNombreTipoProducto(req.getParameter("nombre"));
        }
        if(req.getParameter("estadoTipoProducto")!=null){
            t.setEstadoTipoProducto(true);
        }
        else{
            t.setEstadoTipoProducto(false);
        }
        try{
            td.registrar(t);
            System.out.println("registro bien insertado");
            listar(req, resp);
        }catch(Exception e) {
            System.out.println("error en la insercion del registro" + e.getMessage().toString());
        }
    }
     private void listar(HttpServletRequest req, HttpServletResponse resp){
        try{
            List tipoProductolistar=td.listar();
            req.setAttribute("tipoProducto", tipoProductolistar);
            req.getRequestDispatcher("views/tipoProducto/consultarTipoProducto.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }
     private void editar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idTipoProducto")!=null){
            t.setIdTipoProducto(Integer.parseInt(req.getParameter("idTipoProducto")));
        } 
        try{
            List tipoProductolistar=td.editarTipoProducto(t.getIdTipoProducto());
            req.setAttribute("tipoProducto", tipoProductolistar);
            req.getRequestDispatcher("views/tipoProducto/editarTipoProducto.jsp").forward(req, resp);
            System.out.println("datos listados correctamente para editar");
        }catch(Exception e){
            System.out.println("hay un problema al listar los datos" +e.getMessage().toString());
        }
     }
     private void edit(HttpServletRequest req, HttpServletResponse resp){
         if(req.getParameter("idTipoProducto")!=null){
             t.setIdTipoProducto(Integer.parseInt(req.getParameter("idTipoProducto")));
         }
         if(req.getParameter("nombreTipoProducto")!=null){
             t.setNombreTipoProducto(req.getParameter("nombreTipoProducto"));
         }
         if(req.getParameter("estadoTipoProducto")!=null){
             t.setEstadoTipoProducto(true);
         }
         else{
             t.setEstadoTipoProducto(false);
         }
         try{
             td.actualizar(t);
             System.out.println("editar tipo producto");
             listar(req, resp);
         }catch (Exception e){
             System.out.println("Error al editar"+e.getMessage().toString());
         }
     }
     private void visualizar(HttpServletRequest req, HttpServletResponse resp){
       try{
           List tipoProductolistar=td.listar();
           req.setAttribute("tipoProductolistar", tipoProductolistar);
           req.getRequestDispatcher("views/tipoProducto/consultarTipoProducto.jsp").forward(req, resp);
           System.out.println("datos listados correctamente");
       }  catch(Exception e){
           System.out.println("Error al listar"+e.getMessage().toString());
       }
     }

     private void estado(HttpServletRequest req, HttpServletResponse resp){
       if(req.getParameter("idTipoProducto")!=null){
           t.setIdTipoProducto(Integer.parseInt(req.getParameter("idTipoProducto")));
       }  
       if(req.getParameter("estadoTipoProducto")!=null){
           t.setEstadoTipoProducto(Boolean.parseBoolean(req.getParameter("estadoTipoProducto")));
       }
       try{
           td.estado(t.getEstadoTipoProducto(),t.getIdTipoProducto());
           System.out.println("El estado se cambio");
           listar(req, resp);
       }catch (Exception e){
           System.out.println("error al cambiar el estado"+e.getMessage().toString());
       }
     }

     private void eliminar(HttpServletRequest req, HttpServletResponse resp){
         if(req.getParameter("idTipoProducto")!=null){
             t.setIdTipoProducto(Integer.parseInt(req.getParameter("idTipoProducto")));
         }
         try{
             td.eliminar(t.getIdTipoProducto());
             System.out.println("se elimino correctamente");
             listar(req, resp);
         }catch(Exception e){
             System.out.println("Error al eliminar"+e.getMessage().toString());
         }
     }
    
}
