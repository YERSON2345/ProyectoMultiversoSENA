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
      sql="SELECT U.idDetalleCompras,U.fechaVencimientoProducto,U.cantidadCompra,U.precioProveedor,C.noOrdenCompra, O.nombreProveedor,P.nombreProducto FROM detalleCompras U INNER JOIN Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Proveedor O ON U.idProveedor = O.idProveedor INNER JOIN Producto P ON U.idProducto = P.idProducto;";
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

  public int  registrarDetalle (detalleComprasVo detalleCompras) throws SQLException{
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

  public List<comprasVo> editarCompras(int idCompras) throws SQLException{
      List<comprasVo> Compras=new ArrayList<>();
      sql="SELECT * FROM Compras WHERE idCompras ="+idCompras;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            comprasVo c=new comprasVo();
              c.setIdCompras(rs.getInt("idCompras"));
              c.setEntradaCompras(rs.getInt("entradasCompras"));
              c.setNoOrdenCompra(rs.getInt("noOrdenCompra"));
              c.setFechaCompra(rs.getString("fechaCompra"));
              Compras.add(c);
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
      sql="UPDATE Compras SET entradasCompras=?,noOrdenCompra=?,fechaCompra=? WHERE idCompras=?";
     try{
         con=Conexion.conectar();
         ps=con.prepareStatement(sql);
         System.out.println(ps);
         ps.setInt(1, compras.getEntradaCompras());
         ps.setInt(2, compras.getNoOrdenCompra());
         ps.setString(3, compras.getFechaCompra());
         ps.setInt(4, compras.getIdCompras());
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

  public void eliminar (int idCompras) throws SQLException{
      sql="DELETE FROM Compras WHERE idCompras="+idCompras;
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
