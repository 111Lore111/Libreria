package libreria;

import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Libro {

    private String ISBN;
    private String titulo;
    private String autor;
    public int cantidadBiblioteca;
    public int cantidadDispPrestamo;
    private String imagen;

    public Libro(String ISBN, String titulo, String autor, int cantidadBiblioteca, int cantidadDispPrestamo,
            String imagen) {
        setISBN(ISBN);
        setTitulo(titulo);
        setAutor(autor);
        setCantidadBiblioteca(cantidadBiblioteca);
        setCantidadDispPrestamo(cantidadDispPrestamo);
        setImagen(imagen);
    }

    public Libro(String ISBN) {
        setISBN(ISBN);
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getCantidadBiblioteca() {
        return cantidadBiblioteca;
    }

    public void setCantidadBiblioteca(int cantidadBiblioteca) {
        this.cantidadBiblioteca = cantidadBiblioteca;
    }

    public int getCantidadDispPrestamo() {
        return cantidadDispPrestamo;
    }

    public void setCantidadDispPrestamo(int cantidadDispPrestamo) {
        this.cantidadDispPrestamo = cantidadDispPrestamo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    // Metodo cargarLibros homologo a cargarUsuarios
    public static ArrayList<Libro> cargaLibros(String archivoLibros) throws FileNotFoundException {

        File archivo = new File(archivoLibros);
        if (!archivo.exists()) {
            throw new IllegalArgumentException("Archivo no existente.");
        }

        ArrayList<Libro> libros = new ArrayList<>();
        Scanner sc = new Scanner(archivo);
        // El formato del archivo es
        // ISBN;TITULO;AUTOR;CANTIDADBIBLIOTECA;CANTIDADPRESTAMO;IMAGEN;
        while (sc.hasNextLine()) {
            String linea = sc.nextLine();
            String[] datos = linea.split(";");
            Libro libro = new Libro(datos[0], datos[1], datos[2], Integer.parseInt(datos[3]),
                    Integer.parseInt(datos[4]), datos[5]);
            libros.add(libro);
        }
        return libros;
    }

    // Metodo solicitarISBN
    public static String solicitarISBN() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el ISBN del libro a prestar: ");
        String ISBN = sc.nextLine();
        return ISBN;
    }

    // Metodo buscarLibro(ISBN);
    public static Libro buscarLibro(String ISBN, ArrayList<Libro> libros) {
        for (Libro libro : libros) {
            if (libro.getISBN().equals(ISBN)) {
                return libro;
            }
        }
        return null;
    }

    // Metodo para crear un libro
    public static Libro crearLibro() {
        // Se cargan los libros actuales con el metodo cargaLibros
        ArrayList<Libro> libros = new ArrayList<>();
        try {
            libros = cargaLibros("listaLibros.csv");
        } catch (FileNotFoundException e) {
            System.out.println("No se ha encontrado el archivo de libros.");
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el ISBN del libro: ");
        String ISBN = sc.nextLine();
        System.out.println("Introduzca el titulo del libro: ");
        String titulo = sc.nextLine();
        System.out.println("Introduzca el autor del libro: ");
        String autor = sc.nextLine();
        System.out.println("Introduzca la cantidad de libros en la biblioteca: ");
        int cantidadBiblioteca = sc.nextInt();
        System.out.println("Introduzca la cantidad de libros disponibles para prestamo: ");
        int cantidadDispPrestamo = sc.nextInt();
        System.out.println("Introduzca la ruta de la imagen del libro: ");
        String imagen = sc.nextLine();
        Libro libro = new Libro(ISBN, titulo, autor, cantidadBiblioteca, cantidadDispPrestamo, imagen);
        return libro;
    }

}
