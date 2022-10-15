package model;

public class tipoProductoVo {
    private int idTipoProducto;
    private String nombreTipoProducto;
    private Boolean estadoTipoProducto;
    
    public tipoProductoVo(){
        
    }

    public tipoProductoVo(int idTipoProducto, String nombreTipoProducto, Boolean estadoTipoProducto) {
        this.idTipoProducto = idTipoProducto;
        this.nombreTipoProducto = nombreTipoProducto;
        this.estadoTipoProducto = estadoTipoProducto;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }

    public String getNombreTipoProducto() {
        return nombreTipoProducto;
    }

    public void setNombreTipoProducto(String nombreTipoProducto) {
        this.nombreTipoProducto = nombreTipoProducto;
    }

    public Boolean getEstadoTipoProducto() {
        return estadoTipoProducto;
    }

    public void setEstadoTipoProducto(Boolean estadoTipoProducto) {
        this.estadoTipoProducto = estadoTipoProducto;
    }
    
}
