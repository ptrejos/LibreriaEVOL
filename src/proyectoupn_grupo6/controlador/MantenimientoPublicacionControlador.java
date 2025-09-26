/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.controlador;

import java.sql.SQLException;
import java.util.List;
import proyectoupn_grupo6.modelo.Publicacion;
import proyectoupn_grupo6.servicio.PublicacionServicio;

/**
 *
 * @author PABLO TREJO
 */
public class MantenimientoPublicacionControlador {
     public List<Publicacion> listarPublicaciones() throws SQLException{  
        PublicacionServicio svc = new PublicacionServicio();     
        return svc.listarPublicacion();
        
    }
    
    public boolean actualizarPrecioPublicacion(String id, double precio) throws SQLException{
    
        PublicacionServicio svc = new PublicacionServicio();
        return svc.actualizarPublicacion(id, precio);
    
    }
}
