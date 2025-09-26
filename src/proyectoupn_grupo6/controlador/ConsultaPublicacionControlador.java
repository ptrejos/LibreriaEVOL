/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.controlador;

import java.sql.SQLException;
import java.util.List;
import proyectoupn_grupo6.modelo.Publicacion;
import proyectoupn_grupo6.modelo.Tipo;
import proyectoupn_grupo6.servicio.PublicacionServicio;
import proyectoupn_grupo6.servicio.TipoServicio;

/**
 *
 * @author PABLO TREJO
 */
public class ConsultaPublicacionControlador {
    public List<Tipo> listarTipos() throws SQLException{
        // Crea una instancia del servicio de tipos llamado 'svc'.
        TipoServicio svc = new TipoServicio();
        // Llama al método 'listarTipoDto()' del servicio para obtener una lista de tipos.
        return svc.listarTipoDto();  
    }
    
    public List<Publicacion> listarPublicacionPorTipo(String idTipo , String idPublicacion) throws SQLException{  
         // Crea una instancia del servicio de publicaciones llamado 'svc'.
        PublicacionServicio svc = new PublicacionServicio();   
        // Llama al método 'listarPublicacionesPorTipo(idTipo, idPublicacion)' del servicio
    // para obtener una lista de publicaciones filtradas por tipo y publicación.
        return svc.listarPublicacionesPorTipo(idTipo, idPublicacion);
        
    }
}
