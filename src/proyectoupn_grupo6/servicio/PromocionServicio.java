/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import proyectoupn_grupo6.bd.AccesoDB;
import proyectoupn_grupo6.modelo.Promocion;

/**
 *
 * @author PABLO TREJO
 */
public class PromocionServicio {
    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_PORCENTAJE = "SELECT porcentaje "
            + "FROM PROMOCION "
            + "WHERE " +  "? "
            + "between cantmin AND cantmax;";
    
    public Promocion getPorcentajePromocion(int cantidad) throws SQLException {
    // Declaración de un objeto 'Promocion' llamado 'Porcentaje'.
    Promocion Porcentaje = new Promocion();

        try {
            // Obtiene una conexión a la base de datos utilizando la clase 'AccesoDB'.
            cn = AccesoDB.getConnection();

            // Prepara una declaración SQL de consulta utilizando la constante 'GET_PORCENTAJE'.
            pstm = cn.prepareStatement(GET_PORCENTAJE);

            // Establece el parámetro en la declaración SQL.
            pstm.setInt(1, cantidad);

            // Ejecuta la consulta y obtiene un conjunto de resultados (ResultSet).
            ResultSet rs = pstm.executeQuery();

            // Recorre el conjunto de resultados (ResultSet).
            while (rs.next()) {
                // Asigna el valor de la columna "porcentaje" del ResultSet al objeto 'Porcentaje'.
                Porcentaje.setPorcentaje(rs.getDouble("porcentaje"));
            }

            // Cierra la declaración preparada 'pstm'.
            pstm.close();

        } catch (SQLException e) {
            // Captura y relanza cualquier excepción SQLException con un mensaje personalizado.
            throw new SQLException("error : " + e.getMessage());
        } finally {
            // Finalmente, asegura que la conexión 'cn' se cierre adecuadamente, independientemente de si se produce una excepción o no.
            cn.close();
        }

        // Devuelve el objeto 'Porcentaje', que contiene el porcentaje de la promoción.
        return Porcentaje;
    }

}
