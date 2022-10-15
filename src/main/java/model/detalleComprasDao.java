package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class detalleComprasDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int d;

  public List<detalleComprasVo> listar() throws SQLException{
      List<detalleComprasVo> detalleCompras=new ArrayList<>();
      sql="SELECT *FROM DetalleCompras";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            detalleComprasVo filas=new detalleComprasVo();
              filas.setIdDetalleCompras(rs.getInt("idDetalleCompras"));
              filas.setCantidadCompra(rs.getInt("cantidadCompra"));
              filas.setPrecioProveedor(rs.getInt("precioProveedor"));
              filas.setFechaVencimientoProducto(rs.getString("fechaVencimientoProducto"));
              detalleCompras.add(filas);
          }
          ps.close();
          System.out.println("consulta exitosa");
      }catch(Exception e){
          System.out.println("La consulta no se pudo");
      }
      finally{
          con.close();
      }
      return detalleCompras;
  }
  public int registrar (detalleComprasVo detalleCompras) throws SQLException{
       sql="INSERT INTO DetalleCompras(cantidadCompra,precioProveedor,fechaVencimientoProducto) values(?,?,?)";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.setInt(1, detalleCompras.getCantidadCompra());
          ps.setInt(2, detalleCompras.getPrecioProveedor());
          ps.setString(3, detalleCompras.getFechaVencimientoProducto());
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
      return d;
  }

  public List<detalleComprasVo> editarDetalleCompras(int idDetalleCompras) throws SQLException{
      List<detalleComprasVo> detalleCompras=new ArrayList<>();
      sql="SELECT * FROM DetalleCompras WHERE idDetalleCompras ="+idDetalleCompras;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            detalleComprasVo d=new detalleComprasVo();
            d.setIdDetalleCompras(rs.getInt("idDetalleCompras"));
            d.setCantidadCompra(rs.getInt("cantidadCompra"));
            d.setPrecioProveedor(rs.getInt("precioProveedor"));
            d.setFechaVencimientoProducto(rs.getString("fechaVencimientoProducto"));;
              detalleCompras.add(d);
          }
          ps.close();
          System.out.println("consulta bien echa");
      }catch (Exception e){
          System.out.println("La consulta no se pudo" +e.getMessage().toString());
      }
      finally{
          con.close();
      }
      return detalleCompras;
  }
  public int actualizar(detalleComprasVo detalleCompras) throws SQLException{
      sql="UPDATE DetalleCompras SET cantidadCompra=?,precioProveedor=?,fechaVencimientoProducto=? WHERE idDetalleCompras=?";
     try{
         con=Conexion.conectar();
         ps=con.prepareStatement(sql);
         System.out.println(ps);
         ps.setInt(1, detalleCompras.getCantidadCompra());
         ps.setInt(2, detalleCompras.getPrecioProveedor());
         ps.setString(3, detalleCompras.getFechaVencimientoProducto());
         ps.setInt(4, detalleCompras.getIdDetalleCompras());
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
     return d;
  }

  public void eliminar (int idDetalleCompras) throws SQLException{
      sql="DELETE FROM DetalleCompras WHERE idDetalleCompras="+idDetalleCompras;
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
