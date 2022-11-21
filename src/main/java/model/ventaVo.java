package model;

public class ventaVo extends ventaclass{

    private int idDetalleVenta;
    private int cantidadVendida;
    private int precioTotal;
    private int idProductoFK;
    private int noDocCliente;
    private String nombreProducto;
    private String nombreCliente;
    private int resultadoResta;
    private int cantidadProducto;
    private int CantidadSalida;
    private String ObservacionesProducto;
    private int PrecioProducto;
    private int resultadoTotal;

    private int cantidadTotal;


    public ventaVo(){

    }

    public ventaVo(int idDetalleVenta, int cantidadVendida, int precioTotal, int idProductoFK, int noDocCliente,
            String nombreProducto, String nombreCliente, int resultadoResta, int cantidadProducto,int CantidadSalida,
            String ObservacionesProducto, int PrecioProducto,int cantidadTotal,int resultadoTotal) {
        this.idDetalleVenta = idDetalleVenta;
        this.cantidadVendida = cantidadVendida;
        this.precioTotal = precioTotal;
        this.idProductoFK = idProductoFK;
        this.noDocCliente = noDocCliente;
        this.nombreProducto = nombreProducto;
        this.nombreCliente = nombreCliente;
        this.resultadoResta = resultadoResta;
        this.cantidadProducto = cantidadProducto;
        this.CantidadSalida = CantidadSalida;
        this.ObservacionesProducto = ObservacionesProducto;
        this.PrecioProducto = PrecioProducto;
        this.cantidadTotal = cantidadTotal;
        this.resultadoTotal = resultadoTotal;
 }
    public void setresultadoTotal(int resultadoTotal){
        this.resultadoTotal = resultadoTotal;
    }
    public int getresultadoTotal(){
        return resultadoTotal;
    }
    
    public void setcantidadTotal(int cantidadTotal){
        this.cantidadTotal = cantidadTotal;
    }
    public int getcantidadTotal(){
        return cantidadTotal;
    }
    public void setCantidadSalida(int CantidadSalida){
        this.CantidadSalida = CantidadSalida;
    }
    public int getCantidadSalida(){
        return CantidadSalida;
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

    public int getidProductoFK() {
        return idProductoFK;
    }

    public void setidProductoFK(int idProductoFK) {
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

    public int getresultadoResta(){
        return resultadoResta;
    }

    public void setresultadoResta(int resultadoResta){
        this.resultadoResta = resultadoResta;
    }

    public int getcantidadProducto(){
        return cantidadProducto;
    }

    public void setcantidadProducto(int cantidadProducto){
        this.cantidadProducto = cantidadProducto;
    }

    public String getObservacionesProducto(){
        return ObservacionesProducto;
    }

    public void setObservacionesProducto(String ObservacionesProducto){
        this.ObservacionesProducto = ObservacionesProducto;
    }
    
    public int getPrecioProducto(){
        return PrecioProducto;
    }

    public void setPrecioProducto(int PrecioProducto){
        this.PrecioProducto = PrecioProducto;
    }

// Funciones para actualizar stock
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
    public int actualizarExistencias(int A,int B, int C) {

        System.out.println(C);
        System.out.println(A);
        System.out.println(B);
        resultadoResta = C +(A - B);

        System.out.println("El resultado es de " + resultadoResta);

    return resultadoResta;

    }

    @Override
    public int calcularTotal(int A,int B) {

        System.out.println(A);
        System.out.println(B);
        resultadoTotal = A * B;
        System.out.println("El resultado es de " + resultadoTotal);

    return resultadoTotal;

    }

}