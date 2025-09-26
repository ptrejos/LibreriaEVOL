/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author PABLO TREJO
 */
public class AccesoDB {
    public AccesoDB() {
    }
    
    public static Connection getConnection() throws SQLException {

        Connection cn = null;
        // Parámetros de la base de datos
        String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
        String urlDB = "jdbc:sqlserver://localhost:1433;databaseName=LIBRERIA;encrypt=false;trustServerCertificate=true";
        String user = "u_ventas";
        String pass = "u_ventas";
        
        try {
            // Conexión con la BD
            Class.forName(driver).getDeclaredConstructor().newInstance();
            cn = DriverManager.getConnection(urlDB, user, pass);
        } catch (SQLException e) {
            throw e;
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de la BD.");
        } catch (Exception e) {
            throw new SQLException("No se puede establecer "
                    + "conexión de la BD.");
        }
        return cn;
    }
    
}
