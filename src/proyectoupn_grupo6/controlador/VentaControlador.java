/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.controlador;

import java.sql.SQLException;
import java.util.List;
import proyectoupn_grupo6.modelo.Empleado;
import proyectoupn_grupo6.modelo.Publicacion;
import proyectoupn_grupo6.modelo.Venta;
import proyectoupn_grupo6.servicio.ControlServicio;
import proyectoupn_grupo6.servicio.EmpleadoServicio;
import proyectoupn_grupo6.servicio.PublicacionServicio;
import proyectoupn_grupo6.servicio.VentasServicio;

/**
 *
 * @author PABLO TREJO
 */
public class VentaControlador {
     public List<Publicacion> listarPublicaciones() throws SQLException {
        PublicacionServicio svc = new PublicacionServicio();
        return svc.listarPublicacion();

    }

    public List<Empleado> listarEmpleados() throws SQLException {
        EmpleadoServicio svc = new EmpleadoServicio();
        return svc.listarEmpleados();

    }

    public List<Venta> listarVentas() throws SQLException {
        VentasServicio svc = new VentasServicio();
        return svc.listarVentas();
    }

    public Publicacion getPublicacionPorId(String idPublicacion) throws SQLException {
        PublicacionServicio svc = new PublicacionServicio();
        return svc.getPublicacionPorId(idPublicacion);

    }

    public Venta calcular(Venta dto, double igv) throws SQLException {
        VentasServicio svc = new VentasServicio();
        return svc.calcular(dto, igv);
    }

    public int getIdventa() throws SQLException {
        VentasServicio svc = new VentasServicio();
        return svc.getIdVenta();
    }

    public boolean insertarVenta(Venta dto) throws SQLException {

        VentasServicio svc = new VentasServicio();
        return svc.insertarVenta(dto);
    }

    public boolean actualizarStock(int cantidad, String idPublicacion) throws SQLException {
        PublicacionServicio svc = new PublicacionServicio();
        return svc.actualizarStock(cantidad, idPublicacion);
    }

    public double getIgv() throws SQLException {
        ControlServicio svc = new ControlServicio();
        return Double.parseDouble(svc.getControl("IGV"));
    }

    public boolean sumVenta() throws SQLException {
        ControlServicio svc = new ControlServicio();
        int venta = Integer.parseInt(svc.getControl("VENTA"));
        return  svc.actualizarControl("VENTA", String.valueOf(venta + 1));

    }
}
