package controller;

import java.beans.BeanProperty;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.XADataSource;
import javax.swing.RowSorter;
import javax.swing.table.TableModel;

import model.ventaDao;
import model.ventaVo;
import model.productoDao;
import model.productoVo;
import model.tipoProductoDao;
import model.tipoProductoVo;

public class productoController extends HttpServlet{

    private javax.swing.JTable TableVenta;
    private javax.swing.JTextField txtNombreClienteventa;
    
  productoVo p=new productoVo();
  productoDao pd=new productoDao();

  tipoProductoDao tp=new tipoProductoDao();
  tipoProductoVo td=new tipoProductoVo();

  ventaDao vd = new ventaDao();
  ventaVo vo = new ventaVo();


    @Override
    protected void doGet(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException{
    System.out.println("Entro al doGet");
    String a=req.getParameter("accion");

    switch(a){
        case"listar":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listar(req,resp);
        break;
        case"Stock":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listarStock(req,resp);
        break;
        case"listarSalidas":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        listarSalidas(req, resp);
        break;
        case"editar":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        editar(req, resp);
        break;
        //Reportes
        case"abrirVistaFechas":
        reporte_Fechas_Vencimiento(req,resp);
        break;
        case"abrirVistaCantidad":
        reporte_Cantidad_Producto(req,resp);
        break;
        //
        case "estadoProducto":
        estado(req, resp);
        break;
        case"eliminar":
        eliminar(req,resp);
        break;
        case"visualizar":
        visualizar(req, resp);
        break;
        case "Add_Producto":
        cantidad(req,resp);
        cantidadProducto(req,resp);
        cantidadDias(req,resp);
        listarDias(req,resp);
        consultartipoproducto(req,resp);
        req.getRequestDispatcher("views/Producto/agregarProducto.jsp").forward(req, resp);
        break;
        case "Suma":
        req.getRequestDispatcher("views/Producto/sumarStock.jsp").forward(req, resp);
        break;
        // case "actualizarStock":
        // actualizarStock();
        // break;
        default:
        error404(req,resp);
        System.out.println("No se encontro respuesta a su petición");
        break;
    }
    
    }
    private void consultartipoproducto(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List idTipoProducto=tp.listarActivo();
            req.setAttribute("idTipoProducto", idTipoProducto);
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
    //Error 404(Sin repuesta)
    private void error404(HttpServletRequest req, HttpServletResponse resp)
    {
      try {
        req.getRequestDispatcher("views/Errores/error404.jsp").forward(req,resp);
  
      } catch (Exception e) {
      }
    }
    //Reporte por cantidad de producto
     private void reporte_Cantidad_Producto(HttpServletRequest req, HttpServletResponse resp){
        try{
            List listarFecha=pd.listar_Fecha();
            List listardias=pd.listar_Producto_Cantidad();
            req.setAttribute("fecha", listarFecha);
            req.setAttribute("productosCantidad", listardias);
            req.getRequestDispatcher("views/Producto/reporte_Cantidad_Producto.jsp").forward(req, resp);
            System.out.println("Reporte abierto correctamente");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }
      //Reporte por fecha de vencimiento de producto
     private void reporte_Fechas_Vencimiento(HttpServletRequest req, HttpServletResponse resp){
        try{
            List listarFecha=pd.listar_Fecha();
            List listardias=pd.listar_Producto_Fechas();
            req.setAttribute("fecha", listarFecha);
            req.setAttribute("productosFecha", listardias);
            req.getRequestDispatcher("views/Producto/reporte_Fecha_Vencimiento.jsp").forward(req, resp);
            System.out.println("Reporte abierto correctamente");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }

    private void cantidad(HttpServletRequest req, HttpServletResponse resp){
        try{
            List listardias=pd.cantidad();
            System.out.println("cantidad:" +p.getcantidad());
            req.setAttribute("productossss", listardias);
            System.out.println("Dias listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas con los dias" + e.getMessage().toString());
        }
     }
    private void cantidadProducto(HttpServletRequest req, HttpServletResponse resp){
        try{
            List listardias=pd.cantidadProducto();
            System.out.println("cantidad Producto:" +p.getCantidadProducto());
            req.setAttribute("productosss", listardias);
            System.out.println("Dias listados melo");
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

    private void add(HttpServletRequest req, HttpServletResponse resp){  
            p.setfechaVencimiento(req.getParameter("fechaVencimiento"));
        if(req.getParameter("observaciones")!=null){
            p.setObservacionesProducto(req.getParameter("observaciones"));
        }
        if(req.getParameter("nombre")!=null){
            p.setNombreProducto(req.getParameter("nombre"));
        }
        if(req.getParameter("precio")!=null){
          p.setPrecioProducto(Integer.parseInt(req.getParameter("precio")));
        }
        if(req.getParameter("cantidad")!=null){
            p.setCantidadProducto(Integer.parseInt(req.getParameter("cantidad")));
        }
        if(req.getParameter("IdTipoProducto")!=null){
            p.setIdTipoProducto(Integer.parseInt(req.getParameter("IdTipoProducto")));
        }
        if(req.getParameter("estadoProducto")!=null){
            p.setEstadoProducto(true);
        }
        else{
            p.setEstadoProducto(false);
        }
        try{
            pd.registrar(p);
            System.out.println("registro bien insertado");
            cantidad(req,resp);
            cantidadProducto(req,resp);
            cantidadDias(req,resp);
            listarDias(req,resp);
            listar(req, resp);
        }catch(Exception e) {
            System.out.println("error en la insercion del registro" + e.getMessage().toString());
        }
    }
     private void listar(HttpServletRequest req, HttpServletResponse resp){
        try{
            List productolistar=pd.listar();
            req.setAttribute("producto", productolistar);
            cantidad(req,resp);
            cantidadProducto(req,resp);
            cantidadDias(req,resp);
            listarDias(req,resp);
            req.getRequestDispatcher("views/Producto/consultarProducto.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }

     private void listarStock(HttpServletRequest req, HttpServletResponse resp){
        try{
            List productolistar=pd.listarStock();
            req.setAttribute("producto", productolistar);
            cantidad(req,resp);
            cantidadProducto(req,resp);
            cantidadDias(req,resp);
            listarDias(req,resp);
            req.getRequestDispatcher("views/Producto/actualizarStock.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }
    private void listarSalidas(HttpServletRequest req, HttpServletResponse resp){
        try{
            List productolistar=pd.listarStock();
            req.setAttribute("producto", productolistar);
            req.getRequestDispatcher("views/Producto/salidasStock.jsp").forward(req, resp);
            System.out.println("Datos listados melo");
        } catch (Exception e){
            System.out.println("estas armandoproblemas" + e.getMessage().toString());
        }
     }

     private void editar(HttpServletRequest req, HttpServletResponse resp){
        if(req.getParameter("idProducto")!=null){
            p.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
        } 
        try{
            List productolistar=pd.editarProducto(p.getIdProducto());
            req.setAttribute("producto", productolistar);
            cantidad(req,resp);
            cantidadProducto(req,resp);
            cantidadDias(req,resp);
            listarDias(req,resp);
            req.getRequestDispatcher("views/Producto/editarProducto.jsp").forward(req, resp);
            System.out.println("datos listados correctamente para editar");
        }catch(Exception e){
            System.out.println("hay un problema al listar los datos" +e.getMessage().toString());
        }
     }
     private void edit(HttpServletRequest req, HttpServletResponse resp){
         if(req.getParameter("idProducto")!=null){
            p.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
        }
        if(req.getParameter("fechaVencimiento")!=null){
            p.setfechaVencimiento(req.getParameter("fechaVencimiento"));
         }
         if(req.getParameter("observacionesProducto")!=null){
            p.setObservacionesProducto(req.getParameter("observacionesProducto"));
         }
         if(req.getParameter("nombre")!=null){
            p.setNombreProducto(req.getParameter("nombre"));
        }
         if(req.getParameter("precio")!=null){
            p.setPrecioProducto(Integer.parseInt(req.getParameter("precio")));
        }
         if(req.getParameter("estadoProducto")!=null){
            p.setEstadoProducto(true);
        }
        else{
            p.setEstadoProducto(false);
         }
         try{
             pd.actualizar(p);
             System.out.println("editar tipo producto");
             cantidad(req,resp);
             cantidadProducto(req,resp);
             cantidadDias(req,resp);
             listarDias(req,resp);
             listar(req, resp);
         }catch (Exception e){
             System.out.println("Error al editar"+e.getMessage().toString());
         }
     }
     private void visualizar(HttpServletRequest req, HttpServletResponse resp){
       try{
           List productolistar=pd.listar();
           req.setAttribute("tipoProductolistar", productolistar);
           cantidad(req,resp);
           cantidadProducto(req,resp);
           cantidadDias(req,resp);
           listarDias(req,resp);
           req.getRequestDispatcher("views/Producto/consultarProducto.jsp").forward(req, resp);
           System.out.println("datos listados correctamente");
       }  catch(Exception e){
           System.out.println("Error al listar"+e.getMessage().toString());
       }
     }

     private void estado(HttpServletRequest req, HttpServletResponse resp){
       if(req.getParameter("idProducto")!=null){
           p.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
       }  
       if(req.getParameter("estadoProducto")!=null){
           p.setEstadoProducto(Boolean.parseBoolean(req.getParameter("estadoProducto")));
       }
       try{
           pd.estado(p.getEstadoProducto(),p.getIdProducto());
           System.out.println("El estado se cambio");
           cantidad(req,resp);
           cantidadProducto(req,resp);
           cantidadDias(req,resp);
           listarDias(req,resp);
           listar(req, resp);
       }catch (Exception e){
           System.out.println("error al cambiar el estado"+e.getMessage().toString());
       }
     }

     private void eliminar(HttpServletRequest req, HttpServletResponse resp){
         if(req.getParameter("idProducto")!=null){
             p.setIdProducto(Integer.parseInt(req.getParameter("idProducto")));
         }
         try{
             pd.eliminar(p.getIdProducto());
             System.out.println("se elimino correctamente");
             cantidad(req,resp);
             cantidadProducto(req,resp);
             cantidadDias(req,resp);
             listarDias(req,resp);
             listar(req, resp);
         }catch(Exception e){
             System.out.println("Error al eliminar"+e.getMessage().toString());
         }
     }

}