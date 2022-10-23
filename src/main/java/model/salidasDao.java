package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class salidasDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int c;


  public List<salidasVo>listar() throws SQLException{
      List<salidasVo> compras=new ArrayList<>();
      sql="SELECT U.idProducto,U.nombreProducto,U.observacionesProducto,U.cantidadProducto,U.precioProducto,U.idTipoProducto,C.nombreTipoProducto,P.idSalida,P.cantidadSalidas, P.motivoSalidas FROM Producto U INNER JOIN salidasProducto P ON U.idProducto = P.idProductoSalidas INNER JOIN tipoProducto C ON U.idTipoProducto = C.idTipoProducto;";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            salidasVo filas=new salidasVo();
              filas.setIdSalida(rs.getInt("idSalida"));
              filas.setCantidadSalida(rs.getInt("cantidadSalidas"));
              filas.setMotivoSalidas(rs.getString("motivoSalidas"));
              filas.setNombreProducto(rs.getString("nombreProducto"));
              filas.setCantidadProducto(rs.getInt("cantidadProducto"));
              compras.add(filas);
          }
          ps.close();
          System.out.println("Consulta exitosa de salidas");
      }catch(Exception e){
          System.out.println("La consulta no pudo ni con sigo misma :(");
      }
      finally{
          con.close();
      }
      return compras;
  }
  public List<salidasVo> listarGenero(int id, int cantidad) throws SQLException{
    List<salidasVo> genero=new ArrayList<>();
    sql="SELECT U.idProducto,U.nombreProducto,U.observacionesProducto,U.cantidadProducto,U.precioProducto,U.idTipoProducto,C.nombreTipoProducto,P.cantidadSalidas, P.motivoSalidas,P.idSalida FROM Producto U INNER JOIN salidasProducto P ON U.idProducto = P.idProductoSalidas INNER JOIN tipoProducto C ON U.idTipoProducto = C.idTipoProducto WHERE P.idSalida ="+id;//variable para la BD
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
              salidasVo filas=new salidasVo();
            //Escribir  en el setter cada valor encontrado
            filas.setIdSalida(rs.getInt("idSalida"));
            filas.setCantidadSalida(rs.getInt("cantidadSalidas"));
            filas.setMotivoSalidas(rs.getString("motivoSalidas"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            filas.setIdProducto(rs.getInt("idProducto"));
            filas.setCantidadTotal(cantidad);

            genero.add(filas);
        }
        ps.close();
        System.out.println("Consulta exitosa de salida");
    } catch (Exception e) {
        System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
    }
    finally{
        con.close();
    }
    return genero;
  }

  public List<salidasVo> listarDetalleSalidas() throws SQLException{
    List<salidasVo> salidas=new ArrayList<>();
    sql="SELECT U.idDetalleCompras,C.noOrdenCompra,P.nombreProducto,P.cantidadProducto FROM detalleCompras U INNER JOIN Compras C ON U.noOrdenCompra = C.noOrdenCompra INNER JOIN Producto P ON U.idProducto = P.idProducto;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          salidasVo filas=new salidasVo();
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            salidas.add(filas);
        }
        ps.close();
        System.out.println("Consulta exitosa de compras de productos");
    }catch(Exception e){
        System.out.println("La consulta no se pudo");
    }
    finally{
        con.close();
    }
    return salidas;
}

public List<salidasVo> listarDetalleCompras(int id) throws SQLException{
    List<salidasVo> genero=new ArrayList<>();
    sql="SELECT U.idProducto,U.nombreProducto,U.observacionesProducto,U.cantidadProducto,U.precioProducto,U.idTipoProducto,P.nombreTipoProducto FROM Producto U INNER JOIN tipoProducto P ON U.idTipoProducto = P.idTipoProducto WHERE U.idProducto ="+id;//variable para la BD
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
              salidasVo filas=new salidasVo();
            //Escribir  en el setter cada valor encontrado
            filas.setIdProducto(rs.getInt("idProducto"));
            filas.setObservacionesProducto(rs.getString("observacionesProducto"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            filas.setPrecioProducto(rs.getInt("precioProducto"));
            filas.setIdTipoProducto(rs.getInt("idTipoProducto"));
            filas.setNombreTipoProducto(rs.getString("nombreTipoProducto"));
            genero.add(filas);
        }
        ps.close();
        System.out.println("Consulta exitosa de salida");
    } catch (Exception e) {
        System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
    }
    finally{
        con.close();
    }
    return genero;
  }

  public int registrar (salidasVo salidas) throws SQLException{
       sql="INSERT INTO salidasProducto(cantidadSalidas,motivoSalidas,idProductoSalidas) values(?,?,?)";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.setInt (1, salidas.getCantidadSalida());
          ps.setString(2, salidas.getMotivoSalidas());
          ps.setInt(3, salidas.getIdProducto());
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se registro la salida del producto");
      } catch(Exception e){
          System.out.println("Error"+ e.getMessage().toString());
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

public void actualizarExistenciasP(int cantidadProducto, String nombreProducto) throws SQLException{
    sql="UPDATE Producto SET cantidadProducto="+cantidadProducto+" WHERE nombreProducto='"+nombreProducto+"';";
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

  public int actualizar(salidasVo compras) throws SQLException{
      sql="UPDATE salidasProducto SET cantidadSalidas=?,motivoSalidas=? WHERE idSalida=?";
     try{
         con=Conexion.conectar();
         ps=con.prepareStatement(sql);
         System.out.println(ps);
         ps.setInt(1, compras.getCantidadSalida());
         ps.setString(2, compras.getMotivoSalidas());
         ps.setInt(3, compras.getIdSalida());
         System.out.println(ps);
         ps.executeUpdate();
         ps.close();
         System.out.println("Se edito correctamente");
     } catch(Exception e){
         System.err.println("Error al editar"+e.getMessage().toString());
     }
     finally{
         con.close();
     }
     return c;
  }

  public void eliminar (int idSalida) throws SQLException{
      sql="DELETE FROM salidasProducto WHERE idSalida="+idSalida;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se elimino correctamente");
      }catch(Exception e){
          System.out.println("Error en la eliminacion"+e.getMessage().toString());
      }
      finally{
          con.close();
      }
  }

}

