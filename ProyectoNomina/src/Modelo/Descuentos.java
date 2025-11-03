package Modelo;

public class Descuentos {
    private int id_descuentos;
    private String id_empleado;
    private String salud;
    private String pension;
    private String credito;
    
    public Descuentos(){
        this.id_descuentos = 0;
        this.id_empleado = "";
        this.salud = "";
        this.pension = "";
        this.credito = "";
    }
    
    public int getId_descuentos() {
        return id_descuentos;
    }

    public void setId_descuentos(int id_descuentos) {
        this.id_descuentos = id_descuentos;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getSalud() {
        return salud;
    }

    public void setSalud(String salud) {
        this.salud = salud;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getCredito() {
        return credito;
    }

    public void setCredito(String credito) {
        this.credito = credito;
    }
    
}
