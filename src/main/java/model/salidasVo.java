package model;

public class salidasVo extends salidasClass {
    
    salidasDao rd= new salidasDao();

    private int idSalida;
    private int cantidadSalida;
    private String motivoSalidas;


    private int idDetalleCompras;
    private int idCompra;
    private int noOrdenCompra;
    private String nombreProducto;
    private int cantidadProducto;

    private int resultadoResta;
    private int cantidadTotal;
    
    public salidasVo(){

    }



    public salidasVo(salidasDao rd, int idSalida, int cantidadSalida, String motivoSalidas, int idDetalleCompras,
            int idCompra, int noOrdenCompra, String nombreProducto, int cantidadProducto, int resultadoResta,
            int cantidadTotal) {
        this.rd = rd;
        this.idSalida = idSalida;
        this.cantidadSalida = cantidadSalida;
        this.motivoSalidas = motivoSalidas;
        this.idDetalleCompras = idDetalleCompras;
        this.idCompra = idCompra;
        this.noOrdenCompra = noOrdenCompra;
        this.nombreProducto = nombreProducto;
        this.cantidadProducto = cantidadProducto;
        this.resultadoResta = resultadoResta;
        this.cantidadTotal = cantidadTotal;
    }



    public salidasDao getRd() {
        return rd;
    }

    public void setRd(salidasDao rd) {
        this.rd = rd;
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

    public int getIdDetalleCompras() {
        return idDetalleCompras;
    }

    public void setIdDetalleCompras(int idDetalleCompras) {
        this.idDetalleCompras = idDetalleCompras;
    }

    public int getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(int idCompra) {
        this.idCompra = idCompra;
    }



    public int getNoOrdenCompra() {
        return noOrdenCompra;
    }



    public void setNoOrdenCompra(int noOrdenCompra) {
        this.noOrdenCompra = noOrdenCompra;
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
