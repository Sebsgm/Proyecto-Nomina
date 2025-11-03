package Controlador;

import Conexion.Conexion;
import java.sql.*;
import Modelo.Descuentos;


public class Ctrl_Descuentos {
    
    public boolean guardar(Descuentos objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();

        try {
            PreparedStatement consulta = cn.prepareStatement(
                "INSERT INTO Descuentos (id_empleado, salud, pension, credito_empleado) VALUES (?, ?, ?, ?)"
            );
            consulta.setString(1, objeto.getId_empleado());
            consulta.setString(2, objeto.getSalud());
            consulta.setString(3, objeto.getPension());
            consulta.setString(4, objeto.getCredito());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Descuentos del Empleado: " + e);
            e.printStackTrace(); // Mostrar detalles del error en consola
        }

        return respuesta;
    }
    
    public boolean actualizar(Descuentos objeto, String idDescuento) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE Descuentos SET salud = ?, pension = ?, credito_empleado = ? WHERE id_empleado = '" + idDescuento + "'");
            consulta.setString(1, objeto.getSalud());
            consulta.setString(2, objeto.getPension());
            consulta.setString(3, objeto.getCredito());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar Descuentos del empleado:" + e);
        }
        return respuesta;
    }
    
    public boolean ExisteDescuetoEmpleado(String nombreEmpleado) {
        boolean existe = false;
        String sql = "SELECT 1 FROM Descuentos d INNER JOIN empleado e ON d.id_empleado = e.cedula WHERE e.Nombre_completo = '" + nombreEmpleado + "';";

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
            System.out.println("Error al consultar empleado: " + e);
        }

        return existe;
    }
    
    
}
