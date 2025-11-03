package Modelo;

public class Devengados {
    private int id_devengados;
    private String id_empleado;
    private String salario;
    private String sub_transporte;
    private String gastos;
    private String viaticos;
    private String comisiones;
    private String horas_trabajadas;
    private String cantidad_horas_diurnas;
    private String cantidad_horas_nocturnas;
    private String cantidad_horas_diurnas_festivas;
    private String cantidad_horas_nocturnas_festivas;
    private String horas_extra_diurnas;
    private String horas_extra_nocturnas;
    private String horas_extra_dominicales_diurnas;
    private String horas_extra_dominicales_nocturnas;
    
    public Devengados(){
        this.id_devengados = 0;
        this.id_empleado = "";
        this.salario = "";
        this.sub_transporte = "";
        this.gastos = "";
        this.viaticos = "";
        this.comisiones= "";
        this.horas_trabajadas = "";
        this.cantidad_horas_diurnas="";
        this.cantidad_horas_nocturnas="";
        this.cantidad_horas_diurnas_festivas="";
        this.cantidad_horas_nocturnas_festivas="";
        this.horas_extra_diurnas = "";
        this.horas_extra_nocturnas = "";
        this.horas_extra_dominicales_diurnas = "";
        this.horas_extra_dominicales_nocturnas = "";    
    }

    public String getCantidad_horas_diurnas() {
        return cantidad_horas_diurnas;
    }

    public void setCantidad_horas_diurnas(String cantidad_horas_diurnas) {
        this.cantidad_horas_diurnas = cantidad_horas_diurnas;
    }

    public String getCantidad_horas_nocturnas() {
        return cantidad_horas_nocturnas;
    }

    public void setCantidad_horas_nocturnas(String cantidad_horas_nocturnas) {
        this.cantidad_horas_nocturnas = cantidad_horas_nocturnas;
    }

    public String getCantidad_horas_diurnas_festivas() {
        return cantidad_horas_diurnas_festivas;
    }

    public void setCantidad_horas_diurnas_festivas(String cantidad_horas_diurnas_festivas) {
        this.cantidad_horas_diurnas_festivas = cantidad_horas_diurnas_festivas;
    }

    public String getCantidad_horas_nocturnas_festivas() {
        return cantidad_horas_nocturnas_festivas;
    }

    public void setCantidad_horas_nocturnas_festivas(String cantidad_horas_nocturnas_festivas) {
        this.cantidad_horas_nocturnas_festivas = cantidad_horas_nocturnas_festivas;
    }

    
    
    public int getId_devengados() {
        return id_devengados;
    }

    public void setId_devengados(int id_devengados) {
        this.id_devengados = id_devengados;
    }

    public String getId_empleado() {
        return id_empleado;
    }

    public void setId_empleado(String id_empleado) {
        this.id_empleado = id_empleado;
    }

    public String getSalario() {
        return salario;
    }

    public void setSalario(String salario) {
        this.salario = salario;
    }

    public String getSub_transporte() {
        return sub_transporte;
    }

    public void setSub_transporte(String sub_transporte) {
        this.sub_transporte = sub_transporte;
    }

    public String getGastos() {
        return gastos;
    }

    public void setGastos(String gastos) {
        this.gastos = gastos;
    }

    public String getViaticos() {
        return viaticos;
    }

    public void setViaticos(String viaticos) {
        this.viaticos = viaticos;
    }

    public String getComisiones() {
        return comisiones;
    }

    public void setComisiones(String comisiones) {
        this.comisiones = comisiones;
    }

    public String getHoras_trabajadas() {
        return horas_trabajadas;
    }

    public void setHoras_trabajadas(String horas_trabajadas) {
        this.horas_trabajadas = horas_trabajadas;
    }

    public String getHoras_extra_diurnas() {
        return horas_extra_diurnas;
    }

    public void setHoras_extra_diurnas(String horas_extra_diurnas) {
        this.horas_extra_diurnas = horas_extra_diurnas;
    }

    public String getHoras_extra_nocturnas() {
        return horas_extra_nocturnas;
    }

    public void setHoras_extra_nocturnas(String horas_extra_nocturnas) {
        this.horas_extra_nocturnas = horas_extra_nocturnas;
    }

    public String getHoras_extra_dominicales_diurnas() {
        return horas_extra_dominicales_diurnas;
    }

    public void setHoras_extra_dominicales_diurnas(String horas_extra_dominicales_diurnas) {
        this.horas_extra_dominicales_diurnas = horas_extra_dominicales_diurnas;
    }

    public String getHoras_extra_dominicales_nocturnas() {
        return horas_extra_dominicales_nocturnas;
    }

    public void setHoras_extra_dominicales_nocturnas(String horas_extra_dominicales_nocturnas) {
        this.horas_extra_dominicales_nocturnas = horas_extra_dominicales_nocturnas;
    }   
}
