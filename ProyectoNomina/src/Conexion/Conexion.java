package Conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    private static final String URL = "jdbc:mysql://127.0.0.1:3306/Nomina";
    private static final String USER = "root";
    private static final String PASSWORD = "Johan2329*";
    
   public static Connection conectar(){
       try{
           Connection cn = DriverManager.getConnection(URL, USER, PASSWORD);
           return cn;
       }catch(SQLException e){
           System.out.println("ERROR EN LA CONEXION");
       }
       return null;
    }
}
