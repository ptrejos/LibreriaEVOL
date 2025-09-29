/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.infraestructure.mapper;

import proyectoupn_grupo6.domain.entity.Tipo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author PABLO TREJO
 */
public class TipoRowMapper {
    /**
     * Mapea una fila del ResultSet a una entidad Tipo
     * @param rs ResultSet con los datos
     * @return Entidad Tipo mapeada
     * @throws SQLException Si hay error en el mapeo
     */
    public Tipo mapRow(ResultSet rs) throws SQLException {
        Tipo tipo = new Tipo();
        tipo.setIdTipo(rs.getString("idtipo"));
        tipo.setDescripcion(rs.getString("descripcion"));
        tipo.setContador(rs.getInt("contador"));
        return tipo;
    }
    
    /**
     * Mapea múltiples filas del ResultSet a una lista de entidades Tipo
     * @param rs ResultSet con múltiples filas
     * @return Lista de entidades Tipo
     * @throws SQLException Si hay error en el mapeo
     */
    public List<Tipo> mapRows(ResultSet rs) throws SQLException {
        List<Tipo> tipos = new ArrayList<>();
        while (rs.next()) {
            tipos.add(mapRow(rs));
        }
        return tipos;
    }
    
    /**
     * Verifica si existe al menos una fila en el ResultSet
     * @param rs ResultSet a verificar
     * @return true si existe al menos una fila
     * @throws SQLException Si hay error al verificar
     */
    public boolean hasRows(ResultSet rs) throws SQLException {
        return rs.next();
    }
    
    /**
     * Mapea la primera fila del ResultSet (útil para consultas por ID)
     * @param rs ResultSet con los datos
     * @return Tipo mapeado o null si no hay filas
     * @throws SQLException Si hay error en el mapeo
     */
    public Tipo mapSingleRow(ResultSet rs) throws SQLException {
        if (rs.next()) {
            return mapRow(rs);
        }
        return null;
    }
}
