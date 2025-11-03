package Controlador;

import Conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import Modelo.Usuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Ctrl_Usuario {
    public boolean loginUser(Usuario objeto){
        
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        String sql = "SELECT Nombre_usuario,contraseña from usuario where Nombre_usuario = '"+objeto.getNombre_usuario()+"' and contraseña = '"+objeto.getContraseña()+"' and estado = true;";
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                respuesta = true;
            }
            
            
        }catch(SQLException e){
            System.out.println("Error al Iniciar Sesion");
            JOptionPane.showMessageDialog(null,"Error al iniciar sesion");
        }
        
        return respuesta;
    }
    
     public boolean guardar(Usuario objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("INSERT INTO usuario VALUES (?,?,?,?)");
            consulta.setInt(1, 0);
            consulta.setString(2, objeto.getNombre_usuario());
            consulta.setString(3, objeto.getContraseña());
            consulta.setBoolean(4, true);

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Usuario" + e);
        }

        return respuesta;
    }
    
    public boolean ExisteUsuario(String usuario){
        boolean respuesta = false;
        String sql = "SELECT Nombre_usuario from usuario where Nombre_usuario = '"+usuario+"';";
        Statement st;
        
        try{
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
            
        }catch(SQLException e){
            System.out.println("Error al consultar usuario" + e);
        }
        
        return respuesta;
    }
    
    public boolean actualizar(Usuario objeto, int idUsuario) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("UPDATE usuario SET Nombre_usuario = ?, contraseña = ?, estado = ?  WHERE id_usuario = '" + idUsuario + "'");
            consulta.setString(1, objeto.getNombre_usuario());
            consulta.setString(2, objeto.getContraseña());
            consulta.setBoolean(3, objeto.isEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar cliente:" + e);
        }
        return respuesta;
    }
}
