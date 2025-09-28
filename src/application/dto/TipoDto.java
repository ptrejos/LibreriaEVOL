/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package application.dto;

/**
 *
 * @author PABLO TREJO
 */
public class TipoDto {
    private String idTipo;
    private String descripcion;
    private int contador;
    private boolean activo;
    
    // Constructor vacío
    public TipoDto() {}
    
    // Constructor completo
    public TipoDto(String idTipo, String descripcion, int contador) {
        this.idTipo = idTipo;
        this.descripcion = descripcion;
        this.contador = contador;
        this.activo = contador > 0;
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
        this.activo = contador > 0; // Actualizar estado activo automáticamente
    }
    
    public boolean isActivo() {
        return activo;
    }
    
    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    
    // Métodos de utilidad para la vista
    public String getEstadoTexto() {
        return activo ? "Activo" : "Inactivo";
    }
    
    public String getDescripcionCompleta() {
        return String.format("%s (%d)", descripcion, contador);
    }
    
    public String getEstadoColor() {
        return activo ? "green" : "gray";
    }
    
    // Validaciones para la vista
    public boolean esValidoParaGuardar() {
        return idTipo != null && !idTipo.trim().isEmpty() 
            && descripcion != null && !descripcion.trim().isEmpty()
            && contador >= 0;
    }
    
    @Override
    public String toString() {
        return String.format("TipoDto{idTipo='%s', descripcion='%s', contador=%d, activo=%s}", 
                           idTipo, descripcion, contador, activo);
    }
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoDto tipoDto = (TipoDto) o;
        return java.util.Objects.equals(idTipo, tipoDto.idTipo);
    }
    
    @Override
    public int hashCode() {
        return java.util.Objects.hash(idTipo);
    }
}
