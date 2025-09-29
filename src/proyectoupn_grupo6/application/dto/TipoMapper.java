/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.application.dto;

import proyectoupn_grupo6.domain.entity.Tipo;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 *
 * @author PABLO TREJO
 */
public class TipoMapper {
    /**
     * Convierte una entidad Tipo a TipoDto
     * @param tipo Entidad de dominio
     * @return DTO para transferencia
     */
    public static TipoDto toDto(Tipo tipo) {
        if (tipo == null) {
            return null;
        }
        
        TipoDto dto = new TipoDto();
        dto.setIdTipo(tipo.getIdTipo());
        dto.setDescripcion(tipo.getDescripcion());
        dto.setContador(tipo.getContador());
        dto.setActivo(tipo.esActivo());
        
        return dto;
    }
    
    /**
     * Convierte un TipoDto a entidad Tipo
     * @param dto DTO de transferencia
     * @return Entidad de dominio
     */
    public static Tipo toEntity(TipoDto dto) {
        if (dto == null) {
            return null;
        }
        
        Tipo tipo = new Tipo();
        tipo.setIdTipo(dto.getIdTipo());
        tipo.setDescripcion(dto.getDescripcion());
        tipo.setContador(dto.getContador());
        
        return tipo;
    }
    
    /**
     * Convierte una lista de entidades Tipo a lista de TipoDto
     * @param tipos Lista de entidades de dominio
     * @return Lista de DTOs
     */
    public static List<TipoDto> toDtoList(List<Tipo> tipos) {
        if (tipos == null) {
            return new ArrayList<>();
        }
        
        return tipos.stream()
                   .map(TipoMapper::toDto)
                   .collect(Collectors.toList());
    }
    
    /**
     * Convierte una lista de TipoDto a lista de entidades Tipo
     * @param dtos Lista de DTOs
     * @return Lista de entidades de dominio
     */
    public static List<Tipo> toEntityList(List<TipoDto> dtos) {
        if (dtos == null) {
            return new ArrayList<>();
        }
        
        return dtos.stream()
                  .map(TipoMapper::toEntity)
                  .collect(Collectors.toList());
    }
    
    /**
     * Actualiza una entidad existente con datos del DTO
     * @param tipo Entidad existente a actualizar
     * @param dto DTO con nuevos datos
     */
    public static void updateEntityFromDto(Tipo tipo, TipoDto dto) {
        if (tipo == null || dto == null) {
            return;
        }
        
        // Solo actualizar campos modificables (no el ID)
        tipo.setDescripcion(dto.getDescripcion());
        tipo.setContador(dto.getContador());
    }
    
    /**
     * Crea un TipoDto con valores por defecto
     * @return TipoDto con valores iniciales
     */
    public static TipoDto createDefault() {
        TipoDto dto = new TipoDto();
        dto.setIdTipo("");
        dto.setDescripcion("");
        dto.setContador(0);
        dto.setActivo(false);
        return dto;
    }
    
    /**
     * Crea un TipoDto para pruebas
     * @param id ID del tipo
     * @param descripcion Descripción del tipo
     * @param contador Contador inicial
     * @return TipoDto para testing
     */
    public static TipoDto createForTest(String id, String descripcion, int contador) {
        return new TipoDto(id, descripcion, contador);
    }
    
}
