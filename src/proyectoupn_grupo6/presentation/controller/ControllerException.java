/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyectoupn_grupo6.presentation.controller;

/**
 *
 * @author PABLO TREJO
 */
public class ControllerException extends RuntimeException {
    /**
     * Constructor con mensaje
     * @param message Mensaje de error
     */
    public ControllerException(String message) {
        super(message);
    }
    
    /**
     * Constructor con mensaje y causa
     * @param message Mensaje de error
     * @param cause Causa original del error
     */
    public ControllerException(String message, Throwable cause) {
        super(message, cause);
    }
}
