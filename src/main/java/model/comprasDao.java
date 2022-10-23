package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class comprasDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int c;

  public List<comprasVo> listar() throws SQLException{
      List<comprasVo> compras=new ArrayList<>();
      sql="SELECT U.idDetalleCompras,U.fechaVencimientoProducto,U.cantidadCompra,U.precioProveedor,C.noOrdenCompra, O.nombreProveedor,P.nombreProducto,P.cantidadProducto FROM detalleCompras U INNER JOIN Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Proveedor O ON U.idProveedor = O.idProveedor INNER JOIN Producto P ON U.idProducto = P.idProducto;";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            comprasVo filas=new comprasVo();
              filas.setIdCompras(rs.getInt("idDetalleCompras"));
              filas.setFechaCompra(rs.getString("fechaVencimientoProducto"));
              filas.setEntradaCompras(rs.getInt("cantidadCompra"));
              filas.setPrecioCompra(rs.getInt("precioProveedor"));
              filas.setNoOrdenCompra(rs.getInt("noOrdenCompra"));
              filas.setNombreProducto(rs.getString("nombreProducto"));
              filas.setNombreProveedor(rs.getString("nombreProveedor"));
              filas.setcantidadProducto(rs.getInt("cantidadProducto"));
              compras.add(filas);
          }
          ps.close();
          System.out.println("consulta exitosa");
      }catch(Exception e){
          System.out.println("La consulta no se pudo");
      }
      finally{
          con.close();
      }
      return compras;
  }

  public List<comprasVo> listarProductoCompras(int idProducto) throws SQLException{
    List<comprasVo> Compras=new ArrayList<>();
    sql="SELECT P.idProducto,P.nombreProducto,P.cantidadProducto,P.observacionesProducto,P.precioProducto,T.nombreTipoProducto FROM Producto P INNER JOIN tipoProducto T ON P.idTipoProducto = T.idTipoProducto WHERE P.idProducto ="+idProducto;
    try{
        con=Conexion.conectar();  
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          comprasVo filas=new comprasVo();
          filas.setIdProducto(rs.getInt("idProducto"));
          filas.setNombreProducto(rs.getString("nombreProducto"));
          filas.setObservacionesProducto(rs.getString("observacionesProducto"));
          filas.setcantidadProducto(rs.getInt("cantidadProducto"));
          filas.setprecioProducto(rs.getInt("precioProducto"));
          filas.setNombreTipoProducto(rs.getString("nombreTipoProducto"));
            Compras.add(filas);
        }
        ps.close();
        System.out.println("consulta bien echa");
    }catch (Exception e){
        System.out.println("La consulta no se pudo" +e.getMessage().toString());
    }
    finally{
        con.close();
    }
    return Compras;
}

  public int registrarDetalle (detalleComprasVo detalleCompras) throws SQLException{
    sql="INSERT INTO DetalleCompras(cantidadCompra,precioProveedor,fechaVencimientoProducto,idProducto,idProveedor,noOrdenCompra) values(?,?,?,?,?,?)";
   try{
       con=Conexion.conectar();
       ps=con.prepareStatement(sql);
       ps.setInt(1, detalleCompras.getCantidadCompra());
       ps.setInt(2, detalleCompras.getPrecioProveedor());
       ps.setString(3, detalleCompras.getFechaVencimientoProducto());
       ps.setInt(4, detalleCompras.getIdProducto());
       ps.setInt(5, detalleCompras.getIdProveedor());
       ps.setInt(6, detalleCompras.getnoOrdenCompra());
       System.out.println(ps);
       ps.executeUpdate();
       ps.close();
       System.out.println("se registro el detalle de venta");
   } catch(Exception e){
       System.out.println("Error"+ e.getMessage().toString());
   }
   finally{
       con.close();
   }
   return c;
}
  public int registrar (comprasVo compras) throws SQLException{
       sql="INSERT INTO Compras(entradasCompras,noOrdenCompra) values(?,?)";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.setInt (1, compras.getEntradaCompras());
          ps.setInt(2, compras.getNoOrdenCompra());
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("se registro el tipo de producto");
      } catch(Exception e){
          System.out.println("Error"+ e.getMessage().toString());
      }
      finally{
          con.close();
      }
      return c;
  }

  public List<comprasVo> editarCompras(int idCompras, int cantidadTotal) throws SQLException{
      List<comprasVo> Compras=new ArrayList<>();
      sql="SELECT U.idDetalleCompras,U.fechaVencimientoProducto,U.cantidadCompra,U.precioProveedor,C.noOrdenCompra, O.nombreProveedor,P.nombreProducto,P.cantidadProducto,P.idProducto FROM detalleCompras U INNER JOIN Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Proveedor O ON U.idProveedor = O.idProveedor INNER JOIN Producto P ON U.idProducto = P.idProducto WHERE U.idDetalleCompras ="+idCompras;
      try{
          con=Conexion.conectar();  
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            comprasVo filas=new comprasVo();
            filas.setIdCompras(rs.getInt("idDetalleCompras"));
            filas.setFechaCompra(rs.getString("fechaVencimientoProducto"));
            filas.setEntradaCompras(rs.getInt("cantidadCompra"));
            filas.setPrecioCompra(rs.getInt("precioProveedor"));
            filas.setNoOrdenCompra(rs.getInt("noOrdenCompra"));
            filas.setIdProducto(rs.getInt("idProducto"));
            filas.setcantidadProducto(rs.getInt("cantidadProducto"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setNombreProveedor(rs.getString("nombreProveedor"));
            filas.setcantidadTotal(cantidadTotal);
              Compras.add(filas);
          }
          ps.close();
          System.out.println("consulta bien echa");
      }catch (Exception e){
          System.out.println("La consulta no se pudo" +e.getMessage().toString());
      }
      finally{
          con.close();
      }
      return Compras;
  }
  public int actualizar(comprasVo compras) throws SQLException{
      sql="UPDATE detalleCompras SET cantidadCompra=?,precioProveedor=?,fechaVencimientoProducto=? WHERE noOrdenCompra=?";
     try{
         con=Conexion.conectar();
         ps=con.prepareStatement(sql);
         System.out.println(ps);
         ps.setInt(1, compras.getEntradaCompras());
         ps.setInt(2, compras.getPrecioCompra());
         ps.setString(3, compras.getFechaCompra());
         ps.setInt(4, compras.getNoOrdenCompra());
         System.out.println(ps);
         ps.executeUpdate();
         ps.close();
         System.out.println("se edito correctamente");
     } catch(Exception e){
         System.err.println("Error al editar"+e.getMessage().toString());
     }
     finally{
         con.close();
     }
     return c;
  }

  public void actualizarExistencias(int cantidadProducto, int idProducto) throws SQLException{
    sql="UPDATE Producto SET cantidadProducto="+cantidadProducto+" WHERE idProducto='"+idProducto+"';";
   try{
       con=Conexion.conectar();
       ps=con.prepareStatement(sql);
       System.out.println(ps);
       System.out.println(ps);
       ps.executeUpdate();
       ps.close();
       System.out.println("Se actualizo el producto correctamente");
   } catch(Exception e){
       System.out.println("Error al editar"+e.getMessage().toString());
   }
   finally{
       con.close();
   }
}

  public void eliminarCompras (int idCompras) throws SQLException{
    sql="DELETE FROM Compras WHERE noOrdenCompra="+idCompras;


  try{
      con=Conexion.conectar();
      ps=con.prepareStatement(sql);
      System.out.println(ps);
      ps.executeUpdate();
      ps.close();
      System.out.println("se elimino bien echo");
  }catch(Exception e){
      System.out.println("Error en la eliminacion"+e.getMessage().toString());
  }
  finally{
      con.close();
  }
}

  public void eliminar(int noOrdenCompra) throws SQLException{
        sql="DELETE FROM detalleCompras WHERE noOrdenCompra="+noOrdenCompra;
  

      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("se elimino bien echo");
      }catch(Exception e){
          System.out.println("Error en la eliminacion"+e.getMessage().toString());
      }
      finally{
          con.close();
      }
  }

}
