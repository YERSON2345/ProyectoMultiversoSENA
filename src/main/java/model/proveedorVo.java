package model;

public class proveedorVo {

    private int idProveedor;
    private String nombreProveedor;
    private String empresaProveedor;
    private Boolean estadoProveedor;

    public proveedorVo() {
    }

    public proveedorVo(int idProveedor, String nombreProveedor, String empresaProveedor, Boolean estadoProveedor) {
        this.idProveedor = idProveedor;
        this.nombreProveedor = nombreProveedor;
        this.empresaProveedor = empresaProveedor;
        this.estadoProveedor = estadoProveedor;
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

    public String getEmpresaProveedor() {
        return empresaProveedor;
    }

    public void setEmpresaProveedor(String empresaProveedor) {
        this.empresaProveedor = empresaProveedor;
    }

    public void setEstadoProveedor(Boolean estadoProveedor) {
        this.estadoProveedor = estadoProveedor;
    }

    public Boolean getEstadoProveedor() {
        return estadoProveedor;
    }

    @Override
    public String toString() {
        return "proveedorVo [empresaProveedor=" + empresaProveedor + ", idProveedor=" + idProveedor
                + ", nombreProveedor=" + nombreProveedor + "]";
    }

    public static void add(proveedorVo filas) {
    }
}