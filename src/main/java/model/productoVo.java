package model;

public class productoVo {
    private int idProducto;
    private String nombreProducto;
    private boolean estadoProducto;
    private String observacionesProducto;
    private int cantidadProducto;
    private int precioProducto;
    private int idTipoProducto;
    private String NombreTipoProducto;
    private String fechaVencimiento; 

    //cantidad de fechas vencimiento 
    private int cantidadRegistros;

        //fecha vencimiento dias que faltan
        private int DIFERENCIA_DIAS;

        //cantidad de la cantidad de producto
        private int cantidad;
        //fecha actual(reportes)
        private String fecha_actual;

    public productoVo() {

    }

    public productoVo(int idProducto, Boolean estadoProducto, String nombreProducto, String observacionesProducto,int DIFERENCIA_DIAS,
    int cantidadProducto, int precioProducto, int idTipoProducto, String NombreTipoProducto,String fechaVencimiento,int cantidadRegistros,int cantidad,String fecha_actual) {

        this.cantidad=cantidad;
        this.DIFERENCIA_DIAS = DIFERENCIA_DIAS;
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.observacionesProducto = observacionesProducto;
        this.cantidadProducto = cantidadProducto;
        this.precioProducto = precioProducto;
        this.estadoProducto = estadoProducto;
        this.idTipoProducto=idTipoProducto;
        this.fechaVencimiento=fechaVencimiento;
        this.cantidadRegistros=cantidadRegistros;
        this.fecha_actual = fecha_actual;
    }
    public String getfecha_actual() {
        return fecha_actual;
    }

    public void setfecha_actual(String fecha_actual) {
        this.fecha_actual = fecha_actual;
    }

    public int getcantidad() {
        return cantidad;
    }

    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public int getcantidadRegistros() {
        return cantidadRegistros;
    }

    public void setcantidadRegistros(int cantidadRegistros) {
        this.cantidadRegistros = cantidadRegistros;
    }
    public int getDIFERENCIA_DIAS() {
        return DIFERENCIA_DIAS;
    }

    public void setDIFERENCIA_DIAS(int DIFERENCIA_DIAS) {
        this.DIFERENCIA_DIAS = DIFERENCIA_DIAS;
    }
    public String getfechaVencimiento() {
        return fechaVencimiento;
    }

    public void setfechaVencimiento(String fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
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

    public String getNombreTipoProducto(){
        return NombreTipoProducto;
    }

    public void setNombreTipoProducto(String NombreTipoProducto){
        this.NombreTipoProducto = NombreTipoProducto;
    }
    
}