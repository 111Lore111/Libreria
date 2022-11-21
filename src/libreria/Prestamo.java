/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template


 */

package libreria;

import libreria.Libro;
import libreria.Usuario;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
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
    private Devolucion devolucion;

    public Prestamo(GregorianCalendar fecha, Usuario usuario, Libro libro, Devolucion devolucion) {
        setFecha(fecha);
        setUsuario(usuario);
        setLibro(libro);
        setDevolucion(devolucion);
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

    public Devolucion getDevolucion() {
        return devolucion;
    }

    public void setDevolucion(Devolucion devolucion) {
        this.devolucion = devolucion;
    }

    public static Libro buscarLibro(String ISBN, ArrayList<Libro> libros) {

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

    // -------- METODOS PRINCIPIALES --------
    // Crear prestamo
    public static void crearPrestamo() throws FileNotFoundException {
        Scanner lectura = new Scanner(System.in);
        // Se cargan los libros y los usuarios
        ArrayList<Libro> libros = Libro.cargaLibros("listaLibros.csv");
        ArrayList<Usuario> usuarios = Usuario.cargaUsuarios("listaUsuarios.csv");
        // Se solicita el run de un usuario invocando el metodo solicitarRun
        String run = Usuario.solicitarRut();
        // Se busca el usuario en la lista de usuarios
        Usuario usuario = Usuario.buscarUsuario(run, usuarios);

        // Se valida que el usuario tenga prestamo == 0
        if (usuario.getPrestamo() == "0") {
            // Se solicita el ISBN del libro
            System.out.println("Ingrese el ISBN del libro: ");
            String ISBN = lectura.nextLine();
            // Se busca el libro en la lista de libros
            Libro libro = Libro.buscarLibro(ISBN, libros);
            // Se valida que el libro no sea null
            if (libro != null) {
                // Se valida que el libro tenga cantidadDispPrestamo > 0
                if (libro.getCantidadDispPrestamo() > 0) {
                    // Se solicita el numero de días de prestamo
                    System.out.println("Ingrese el numero de dias de prestamo: ");
                    int dias = lectura.nextInt();
                    // Se crea un objeto de tipo GregorianCalendar con la fecha actual
                    GregorianCalendar fecha = new GregorianCalendar();
                    // Se define fecha de devolucion como fecha actual + dias de prestamo
                    fecha.add(GregorianCalendar.DAY_OF_MONTH, dias);
                    // Se actualiza el prestamo del usuario
                    usuario.setPrestamo(ISBN);
                    // Se crea un objeto de tipo Prestamo
                    Prestamo prestamo = new Prestamo(fecha, usuario, libro, null);
                    // Se actualiza la cantidad de prestamos disponibles del libro
                    libro.setCantidadDispPrestamo(libro.getCantidadDispPrestamo() - 1);

                    // Se guarda un archivo prestamos.csv con los datos del prestamo
                    guardarPrestamoEnArchivo(prestamo);

                    // Se muestra mensaje de prestamo creado
                    System.out.println("Prestamo creado con exito");
                } else {
                    // Se muestra mensaje de libro prestado
                    System.out.println("El libro ya esta prestado");
                }
            } else {
                // Se muestra mensaje de libro no encontrado
                System.out.println("Libro no encontrado");
            }
        } else {
            // Se muestra mensaje de usuario con prestamo
            System.out.println("El usuario ya tiene un prestamo");
        }

    }

    // Crear devolucion
    public static void crearDevolucion() throws FileNotFoundException {
        Scanner lectura = new Scanner(System.in);
        // Se cargan los libros y los usuarios
        ArrayList<Libro> libros = Libro.cargaLibros("listaLibros.csv");
        ArrayList<Usuario> usuarios = Usuario.cargaUsuarios("listaUsuarios.csv");
        ArrayList<Prestamo> prestamos = Prestamo.cargaPrestamos();
        // Se solicita el run de un usuario invocando el metodo solicitarRun
        String run = Usuario.solicitarRut();
        // Se busca si el run de usuario en la lista de prestamos
        Prestamo prestamo = Prestamo.buscarPrestamoPendiente(run, prestamos);

        // Se valida que el prestamo no sea null
        if (prestamo != null) {
            // Se crea un objeto de tipo GregorianCalendar con la fecha actual
            GregorianCalendar fecha = new GregorianCalendar();

            // Se comparan la fecha actual con la fecha de prestamo para calcular los dias
            // de atraso
            int diasAtraso = fecha.compareTo(prestamo.getFecha());
            if (diasAtraso < 0) {
                diasAtraso = 0;
            }
            // Se calcula la multa
            int multa = diasAtraso * 1000;
            // Se crea un objeto de tipo Devolucion
            Devolucion devolucion = new Devolucion(fecha, multa);
            // Se actualiza el prestamo del usuario
            prestamo.getUsuario().setPrestamo("0");
            // Se actualiza la cantidad de prestamos disponibles del libro
            prestamo.getLibro().setCantidadDispPrestamo(prestamo.getLibro().getCantidadDispPrestamo() + 1);

            // Se guarda un archivo devoluciones.csv con los datos de la devolucion
            // guardarDevolucion(devolucion); // TODO: Crear metodo guardarDevolucion

            // Se muestra mensaje de devolucion creada
            System.out.println("Devolucion creada con exito");
        } else {
            // Se muestra mensaje de prestamo no encontrado
            System.out.println("No tiene prestamos pendientes");
        }

    }

    // Guardar prestamo en archivo
    public static void guardarPrestamoEnArchivo(Prestamo prestamo) throws FileNotFoundException {
        // Se crea un objeto de tipo File con el nombre del archivo
        File archivo = new File("prestamos.csv");
        // Se crea un objeto de tipo PrintWriter para escribir en el archivo
        PrintWriter escritor = new PrintWriter(archivo);
        // Se escribe en el archivo en formato CSV
        escritor.println(prestamo.getFecha().get(GregorianCalendar.DAY_OF_MONTH) + "/"
                + prestamo.getFecha().get(GregorianCalendar.MONTH) + "/"
                + prestamo.getFecha().get(GregorianCalendar.YEAR) + ";" + prestamo.getUsuario().getRun() + ";"
                + prestamo.getLibro().getISBN() + ";" + prestamo.getDevolucion());
        escritor.close();
    }

    // Buscar prestamo por run
    public static Prestamo buscarPrestamoPendiente(String run, ArrayList<Prestamo> prestamos) {
        // Se recorre el array de prestamos y se busca el prestamo con el run que no
        // tenga devolucion
        for (Prestamo prestamo : prestamos) {
            if (prestamo.getUsuario().getRun().equals(run) && prestamo.getDevolucion() == null) {
                return prestamo;
            }
        }
        return null;
    }

    // cargaPrestamos
    public static ArrayList<Prestamo> cargaPrestamos() throws FileNotFoundException {
        // Se crea un array de prestamos
        ArrayList<Prestamo> prestamos = new ArrayList<Prestamo>();
        // Se crea un objeto de tipo File con el archivo prestamos.csv
        File archivo = new File("prestamos.csv");
        // Se valida que el archivo exista
        if (archivo.exists()) {
            // Se crea un objeto de tipo Scanner para leer el archivo prestamos.csv
            Scanner lectura = new Scanner(archivo);
            // Se recorre el archivo prestamos.csv
            // El archivo tiene el siguiente formato:fecha;usuario;libro;devolucion
            while (lectura.hasNextLine()) {
                String linea = lectura.nextLine();
                String cortado[] = linea.split(";");
                String acum = "";
                // Se parsea cortado[0] a un objeto de tipo GregorianCalendar
                GregorianCalendar fecha = new GregorianCalendar();
                String fechaCortada[] = cortado[0].split("/");
                fecha.set(Integer.parseInt(fechaCortada[2]), Integer.parseInt(fechaCortada[1]),
                        Integer.parseInt(fechaCortada[0]));

                Usuario usuario = null;
                // Usuario usuario = new Usuario(cortado[1]);
                // Se crea un objeto de tipo Libro con el codigo cortado[2]
                Libro libro = new Libro(cortado[2]);
                // Se crea un objeto de tipo Devolucion con el run cortado[3]
                Devolucion devolucion = null;
                if (!cortado[3].equals("null")) {
                    // devolucion = new Devolucion(cortado[3]);
                }
                // Se crea un objeto de tipo Prestamo con los datos anteriores
                Prestamo prestamo = new Prestamo(fecha, usuario, libro, devolucion);

                // Se agrega el prestamo al array de prestamos
                prestamos.add(prestamo);
            }
            // Se retorna el array de prestamos
            return prestamos;
        }
        return prestamos;
    }
}
