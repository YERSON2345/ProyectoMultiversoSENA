package model;

public class detalleComprasVo{
    private int idDetalleCompras;
    private String fechaVencimientoProducto;
    private int cantidadCompra;
    private int precioProveedor;
    private int noOrdenCompra;
    private int idProducto;
    private int idProveedor;

    public detalleComprasVo(){

    }

    public detalleComprasVo(int idDetalleCompras, String fechaVencimientoProducto, int cantidadCompra,
            int precioProveedor, int idProducto, int idProveedor, int noOrdenCompra) {
        this.idDetalleCompras = idDetalleCompras;
        this.fechaVencimientoProducto = fechaVencimientoProducto;
        this.cantidadCompra = cantidadCompra;
        this.precioProveedor = precioProveedor;
        this.idProducto = idProducto;
        this.idProveedor = idProveedor;
        this.noOrdenCompra = noOrdenCompra;
    }

    public int getIdDetalleCompras() {
        return idDetalleCompras;
    }

    public void setIdDetalleCompras(int idDetalleCompras) {
        this.idDetalleCompras = idDetalleCompras;
    }
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    
    public String getFechaVencimientoProducto() {
        return fechaVencimientoProducto;
    }

    public void setFechaVencimientoProducto(String fechaVencimientoProducto) {
        this.fechaVencimientoProducto = fechaVencimientoProducto;
    }

    public int getCantidadCompra() {
        return cantidadCompra;
    }

    public void setCantidadCompra(int cantidadCompra) {
        this.cantidadCompra = cantidadCompra;
    }

    public int getPrecioProveedor() {
        return precioProveedor;
    }

    public void setPrecioProveedor(int precioProveedor) {
        this.precioProveedor = precioProveedor;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }
    public int getnoOrdenCompra() {
        return noOrdenCompra;
    }

    public void setnoOrdenCompra(int noOrdenCompra) {
        this.noOrdenCompra = noOrdenCompra;
    }
    
}