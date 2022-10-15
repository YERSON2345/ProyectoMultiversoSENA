package model;

public class usuarioVo {
    
    private String nombreUsuario;
    private String apellidoUsuario;
    private String tipoDocUsuario;
    private String correoUsuario;
    private int noDocUsuario;
    private String contrasenaUsuario;
    private Boolean estadoUsuario;
    private int idRol;
    private rolVo rol;

    public usuarioVo(){

    }

    public usuarioVo(String nombreUsuario, String apellidoUsuario, String tipoDocUsuario, String correoUsuario,
            int noDocUsuario, String contrasenaUsuario, Boolean estadoUsuario, int idRol, rolVo rol) {
        this.nombreUsuario = nombreUsuario;
        this.apellidoUsuario = apellidoUsuario;
        this.tipoDocUsuario = tipoDocUsuario;
        this.correoUsuario = correoUsuario;
        this.noDocUsuario = noDocUsuario;
        this.contrasenaUsuario = contrasenaUsuario;
        this.estadoUsuario = estadoUsuario;
        this.idRol = idRol;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getApellidoUsuario() {
        return apellidoUsuario;
    }

    public void setApellidoUsuario(String apellidoUsuario) {
        this.apellidoUsuario = apellidoUsuario;
    }

    public String getTipoDocUsuario() {
        return tipoDocUsuario;
    }

    public void setTipoDocUsuario(String tipoDocUsuario) {
        this.tipoDocUsuario = tipoDocUsuario;
    }

    public String getCorreoUsuario() {
        return correoUsuario;
    }

    public void setCorreoUsuario(String correoUsuario) {
        this.correoUsuario = correoUsuario;
    }

    public int getNoDocUsuario() {
        return noDocUsuario;
    }

    public void setNoDocUsuario(int noDocUsuario) {
        this.noDocUsuario = noDocUsuario;
    }

    public String getContrasenaUsuario() {
        return contrasenaUsuario;
    }

    public void setContrasenaUsuario(String contrasenaUsuario) {
        this.contrasenaUsuario = contrasenaUsuario;
    }

    public Boolean getEstadoUsuario() {
        return estadoUsuario;
    }

    public void setEstadoUsuario(Boolean estadoUsuario) {
        this.estadoUsuario = estadoUsuario;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public rolVo getRol() {
        return rol;
    }

    public void setRol(rolVo rol) {
        this.rol = rol;
    }


    

}
