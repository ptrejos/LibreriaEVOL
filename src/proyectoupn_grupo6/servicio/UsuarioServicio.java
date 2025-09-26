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
import proyectoupn_grupo6.modelo.Usuario;

/**
 *
 * @author PABLO TREJO
 */
public class UsuarioServicio {
    private Connection cn; // Declaración de una variable de tipo Connection

    //Metodo para validar el usuario
    public Usuario validarUsuario(String usuario, String clave) {
        Usuario dto = null;
        final String SQL = "select u.idempleado as idempleado,e.apellido as apellido,e.nombre as nombre,activo , e.direccion as direccion, e.email, u.usuario as usuario,  u.clave as clave "
                + "from USUARIO U inner join EMPLEADO E on u.idempleado=e."
                + "idempleado where u.usuario=? and u.clave=?;";
        try {
            cn = AccesoDB.getConnection();
            PreparedStatement pstm = cn.prepareStatement(SQL);
            pstm.setString(1, usuario);
            pstm.setString(2, clave);
            ResultSet rs = pstm.executeQuery();
            if (!rs.next()) {
                throw new SQLException("Datos incorrectos.");
            }
            dto = new Usuario();
            dto.setIdEmpleado(rs.getInt("idempleado"));
            dto.setApellido(rs.getString("apellido"));
            dto.setNombre(rs.getString("nombre"));
            dto.setDireccion(rs.getString("direccion"));
            dto.setEmail(rs.getString("email"));
            dto.setUsuario(rs.getString("usuario"));
            dto.setClave(rs.getString("clave"));

            rs.close();
            pstm.close();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        } catch (Exception e) {
            throw new RuntimeException("Error en el proceso, intentelo nuevamente.");
        } finally {
            try {
                cn.close();
            } catch (Exception e) {
            }
        }
        return dto;
    }
}
