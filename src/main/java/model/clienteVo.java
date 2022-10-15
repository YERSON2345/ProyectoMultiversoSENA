package model;

public class clienteVo {

    private String tipoDocCliente;
    private int noDocCliente;
    private String nombreCliente;
    private String apellidoCliente;
    private int telefonoCliente;
    private String correoCliente;
    private String direccionDestinoVenta;
    private Boolean frecuenciaCliente;
    private Boolean estadoCliente;

    public clienteVo(){
        
    }

    public clienteVo(String tipoDocCliente, int noDocCliente, String nombreCliente, String apellidoCliente,
            int telefonoCliente, String correoCliente, String direccionDestinoVenta, Boolean frecuenciaCliente,
            Boolean estadoCliente) {
        this.tipoDocCliente = tipoDocCliente;
        this.noDocCliente = noDocCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
        this.telefonoCliente = telefonoCliente;
        this.correoCliente = correoCliente;
        this.direccionDestinoVenta = direccionDestinoVenta;
        this.frecuenciaCliente = frecuenciaCliente;
        this.estadoCliente = estadoCliente;
    }

    public String getTipoDocCliente() {
        return tipoDocCliente;
    }

    public void setTipoDocCliente(String tipoDocCliente) {
        this.tipoDocCliente = tipoDocCliente;
    }

    public int getNoDocCliente() {
        return noDocCliente;
    }

    public void setNoDocCliente(int noDocCliente) {
        this.noDocCliente = noDocCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public int getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(int telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public String getDireccionDestinoVenta() {
        return direccionDestinoVenta;
    }

    public void setDireccionDestinoVenta(String direccionDestinoVenta) {
        this.direccionDestinoVenta = direccionDestinoVenta;
    }

    public Boolean getFrecuenciaCliente() {
        return frecuenciaCliente;
    }

    public void setFrecuenciaCliente(Boolean frecuenciaCliente) {
        this.frecuenciaCliente = frecuenciaCliente;
    }

    public Boolean getEstadoCliente() {
        return estadoCliente;
    }

    public void setEstadoCliente(Boolean estadoCliente) {
        this.estadoCliente = estadoCliente;
    }

}
