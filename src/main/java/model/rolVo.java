package model;

public class rolVo {
    private int idRol;
    private String tiporol;

    public rolVo(){

    }

    public rolVo(int idRol, String tiporol) {
        this.idRol = idRol;
        this.tiporol = tiporol;
    }

    public int getIdRol() {
        return idRol;
    }

    public void setIdRol(int idRol) {
        this.idRol = idRol;
    }

    public String getTiporol() {
        return tiporol;
    }

    public void setTiporol(String tiporol) {
        this.tiporol = tiporol;
    }
    
}
