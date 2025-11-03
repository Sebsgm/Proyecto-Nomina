package Controlador;

import Conexion.Conexion;
import Modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Empleado {
    public boolean guardar(Empleado objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO empleado VALUES (?,?,?,?,?,?,?,?)");
            consulta.setString(1, objeto.getCedula());
            consulta.setString(2, objeto.getNombre_completo());
            consulta.setString(3, objeto.getFecha_ingreso());
            consulta.setString(4, objeto.getFecha_retiro());
            consulta.setString(5, objeto.getTelefono());
            consulta.setInt(6, objeto.getId_cargo());
            consulta.setInt(7, objeto.getId_departamento());
            consulta.setInt(8, objeto.getId_tipoContrato());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar empleado" + e);
        }

        return respuesta;
    }
    
    public boolean ExisteEmpleadoPorCedula(String cedula) {
    boolean respuesta = false;
    String sql = "SELECT cedula FROM empleado WHERE cedula = '" + cedula + "';";
    Statement st;

    try {
        Connection cn = Conexion.conectar();
        st = cn.createStatement();
        ResultSet rs = st.executeQuery(sql);

        if (rs.next()) {
            respuesta = true; // El empleado existe por cédula
        }

        cn.close();
    } catch (SQLException e) {
        System.out.println("Error al consultar empleado por cédula: " + e);
    }

    return respuesta;
}
    
    public boolean actualizar_Completo(Empleado objeto, String idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE empleado SET Nombre_completo = ?, fecha_ingreso = ?, fecha_retiro = ?, telefono = ?, id_cargo = ?, id_departamento = ?, id_tipoContrato = ? WHERE cedula = '" + idCliente + "'");
            consulta.setString(1, objeto.getNombre_completo());
            consulta.setString(2, objeto.getFecha_ingreso());
            consulta.setString(3, objeto.getFecha_retiro());
            consulta.setString(4, objeto.getTelefono());
            consulta.setInt(5, objeto.getId_cargo());
            consulta.setInt(6, objeto.getId_departamento());
            consulta.setInt(7, objeto.getId_tipoContrato());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado:" + e);
        }

        return respuesta;
    }
    
    public boolean actualizar_Fecha(Empleado objeto, String idCliente) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE empleado SET fecha_retiro = ? WHERE cedula = '" + idCliente + "'");
            consulta.setString(1, objeto.getFecha_retiro());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar :" + e);
        }

        return respuesta;
    }
   
    
    
}
