/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.controlador;

import proyectoupn_grupo6.modelo.Usuario;
import proyectoupn_grupo6.servicio.UsuarioServicio;
import proyectoupn_grupo6.util.Session;

/**
 *
 * @author PABLO TREJO
 */
public class LoginControlador {
      public void validarUsuario(String usuario, String clave) {
        UsuarioServicio service = new UsuarioServicio();
        Usuario dto = service.validarUsuario(usuario, clave);
        Session.put("USUARIO", dto);
       
    }
}
