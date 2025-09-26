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
import proyectoupn_grupo6.modelo.Empleado;

/**
 *
 * @author PABLO TREJO
 */
public class EmpleadoServicio {
    private Connection cn;
    private PreparedStatement pstm;

    private final String GET_ALL = "select idempleado, apellido , nombre from EMPLEADO;";

    public List<Empleado> listarEmpleados() throws SQLException {
        // Declaración de una lista de objetos 'Empleado' llamada 'empleados'.
        List<Empleado> empleados = new ArrayList<>();

        try {
            // Obtiene una conexión a la base de datos utilizando la clase 'AccesoDB'.
            cn = AccesoDB.getConnection();

            // Prepara una declaración SQL de consulta utilizando la constante 'GET_ALL'.
            pstm = cn.prepareStatement(GET_ALL);

            // Ejecuta la consulta y obtiene un conjunto de resultados (ResultSet).
            ResultSet rs = pstm.executeQuery();

            // Recorre el conjunto de resultados (ResultSet).
            while (rs.next()) {
                // Crea un nuevo objeto 'Empleado'.
                Empleado dto = new Empleado();

                // Asigna valores a las propiedades del objeto 'Empleado' desde el ResultSet.
                dto.setIdEmpleado(rs.getInt("idempleado"));
                dto.setApellido(rs.getString("apellido"));
                dto.setNombre(rs.getString("nombre"));

                // Agrega el objeto 'Empleado' a la lista 'empleados'.
                empleados.add(dto);
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

        // Devuelve la lista de objetos 'Empleado' que se ha llenado con los resultados de la base de datos.
        return empleados;
    }

}
