package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class tipoProductoDao {
    
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    String sql=null;
    int t;

  public List<tipoProductoVo> listar() throws SQLException{
      List<tipoProductoVo> tipoProducto=new ArrayList<>();
      sql="SELECT *FROM TipoProducto";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            tipoProductoVo filas=new tipoProductoVo();
              filas.setIdTipoProducto(rs.getInt("idTipoProducto"));
              filas.setNombreTipoProducto(rs.getString("nombreTipoProducto"));
              filas.setEstadoTipoProducto(rs.getBoolean("estadoTipoProducto"));
              tipoProducto.add(filas);
          }
          ps.close();
          System.out.println("consulta exitosa");
      }catch(Exception e){
          System.out.println("La consulta no se pudo");
      }
      finally{
          con.close();
      }
      return tipoProducto;
  }
  public int registrar (tipoProductoVo tipoProducto) throws SQLException{
       sql="INSERT INTO TipoProducto(nombreTipoProducto,estadoTipoProducto) values(?,?)";
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          ps.setString(1, tipoProducto.getNombreTipoProducto());
          ps.setBoolean(2, tipoProducto.getEstadoTipoProducto());
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
      return t;
  }

  public List<tipoProductoVo> editarTipoProducto(int idTipoProducto) throws SQLException{
      List<tipoProductoVo> tipoProducto=new ArrayList<>();
      sql="SELECT * FROM TipoProducto WHERE idTipoProducto ="+idTipoProducto;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs=ps.executeQuery(sql);
          while(rs.next()){
            tipoProductoVo t=new tipoProductoVo();
              t.setIdTipoProducto(rs.getInt("idTipoProducto"));
              t.setNombreTipoProducto(rs.getString("nombreTipoProducto"));
              t.setEstadoTipoProducto(rs.getBoolean("estadoTipoProducto"));
              tipoProducto.add(t);
          }
          ps.close();
          System.out.println("consulta bien echa");
      }catch (Exception e){
          System.out.println("La consulta no se pudo" +e.getMessage().toString());
      }
      finally{
          con.close();
      }
      return tipoProducto;
  }
  public int actualizar(tipoProductoVo tipoProducto) throws SQLException{
      sql="UPDATE TipoProducto SET nombreTipoProducto=?,estadoTipoProducto=? WHERE idTipoProducto=?";
     try{
         con=Conexion.conectar();
         ps=con.prepareStatement(sql);
         System.out.println(ps);
         ps.setString(1, tipoProducto.getNombreTipoProducto());
         ps.setBoolean(2, tipoProducto.getEstadoTipoProducto());
         ps.setInt(3, tipoProducto.getIdTipoProducto());
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
     return t;
  }

  public void estado(Boolean estadoTipoProducto, int idTipoProducto) throws SQLException{
      sql="UPDATE TipoProducto SET estadoTipoProducto="+estadoTipoProducto+" WHERE idTipoProducto="+idTipoProducto;
      try{
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          System.out.println(ps);
          ps.executeUpdate();
          ps.close();
          System.out.println("Se cambio el estado a"+estadoTipoProducto);
      }catch(Exception e){
          System.out.println("error al cambiar estado"+e.getMessage().toString());
      }
      finally{
          con.close();
      }
  }

  public void eliminar (int idTipoProducto) throws SQLException{
      sql="DELETE FROM TipoProducto WHERE idTipoProducto="+idTipoProducto;
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
