package Modelo;

public class Banco {
    private int id_banco;
    private String Nombre_banco;
    private String Tipo_cuenta;
    private String Numero_de_cuenta;
    private String id_cedula;
    
    public Banco(){
        this.id_banco = 0;
        this.Nombre_banco = "";
        this.Tipo_cuenta = "";
        this.Numero_de_cuenta = "";
        this.id_cedula = "";
    }

    public int getId_banco() {
        return id_banco;
    }

    public void setId_banco(int id_banco) {
        this.id_banco = id_banco;
    }

    public String getNombre_banco() {
        return Nombre_banco;
    }

    public void setNombre_banco(String Nombre_banco) {
        this.Nombre_banco = Nombre_banco;
    }

    public String getTipo_cuenta() {
        return Tipo_cuenta;
    }

    public void setTipo_cuenta(String Tipo_cuenta) {
        this.Tipo_cuenta = Tipo_cuenta;
    }

    public String getNumero_de_cuenta() {
        return Numero_de_cuenta;
    }

    public void setNumero_de_cuenta(String Numero_de_cuenta) {
        this.Numero_de_cuenta = Numero_de_cuenta;
    }

    public String getId_cedula() {
        return id_cedula;
    }

    public void setId_cedula(String id_cedula) {
        this.id_cedula = id_cedula;
    }
    
    
    
}
