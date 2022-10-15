package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.comprasDao;
import model.comprasVo;

import model.productoDao;
import model.productoVo;

import model.proveedorDao;
import model.proveedorVo;

import model.detalleComprasDao;
import model.detalleComprasVo;

public class comprasController extends HttpServlet{
    
    comprasVo c=new comprasVo();
    comprasDao cd=new comprasDao();

    productoDao cp=new productoDao();
    productoVo ct=new productoVo();

    proveedorDao pp=new proveedorDao();
    proveedorVo pd=new proveedorVo();

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
        case "Add_Compras":
        consultarProveedor(req,resp);
        consultarProducto(req,resp);
        req.getRequestDispatcher("views/Compras/agregarCompras.jsp").forward(req, resp);
        break;
    }
    //
    
    }
    private void consultarProveedor(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List idProveedor=pp.listar();
            req.setAttribute("idProveedor", idProveedor);
            System.out.println("datos listados correctamente de tipo producto");
        }catch(Exception e){
            System.out.println("no se pudo listar los datos de tipo producto"+e.getMessage().toString());
        }
	}
	private void consultarProducto(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List idProducto=cp.listar();
            req.setAttribute("idProducto", idProducto);
            System.out.println("datos listados correctamente de tipo producto");
        }catch (Exception e){
            System.out.println("no se pudo listar los datos de tipo producto"+e.getMessage().toString());
        }
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

        if(req.getParameter("cantidad")!=null){
            c.setEntradaCompras(Integer.parseInt(req.getParameter("cantidad")));
        }
        if(req.getParameter("NoOrden")!=null){
            c.setNoOrdenCompra(Integer.parseInt(req.getParameter("NoOrden")));
        }
        if(req.getParameter("NoOrden")!=null){
            d.setnoOrdenCompra(Integer.parseInt(req.getParameter("NoOrden")));
        }
        if(req.getParameter("fecha")!=null){
            d.setFechaVencimientoProducto(req.getParameter("fecha"));
        }
        if(req.getParameter("cantidad")!=null){
            d.setCantidadCompra(Integer.parseInt(req.getParameter("cantidad")));
        }
        if(req.getParameter("precio")!=null){
            d.setPrecioProveedor(Integer.parseInt(req.getParameter("precio")));
        }
        if(req.getParameter("idProducto")!=null){
            d.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
        }
        if(req.getParameter("idProveedor")!=null){
            d.setIdProveedor(Integer.parseInt(req.getParameter("idProveedor")));
        }
        
        try{
            cd.registrar(c);
            cd.registrarDetalle(d);
            System.out.println("registro bien insertado");
            listar(req, resp);
        }catch(Exception e) {
            System.out.println("error en la insercion del registro" + e.getMessage().toString());
        }
    }
     private void listar(HttpServletRequest req, HttpServletResponse resp){
        try{
            List compraslistar=cd.listar();
            req.setAttribute("compras", compraslistar);
            req.getRequestDispatcher("views/Compras/consultarCompras.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }

     }

     private void editar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idCompras")!=null){
            c.setIdCompras(Integer.parseInt(req.getParameter("idCompras")));
        } 
        try{
            List compraslistar=cd.editarCompras(c.getIdCompras());
            req.setAttribute("compras", compraslistar);
            req.getRequestDispatcher("views/Compras/editarCompras.jsp").forward(req, resp);
            System.out.println("datos listados correctamente para editar");
        }catch(Exception e){
            System.out.println("hay un problema al listar los datos" +e.getMessage().toString());
        }
     }
     private void edit(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("fecha")!=null){
            c.setFechaCompra(req.getParameter("fecha"));
        }
        if(req.getParameter("entradas")!=null){
            c.setEntradaCompras(Integer.parseInt(req.getParameter("entradas")));
        }
        if(req.getParameter("NoOrden")!=null){
            c.setNoOrdenCompra(Integer.parseInt(req.getParameter("NoOrden")));
        }
         try{
             cd.actualizar(c);
             System.out.println("editar tipo producto");
             listar(req, resp);
         }catch (Exception e){
             System.out.println("Error al editar"+e.getMessage().toString());
         }
     }
     private void visualizar(HttpServletRequest req, HttpServletResponse resp){
       try{
           List compraslistar=cd.listar();
           req.setAttribute("compras", compraslistar);
           req.getRequestDispatcher("views/Compras/consultarCompras.jsp").forward(req, resp);
           System.out.println("datos listados correctamente");
       }  catch(Exception e){
           System.out.println("Error al listar"+e.getMessage().toString());
       }
     }

     private void eliminar(HttpServletRequest req, HttpServletResponse resp){
         if(req.getParameter("idCompras")!=null){
             c.setIdCompras(Integer.parseInt(req.getParameter("idCompras")));
         }
         try{
             cd.eliminar(c.getIdCompras());
             System.out.println("se elimino correctamente");
             listar(req, resp);
         }catch(Exception e){
             System.out.println("Error al eliminar"+e.getMessage().toString());
         }
     }
    
} 
