/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.controlador;

import java.sql.SQLException;
import java.util.List;
import proyectoupn_grupo6.modelo.Control;
import proyectoupn_grupo6.servicio.ControlServicio;

/**
 *
 * @author PABLO TREJO
 */
public class ControlControlador {
     public List<Control> listarControl() throws SQLException{  
         ControlServicio svc = new ControlServicio();     
        return svc.listarControl();
        
    }  
     public boolean actualizar(String parametro, String valor ) throws SQLException{  
         ControlServicio svc = new ControlServicio();     
        return svc.actualizarControl(parametro, valor);
        
    }
}
