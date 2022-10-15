package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class usuarioDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    Statement st;
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;

//CONSULTA PARA USUARIO ACTIVOS
    public List<usuarioVo> listar() throws SQLException{
      List<usuarioVo> usuario=new ArrayList<>();
      sql="SELECT * FROM Usuario WHERE estadoUsuario = 1";
      try {
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs =ps.executeQuery(sql);
          while(rs.next()){
            usuarioVo filas=new usuarioVo();

            filas.setNoDocUsuario(rs.getInt("noDocUsuario"));
            filas.setIdRol(rs.getInt("idRol"));
            filas.setNombreUsuario(rs.getString("nombreUsuario"));
            filas.setApellidoUsuario(rs.getString("apellidoUsuario"));
            filas.setTipoDocUsuario(rs.getString("tipoDocUsuario"));
            filas.setCorreoUsuario(rs.getString("correoUsuario"));
            filas.setContrasenaUsuario(rs.getString("contrasenaUsuario"));
            filas.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
            usuario.add(filas);

          }
          ps.close();
          System.out.println("Consulta exitosa");
      } catch (Exception e) {
          System.out.println("La consulta presenta error"+ e.getMessage().toString());
      }
      finally{
        con.close();
      }
      return usuario;
}
//CONSULTAR PARA PETICIONES
public List<usuarioVo> listarPorEstado() throws SQLException{
    List<usuarioVo> usuario=new ArrayList<>();
    sql="SELECT * FROM Usuario WHERE estadoUsuario = 0";
    try {
        con=Conexion.conectar();
        ps=con.prepareStatement(sql);
        rs =ps.executeQuery(sql);
        while(rs.next()){
          usuarioVo filas=new usuarioVo();

          filas.setNoDocUsuario(rs.getInt("noDocUsuario"));
          filas.setIdRol(rs.getInt("idRol"));
          filas.setNombreUsuario(rs.getString("nombreUsuario"));
          filas.setApellidoUsuario(rs.getString("apellidoUsuario"));
          filas.setTipoDocUsuario(rs.getString("tipoDocUsuario"));
          filas.setCorreoUsuario(rs.getString("correoUsuario"));
          filas.setContrasenaUsuario(rs.getString("contrasenaUsuario"));
          filas.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
          usuario.add(filas);

        }
        ps.close();
        System.out.println("Consulta exitosa");
    } catch (Exception e) {
        System.out.println("La consulta presenta error"+ e.getMessage().toString());
    }
    finally{
      con.close();
    }
    return usuario;
}

//REGISTRO DE USUARIO
public int insertar(usuarioVo usuario) throws SQLException{   
  sql="INSERT INTO Usuario(nombreUsuario,apellidoUsuario,tipoDocUsuario,correoUsuario,noDocUsuario,contrasenaUsuario,estadoUsuario,idRol) values(?,?,?,?,?,?,?,?)";
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia
      ps.setString(1, usuario.getNombreUsuario());
      ps.setString(2, usuario.getApellidoUsuario());
      ps.setString(3, usuario.getTipoDocUsuario());
      ps.setString(4, usuario.getCorreoUsuario());
      ps.setInt(5, usuario.getNoDocUsuario());
      ps.setString(6, usuario.getContrasenaUsuario());
      ps.setBoolean(7, usuario.getEstadoUsuario());
      ps.setInt(8, usuario.getIdRol());
      System.out.println(ps);
      
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se registró el genero correctamente");
  }catch(Exception e){
      System.out.println("Error en el regisro "+e.getMessage().toString());
  }
  finally{
      con.close();//cerrando conexión
  }
  return r;
}

//LISATR USUARIO POR ID
public List<usuarioVo> listarUsuario(int id) throws SQLException{
  List<usuarioVo> usuario=new ArrayList<>();
  sql="SELECT * FROM Usuario WHERE noDocUsuario="+id;//variable para la BD
  try {
      con=Conexion.conectar();
      ps=con.prepareStatement(sql);
      rs=ps.executeQuery(sql);
      while(rs.next()){
        usuarioVo filas=new usuarioVo();
          //Escribir  en el setter cada valor encontrado
          filas.setNombreUsuario(rs.getString("nombreUsuario"));
          filas.setApellidoUsuario(rs.getString("apellidoUsuario"));
          filas.setCorreoUsuario(rs.getString("correoUsuario"));
          filas.setTipoDocUsuario(rs.getString("tipoDocUsuario"));
          filas.setNoDocUsuario(rs.getInt("noDocUsuario"));
          filas.setContrasenaUsuario(rs.getString("contrasenaUsuario"));//peticion de nombre
          filas.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
          filas.setIdRol(rs.getInt("idRol"));//peticion de estado
          usuario.add(filas);
      }
      ps.close();
      System.out.println("Consulta exitosa de usuario");
  } catch (Exception e) {
      System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
  }
  finally{
      con.close();
  }
  return usuario;
}

  public int actualizar(usuarioVo usuario) throws SQLException{
    sql="UPDATE Usuario SET nombreUsuario=?,apellidoUsuario=?,correoUsuario=?,contrasenaUsuario=?,estadoUsuario=?,idRol=? WHERE noDocUsuario=?";//variable para el sql

    try{
        con=Conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.setString(1, usuario.getNombreUsuario());
        ps.setString(2, usuario.getApellidoUsuario());
        ps.setString(3, usuario.getCorreoUsuario());
        ps.setString(4, usuario.getContrasenaUsuario());
        ps.setBoolean(5, usuario.getEstadoUsuario());
        ps.setInt(6, usuario.getIdRol());
        ps.setInt(7, usuario.getNoDocUsuario());
       
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("Se edito el Usuario correctamente");

        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    }
    return r;//retornar numero de filas
    
}

//ACEPTAR O RECHAZAR LA PETICIÓN
public void cambiarEstado(Boolean estado, int id) throws SQLException{
  sql="UPDATE Usuario SET estadoUsuario="+estado+" WHERE noDocUsuario="+id;//variable para el sql
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
//ELIMINAR EL USUARIO
public void eliminar(int id) throws SQLException{
  sql="DELETE FROM Usuario WHERE noDocUsuario="+id;//variable para el sql
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

}
