/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.modelo;

/**
 *
 * @author PABLO TREJO
 */
public class Tipo {
    //Declaracion de atributos
    private String idTipo ;
    private String Descripcion;
    private int contador;

    //Constructor
    public Tipo() {
    }

     //Metodos GET y SET
    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }
}
