package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ventaDao {
    
    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;

    public List<ventaVo>listar() throws SQLException{
      List<ventaVo> ventas=new ArrayList<>();
      sql="SELECT U.idDetalleVenta,U.cantidadVendida,U.precioTotal,U.idProductoFK, U.noDocCliente,C.nombreProducto,C.cantidadProducto,O.nombreCliente FROM Ventas U INNER JOIN Producto C ON U.idProductoFK = C.idProducto INNER JOIN Cliente O ON O.noDocCliente = U.noDocCliente";
      try {
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs =ps.executeQuery(sql);
          while(rs.next()){
            ventaVo filas = new ventaVo();
            filas.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
            filas.setCantidadVendida(rs.getInt("cantidadVendida"));
            filas.setcantidadProducto(rs.getInt("cantidadProducto"));
            filas.setPrecioTotal(rs.getInt("precioTotal"));
            filas.setidProductoFK(rs.getInt("idProductoFK"));
            filas.setNoDocCliente(rs.getInt("noDocCliente"));
            filas.setNombreCliente(rs.getString("nombreCliente"));
            filas.setNombreProducto(rs.getString("nombreProducto"));
            ventas.add(filas);
          }
          ps.close();
          System.out.println("Consulta exitosa");
      } catch (Exception e) {
          System.out.println("La consulta presenta error"+ e.getMessage().toString());
      }
      finally{
        con.close();
      }
      return ventas;
}

public List<comprasVo> listarProductoVentas(int idProducto) throws SQLException{
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


public int insertar(ventaVo ventas) throws SQLException{   
  sql="INSERT INTO ventas(cantidadVendida,precioTotal,idProductoFK,noDocCliente) values(?,?,?,?)";
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia
      ps.setInt(1, ventas.getCantidadVendida());
      ps.setInt(2, ventas.getPrecioTotal());
      ps.setInt(3, ventas.getidProductoFK());
      ps.setInt(4, ventas.getNoDocCliente());
      System.out.println(ps);
      
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se registró la venta correctamente");
  }catch(Exception e){
      System.out.println("Error en el regisro "+e.getMessage().toString());
  }
  finally{
      con.close();//cerrando conexión
  }
  return r;
}

public List<ventaVo> listarVenta(int id, int cantidadTotal) throws SQLException{
  List<ventaVo> ventas=new ArrayList<>();
  sql="SELECT U.idDetalleVenta,U.cantidadVendida,U.precioTotal,U.idProductoFK, U.noDocCliente,C.nombreProducto,C.observacionesProducto,C.cantidadProducto,C.precioProducto FROM Ventas U INNER JOIN Producto C ON U.idProductoFK = C.idProducto WHERE U.idDetalleVenta ="+id;//variable para la BD
  try {
      con=Conexion.conectar();
      ps=con.prepareStatement(sql);
      rs=ps.executeQuery(sql);
      while(rs.next()){
        ventaVo filas=new ventaVo();
          //Escribir  en el setter cada valor encontrado
          filas.setCantidadVendida(rs.getInt("cantidadVendida"));
          filas.setPrecioTotal(rs.getInt("precioTotal"));
          filas.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
          filas.setidProductoFK(rs.getInt("idProductoFK"));
          filas.setNombreProducto(rs.getString("nombreProducto"));
          filas.setObservacionesProducto(rs.getString("observacionesProducto"));
          filas.setcantidadProducto(rs.getInt("cantidadProducto"));
          filas.setPrecioProducto(rs.getInt("precioProducto"));
          filas.setcantidadTotal(cantidadTotal);

          ventas.add(filas);
      }
      ps.close();
      System.out.println("Consulta exitosa de usuario");
  } catch (Exception e) {
      System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
  }
  finally{
      con.close();
  }
  return ventas;
}

  public int actualizar(ventaVo ventas) throws SQLException{
    sql="UPDATE ventas SET cantidadVendida=?,precioTotal=? WHERE idDetalleVenta=?";//variable para el sql

    try{
        con=Conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.setInt(1, ventas.getCantidadVendida());
        ps.setInt(2, ventas.getPrecioTotal());
        ps.setInt(3, ventas.getIdDetalleVenta());
       
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("Se edito la Venta correctamente");

        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    }
    return r;//retornar numero de filas
    
}

public void eliminar(int id) throws SQLException{
  sql="DELETE FROM ventas WHERE idDetalleVenta="+id;//variable para el sql
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia9
      System.out.println(ps);
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se elimino el registro correctamente correctamente");
      
  }catch(Exception e){
      System.out.println("Error en la eliminación "+e.getMessage().toString());
  }

  finally{
      con.close();//cerrando conexión
  }
 }

public void ActualizarStock(int cantidadProducto, int nombreProducto) throws SQLException{

    sql="UPDATE Producto SET cantidadProducto="+cantidadProducto+" WHERE idProducto='"+nombreProducto+"';";
    try{
       con=Conexion.conectar();
       ps=con.prepareStatement(sql);
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
}
