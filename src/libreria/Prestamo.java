/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


 */

package libreria;

import libreria.Libro;
import libreria.Usuario;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Scanner;

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

    // public static void crearPrestamo() {
    // // ArrayList<Usuario> usuarios = Usuario.listarUsuarios();
    // // ArrayList<Libro> libros = Libro.listarLibros();

    // // Scanner lectura = new Scanner(System.in);

    // // System.out.println("Ingrese el run del usuario: ");
    // // String run = lectura.nextLine();

    // // Usuario usuario = buscarUsuario(run, usuarios);

    // // if (usuario != null) {
    // // System.out.println("Ingrese el ISBN del libro: ");
    // // int ISBN = lectura.nextInt();

    // // Libro libro = buscarLibro(ISBN, libros);

    // // if (libro != null) {
    // // System.out.println("Ingrese el año: ");
    // // int año = lectura.nextInt();
    // // System.out.println("Ingrese el mes: ");
    // // int mes = lectura.nextInt();
    // // System.out.println("Ingrese el dia: ");
    // // int dia = lectura.nextInt();

    // // GregorianCalendar fecha = new GregorianCalendar(año, mes, dia);

    // // Prestamo prestamo = new Prestamo(fecha, usuario, libro);

    // // System.out.println("Prestamo creado con exito");
    // // } else {
    // // System.out.println("No se pudo crear el prestamo");
    // // }
    // // } else {
    // // System.out.println("No se pudo crear el prestamo");
    // // }
    // }

    public static void crearPrestamo() throws FileNotFoundException {
        Scanner lectura = new Scanner(System.in);
        // Se cargan los libros y los usuarios
        ArrayList<Libro> libros = Libro.cargaLibros("listaLibros.csv");
        ArrayList<Usuario> usuarios = Usuario.cargaUsuarios("listaUsuarios.csv");
        // Se solicita el run de un usuario invocando el metodo solicitarRun
        String run = Usuario.solicitarRut();
        // Se busca el usuario en la lista de usuarios
        Usuario usuario = Usuario.buscarUsuario(run);
        // Se solicita el ISBN de un libro invocando el metodo solicitarISBN
        // int ISBN = Libro.solicitarISBN();
    }

    // buscarLibro
    public static Libro buscarLibro(int ISBN) throws FileNotFoundException {
        // Clase Scanner para leer datos desde el teclado
        Scanner lectura = new Scanner(System.in);
        // Se carga el arraylist de libros
        ArrayList<Libro> listaLibros = Libro.cargaLibros("listaLibros.csv");

        // Se busca el libro en el arraylist
        for (int i = 0; i < listaLibros.size(); i++) {
            Libro libro = listaLibros.get(i);

            if (libro.getISBN() == ISBN) {
                System.out.println("Libro encontrado");
                return libro;
            }
        }
        System.out.println("Libro no encontrado");
        return null;

    }
}
