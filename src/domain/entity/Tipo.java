/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package domain.entity;

import java.util.Objects;

/**
 *
 * @author PABLO TREJO
 */
public class Tipo {
    private String idTipo;
    private String descripcion;
    private int contador;
    
    // Constructor vacío
    public Tipo() {}
    
    // Constructor completo
    public Tipo(String idTipo, String descripcion, int contador) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
        this.contador = contador;
    }
    
    // Getters y Setters
    public String getIdTipo() {
        return idTipo;
    }
    
    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public int getContador() {
        return contador;
    }
    
    public void setContador(int contador) {
        this.contador = contador;
    }
    
    // Métodos de dominio (lógica de negocio)
    public void incrementarContador() {
        this.contador++;
    }
    
    public void decrementarContador() {
        if (this.contador > 0) {
            this.contador--;
        }
    }
    
    public boolean esActivo() {
        return this.contador > 0;
    }
    
    public boolean esValidoParaCrear() {
        return this.idTipo != null && !this.idTipo.trim().isEmpty() 
            && this.descripcion != null && !this.descripcion.trim().isEmpty();
    }
    
    // Equals y HashCode para comparaciones
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tipo tipo = (Tipo) o;
        return Objects.equals(idTipo, tipo.idTipo);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(idTipo);
    }
    
    // ToString para debugging
    @Override
    public String toString() {
        return String.format("Tipo{idTipo='%s', descripcion='%s', contador=%d}", 
                           idTipo, descripcion, contador);
    }
    
}
