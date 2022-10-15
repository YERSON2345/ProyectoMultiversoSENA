package model;

public class comprasVo {
    private int idCompras;
    private int entradaCompras;
    private int noOrdenCompra;
    private String fechaCompra;
    private int idProducto;
    private int idProveedor;

    private int cantidadCompra;
    private int precioCompra;
    private String nombreProveedor;
    private String nombreProducto;


public comprasVo(){

}


public comprasVo(int idCompras, int entradaCompras, int noOrdenCompra, String fechaCompra, int idProducto,
        int idProveedor, int cantidadCompra, int precioCompra, String nombreProveedor, String nombreProducto) {
    this.idCompras = idCompras;
    this.entradaCompras = entradaCompras;
    this.noOrdenCompra = noOrdenCompra;
    this.fechaCompra = fechaCompra;
    this.idProducto = idProducto;
    this.idProveedor = idProveedor;
    this.cantidadCompra = cantidadCompra;
    this.precioCompra = precioCompra;
    this.nombreProveedor = nombreProveedor;
    this.nombreProducto = nombreProducto;
}


public int getIdCompras() {
    return idCompras;
}


public void setIdCompras(int idCompras) {
    this.idCompras = idCompras;
}


public int getEntradaCompras() {
    return entradaCompras;
}


public void setEntradaCompras(int entradaCompras) {
    this.entradaCompras = entradaCompras;
}


public int getNoOrdenCompra() {
    return noOrdenCompra;
}


public void setNoOrdenCompra(int noOrdenCompra) {
    this.noOrdenCompra = noOrdenCompra;
}


public String getFechaCompra() {
    return fechaCompra;
}


public void setFechaCompra(String fechaCompra) {
    this.fechaCompra = fechaCompra;
}


public int getIdProducto() {
    return idProducto;
}


public void setIdProducto(int idProducto) {
    this.idProducto = idProducto;
}


public int getIdProveedor() {
    return idProveedor;
}


public void setIdProveedor(int idProveedor) {
    this.idProveedor = idProveedor;
}


public int getCantidadCompra() {
    return cantidadCompra;
}


public void setCantidadCompra(int cantidadCompra) {
    this.cantidadCompra = cantidadCompra;
}


public int getPrecioCompra() {
    return precioCompra;
}


public void setPrecioCompra(int precioCompra) {
    this.precioCompra = precioCompra;
}


public String getNombreProveedor() {
    return nombreProveedor;
}


public void setNombreProveedor(String nombreProveedor) {
    this.nombreProveedor = nombreProveedor;
}


public String getNombreProducto() {
    return nombreProducto;
}


public void setNombreProducto(String nombreProducto) {
    this.nombreProducto = nombreProducto;
}





}
