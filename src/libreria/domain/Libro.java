/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.domain;

/**
 *
 * @author Lorraine
 */
public class Libro {
    
    private String ISBN;
    private String titulo;
    private String autor;
    public int cantidadBiblioteca;
    public int cantidadDispPrestamo;
    private String imagen;

    public Libro(String ISBN, String titulo, String autor, int cantidadBiblioteca, int cantidadDispPrestamo, String imagen) {
        setISBN(ISBN);
        this.titulo = titulo;
        this.autor = autor;
        this.cantidadBiblioteca = cantidadBiblioteca;
        this.cantidadDispPrestamo = cantidadDispPrestamo;
        this.imagen = imagen;
    }
    
    public Libro (){ 
        
        
    
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
    
    
    
    
    
}
