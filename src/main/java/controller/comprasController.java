package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.time.LocalDate;
import java.time.Month;
import java.time.Period;


import model.comprasDao;
import model.comprasVo;

import model.productoDao;
import model.productoVo;

import model.proveedorDao;
import model.proveedorVo;
import model.salidasVo;
import model.detalleComprasDao;
import model.detalleComprasVo;
import model.productoDao;


public class comprasController extends HttpServlet{
    
    comprasVo c=new comprasVo();
    comprasDao cd=new comprasDao();

    productoDao cp=new productoDao();
    productoVo ct=new productoVo();

    proveedorDao pp=new proveedorDao();
    proveedorVo pd=new proveedorVo();

    detalleComprasVo d=new detalleComprasVo();
    detalleComprasDao dd=new detalleComprasDao();

    productoDao ks = new productoDao(); 


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
        case"agregarCompra":
        consultarProveedor(req,resp);
        listarComprasProducto(req,resp);
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
            c.setCantidadCompra(Integer.parseInt(req.getParameter("cantidad")));
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

            int cantidadProducto=Integer.parseInt(req.getParameter("cantidadProducto"));
            int cantidadEntradas=Integer.parseInt(req.getParameter("cantidad"));
            int idProducto = Integer.parseInt(req.getParameter("idProducto"));
            comprasVo resultado = new comprasVo();
            int resultados = resultado.sumarExistencias(cantidadProducto,cantidadEntradas);
            int resultadoSuma = resultados;
            cd.actualizarExistencias(resultadoSuma,idProducto);

            cd.registrar(c);
            cd.registrarDetalle(d);

            System.out.println("registro bien insertado");
            listarProductos(req, resp);
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
     private void listarProductos(HttpServletRequest req, HttpServletResponse resp){
        try{
            List productolistar=ks.listar();
            req.setAttribute("producto", productolistar);
            req.getRequestDispatcher("views/Producto/actualizarStock.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }
     private void listarComprasProducto(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("id")!=null){
            c.setIdProducto(Integer.parseInt(req.getParameter("id")));
        }
        try{
            List compraslistar=cd.listarProductoCompras(c.getIdProducto());
            req.setAttribute("compras", compraslistar);
            req.getRequestDispatcher("views/Compras/agregarCompras.jsp").forward(req, resp);
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
            int cantidadActualProducto=Integer.parseInt(req.getParameter("cantidadP"));
            int cantidadDescontada=Integer.parseInt(req.getParameter("cantidadEntradas"));
            salidasVo resultado = new salidasVo();
            int resultados = resultado.restarExistencias(cantidadActualProducto,cantidadDescontada);
            int resultadoss = resultados;
            c.setcantidadTotal(resultadoss);
            List compraslistar=cd.editarCompras(c.getIdCompras(), c.getcantidadTotal());
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
        if(req.getParameter("noOrdenCompra")!=null){
            c.setNoOrdenCompra(Integer.parseInt(req.getParameter("noOrdenCompra")));
        }
        if(req.getParameter("PrecioProveedor")!=null){
            c.setPrecioCompra(Integer.parseInt(req.getParameter("PrecioProveedor")));
        }
         try{
            cd.actualizar(c);
            int cantidadAntigua=Integer.parseInt(req.getParameter("cantidadAntigua"));
            int cantidadProducto=Integer.parseInt(req.getParameter("cantidadActual"));
            int cantidadEntradas=Integer.parseInt(req.getParameter("entradas"));
            int idProducto = Integer.parseInt(req.getParameter("idProducto"));
            comprasVo resultado = new comprasVo();
            
            int resultados = resultado.actualizarExistencias(cantidadProducto,cantidadEntradas,cantidadAntigua);
            int resultadoTotal = resultados;

            cd.actualizarExistencias(resultadoTotal,idProducto);
             System.out.println("editar tipo producto");
             listar(req, resp);
         }catch (Exception e){
             System.out.println("Buenas noches gente, que descansen, Error al editar"+e.getMessage().toString());
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
         if(req.getParameter("noOrdenCompra")!=null){
            c.setNoOrdenCompra(Integer.parseInt(req.getParameter("noOrdenCompra")));
        }
         try{
            cd.eliminar(c.getNoOrdenCompra());
            cd.eliminarCompras(c.getNoOrdenCompra());

     
             System.out.println("se elimino correctamente");
             listar(req, resp);
         }catch(Exception e){
             System.out.println("Error al eliminar"+e.getMessage().toString());
         }
     }
     /*
     public class DiferenciaTimepo{
        public static void main(String[] args) {
            LocalDate primeraFecha = LocalDate.of(2000, Month.JANUARY, 1);
            LocalDate fechaActual = LocalDate.now();

            System.out.println("Primera fecha:" + primeraFecha);
            System.out.println("Fecha actual:" + fechaActual);

            System.out.println();

            Period periodo = Period.between(primeraFecha, fechaActual);
            System.out.println("diferencia en años:" + periodo.getYears());
            System.out.println("diferencia en meses:" + periodo.getMonths());
            System.out.println("diferencia en dias:" + periodo.getDays());
        }
    }*/
    
} 
