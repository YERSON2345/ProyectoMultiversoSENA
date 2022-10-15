package model;

public class productoVo {
    private int idProducto;
    private String nombreProducto;
    private boolean estadoProducto;
    private String observacionesProducto;
    private int cantidadProducto;
    private int precioProducto;
    private int idTipoProducto;

    public productoVo() {

    }

    public productoVo(int idProducto, Boolean estadoProducto, String nombreProducto, String observacionesProducto,
            int cantidadProducto, int precioProducto, int idTipoProducto) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.observacionesProducto = observacionesProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.estadoProducto = estadoProducto;
        this.idTipoProducto=idTipoProducto;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getObservacionesProducto() {
        return observacionesProducto;
    }

    public void setObservacionesProducto(String observacionesProducto) {
        this.observacionesProducto = observacionesProducto;
    }

    public int getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(int cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    public int getPrecioProducto() {
        return precioProducto;
    }

    public void setPrecioProducto(int precioProducto) {
        this.precioProducto = precioProducto;
    }

    public boolean getEstadoProducto() {
        return estadoProducto;
    }

    public void setEstadoProducto(boolean estadoProducto) {
        this.estadoProducto = estadoProducto;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public int getIdTipoProducto() {
        return idTipoProducto;
    }

    public void setIdTipoProducto(int idTipoProducto) {
        this.idTipoProducto = idTipoProducto;
    }
    
}