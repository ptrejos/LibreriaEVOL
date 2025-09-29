/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.domain.service;

import proyectoupn_grupo6.domain.entity.Tipo;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PABLO TREJO
 */
public interface TipoService {
    /**
     * Lista todos los tipos disponibles
     * @return Lista de todos los tipos
     */
    List<Tipo> listarTodos();
    
    /**
     * Busca un tipo específico por ID
     * @param id Identificador del tipo
     * @return Optional con el tipo encontrado
     */
    Optional<Tipo> buscarPorId(String id);
    
    /**
     * Lista solo los tipos activos (con contador > 0)
     * @return Lista de tipos activos
     */
    List<Tipo> listarActivos();
    
    /**
     * Busca tipos por descripción parcial
     * @param descripcionParcial Parte de la descripción
     * @return Lista de tipos que coincidan
     */
    List<Tipo> buscarPorDescripcion(String descripcionParcial);
    
    /**
     * Crea un nuevo tipo
     * @param tipo Tipo a crear
     * @return Tipo creado
     * @throws IllegalArgumentException Si los datos no son válidos
     */
    Tipo crear(Tipo tipo);
    
    /**
     * Actualiza un tipo existente
     * @param tipo Tipo a actualizar
     * @return Tipo actualizado
     * @throws IllegalArgumentException Si el tipo no existe o datos inválidos
     */
    Tipo actualizar(Tipo tipo);
    
    /**
     * Elimina un tipo por ID
     * @param id Identificador del tipo a eliminar
     * @throws IllegalArgumentException Si el tipo no existe o está siendo usado
     */
    void eliminar(String id);
    
    /**
     * Incrementa el contador de un tipo
     * @param id Identificador del tipo
     * @return Tipo actualizado
     */
    Tipo incrementarContador(String id);
    
    /**
     * Decrementa el contador de un tipo
     * @param id Identificador del tipo
     * @return Tipo actualizado
     */
    Tipo decrementarContador(String id);
}
