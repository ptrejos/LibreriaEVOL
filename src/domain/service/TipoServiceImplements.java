/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.service;

import domain.entity.Tipo;
import domain.repository.TipoRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author PABLO TREJO
 */
public class TipoServiceImplements implements TipoService{
       private final TipoRepository tipoRepository;
    
    /**
     * Constructor con inyección de dependencias
     * @param tipoRepository Repository de tipos
     */
    public TipoServiceImplements(TipoRepository tipoRepository) {
        this.tipoRepository = tipoRepository;
    }
    
    @Override
    public List<Tipo> listarTodos() {
        return tipoRepository.findAll();
    }
    
    @Override
    public Optional<Tipo> buscarPorId(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del tipo no puede ser nulo o vacío");
        }
        return tipoRepository.findById(id);
    }
    
    @Override
    public List<Tipo> listarActivos() {
        return tipoRepository.findByContadorGreaterThanZero();
    }
    
    @Override
    public List<Tipo> buscarPorDescripcion(String descripcionParcial) {
        if (descripcionParcial == null || descripcionParcial.trim().isEmpty()) {
            throw new IllegalArgumentException("La descripción no puede ser nula o vacía");
        }
        return tipoRepository.findByDescripcionContaining(descripcionParcial);
    }
    
    @Override
    public Tipo crear(Tipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo no puede ser nulo");
        }
        
        if (!tipo.esValidoParaCrear()) {
            throw new IllegalArgumentException("Datos del tipo inválidos para crear");
        }
        
        if (tipoRepository.existsById(tipo.getIdTipo())) {
            throw new IllegalArgumentException("Ya existe un tipo con ID: " + tipo.getIdTipo());
        }
        
        return tipoRepository.save(tipo);
    }
    
    @Override
    public Tipo actualizar(Tipo tipo) {
        if (tipo == null) {
            throw new IllegalArgumentException("El tipo no puede ser nulo");
        }
        
        if (!tipoRepository.existsById(tipo.getIdTipo())) {
            throw new IllegalArgumentException("No existe un tipo con ID: " + tipo.getIdTipo());
        }
        
        if (!tipo.esValidoParaCrear()) {
            throw new IllegalArgumentException("Datos del tipo inválidos para actualizar");
        }
        
        return tipoRepository.save(tipo);
    }
    
    @Override
    public void eliminar(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("El ID del tipo no puede ser nulo o vacío");
        }
        
        Optional<Tipo> tipoExistente = tipoRepository.findById(id);
        if (!tipoExistente.isPresent()) {
            throw new IllegalArgumentException("No existe un tipo con ID: " + id);
        }
        
        // Regla de negocio: no eliminar tipos activos
        if (tipoExistente.get().esActivo()) {
            throw new IllegalArgumentException("No se puede eliminar un tipo activo (contador > 0)");
        }
        
        tipoRepository.deleteById(id);
    }
    
    @Override
    public Tipo incrementarContador(String id) {
        Optional<Tipo> tipoOpt = buscarPorId(id);
        if (!tipoOpt.isPresent()) {
            throw new IllegalArgumentException("No existe un tipo con ID: " + id);
        }
        
        Tipo tipo = tipoOpt.get();
        tipo.incrementarContador();
        return tipoRepository.save(tipo);
    }
    
    @Override
    public Tipo decrementarContador(String id) {
        Optional<Tipo> tipoOpt = buscarPorId(id);
        if (!tipoOpt.isPresent()) {
            throw new IllegalArgumentException("No existe un tipo con ID: " + id);
        }
        
        Tipo tipo = tipoOpt.get();
        tipo.decrementarContador();
        return tipoRepository.save(tipo);
    }
}
