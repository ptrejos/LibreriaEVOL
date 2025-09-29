/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.domain.repository;

import proyectoupn_grupo6.domain.entity.Tipo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PABLO TREJO
 */
public interface TipoRepository {
    /**
     * Obtiene todos los tipos disponibles
     * @return Lista de todos los tipos
     */
    List<Tipo> findAll();
    
    /**
     * Busca un tipo por su ID
     * @param id Identificador del tipo
     * @return Optional con el tipo encontrado o vacío si no existe
     */
    Optional<Tipo> findById(String id);
    
    /**
     * Guarda un tipo nuevo o actualiza uno existente
     * @param tipo Tipo a guardar
     * @return Tipo guardado
     */
    Tipo save(Tipo tipo);
    
    /**
     * Elimina un tipo por su ID
     * @param id Identificador del tipo a eliminar
     */
    void deleteById(String id);
    
    /**
     * Verifica si existe un tipo con el ID especificado
     * @param id Identificador del tipo
     * @return true si existe, false si no
     */
    boolean existsById(String id);
    
    /**
     * Obtiene tipos que tengan contador mayor a cero (activos)
     * @return Lista de tipos activos
     */
    List<Tipo> findByContadorGreaterThanZero();
    
    /**
     * Busca tipos por descripción (búsqueda parcial)
     * @param descripcionParcial Parte de la descripción a buscar
     * @return Lista de tipos que coincidan
     */
    List<Tipo> findByDescripcionContaining(String descripcionParcial);
}
