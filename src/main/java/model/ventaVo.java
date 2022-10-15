package model;

public class ventaVo {

    private int idDetalleVenta;
    private int cantidadVendida;
    private int precioTotal;
    private int idProductoFK;
    private int noDocCliente;
    private String nombreProducto;
    private String nombreCliente;

    public ventaVo(){

    }

    public ventaVo(int idDetalleVenta, int cantidadVendida, int precioTotal, int idProductoFK, int noDocCliente,
            String nombreProducto, String nombreCliente) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidadVendida = cantidadVendida;
        this.precioTotal = precioTotal;
        this.idProductoFK = idProductoFK;
        this.noDocCliente = noDocCliente;
        this.nombreProducto = nombreProducto;
        this.nombreCliente = nombreCliente;
    }

    public int getIdDetalleVenta() {
        return idDetalleVenta;
    }

    public void setIdDetalleVenta(int idDetalleVenta) {
        this.idDetalleVenta = idDetalleVenta;
    }

    public int getCantidadVendida() {
        return cantidadVendida;
    }

    public void setCantidadVendida(int cantidadVendida) {
        this.cantidadVendida = cantidadVendida;
    }

    public int getPrecioTotal() {
        return precioTotal;
    }

    public void setPrecioTotal(int precioTotal) {
        this.precioTotal = precioTotal;
    }

    public int getIdProductoFK() {
        return idProductoFK;
    }

    public void setIdProductoFK(int idProductoFK) {
        this.idProductoFK = idProductoFK;
    }

    public int getNoDocCliente() {
        return noDocCliente;
    }

    public void setNoDocCliente(int noDocCliente) {
        this.noDocCliente = noDocCliente;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

}