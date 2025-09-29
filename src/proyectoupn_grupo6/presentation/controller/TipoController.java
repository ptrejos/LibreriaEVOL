/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.presentation.controller;

import java.util.List;
import proyectoupn_grupo6.application.dto.TipoDto;
import proyectoupn_grupo6.application.usecase.ConsultarTiposUseCase;
import proyectoupn_grupo6.application.usecase.MantenimientoTipoUseCase;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author PABLO TREJO
 */
public class TipoController {
      private static final Logger logger = LoggerFactory.getLogger(TipoController.class);
    
    private final ConsultarTiposUseCase consultarTiposUseCase;
    private final MantenimientoTipoUseCase mantenimientoTipoUseCase;
    
    /**
     * Constructor con inyección de dependencias
     * @param consultarTiposUseCase Caso de uso para consultas
     * @param mantenimientoTipoUseCase Caso de uso para mantenimiento
     */
    public TipoController(ConsultarTiposUseCase consultarTiposUseCase,
                         MantenimientoTipoUseCase mantenimientoTipoUseCase) {
        this.consultarTiposUseCase = consultarTiposUseCase;
        this.mantenimientoTipoUseCase = mantenimientoTipoUseCase;
    }
    
    /**
     * Lista todos los tipos disponibles
     * @return Lista de tipos en formato DTO
     */
    public List<TipoDto> listarTodos() {
        logger.debug("Controlador: listando todos los tipos");
        
        try {
            List<TipoDto> tipos = consultarTiposUseCase.ejecutar();
            logger.info("Listado de tipos completado. {} tipos encontrados", tipos.size());
            return tipos;
            
        } catch (Exception e) {
            logger.error("Error en controlador al listar tipos", e);
            throw new ControllerException("Error al obtener la lista de tipos", e);
        }
    }
    
    /**
     * Lista solo los tipos activos (contador > 0)
     * @return Lista de tipos activos
     */
    public List<TipoDto> listarActivos() {
        logger.debug("Controlador: listando tipos activos");
        
        try {
            List<TipoDto> tipos = consultarTiposUseCase.ejecutarSoloActivos();
            logger.info("Listado de tipos activos completado. {} tipos encontrados", tipos.size());
            return tipos;
            
        } catch (Exception e) {
            logger.error("Error en controlador al listar tipos activos", e);
            throw new ControllerException("Error al obtener tipos activos", e);
        }
    }
    
    /**
     * Busca un tipo específico por ID
     * @param id Identificador del tipo
     * @return Tipo encontrado o null si no existe
     */
    public TipoDto buscarPorId(String id) {
        logger.debug("Controlador: buscando tipo por ID {}", id);
        
        try {
            if (id == null || id.trim().isEmpty()) {
                throw new ControllerException("El ID del tipo es requerido");
            }
            
            TipoDto tipo = consultarTiposUseCase.ejecutarPorId(id);
            
            if (tipo != null) {
                logger.info("Tipo encontrado: {}", tipo.getIdTipo());
            } else {
                logger.info("No se encontró tipo con ID: {}", id);
            }
            
            return tipo;
            
        } catch (ControllerException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error en controlador al buscar tipo por ID: {}", id, e);
            throw new ControllerException("Error al buscar tipo por ID", e);
        }
    }
    
    /**
     * Busca tipos por descripción parcial
     * @param descripcionParcial Parte de la descripción a buscar
     * @return Lista de tipos que coinciden
     */
    public List<TipoDto> buscarPorDescripcion(String descripcionParcial) {
        logger.debug("Controlador: buscando tipos por descripción '{}'", descripcionParcial);
        
        try {
            if (descripcionParcial == null || descripcionParcial.trim().isEmpty()) {
                throw new ControllerException("La descripción a buscar es requerida");
            }
            
            List<TipoDto> tipos = consultarTiposUseCase.ejecutarPorDescripcion(descripcionParcial);
            logger.info("Búsqueda por descripción completada. {} tipos encontrados", tipos.size());
            return tipos;
            
        } catch (ControllerException e) {
            throw e;
        } catch (Exception e) {
            logger.error("Error en controlador al buscar por descripción: {}", descripcionParcial, e);
            throw new ControllerException("Error al buscar tipos por descripción", e);
        }
    }
    
    /**
     * Crea un nuevo tipo
     * @param tipoDto Datos del tipo a crear
     * @return Tipo creado
     */
    public TipoDto crear(TipoDto tipoDto) {
        logger.debug("Controlador: creando nuevo tipo");
        
        try {
            TipoDto tipoCreado = mantenimientoTipoUseCase.crear(tipoDto);
            logger.info("Tipo creado exitosamente: {}", tipoCreado.getIdTipo());
            return tipoCreado;
            
        } catch (IllegalArgumentException e) {
            logger.warn("Datos inválidos para crear tipo: {}", e.getMessage());
            throw new ControllerException("Datos inválidos: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error en controlador al crear tipo", e);
            throw new ControllerException("Error al crear tipo", e);
        }
    }
    
    /**
     * Actualiza un tipo existente
     * @param tipoDto Datos del tipo a actualizar
     * @return Tipo actualizado
     */
    public TipoDto actualizar(TipoDto tipoDto) {
        logger.debug("Controlador: actualizando tipo {}", tipoDto != null ? tipoDto.getIdTipo() : "null");
        
        try {
            TipoDto tipoActualizado = mantenimientoTipoUseCase.actualizar(tipoDto);
            logger.info("Tipo actualizado exitosamente: {}", tipoActualizado.getIdTipo());
            return tipoActualizado;
            
        } catch (IllegalArgumentException e) {
            logger.warn("Datos inválidos para actualizar tipo: {}", e.getMessage());
            throw new ControllerException("Datos inválidos: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error en controlador al actualizar tipo", e);
            throw new ControllerException("Error al actualizar tipo", e);
        }
    }
    
    /**
     * Elimina un tipo por ID
     * @param id Identificador del tipo a eliminar
     */
    public void eliminar(String id) {
        logger.debug("Controlador: eliminando tipo {}", id);
        
        try {
            mantenimientoTipoUseCase.eliminar(id);
            logger.info("Tipo eliminado exitosamente: {}", id);
            
        } catch (IllegalArgumentException e) {
            logger.warn("Error al eliminar tipo: {}", e.getMessage());
            throw new ControllerException("Error de validación: " + e.getMessage(), e);
        } catch (Exception e) {
            logger.error("Error en controlador al eliminar tipo: {}", id, e);
            throw new ControllerException("Error al eliminar tipo", e);
        }
    }
    
    /**
     * Incrementa el contador de un tipo
     * @param id Identificador del tipo
     * @return Tipo con contador incrementado
     */
    public TipoDto incrementarContador(String id) {
        logger.debug("Controlador: incrementando contador del tipo {}", id);
        
        try {
            TipoDto tipoActualizado = mantenimientoTipoUseCase.incrementarContador(id);
            logger.info("Contador incrementado para tipo: {}", id);
            return tipoActualizado;
            
        } catch (Exception e) {
            logger.error("Error en controlador al incrementar contador: {}", id, e);
            throw new ControllerException("Error al incrementar contador", e);
        }
    }
    
    /**
     * Decrementa el contador de un tipo
     * @param id Identificador del tipo
     * @return Tipo con contador decrementado
     */
    public TipoDto decrementarContador(String id) {
        logger.debug("Controlador: decrementando contador del tipo {}", id);
        
        try {
            TipoDto tipoActualizado = mantenimientoTipoUseCase.decrementarContador(id);
            logger.info("Contador decrementado para tipo: {}", id);
            return tipoActualizado;
            
        } catch (Exception e) {
            logger.error("Error en controlador al decrementar contador: {}", id, e);
            throw new ControllerException("Error al decrementar contador", e);
        }
    }
}
