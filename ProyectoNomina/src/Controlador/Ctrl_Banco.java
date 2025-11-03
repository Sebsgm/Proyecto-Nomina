package Controlador;

import Conexion.Conexion;
import Modelo.Banco;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Ctrl_Banco {
    public boolean guardar(Banco objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO banco VALUES (?,?,?,?,?)");
            consulta.setInt(1,0);
            consulta.setString(2, objeto.getNombre_banco());
            consulta.setString(3, objeto.getTipo_cuenta());
            consulta.setString(4, objeto.getNumero_de_cuenta());
            consulta.setString(5, objeto.getId_cedula());
            
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar informacion bancaria del Empleado" + e);
        }

        return respuesta;
    }
    
    public boolean actualizar(Banco objeto, int idBanco) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE banco SET Nombre_banco = ?, Tipo_cuenta = ?, Numero_de_cuenta = ?  WHERE id_banco = '" + idBanco + "'");
            consulta.setString(1, objeto.getNombre_banco());
            consulta.setString(2, objeto.getTipo_cuenta());
            consulta.setString(3, objeto.getNumero_de_cuenta());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente:" + e);
        }
        return respuesta;
    }
    
    public boolean ExisteBancoEmpleado(String nombreEmpleado) {
        boolean existe = false;
        String sql = "SELECT b.id_banco FROM banco b " +
                     "INNER JOIN empleado e ON b.id_cedula = e.cedula " +
                     "WHERE e.Nombre_completo = '" + nombreEmpleado + "';";

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
