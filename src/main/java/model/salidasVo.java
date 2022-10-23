package model;

public class salidasVo extends salidasClass {
    
    private int idSalida;
    private int cantidadSalida;
    private String motivoSalidas;


    private int idProducto;
    private String ObservacionesProducto;
    private String nombreProducto;
    private int cantidadProducto;
    private int precioProducto;

    private int idTipoProducto;
    private String nombreTipoProducto;

    private int resultadoResta;
    private int cantidadTotal;
    
    public salidasVo(){

    }

    public salidasVo(int idSalida, int cantidadSalida, String motivoSalidas, int idProducto, String observacionesProducto,
            String nombreProducto, int cantidadProducto, int precioProducto, int idTipoProducto, String nombreTipoProducto,
            int resultadoResta, int cantidadTotal) {
        this.idSalida = idSalida;
        this.cantidadSalida = cantidadSalida;
        this.motivoSalidas = motivoSalidas;
        this.idProducto = idProducto;
        ObservacionesProducto = observacionesProducto;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.idTipoProducto = idTipoProducto;
        this.nombreTipoProducto = nombreTipoProducto;
        this.resultadoResta = resultadoResta;
        this.cantidadTotal = cantidadTotal;
    }


    public int getIdSalida() {
        return idSalida;
    }


    public void setIdSalida(int idSalida) {
        this.idSalida = idSalida;
    }


    public int getCantidadSalida() {
        return cantidadSalida;
    }


    public void setCantidadSalida(int cantidadSalida) {
        this.cantidadSalida = cantidadSalida;
    }


    public String getMotivoSalidas() {
        return motivoSalidas;
    }


    public void setMotivoSalidas(String motivoSalidas) {
        this.motivoSalidas = motivoSalidas;
    }


    public int getIdProducto() {
        return idProducto;
    }


    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }


    public String getObservacionesProducto() {
        return ObservacionesProducto;
    }


    public void setObservacionesProducto(String observacionesProducto) {
        ObservacionesProducto = observacionesProducto;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }


    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
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


    public int getResultadoResta() {
        return resultadoResta;
    }


    public void setResultadoResta(int resultadoResta) {
        this.resultadoResta = resultadoResta;
    }


    public int getCantidadTotal() {
        return cantidadTotal;
    }


    public void setCantidadTotal(int cantidadTotal) {
        this.cantidadTotal = cantidadTotal;
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
    public int actualizarExistencias(int A,int B, int C) {

        System.out.println(C);
        System.out.println(A);
        System.out.println(B);
        resultadoResta = C +(A - B);

        System.out.println("El resultado es de " + resultadoResta);

    return resultadoResta;

    }
}
