package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class rolDao {

    Connection con; //objeto de conexión
    PreparedStatement ps; //objeto para sentencias preparadas
    ResultSet rs; //objeto para almacenar consultas
    String sql=null; //variable para guardar sentencias
    int r;

    public List<rolVo> listar() throws SQLException{
      List<rolVo> rol=new ArrayList<>();
      sql="SELECT * FROM rol";
      try {
          con=Conexion.conectar();
          ps=con.prepareStatement(sql);
          rs =ps.executeQuery(sql);
          while(rs.next()){
            rolVo filas=new rolVo();

            filas.setIdRol(rs.getInt("idRol"));
            filas.setTiporol(rs.getString("tipoRol"));
            rol.add(filas);

          }
          ps.close();
          System.out.println("Consulta exitosa");
      } catch (Exception e) {
          System.out.println("La consulta presenta error"+ e.getMessage().toString());
      }
      finally{
        con.close();
      }
      return rol;
}


}
