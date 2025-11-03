package Modelo;

public class Pagos {
    private int id_pagos;
    private String id_empleados;
    private String total_devengados;
    private String total_descuentos;
    private String total_pago;
    private String fecha_pago;
    
    public Pagos(){
        this.id_pagos = 0;
        this.id_empleados = "";
        this.total_devengados = "";
        this.total_descuentos = "";
        this.total_pago = "";
        this.fecha_pago = "";
    }

    public int getId_pagos() {
        return id_pagos;
    }

    public void setId_pagos(int id_pagos) {
        this.id_pagos = id_pagos;
    }

    public String getId_empleados() {
        return id_empleados;
    }

    public void setId_empleados(String id_empleados) {
        this.id_empleados = id_empleados;
    }

    public String getTotal_devengados() {
        return total_devengados;
    }

    public void setTotal_devengados(String total_devengados) {
        this.total_devengados = total_devengados;
    }

    public String getTotal_descuentos() {
        return total_descuentos;
    }

    public void setTotal_descuentos(String total_descuentos) {
        this.total_descuentos = total_descuentos;
    }

    public String getTotal_pago() {
        return total_pago;
    }

    public void setTotal_pago(String total_pago) {
        this.total_pago = total_pago;
    }

    public String getFecha_pago() {
        return fecha_pago;
    }

    public void setFecha_pago(String fecha_pago) {
        this.fecha_pago = fecha_pago;
    }
    
    
    
}
