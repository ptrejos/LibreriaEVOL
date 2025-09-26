/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.controlador;

import java.sql.SQLException;
import java.util.List;
import proyectoupn_grupo6.modelo.Venta;
import proyectoupn_grupo6.servicio.VentasServicio;

/**
 *
 * @author PABLO TREJO
 */
public class ConsultaVentaControlador {
    public List<Venta> listarVentasPorRangoFechas(String fechaInicio , String fechaTermino) throws SQLException {
        // Crea una instancia del servicio de ventas llamado 'svc'.
        VentasServicio svc = new VentasServicio();
         // Llama al método 'listarVentasPorRangoFecha(fechaInicio, fechaTermino)' del servicio
        // para obtener una lista de ventas que ocurrieron dentro del rango de fechas especificado.
        return svc.listarVentasPorRangoFecha(fechaInicio, fechaTermino);
    }
}
