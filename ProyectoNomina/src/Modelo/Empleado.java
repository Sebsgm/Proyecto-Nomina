package Modelo;

public class Empleado {
    private String cedula;
    private String Nombre_completo;
    private String Fecha_ingreso;
    private String Fecha_retiro;
    private String Telefono;
    private int id_cargo;
    private int id_departamento;
    private int id_tipoContrato;
    
    public Empleado(){
        this.cedula = "";
        this.Nombre_completo = "";
        this.Fecha_ingreso = "";
        this.Fecha_retiro = "";
        this.Telefono = "";
        this.id_cargo = 0;
        this.id_departamento = 0;
        this.id_tipoContrato = 0;
    }

    public Empleado(String cedula, String Nombre_completo, String Fecha_ingreso, String Fecha_retiro, String Telefono, int id_cargo, int id_departamento, int id_tipoContrato) {
        this.cedula = cedula;
        this.Nombre_completo = Nombre_completo;
        this.Fecha_ingreso = Fecha_ingreso;
        this.Fecha_retiro = Fecha_retiro;
        this.Telefono = Telefono;
        this.id_cargo = id_cargo;
        this.id_departamento = id_departamento;
        this.id_tipoContrato = id_tipoContrato;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombre_completo() {
        return Nombre_completo;
    }

    public void setNombre_completo(String Nombre_completo) {
        this.Nombre_completo = Nombre_completo;
    }

    public String getFecha_ingreso() {
        return Fecha_ingreso;
    }

    public void setFecha_ingreso(String Fecha_ingreso) {
        this.Fecha_ingreso = Fecha_ingreso;
    }

    public String getFecha_retiro() {
        return Fecha_retiro;
    }

    public void setFecha_retiro(String Fecha_retiro) {
        this.Fecha_retiro = Fecha_retiro;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public int getId_cargo() {
        return id_cargo;
    }

    public void setId_cargo(int id_cargo) {
        this.id_cargo = id_cargo;
    }

    public int getId_departamento() {
        return id_departamento;
    }

    public void setId_departamento(int id_departamento) {
        this.id_departamento = id_departamento;
    }

    public int getId_tipoContrato() {
        return id_tipoContrato;
    }

    public void setId_tipoContrato(int id_tipoContrato) {
        this.id_tipoContrato = id_tipoContrato;
    }
    
    
}
