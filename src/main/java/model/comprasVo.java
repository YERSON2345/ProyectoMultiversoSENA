package model;

import javax.xml.stream.events.EntityReference;

public class comprasVo extends comprasClass {

    private int idDetalleCompras;
    private int precioProveedor;
    private int noOrdenCompra;
    private String fechaCompra;
    private int idProducto;
    private int idProveedor;
    private int entradasCompras;



    //Relaciones
    private String nombreProveedor;
    private String nombreProducto;

    //toca listar de la tabla producto
    private String ObservacionesProducto;
    private int cantidadProducto;
    private int precioProducto;
    private int idTipoProducto;
    private String nombreTipoProducto;

    private int resultadoResta;
    private int cantidadTotal;



public comprasVo(){

}


public comprasVo(String fechaCompra, int idProducto,int idDetalleCompras,int precioProveedor,int noOrdenCompra,int entradasCompras,
        int idProveedor,String nombreProveedor, String nombreProducto,String ObservacionesProducto,
        int cantidadProducto,int precioProducto,int idTipoProducto,String nombreTipoProducto,int resultadoResta,int cantidadTotal) {
    this.fechaCompra = fechaCompra;
    this.idProducto = idProducto;
    this.idProveedor = idProveedor;
    this.entradasCompras = entradasCompras;
    this.nombreProveedor = nombreProveedor;
    this.nombreProducto = nombreProducto;
    this.cantidadTotal = cantidadTotal;
    this.resultadoResta = resultadoResta;
    this.idDetalleCompras = idDetalleCompras;
    this.precioProveedor = precioProveedor;
    this.noOrdenCompra = noOrdenCompra;

    this.ObservacionesProducto = ObservacionesProducto;
    this.cantidadProducto = cantidadProducto;
    this.precioProducto = precioProducto;
    this.idTipoProducto = idTipoProducto;
    this.nombreTipoProducto = nombreTipoProducto;
}

public void setentradasCompras(int entradasCompras){
    this.entradasCompras = entradasCompras;
}
public int getentradasCompras(){
    return entradasCompras;
}
public void setnoOrdenCompra(int noOrdenCompra){
    this.noOrdenCompra = noOrdenCompra;
}
public int getnoOrdenCompra(){
    return noOrdenCompra;
}
public void setprecioProveedor(int precioProveedor){
    this.precioProveedor = precioProveedor;
}
public int getprecioProveedor(){
    return precioProveedor;
}
public void setidDetalleCompras(int idDetalleCompras){
    this.idDetalleCompras = idDetalleCompras;
}
public int getidDetalleCompras(){
    return idDetalleCompras;
}
public void setresultadoResta(int resultadoResta){
    this.resultadoResta = resultadoResta;
}
public int getcantidadTotal(){
    return cantidadTotal;
}

public void setcantidadTotal(int cantidadTotal){
    this.cantidadTotal = cantidadTotal;
}

public int getresultadoResta() {
    return resultadoResta;
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

public void setprecioProducto(int precioProducto){
    this.precioProducto = precioProducto;
}

public int getprecioProducto(){
    return precioProducto;
}

public void setcantidadProducto(int cantidadProducto){
    this.cantidadProducto = cantidadProducto;
}

public int getcantidadProducto(){
    return cantidadProducto;
}

public String  getObservacionesProducto (){
    return ObservacionesProducto;
}

public void setObservacionesProducto(String ObservacionesProducto){
    this.ObservacionesProducto = ObservacionesProducto;
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

@Override
public int restarExistencias(int B,int A) {

    System.out.println(B);
    System.out.println(A);
    resultadoResta = B - A;
    System.out.println("El resultado es de " + resultadoResta);

return resultadoResta;

}
@Override
public int sumarExistencias(int B,int A) {

    System.out.println(B);
    System.out.println(A);
    resultadoResta = B + A;
    System.out.println("El resultado es de " + resultadoResta);

return resultadoResta;

}
@Override
public int actualizarExistencias(int cantidadProducto,int cantidadEntradas, int cantidadAntigua) {

    System.out.println(cantidadAntigua);
    System.out.println(cantidadProducto);
    System.out.println(cantidadEntradas);
    resultadoResta = cantidadAntigua + cantidadEntradas;

    System.out.println("El resultado es de " + resultadoResta);

return resultadoResta;

}

}
