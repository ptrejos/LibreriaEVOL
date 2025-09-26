/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.modelo;

import java.time.LocalDate;

/**
 *
 * @author PABLO TREJO
 */
public class Venta extends Promocion{
    //Declaracion de atributos
    private int idVenta;
    private String cliente;
    private LocalDate fecha;
    private int idEmpleado;
    private String idPublicacion;
    private int cantidad;
    private double precio;
    private double dcto;
    private double subTotal;
    private double impuesto;
    private double total;
    private Promocion promocion;

    //Constructor Vacio
    public Venta() {
    }
    
    //Constructor con dos parametros
    public Venta(int cantidad, double precio) {
        this.cantidad = cantidad;
        this.precio = precio;
    }

    //Metodos GET y SET
    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getIdPublicacion() {
        return idPublicacion;
    }

    public void setIdPublicacion(String idPublicacion) {
        this.idPublicacion = idPublicacion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getDcto() {
        return dcto;
    }

    public void setDcto(double dcto) {
        this.dcto = dcto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public Promocion getPromocion() {
        return promocion;
    }

    public void setPromocion(Promocion promocion) {
        this.promocion = promocion;
       
    }
}
