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

    public Prestamo(GregorianCalendar fecha, Usuario usuario, Libro libro) {
        setFecha(fecha);
        setUsuario(usuario);
        setLibro(libro);
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }

    public GregorianCalendar getFecha() {
        return fecha;
    }

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

    public static Libro buscarLibro(int ISBN, ArrayList<Libro> libros) {

        for (int i = 0; i < libros.size(); i++) {
            Libro libro = libros.get(i);

            if (libro.getISBN() == ISBN) {
                System.out.println("Libro encontrado");
                return libro;
            }
        }
        System.out.println("Libro no encontrado");
        return null;
    }

    // Pasas el rut y te retorna el usuario en caso de no encontrarlo retorna null
    public static Usuario buscarUsuario(String run, ArrayList<Usuario> usuarios) {

        for (int i = 0; i < usuarios.size(); i++) {
            Usuario usuario = usuarios.get(i);
            if (usuario.getRun().equals(run)) {
                System.out.println("Run encontrado");
                return usuario;
            }
        }
        System.out.println("Run no encontrado");
        return null;
    }
}
