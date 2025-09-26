/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.modelo;

/**
 *
 * @author PABLO TREJO
 */
public class Usuario extends Empleado {
    //Declaracion de atributos
    private Empleado empleado;
    private String usuario;
    private String clave;
    private int activo;

    //Constructor
    public Usuario() {
    }

     //Metodos GET y SET
    public Empleado getDto() {
        return empleado;
    }

    public void setDto(Empleado empleado) {
        this.empleado = empleado;
    }
    
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getActivo() {
        return activo;
    }

    public void setActivo(int activo) {
        this.activo = activo;
    }

   
}
