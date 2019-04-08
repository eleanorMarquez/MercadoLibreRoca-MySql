
package Clases;

import java.sql.*;

public class ConexionBD {
    public static Connection conectar=null;
    public Connection conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar=DriverManager.getConnection("jdbc:mysql://localhost:3306/mercadolibreroca","root","");
            System.out.println("\n Conexion exitosa");
        } catch (Exception e) {
            System.out.println("\n no conecta "+e);
        }
        return conectar;
    }
    
    Statement createStatement(){
        throw new UnsupportedOperationException("no sorportado");        
    }
    
}
