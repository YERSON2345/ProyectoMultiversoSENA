package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class clienteDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;

    public List<clienteVo> listar() throws SQLException{
      List<clienteVo> genero=new ArrayList<>();
      sql="SELECT * FROM cliente";
      try {
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs =ps.executeQuery(sql);
          while(rs.next()){
            clienteVo filas=new clienteVo();

            filas.setNoDocCliente(rs.getInt("noDocCliente"));
            filas.setTelefonoCliente(rs.getInt("telefonoCliente"));
            filas.setTipoDocCliente(rs.getString("tipoDocCliente"));
            filas.setNombreCliente(rs.getString("nombreCliente"));
            filas.setApellidoCliente(rs.getString("apellidoCliente"));
            filas.setCorreoCliente(rs.getString("correoCliente"));
            filas.setDireccionDestinoVenta(rs.getString("direccionDestinoVenta"));
            filas.setFrecuenciaCliente(rs.getBoolean("frecuenciaCliente"));
            genero.add(filas);

          }
          ps.close();
          System.out.println("Consulta exitosa");
      } catch (Exception e) {
          System.out.println("La consulta presenta error"+ e.getMessage().toString());
      }
      finally{
        con.close();
      }
      return genero;
}

public int insertar(clienteVo genero) throws SQLException{   
  sql="INSERT INTO cliente(tipoDocCliente,noDocCliente,nombreCliente,apellidoCliente,telefonoCliente,correoCliente,direccionDestinoVenta,frecuenciaCliente) values(?,?,?,?,?,?,?,?)";
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia
      ps.setString(1, genero.getTipoDocCliente());
      ps.setInt(2, genero.getNoDocCliente());
      ps.setString(3, genero.getNombreCliente());
      ps.setString(4, genero.getApellidoCliente());
      ps.setInt(5, genero.getTelefonoCliente());
      ps.setString(6, genero.getCorreoCliente());
      ps.setString(7, genero.getDireccionDestinoVenta());
      ps.setBoolean(8, genero.getFrecuenciaCliente());
      System.out.println(ps);
      
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se registró el cliente correctamente");
  }catch(Exception e){
      System.out.println("Error en el regisro "+e.getMessage().toString());
  }
  finally{
      con.close();//cerrando conexión
  }
  return r;
}

public List<clienteVo> listarGenero(int id) throws SQLException{
  List<clienteVo> genero=new ArrayList<>();
  sql="SELECT * FROM cliente WHERE noDocCliente="+id;//variable para la BD
  try {
      con=Conexion.conectar();
      ps=con.prepareStatement(sql);
      rs=ps.executeQuery(sql);
      while(rs.next()){
            clienteVo filas=new clienteVo();
          //Escribir  en el setter cada valor encontrado
          filas.setNoDocCliente(rs.getInt("noDocCliente"));
          filas.setTelefonoCliente(rs.getInt("telefonoCliente"));
          filas.setTipoDocCliente(rs.getString("tipoDocCliente"));
          filas.setNombreCliente(rs.getString("nombreCliente"));
          filas.setApellidoCliente(rs.getString("apellidoCliente"));
          filas.setCorreoCliente(rs.getString("correoCliente"));
          filas.setDireccionDestinoVenta(rs.getString("direccionDestinoVenta"));
          filas.setFrecuenciaCliente(rs.getBoolean("frecuenciaCliente"));
          genero.add(filas);
      }
      ps.close();
      System.out.println("Consulta exitosa de Cliente");
  } catch (Exception e) {
      System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
  }
  finally{
      con.close();
  }
  return genero;
}

  public int actualizar(clienteVo genero) throws SQLException{
    sql="UPDATE cliente SET telefonoCliente=?,nombreCliente=? ,apellidoCliente=? ,correoCliente=? ,direccionDestinoVenta=? ,frecuenciaCliente=?  WHERE noDocCliente=?";//variable para el sql

    try{
        con=Conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.setInt(1, genero.getTelefonoCliente());
        ps.setString(2, genero.getNombreCliente());
        ps.setString(3, genero.getApellidoCliente());
        ps.setString(4, genero.getCorreoCliente());
        ps.setString(5, genero.getDireccionDestinoVenta());
        ps.setBoolean(6, genero.getFrecuenciaCliente());
        ps.setInt(7, genero.getNoDocCliente());
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("Se edito el genero correctamente");

        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    }
    return r;//retornar numero de filas
    
}

public void cambiarEstado(Boolean estado, int id) throws SQLException{
  sql="UPDATE Cliente SET frecuenciaCliente="+estado+" WHERE noDocCliente="+id;//variable para el sql
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia
      System.out.println(ps);
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se cambio el estado a "+estado+" correctamente");
      
  }catch(Exception e){
      System.out.println("Error en el cambio de estado "+e.getMessage().toString());
  }

  finally{
      con.close();//cerrando conexión
  }
}

public void eliminar(int id) throws SQLException{
  sql="DELETE FROM Cliente WHERE noDocCliente="+id;//variable para el sql
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia9
      System.out.println(ps);
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se elimino el registro correctamente");
      
  }catch(Exception e){
      System.out.println("Error en la eliminación "+e.getMessage().toString());
  }

  finally{
      con.close();//cerrando conexión
  }
}
  
}

