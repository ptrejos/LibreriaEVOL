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
import proyectoupn_grupo6.modelo.Control;

/**
 *
 * @author PABLO TREJO
 */
public class ControlServicio {
    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_ALL = "SELECT parametro, valor FROM CONTROL; ";

    private final String GET = "select valor from control "
            + "where parametro = ? ;";

    private final String UPDATE = "UPDATE CONTROL SET VALOR = ? "
            + "WHERE parametro = ? ";

    public List<Control> listarControl() throws SQLException {
        // Declaración de una lista de objetos 'Control' llamada 'controles'.
        List<Control> controles = new ArrayList<>();

        try {
            // Obtiene una conexión a la base de datos utilizando la clase 'AccesoDB'.
            cn = AccesoDB.getConnection();

            // Prepara una declaración SQL de consulta utilizando la constante 'GET_ALL'.
            pstm = cn.prepareStatement(GET_ALL);

            // Ejecuta la consulta y obtiene un conjunto de resultados (ResultSet).
            ResultSet rs = pstm.executeQuery();

            // Recorre el conjunto de resultados (ResultSet).
            while (rs.next()) {
                // Crea un nuevo objeto 'Control'.
                Control dto = new Control();

                // Asigna valores a las propiedades del objeto 'Control' desde el ResultSet.
                dto.setParametro(rs.getString("parametro"));
                dto.setValor(rs.getString("valor"));

                // Agrega el objeto 'Control' a la lista 'controles'.
                controles.add(dto);
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

        // Devuelve la lista de objetos 'Control' que se ha llenado con los resultados de la base de datos.
        return controles;
    }


    public String getControl(String parametro) throws SQLException {
        // Declaración de una variable de tipo String llamada 'control'.
        String control = "";

        try {
            // Obtiene una conexión a la base de datos utilizando la clase 'AccesoDB'.
            cn = AccesoDB.getConnection();

            // Prepara una declaración SQL de consulta utilizando la constante 'GET'.
            pstm = cn.prepareStatement(GET);

            // Establece el parámetro en la declaración SQL.
            pstm.setString(1, parametro);

            // Ejecuta la consulta y obtiene un conjunto de resultados (ResultSet).
            ResultSet rs = pstm.executeQuery();

            // Recorre el conjunto de resultados (ResultSet).
            while (rs.next()) {
                // Obtiene el valor de la columna "valor" en la fila actual y lo asigna a la variable 'control'.
                control = rs.getString("valor");
            }

            // Cierra la declaración preparada 'pstm'.
            pstm.close();

        } catch (SQLException e) {
            // Captura y relanza cualquier excepción SQLException con un mensaje personalizado.
            throw new SQLException("error : " + e.getMessage());
        } finally {
            // Finalmente, asegura que la conexión se cierre, independientemente de si se produce una excepción o no.
            cn.close();
        }

        // Devuelve el valor de 'control', que es el valor obtenido de la base de datos.
        return control;
    }


    
    public boolean actualizarControl(String parametro, String valor) throws SQLException {
    // Declaración de una variable booleana llamada 'respuesta'.
    boolean respuesta = false;

    try {
        // Obtiene una conexión a la base de datos utilizando la clase 'AccesoDB'.
        cn = AccesoDB.getConnection();

        // Prepara una declaración SQL de actualización utilizando la constante 'UPDATE'.
        pstm = cn.prepareStatement(UPDATE);

        // Establece los parámetros en la declaración SQL.
        pstm.setString(1, valor);     // El primer "?" se establece con el valor 'valor'.
        pstm.setString(2, parametro); // El segundo "?" se establece con el valor 'parametro'.

        // Ejecuta la declaración de actualización y verifica si se actualizó al menos una fila.
        if (pstm.executeUpdate() > 0) {
            respuesta = true; // Si se actualizó al menos una fila, establece 'respuesta' en true.
        }

        // Cierra la declaración preparada 'pstm'.
        pstm.close();

    } catch (SQLException e) {
        // Captura y relanza cualquier excepción SQLException con un mensaje personalizado.
        throw new SQLException("error : " + e.getMessage());
    } finally {
        // Finalmente, asegura que la conexión se cierre, independientemente de si se produce una excepción o no.
        cn.close();
    }

    // Devuelve el valor de 'respuesta', que indica si la actualización fue exitosa o no.
    return respuesta;
}

}
