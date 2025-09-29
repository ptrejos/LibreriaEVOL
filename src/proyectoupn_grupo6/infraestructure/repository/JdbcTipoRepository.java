/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.infraestructure.repository;

import proyectoupn_grupo6.domain.entity.Tipo;
import proyectoupn_grupo6.domain.repository.TipoRepository;
import proyectoupn_grupo6.infraestructure.config.DatabaseConfig;
import proyectoupn_grupo6.infraestructure.mapper.TipoRowMapper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
/**
 *
 * @author PABLO TREJO
 */
public class JdbcTipoRepository implements TipoRepository {
    private final TipoRowMapper rowMapper;
    
    // Consultas SQL como constantes
    private static final String SELECT_ALL = 
        "SELECT idtipo, descripcion, contador FROM tipo ORDER BY descripcion";
    
    private static final String SELECT_BY_ID = 
        "SELECT idtipo, descripcion, contador FROM tipo WHERE idtipo = ?";
    
    private static final String INSERT_TIPO = 
        "INSERT INTO tipo (idtipo, descripcion, contador) VALUES (?, ?, ?)";
    
    private static final String UPDATE_TIPO = 
        "UPDATE tipo SET descripcion = ?, contador = ? WHERE idtipo = ?";
    
    private static final String DELETE_BY_ID = 
        "DELETE FROM tipo WHERE idtipo = ?";
    
    private static final String EXISTS_BY_ID = 
        "SELECT 1 FROM tipo WHERE idtipo = ?";
    
    private static final String SELECT_BY_CONTADOR_GT_ZERO = 
        "SELECT idtipo, descripcion, contador FROM tipo WHERE contador > 0 ORDER BY descripcion";
    
    private static final String SELECT_BY_DESCRIPCION_LIKE = 
        "SELECT idtipo, descripcion, contador FROM tipo WHERE descripcion LIKE ? ORDER BY descripcion";
    
    /**
     * Constructor
     */
    public JdbcTipoRepository() {
        this.rowMapper = new TipoRowMapper();
    }
    
    @Override
    public List<Tipo> findAll() {
        System.out.println("Consultando todos los tipos");
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_ALL);
             ResultSet rs = stmt.executeQuery()) {
            
            List<Tipo> tipos = rowMapper.mapRows(rs);
            System.out.println("Se encontraron " + tipos.size() + " tipos");
            return tipos;
            
        } catch (SQLException e) {
            System.err.println("Error al consultar todos los tipos: " + e.getMessage());
            throw new RuntimeException("Error al obtener la lista de tipos", e);
        }
    }
    
    @Override
    public Optional<Tipo> findById(String id) {
        System.out.println("Consultando tipo por ID: " + id);
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_ID)) {
            
            stmt.setString(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                Tipo tipo = rowMapper.mapSingleRow(rs);
                
                if (tipo != null) {
                    System.out.println("Tipo encontrado: " + tipo);
                    return Optional.of(tipo);
                } else {
                    System.out.println("No se encontró tipo con ID: " + id);
                    return Optional.empty();
                }
            }
            
        } catch (SQLException e) {
            System.err.println("Error al consultar tipo por ID: " + id + " - " + e.getMessage());
            throw new RuntimeException("Error al buscar tipo por ID: " + id, e);
        }
    }
    
    @Override
    public Tipo save(Tipo tipo) {
        if (existsById(tipo.getIdTipo())) {
            return update(tipo);
        } else {
            return insert(tipo);
        }
    }
    
    private Tipo insert(Tipo tipo) {
        System.out.println("Insertando nuevo tipo: " + tipo);
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_TIPO)) {
            
            stmt.setString(1, tipo.getIdTipo());
            stmt.setString(2, tipo.getDescripcion());
            stmt.setInt(3, tipo.getContador());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Tipo insertado exitosamente: " + tipo.getIdTipo());
                return tipo;
            } else {
                throw new RuntimeException("No se pudo insertar el tipo");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al insertar tipo: " + tipo + " - " + e.getMessage());
            throw new RuntimeException("Error al guardar el tipo: " + tipo.getIdTipo(), e);
        }
    }
    
    private Tipo update(Tipo tipo) {
        System.out.println("Actualizando tipo: " + tipo);
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_TIPO)) {
            
            stmt.setString(1, tipo.getDescripcion());
            stmt.setInt(2, tipo.getContador());
            stmt.setString(3, tipo.getIdTipo());
            
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Tipo actualizado exitosamente: " + tipo.getIdTipo());
                return tipo;
            } else {
                throw new RuntimeException("No se pudo actualizar el tipo");
            }
            
        } catch (SQLException e) {
            System.err.println("Error al actualizar tipo: " + tipo + " - " + e.getMessage());
            throw new RuntimeException("Error al actualizar el tipo: " + tipo.getIdTipo(), e);
        }
    }
    
    @Override
    public void deleteById(String id) {
        System.out.println("Eliminando tipo por ID: " + id);
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_BY_ID)) {
            
            stmt.setString(1, id);
            int rowsAffected = stmt.executeUpdate();
            
            if (rowsAffected > 0) {
                System.out.println("Tipo eliminado exitosamente: " + id);
            } else {
                System.out.println("No se encontró tipo para eliminar con ID: " + id);
            }
            
        } catch (SQLException e) {
            System.err.println("Error al eliminar tipo por ID: " + id + " - " + e.getMessage());
            throw new RuntimeException("Error al eliminar el tipo: " + id, e);
        }
    }
    
    @Override
    public boolean existsById(String id) {
        System.out.println("Verificando existencia de tipo por ID: " + id);
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(EXISTS_BY_ID)) {
            
            stmt.setString(1, id);
            
            try (ResultSet rs = stmt.executeQuery()) {
                boolean exists = rs.next();
                System.out.println("Tipo con ID " + id + " existe: " + exists);
                return exists;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al verificar existencia de tipo por ID: " + id + " - " + e.getMessage());
            throw new RuntimeException("Error al verificar existencia del tipo: " + id, e);
        }
    }
    
    @Override
    public List<Tipo> findByContadorGreaterThanZero() {
        System.out.println("Consultando tipos activos (contador > 0)");
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_CONTADOR_GT_ZERO);
             ResultSet rs = stmt.executeQuery()) {
            
            List<Tipo> tipos = rowMapper.mapRows(rs);
            System.out.println("Se encontraron " + tipos.size() + " tipos activos");
            return tipos;
            
        } catch (SQLException e) {
            System.err.println("Error al consultar tipos activos: " + e.getMessage());
            throw new RuntimeException("Error al obtener tipos activos", e);
        }
    }
    
    @Override
    public List<Tipo> findByDescripcionContaining(String descripcionParcial) {
        System.out.println("Consultando tipos por descripción parcial: " + descripcionParcial);
        
        try (Connection conn = DatabaseConfig.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_BY_DESCRIPCION_LIKE)) {
            
            stmt.setString(1, "%" + descripcionParcial + "%");
            
            try (ResultSet rs = stmt.executeQuery()) {
                List<Tipo> tipos = rowMapper.mapRows(rs);
                System.out.println("Se encontraron " + tipos.size() + " tipos con descripción que contiene '" + descripcionParcial + "'");
                return tipos;
            }
            
        } catch (SQLException e) {
            System.err.println("Error al consultar tipos por descripción parcial: " + descripcionParcial + " - " + e.getMessage());
            throw new RuntimeException("Error al buscar tipos por descripción: " + descripcionParcial, e);
        }
    }
}
