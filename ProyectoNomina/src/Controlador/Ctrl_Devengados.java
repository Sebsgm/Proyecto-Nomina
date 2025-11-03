package Controlador;

import Conexion.Conexion;
import Modelo.Devengados;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Devengados {
    public boolean guardar(Devengados objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO Devengados VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1,0);
            consulta.setString(2, objeto.getId_empleado());
            consulta.setString(3, objeto.getSalario());
            consulta.setString(4, objeto.getSub_transporte());
            consulta.setString(5, objeto.getGastos());
            consulta.setString(6, objeto.getViaticos());
            consulta.setString(7, objeto.getComisiones());
            consulta.setString(8, objeto.getHoras_trabajadas());
            consulta.setString(9, objeto.getCantidad_horas_diurnas());
            consulta.setString(10, objeto.getCantidad_horas_nocturnas());
            consulta.setString(11, objeto.getCantidad_horas_diurnas_festivas());
            consulta.setString(12, objeto.getCantidad_horas_nocturnas_festivas());
            consulta.setString(13, objeto.getHoras_extra_diurnas());
            consulta.setString(14, objeto.getHoras_extra_nocturnas());
            consulta.setString(15, objeto.getHoras_extra_dominicales_diurnas());
            consulta.setString(16, objeto.getHoras_extra_dominicales_nocturnas());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar devengados del Empleado" + e);
        }

        return respuesta;
    }
    
    public boolean actualizar(Devengados objeto, int idDevengados) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE Devengados SET salario = ?, Sub_transporte = ?, Gastos_representativos = ?  , Viaticos = ?, "
                    + "Comisiones = ?, Horas_trabajadas =  ?, Cantidad_horas_diurnas = ?, Cantidad_horas_nocturnas = ?, Cantidad_horas_diurnas_festivas = ?,"
                    + "Cantidad_horas_nocturnas_festivas = ?, Horas_extra_diurnas = ?, Horas_extra_nocturnas = ?, Horas_extra_dominicales_diurnas = ?,"
                    + "Horas_extra_dominicales_nocturnas = ? WHERE id_devengados = '" + idDevengados + "'");
            consulta.setString(1, objeto.getSalario());
            consulta.setString(2, objeto.getSub_transporte());
            consulta.setString(3, objeto.getGastos());
            consulta.setString(4, objeto.getViaticos());
            consulta.setString(5, objeto.getComisiones());
            consulta.setString(6, objeto.getHoras_trabajadas());
            
            consulta.setString(7, objeto.getCantidad_horas_diurnas());
            consulta.setString(8, objeto.getCantidad_horas_nocturnas());
            consulta.setString(9, objeto.getCantidad_horas_diurnas_festivas());
            consulta.setString(10, objeto.getCantidad_horas_nocturnas_festivas());
            
            consulta.setString(11, objeto.getHoras_extra_diurnas());
            consulta.setString(12, objeto.getHoras_extra_nocturnas());
            consulta.setString(13, objeto.getHoras_extra_dominicales_diurnas());
            consulta.setString(14, objeto.getHoras_extra_dominicales_nocturnas());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar Devengados del empleado:" + e);
        }
        return respuesta;
    }
    
    public boolean ExisteDevengadoEmpleado(String nombreEmpleado) {
        boolean existe = false;
        String sql = "SELECT 1 FROM Devengados d INNER JOIN empleado e ON d.id_empleado = e.cedula WHERE e.Nombre_completo = '" + nombreEmpleado + "';";

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
}
