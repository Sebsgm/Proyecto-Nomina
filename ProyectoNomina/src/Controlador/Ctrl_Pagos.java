package Controlador;

import Conexion.Conexion;
import Modelo.Devengados;
import Modelo.Pagos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Pagos {
    public boolean guardar(Pagos objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO Pagos VALUES (?,?,?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getId_empleados());
            consulta.setString(3, objeto.getTotal_devengados());
            consulta.setString(4, objeto.getTotal_descuentos());
            consulta.setString(5, objeto.getTotal_pago());
            consulta.setString(6, objeto.getFecha_pago());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Pago" + e);
        }

        return respuesta;
    }
    
    public boolean ExistePagoEmpleado(String cedula) {
        boolean existe = false;
        String sql = "SELECT 1 FROM Pagos d INNER JOIN empleado e ON d.id_empleado = e.cedula WHERE d.id_empleado = '" + cedula + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            if (rs.next()) {
                existe = true;
            }

            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al consultar banco del empleado: " + e);
        }

        return existe;
    }
    
    public boolean actualizar(Pagos objeto, String cedula) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE Pagos SET total_devengados = ?, total_descuentos = ?, total_pagos = ?, fecha_pago = ? WHERE id_empleado = '" + cedula + "'");
            consulta.setString(1, objeto.getTotal_devengados());
            consulta.setString(2, objeto.getTotal_descuentos());
            consulta.setString(3, objeto.getTotal_pago());
            consulta.setString(4, objeto.getFecha_pago());
            
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar pago del empleado:" + e);
        }
        return respuesta;
    }
}
