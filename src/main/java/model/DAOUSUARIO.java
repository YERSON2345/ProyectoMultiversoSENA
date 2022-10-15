package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DAOUSUARIO extends conexions {
    public usuarioVo identificar(usuarioVo user) throws Exception{
        usuarioVo usu = null;
        conexions con;
        Connection cn = null;
        Statement st = null;
        ResultSet rs = null;
        String sql = "SELECT U.noDocUsuario,U.nombreUsuario,U.apellidoUsuario,U.estadoUsuario, C.tipoRol FROM Usuario U "
                + "INNER JOIN rol C ON U.idRol = C.idRol "
                + "WHERE U.correoUsuario = '" + user.getCorreoUsuario() + "' "
                + "AND U.contrasenaUsuario = '"+ user.getContrasenaUsuario() + "'";
        con = new conexions();
        try{
            cn = con.conectar();
            st = cn.createStatement();
            rs = st.executeQuery(sql);
            if(rs.next() == true){
                usu = new usuarioVo();
                usu.setNoDocUsuario(rs.getInt("noDocUsuario"));
                usu.setNombreUsuario(rs.getString("nombreUsuario"));
                usu.setApellidoUsuario(rs.getString("apellidoUsuario"));
                usu.setEstadoUsuario(rs.getBoolean("estadoUsuario"));
                usu.setRol(new rolVo());
                usu.getRol().setTiporol(rs.getString("tipoRol"));
            }
        }catch(Exception e){
            System.out.println("Error" + e.getMessage());
        }finally{
            if (rs !=null && rs.isClosed() == false){
                rs.close();
            }
            rs = null;
            if(st!= null && st.isClosed() == false){
                st.close();
                
            }
            st = null;
            if(cn != null & cn.isClosed() == false){
                cn.close();
                
            }
            cn = null;
        }
        return usu;
    }
}
