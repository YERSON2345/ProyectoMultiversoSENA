package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class productoDao {
    
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int p;

    // public productoVo buscar(int id){
    //     productoVo pro = new productoVo();
    //     String sql = "SELECT * FROM producto WHERE idProducto" + id;
    //     try {
    //         con = Conexion.conectar();
    //         ps = con.prepareStatement(sql);
    //         rs = ps.executeQuery();

    //         while (rs.next()) {
    //             pro.setIdProducto(rs.getInt(1));
    //             pro.setObservacionesProducto(rs.getString(2));
    //             pro.setNombreProducto(rs.getString(3));
    //             pro.setEstadoProducto(rs.getBoolean(4));
    //             pro.setCantidadProducto(rs.getInt(5));
    //             pro.setPrecioProducto(rs.getInt(6));
    //             pro.setIdTipoProducto(rs.getInt(7));
    //         }
    //     } catch (Exception e) {
    //         System.out.println(e.toString());
    //     }
	// 	return pro;
    // }

    //     public int actualizarStock(int idp, int cant){
    //     String sql = "UPDATE producto SET cantidadProducto = ? WHERE idProducto = ?";
    //     try {
    //         con = Conexion.conectar();
    //         ps = con.prepareStatement(sql);
    //         ps.setInt(1, cant);
    //         ps.setInt(2, idp);
    //         ps.executeUpdate();
    //     } catch (SQLException e) {
    //         System.out.println(e.toString());
    //     }
	// 	return p;
    // }

  public List<productoVo> listar() throws SQLException{
      List<productoVo> producto=new ArrayList<>();
      sql="SELECT U.idProducto,U.fechaVencimiento,U.nombreProducto,U.observacionesProducto,U.cantidadProducto,U.estadoProducto,U.precioProducto,U.idTipoProducto,P.nombreTipoProducto FROM Producto U INNER JOIN tipoProducto P ON U.idTipoProducto = P.idTipoProducto;";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            productoVo filas=new productoVo();
              filas.setIdProducto(rs.getInt("idProducto"));
              filas.setfechaVencimiento(rs.getString("fechaVencimiento"));
              filas.setObservacionesProducto(rs.getString("observacionesProducto"));
              filas.setNombreProducto(rs.getString("nombreProducto"));
              filas.setEstadoProducto(rs.getBoolean("estadoProducto"));
              filas.setCantidadProducto(rs.getInt("cantidadProducto"));
              filas.setPrecioProducto(rs.getInt("precioProducto"));
              filas.setIdTipoProducto(rs.getInt("idTipoProducto"));
              filas.setNombreTipoProducto(rs.getString("nombreTipoProducto"));

              producto.add(filas);
          }
          ps.close();
          System.out.println("consulta exitosa");
      }catch(Exception e){
          System.out.println("La consulta no se pudo");
      }
      finally{
          con.close();
      }
      return producto;
  }

  public List<productoVo> cantidadDias() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT COUNT(*) AS cantidadRegistros FROM producto WHERE DATEDIFF(fechaVencimiento,NOW()) <= 30;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setcantidadRegistros(rs.getInt("cantidadRegistros"));
            producto.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}

public List<productoVo> cantidad() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT COUNT(*) AS cantidad FROM producto WHERE cantidadProducto <= 10;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setcantidad(rs.getInt("cantidad"));
            producto.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}

public List<productoVo> cantidadProducto() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT nombreProducto,cantidadProducto FROM producto WHERE cantidadProducto <= 10;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            producto.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}

  public List<productoVo> listarDias() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT nombreProducto, NOW() AS fechaActual, DATEDIFF(fechaVencimiento, NOW()) AS DIFERENCIA_DIAS FROM producto WHERE DATEDIFF(fechaVencimiento,NOW()) <= 30;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setDIFERENCIA_DIAS(rs.getInt("DIFERENCIA_DIAS"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            producto.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}

  public List<productoVo> listarStock() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT U.idProducto,U.fechaVencimiento,U.nombreProducto,U.observacionesProducto,U.cantidadProducto,U.precioProducto,U.idTipoProducto,P.nombreTipoProducto FROM Producto U INNER JOIN tipoProducto P ON U.idTipoProducto = P.idTipoProducto;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setIdProducto(rs.getInt("idProducto"));
            filas.setfechaVencimiento(rs.getString("fechaVencimiento"));
            filas.setObservacionesProducto(rs.getString("observacionesProducto"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            filas.setPrecioProducto(rs.getInt("precioProducto"));
            filas.setIdTipoProducto(rs.getInt("idTipoProducto"));
            filas.setNombreTipoProducto(rs.getString("nombreTipoProducto"));
            producto.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("La consulta no se pudo");
    }
    finally{
        con.close();
    }
    return producto;
}
//Listar productos con 30 o menos a vencerse
public List<productoVo> listar_Producto_Fechas() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT nombreProducto,cantidadProducto,fechaVencimiento,observacionesProducto, NOW() AS fechaActual, DATEDIFF(fechaVencimiento, NOW()) AS DIFERENCIA_DIAS FROM producto WHERE DATEDIFF(fechaVencimiento,NOW()) <= 30;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setDIFERENCIA_DIAS(rs.getInt("DIFERENCIA_DIAS"));
            filas.setfechaVencimiento(rs.getString("fechaVencimiento"));
            filas.setfecha_actual(rs.getString("fechaActual"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            filas.setObservacionesProducto(rs.getString("observacionesProducto"));
            producto.add(filas);
        }
        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}
//Listar productos con menos de 10 cantidades
public List<productoVo> listar_Producto_Cantidad() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT P.idProducto,NOW() AS fechaActual,P.nombreProducto,P.cantidadProducto,P.observacionesProducto,P.precioProducto,T.nombreTipoProducto FROM Producto P INNER JOIN tipoProducto T ON P.idTipoProducto = T.idTipoProducto WHERE P.cantidadProducto <=10;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setIdProducto(rs.getInt("idProducto"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            filas.setCantidadProducto(rs.getInt("cantidadProducto"));
            filas.setObservacionesProducto(rs.getString("observacionesProducto"));
            filas.setPrecioProducto(rs.getInt("precioProducto"));
            filas.setNombreTipoProducto(rs.getString("nombreTipoProducto"));
            filas.setfecha_actual(rs.getString("fechaActual"));
            producto.add(filas);
        }

        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}
//Listar la fecha actual
public List<productoVo> listar_Fecha() throws SQLException{
    List<productoVo> producto=new ArrayList<>();
    sql="SELECT NOW() AS fechaActual;";
    try{
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs=ps.executeQuery(sql);
        while(rs.next()){
          productoVo filas=new productoVo();
            filas.setfecha_actual(rs.getString("fechaActual"));
            producto.add(filas);
        }

        ps.close();
        System.out.println("consulta exitosa");
    }catch(Exception e){
        System.out.println("no se pudo listar dias de diferencia");
    }
    finally{
        con.close();
    }
    return producto;
}

  public int registrar (productoVo producto) throws SQLException{
       sql="INSERT INTO Producto(fechaVencimiento,observacionesProducto,nombreProducto,estadoProducto,cantidadProducto,precioProducto,idTipoProducto) values(?,?,?,?,?,?,?)";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.setString(1, producto.getfechaVencimiento());
          ps.setString(2, producto.getObservacionesProducto());
          ps.setString(3, producto.getNombreProducto());
          ps.setBoolean(4, producto.getEstadoProducto());
          ps.setInt(5, producto.getCantidadProducto());
          ps.setInt(6, producto.getPrecioProducto());
          ps.setInt(7, producto.getIdTipoProducto());
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
      return p;
  }

  public List<productoVo> editarProducto(int idProducto) throws SQLException{
      List<productoVo> producto=new ArrayList<>();
      sql="SELECT * FROM Producto WHERE idProducto ="+idProducto;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            productoVo p=new productoVo();
            p.setIdProducto(rs.getInt("idProducto"));
            p.setfechaVencimiento(rs.getString("fechaVencimiento"));
            p.setObservacionesProducto(rs.getString("observacionesProducto"));
            p.setNombreProducto(rs.getString("nombreProducto"));
            p.setEstadoProducto(rs.getBoolean("estadoProducto"));
            p.setPrecioProducto(rs.getInt("precioProducto"));
            producto.add(p);
          }
          ps.close();
          System.out.println("consulta bien echa");
      }catch (Exception e){
          System.out.println("La consulta no se pudo" +e.getMessage().toString());
      }
      finally{
          con.close();
      }
      return producto;
  }
  public int actualizar(productoVo producto) throws SQLException{
      sql="UPDATE Producto SET fechaVencimiento=?,observacionesProducto=?,nombreProducto=?,estadoProducto=?,precioProducto=? WHERE idProducto=?";
     try{
         con=Conexion.conectar();
         ps=con.prepareStatement(sql);
         System.out.println(ps);
         ps.setString(1, producto.getfechaVencimiento());
         ps.setString(2, producto.getObservacionesProducto());
          ps.setString(3, producto.getNombreProducto());
          ps.setBoolean(4, producto.getEstadoProducto());
          ps.setInt(5, producto.getPrecioProducto());
          ps.setInt(6, producto.getIdProducto());
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
     return p;
  }

  public void estado(Boolean estadoProducto, int idProducto) throws SQLException{
      sql="UPDATE Producto SET estadoProducto="+estadoProducto+" WHERE idProducto="+idProducto;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se cambio el estado a"+estadoProducto);
      }catch(Exception e){
          System.out.println("error al cambiar estado"+e.getMessage().toString());
      }
      finally{
          con.close();
      }
  }

  public void eliminar (int idProducto) throws SQLException{
      sql="DELETE FROM Producto WHERE idProducto="+idProducto;
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
