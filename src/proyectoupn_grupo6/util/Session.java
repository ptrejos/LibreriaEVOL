/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.util;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author PABLO TREJO
 */
public class Session {
    // Un campo privado y estático para almacena los datos de la sesión.
    private static Map<String, Object> datos;
// bloque estático de inicialización que se ejecuta cuando la clase se carga.
	static {
            // Se crea una nueva instancia de HashMap y se asigna a la variable 'datos'.
		datos = new HashMap<>();
	}
 // Un constructor privado, lo que significa que no se pueden crear instancias de la clase desde fuera.
	private Session() {
	}
        
// Método estático 'put' para agregar datos a la sesión.
	public static void put(String key, Object object) {
		datos.put(key, object);
	}
   // Método estático 'get' para obtener datos de la sesión.
	public static Object get(String key) {
		return datos.get(key);
	}
}
