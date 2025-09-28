/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.usecase;

import application.dto.TipoDto;
import application.dto.TipoMapper;
import domain.entity.Tipo;
import domain.service.TipoService;
//import java.lang.System.Logger;
import java.util.List;
import java.util.Optional;
//import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 *
 * @author PABLO TREJO
 */
public class ConsultarTiposUseCase {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ConsultarTiposUseCase.class);
    private final TipoService tipoService;
    
    /**
     * Constructor con inyección de dependencias
     * @param tipoService Servicio de dominio para tipos
     */
    public ConsultarTiposUseCase(TipoService tipoService) {
        this.tipoService = tipoService;
    }
    
    /**
     * Ejecuta la consulta de todos los tipos
     * @return Lista de DTOs de tipos
     */
    public List<TipoDto> ejecutar() {
        logger.debug("Ejecutando caso de uso: consultar todos los tipos");
        
        try {
            List<Tipo> tipos = tipoService.listarTodos();
            List<TipoDto> tiposDto = TipoMapper.toDtoList(tipos);
            
            logger.info("Consulta de tipos ejecutada exitosamente. {} tipos encontrados", tiposDto.size());
            return tiposDto;
            
        } catch (Exception e) {
            logger.error("Error al ejecutar consulta de tipos", e);
            throw new RuntimeException("Error al consultar tipos: " + e.getMessage(), e);
        }
    }
    
    /**
     * Ejecuta la consulta de tipos activos solamente
     * @return Lista de DTOs de tipos activos
     */
    public List<TipoDto> ejecutarSoloActivos() {
        logger.debug("Ejecutando caso de uso: consultar tipos activos");
        
        try {
            List<Tipo> tipos = tipoService.listarActivos();
            List<TipoDto> tiposDto = TipoMapper.toDtoList(tipos);
            
            logger.info("Consulta de tipos activos ejecutada exitosamente. {} tipos encontrados", tiposDto.size());
            return tiposDto;
            
        } catch (Exception e) {
            logger.error("Error al ejecutar consulta de tipos activos", e);
            throw new RuntimeException("Error al consultar tipos activos: " + e.getMessage(), e);
        }
    }
    
    /**
     * Ejecuta la consulta de un tipo específico por ID
     * @param id Identificador del tipo
     * @return DTO del tipo encontrado o null si no existe
     */
    public TipoDto ejecutarPorId(String id) {
        logger.debug("Ejecutando caso de uso: consultar tipo por ID {}", id);
        
        try {
            Optional<Tipo> tipoOpt = tipoService.buscarPorId(id);
            
            if (tipoOpt.isPresent()) {
                TipoDto tipoDto = TipoMapper.toDto(tipoOpt.get());
                logger.info("Tipo encontrado: {}", tipoDto.getIdTipo());
                return tipoDto;
            } else {
                logger.info("No se encontró tipo con ID: {}", id);
                return null;
            }
            
        } catch (Exception e) {
            logger.error("Error al ejecutar consulta de tipo por ID: {}", id, e);
            throw new RuntimeException("Error al consultar tipo por ID: " + e.getMessage(), e);
        }
    }
    
    /**
     * Ejecuta la búsqueda de tipos por descripción parcial
     * @param descripcionParcial Parte de la descripción a buscar
     * @return Lista de DTOs de tipos que coinciden
     */
    public List<TipoDto> ejecutarPorDescripcion(String descripcionParcial) {
        logger.debug("Ejecutando caso de uso: buscar tipos por descripción '{}'", descripcionParcial);
        
        try {
            List<Tipo> tipos = tipoService.buscarPorDescripcion(descripcionParcial);
            List<TipoDto> tiposDto = TipoMapper.toDtoList(tipos);
            
            logger.info("Búsqueda por descripción ejecutada exitosamente. {} tipos encontrados", tiposDto.size());
            return tiposDto;
            
        } catch (Exception e) {
            logger.error("Error al ejecutar búsqueda por descripción: {}", descripcionParcial, e);
            throw new RuntimeException("Error al buscar tipos por descripción: " + e.getMessage(), e);
        }
    }
}
