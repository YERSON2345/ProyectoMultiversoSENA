package model;

public class comprasVo extends comprasClass {

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


public comprasVo(int idCompras, int entradaCompras, int noOrdenCompra, String fechaCompra, int idProducto,
        int idProveedor, int cantidadCompra, int precioCompra, String nombreProveedor, String nombreProducto,String ObservacionesProducto,
        int cantidadProducto,int precioProducto,int idTipoProducto,String nombreTipoProducto,int resultadoResta,int cantidadTotal) {
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
    this.cantidadTotal = cantidadTotal;
    this.resultadoResta = resultadoResta;


    this.ObservacionesProducto = ObservacionesProducto;
    this.cantidadProducto = cantidadProducto;
    this.precioProducto = precioProducto;
    this.idTipoProducto = idTipoProducto;
    this.nombreTipoProducto = nombreTipoProducto;
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
