/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.application.usecase;

import proyectoupn_grupo6.application.dto.TipoDto;
import proyectoupn_grupo6.application.dto.TipoMapper;
import proyectoupn_grupo6.domain.entity.Tipo;
import proyectoupn_grupo6.domain.service.TipoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author PABLO TREJO
 */
public class MantenimientoTipoUseCase {
      private static final Logger logger = LoggerFactory.getLogger(MantenimientoTipoUseCase.class);
    private final TipoService tipoService;
    
    /**
     * Constructor con inyección de dependencias
     * @param tipoService Servicio de dominio para tipos
     */
    public MantenimientoTipoUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }
    
    /**
     * Crea un nuevo tipo
     * @param tipoDto DTO con los datos del tipo a crear
     * @return DTO del tipo creado
     */
    public TipoDto crear(TipoDto tipoDto) {
        logger.debug("Ejecutando caso de uso: crear tipo {}", tipoDto.getIdTipo());
        
        try {
            // Validaciones a nivel de caso de uso
            validarDatosParaCrear(tipoDto);
            
            // Convertir DTO a entidad
            Tipo tipo = TipoMapper.toEntity(tipoDto);
            
            // Ejecutar lógica de dominio
            Tipo tipoCreado = tipoService.crear(tipo);
            
            // Convertir resultado a DTO
            TipoDto resultado = TipoMapper.toDto(tipoCreado);
            
            logger.info("Tipo creado exitosamente: {}", resultado.getIdTipo());
            return resultado;
            
        } catch (IllegalArgumentException e) {
            logger.warn("Error de validación al crear tipo: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error inesperado al crear tipo", e);
            throw new RuntimeException("Error al crear tipo: " + e.getMessage(), e);
        }
    }
    
    /**
     * Actualiza un tipo existente
     * @param tipoDto DTO con los datos del tipo a actualizar
     * @return DTO del tipo actualizado
     */
    public TipoDto actualizar(TipoDto tipoDto) {
        logger.debug("Ejecutando caso de uso: actualizar tipo {}", tipoDto.getIdTipo());
        
        try {
            // Validaciones a nivel de caso de uso
            validarDatosParaActualizar(tipoDto);
            
            // Convertir DTO a entidad
            Tipo tipo = TipoMapper.toEntity(tipoDto);
            
            // Ejecutar lógica de dominio
            Tipo tipoActualizado = tipoService.actualizar(tipo);
            
            // Convertir resultado a DTO
            TipoDto resultado = TipoMapper.toDto(tipoActualizado);
            
            logger.info("Tipo actualizado exitosamente: {}", resultado.getIdTipo());
            return resultado;
            
        } catch (IllegalArgumentException e) {
            logger.warn("Error de validación al actualizar tipo: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error inesperado al actualizar tipo", e);
            throw new RuntimeException("Error al actualizar tipo: " + e.getMessage(), e);
        }
    }
    
    /**
     * Elimina un tipo por ID
     * @param id Identificador del tipo a eliminar
     */
    public void eliminar(String id) {
        logger.debug("Ejecutando caso de uso: eliminar tipo {}", id);
        
        try {
            // Validaciones a nivel de caso de uso
            if (id == null || id.trim().isEmpty()) {
                throw new IllegalArgumentException("El ID del tipo es requerido para eliminar");
            }
            
            // Ejecutar lógica de dominio
            tipoService.eliminar(id);
            
            logger.info("Tipo eliminado exitosamente: {}", id);
            
        } catch (IllegalArgumentException e) {
            logger.warn("Error de validación al eliminar tipo: {}", e.getMessage());
            throw e;
        } catch (Exception e) {
            logger.error("Error inesperado al eliminar tipo: {}", id, e);
            throw new RuntimeException("Error al eliminar tipo: " + e.getMessage(), e);
        }
    }
    
    /**
     * Incrementa el contador de un tipo
     * @param id Identificador del tipo
     * @return DTO del tipo actualizado
     */
    public TipoDto incrementarContador(String id) {
        logger.debug("Ejecutando caso de uso: incrementar contador del tipo {}", id);
        
        try {
            Tipo tipoActualizado = tipoService.incrementarContador(id);
            TipoDto resultado = TipoMapper.toDto(tipoActualizado);
            
            logger.info("Contador incrementado para tipo: {}. Nuevo valor: {}", 
                       id, resultado.getContador());
            return resultado;
            
        } catch (Exception e) {
            logger.error("Error al incrementar contador del tipo: {}", id, e);
            throw new RuntimeException("Error al incrementar contador: " + e.getMessage(), e);
        }
    }
    
    /**
     * Decrementa el contador de un tipo
     * @param id Identificador del tipo
     * @return DTO del tipo actualizado
     */
    public TipoDto decrementarContador(String id) {
        logger.debug("Ejecutando caso de uso: decrementar contador del tipo {}", id);
        
        try {
            Tipo tipoActualizado = tipoService.decrementarContador(id);
            TipoDto resultado = TipoMapper.toDto(tipoActualizado);
            
            logger.info("Contador decrementado para tipo: {}. Nuevo valor: {}", 
                       id, resultado.getContador());
            return resultado;
            
        } catch (Exception e) {
            logger.error("Error al decrementar contador del tipo: {}", id, e);
            throw new RuntimeException("Error al decrementar contador: " + e.getMessage(), e);
        }
    }
    
    /**
     * Validaciones específicas para crear tipo
     */
    private void validarDatosParaCrear(TipoDto tipoDto) {
        if (tipoDto == null) {
            throw new IllegalArgumentException("Los datos del tipo son requeridos");
        }
        
        if (tipoDto.getIdTipo() == null || tipoDto.getIdTipo().trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del tipo es requerido");
        }
        
        if (tipoDto.getDescripcion() == null || tipoDto.getDescripcion().trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción del tipo es requerida");
        }
        
        // Validar longitud de campos
        if (tipoDto.getIdTipo().length() > 10) {
            throw new IllegalArgumentException("El ID del tipo no puede exceder 10 caracteres");
        }
        
        if (tipoDto.getDescripcion().length() > 50) {
            throw new IllegalArgumentException("La descripción no puede exceder 50 caracteres");
        }
        
        // Validar contador no negativo
        if (tipoDto.getContador() < 0) {
            throw new IllegalArgumentException("El contador no puede ser negativo");
        }
    }
    
    /**
     * Validaciones específicas para actualizar tipo
     */
    private void validarDatosParaActualizar(TipoDto tipoDto) {
        validarDatosParaCrear(tipoDto); // Reutilizar validaciones básicas
        
        // Validaciones adicionales específicas para actualización
        // (por ejemplo, verificar que el tipo existe, etc.)
    }
}
