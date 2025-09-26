/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.modelo;

/**
 *
 * @author PABLO TREJO
 */
public class Promocion {
    //Declaracion de atributos
  private int idPromocion;
  private int cantMin;
  private int cantMax;
  private double porcentaje;  
  
  //Constructor
  public Promocion(){
  
  }

  //Constructor con 3 parametros
    public Promocion(int cantMin, int cantMax, double porcentaje) {
        this.cantMin = cantMin;
        this.cantMax = cantMax;
        this.porcentaje = porcentaje;
    }

     //Metodos GET y SET
    public int getIdPromocion() {
        return idPromocion;
    }

    public void setIdPromocion(int idPromocion) {
        this.idPromocion = idPromocion;
    }

    public int getCantMin() {
        return cantMin;
    }

    public void setCantMin(int cantMin) {
        this.cantMin = cantMin;
    }

    public int getCantMax() {
        return cantMax;
    }

    public void setCantMax(int cantMax) {
        this.cantMax = cantMax;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }
}
