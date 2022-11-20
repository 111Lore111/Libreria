/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


 */

package libreria;

import libreria.Libro;
import libreria.Usuario;
import java.util.ArrayList;
import java.util.GregorianCalendar;

/**
 *
 * @author Lorraine
 */
public class Prestamo {

    private GregorianCalendar fecha;
    private Usuario usuario;
    private Libro libro;
    // private Devolucion devolucion;

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @return the libro
     */
    public Libro getLibro() {
        return libro;
    }

    /**
     * @param libro the libro to set
     */
    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    /**
     * @return the fecha
     */
    public GregorianCalendar getFecha() {
        return fecha;
    }

    /**
     * @param fecha the fecha to set
     */
    public void setFecha(GregorianCalendar fecha) {
        this.fecha = fecha;
    }

    /**
     * 
     * 
     * public Devolucion getDevolucion() {
     * return devolucion;
     * }
     * 
     * 
     * public void setDevolucion(Devolucion devolucion) {
     * this.devolucion = devolucion;
     * }
     * 
     */

}
