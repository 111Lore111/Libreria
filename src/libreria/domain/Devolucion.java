/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.domain;

import java.util.GregorianCalendar;

/**
 *
 * @author Lorraine
 */
public class Devolucion {
    
    private GregorianCalendar fechaDevolucion;

    public Devolucion(GregorianCalendar fechaDevolucion) {
        setFechaDevolucion(fechaDevolucion);
    }

    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
