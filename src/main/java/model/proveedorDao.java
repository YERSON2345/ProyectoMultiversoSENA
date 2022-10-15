package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class proveedorDao{

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;

    public List<proveedorVo> listar() throws SQLException{
      List<proveedorVo> proveedor=new ArrayList<>();
      sql="SELECT * FROM Proveedor";
      try {
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs =ps.executeQuery(sql);
          while(rs.next()){
            proveedorVo filas=new proveedorVo();

            filas.setIdProveedor(rs.getInt("idProveedor"));
            filas.setNombreProveedor(rs.getString("nombreProveedor"));
            filas.setEmpresaProveedor(rs.getString("empresaProveedor"));
            filas.setEstadoProveedor(rs.getBoolean("estadoProveedor"));
            proveedor.add(filas);

          }
          ps.close();
          System.out.println("Consulta exitosa");
      } catch (Exception e) {
          System.out.println("La consulta presenta error"+ e.getMessage().toString());
      }
      finally{
        con.close();
      }
      return proveedor;
}

public int insertar(proveedorVo proveedor) throws SQLException{   
  sql="INSERT INTO Proveedor(nombreProveedor, empresaProveedor, estadoProveedor) values(?,?,?)";
  try{
      con=Conexion.conectar(); //abrir conexión
      ps=con.prepareStatement(sql); //preparar sentencia
      ps.setString(1, proveedor.getNombreProveedor());
      ps.setString(2, proveedor.getEmpresaProveedor());
      ps.setBoolean(3, proveedor.getEstadoProveedor());      
      System.out.println(ps);
      
      ps.executeUpdate(); //Ejecutar sentencia
      ps.close(); //cerrar sentencia
      System.out.println("Se registró el proveedor correctamente");
  }catch(Exception e){
      System.out.println("Error en el regisro "+e.getMessage().toString());
  }
  finally{
      con.close();//cerrando conexión
  }
  return r;
}

public List<proveedorVo> listarProveedor(int id) throws SQLException{
  List<proveedorVo> proveedor=new ArrayList<>();
  sql="SELECT * FROM Proveedor WHERE idProveedor="+id;//variable para la BD
  try {
      con=Conexion.conectar();
      ps=con.prepareStatement(sql);
      rs=ps.executeQuery(sql);
      while(rs.next()){
        proveedorVo filas=new proveedorVo();
          //Escribir  en el setter cada valor encontrado
          filas.setIdProveedor(rs.getInt("idProveedor"));
          filas.setNombreProveedor(rs.getString("nombreProveedor"));
          filas.setEmpresaProveedor(rs.getString("empresaProveedor"));
          filas.setEstadoProveedor(rs.getBoolean("estadoProveedor"));
          proveedor.add(filas);
      }
      ps.close();
      System.out.println("Consulta exitosa de usuario");
  } catch (Exception e) {
      System.out.println("La consulta no pudo ser ejecutada "+e.getMessage().toString());//Error
  }
  finally{
      con.close();
  }
  return proveedor;
}

  public int actualizar(proveedorVo proveedor) throws SQLException{
    sql="UPDATE Proveedor SET nombreProveedor=?,empresaProveedor=? WHERE idProveedor=?";//variable para el sql

    try{
        con=Conexion.conectar(); //abrir conexión
        ps=con.prepareStatement(sql); //preparar sentencia
        System.out.println(ps);
        ps.setString(1, proveedor.getNombreProveedor());
        ps.setString(2, proveedor.getEmpresaProveedor());
        ps.setInt(3, proveedor.getIdProveedor());
       
        System.out.println(ps);
        ps.executeUpdate(); //Ejecutar sentencia
        ps.close(); //cerrar sentencia
        System.out.println("Se edito el Proveedor correctamente");

        
    }catch(Exception e){
        System.out.println("Error al editar "+e.getMessage().toString());
    }

    finally{
        con.close();//cerrando conexión
    }
    return r;//retornar numero de filas
    
}

public void cambiarEstado(Boolean estado, int id) throws SQLException{
    sql="UPDATE proveedor SET estadoProveedor="+estado+" WHERE idProveedor="+id;//variable para el sql
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
  sql="DELETE FROM Proveedor WHERE idProveedor="+id;//variable para el sql
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
