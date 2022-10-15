package controller;

import java.beans.BeanProperty;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
        listar(req,resp);
        break;
        case"editar":
        editar(req, resp);
        break;
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
        consultartipoproducto(req,resp);
        req.getRequestDispatcher("views/Producto/agregarProducto.jsp").forward(req, resp);
        break;
        // case "actualizarStock":
        // actualizarStock();
        // break;
    }
    
    }
    private void consultartipoproducto(HttpServletRequest req, HttpServletResponse resp) {
        try{
            List idTipoProducto=tp.listar();
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

    // private void btnGenerarVentaActionPerformed(java.awt.event.ActionEvent evt) {
    //     if (TableVenta.getRowCount() > 0) {
    //         if (!"".equals(txtNombreClienteventa.getText())) {

    //             actualizarStock();

    //         }
    //     }   
    // }

    // private void actualizarStock() {
    //     for (int i = 0; i < TableVenta.getRowCount(); i++) {
    //         int id = Integer.parseInt(TableVenta.getValueAt(i, 0).toString());
    //         int cant = Integer.parseInt(TableVenta.getValueAt(i, 2).toString());
    //         p = pd.buscar(id);
    //         int ca = p.getCantidadProducto() - cant;
    //         vd.ActualizarStock(cant, id);
    //     }
    // }

    private void add(HttpServletRequest req, HttpServletResponse resp){

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
            listar(req, resp);
        }catch(Exception e) {
            System.out.println("error en la insercion del registro" + e.getMessage().toString());
        }
    }
     private void listar(HttpServletRequest req, HttpServletResponse resp){
        try{
            List productolistar=pd.listar();
            req.setAttribute("producto", productolistar);
            req.getRequestDispatcher("views/Producto/consultarProducto.jsp").forward(req, resp);
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
             listar(req, resp);
         }catch (Exception e){
             System.out.println("Error al editar"+e.getMessage().toString());
         }
     }
     private void visualizar(HttpServletRequest req, HttpServletResponse resp){
       try{
           List productolistar=pd.listar();
           req.setAttribute("tipoProductolistar", productolistar);
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
             listar(req, resp);
         }catch(Exception e){
             System.out.println("Error al eliminar"+e.getMessage().toString());
         }
     }
    
}