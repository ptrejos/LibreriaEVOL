/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.servicio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import proyectoupn_grupo6.bd.AccesoDB;
import proyectoupn_grupo6.modelo.Tipo;

/**
 *
 * @author PABLO TREJO
 */
public class TipoServicio {
    private Connection cn; // Declaración de una variable de tipo Connection
    
    public List<Tipo> listarTipoDto() throws SQLException {
        // Declaración de una lista de objetos 'Tipo' llamada 'tipos'.
        List<Tipo> tipos = new ArrayList<>();

        // Definición de la consulta SQL.
        final String SQL = "select idtipo, descripcion , contador from tipo";

        try {
            // Obtiene una conexión a la base de datos utilizando el método 'AccesoDB.getConnection()'.
            cn = AccesoDB.getConnection();

            // Prepara una declaración SQL utilizando la consulta definida.
            PreparedStatement pstm = cn.prepareStatement(SQL);

            // Ejecuta la consulta y obtiene un conjunto de resultados (ResultSet).
            ResultSet rs = pstm.executeQuery();

            // Recorre el conjunto de resultados (ResultSet).
            while (rs.next()) {
                // Crea un nuevo objeto 'Tipo'.
                Tipo dto = new Tipo();

                // Asigna valores a las propiedades del objeto 'Tipo' desde el ResultSet.
                dto.setIdTipo(rs.getString("idtipo"));
                dto.setDescripcion(rs.getString("descripcion"));
                dto.setContador(rs.getInt("contador"));

                // Agrega el objeto 'Tipo' a la lista 'tipos'.
                tipos.add(dto);
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

        // Devuelve la lista de objetos 'Tipo' que se ha llenado con los resultados de la base de datos.
        return tipos;
    }

}
