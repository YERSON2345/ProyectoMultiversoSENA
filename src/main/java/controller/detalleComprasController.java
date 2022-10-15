package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.detalleComprasDao;
import model.detalleComprasVo;

public class detalleComprasController extends HttpServlet{
    
    detalleComprasVo d=new detalleComprasVo();
    detalleComprasDao dd=new detalleComprasDao();

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
        case"eliminar":
        eliminar(req,resp);
        break;
        case"visualizar":
        visualizar(req, resp);
        break;
        case "Add_detalleCompras":
        req.getRequestDispatcher("views/detalleCompras/agregarDetalleCompras.jsp").forward(req, resp);
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
        if(req.getParameter("fecha")!=null){
            d.setFechaVencimientoProducto(req.getParameter("fecha"));
        }
        if(req.getParameter("cantidad")!=null){
            d.setCantidadCompra(Integer.parseInt(req.getParameter("cantidad")));
        }
        if(req.getParameter("precio")!=null){
            d.setPrecioProveedor(Integer.parseInt(req.getParameter("precio")));
        }
        try{
            dd.registrar(d);
            System.out.println("registro bien insertado");
            listar(req, resp);
        }catch(Exception e) {
            System.out.println("error en la insercion del registro" + e.getMessage().toString());
        }
    }
     private void listar(HttpServletRequest req, HttpServletResponse resp){
        try{
            List detalleCompraslistar=dd.listar();
            req.setAttribute("detalleCompras", detalleCompraslistar);
            req.getRequestDispatcher("views/detalleCompras/consultarDetalleCompras.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }
     private void editar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idDetalleCompras")!=null){
            d.setIdDetalleCompras(Integer.parseInt(req.getParameter("idDetalleCompras")));
        } 
        try{
            List detalleCompraslistar=dd.editarDetalleCompras(d.getIdDetalleCompras());
            req.setAttribute("detalleCompras", detalleCompraslistar);
            req.getRequestDispatcher("views/detalleCompras/editarDetalleCompras.jsp").forward(req, resp);
            System.out.println("datos listados correctamente para editar");
        }catch(Exception e){
            System.out.println("hay un problema al listar los datos" +e.getMessage().toString());
        }
     }
     private void edit(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("fecha")!=null){
            d.setFechaVencimientoProducto(req.getParameter("fecha"));
        }
        if(req.getParameter("cantidad")!=null){
            d.setCantidadCompra(Integer.parseInt(req.getParameter("cantidad")));
        }
        if(req.getParameter("precio")!=null){
            d.setPrecioProveedor(Integer.parseInt(req.getParameter("precio")));
        }
         try{
             dd.actualizar(d);
             System.out.println("editar tipo producto");
             listar(req, resp);
         }catch (Exception e){
             System.out.println("Error al editar"+e.getMessage().toString());
         }
     }
     private void visualizar(HttpServletRequest req, HttpServletResponse resp){
       try{
           List detalleCompraslistar=dd.listar();
           req.setAttribute("detalleCompras", detalleCompraslistar);
           req.getRequestDispatcher("views/detalleCompras/consultarDetalleCompras.jsp").forward(req, resp);
           System.out.println("datos listados correctamente");
       }  catch(Exception e){
           System.out.println("Error al listar"+e.getMessage().toString());
       }
     }

     private void eliminar(HttpServletRequest req, HttpServletResponse resp){
         if(req.getParameter("idDetalleCompras")!=null){
             d.setIdDetalleCompras(Integer.parseInt(req.getParameter("idDetalleCompras")));
         }
         try{
             dd.eliminar(d.getIdDetalleCompras());
             System.out.println("se elimino correctamente");
             listar(req, resp);
         }catch(Exception e){
             System.out.println("Error al eliminar"+e.getMessage().toString());
         }
     }
    
} 

