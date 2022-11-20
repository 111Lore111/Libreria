/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import java.util.ArrayList;

/**
 *
 * @author Lorraine
 */
public class Libro {
    
    private int ISBN;
    private String titulo;
    private String autor;
    public int cantidadBiblioteca;
    public int cantidadDisPrestamo;
    private String imagen;

    public Libro(int ISBN, String titulo, String autor, int cantidadBiblioteca, int cantidadDisPrestamo, String imagen) {
        setISBN(ISBN);
        setTitulo(titulo);
        setAutor(autor);
        setCantidadBiblioteca(cantidadBiblioteca);
        setCantidadDisPrestamo(cantidadDisPrestamo);
        setImagen(imagen);
    }
    
    public Libro(int ISBN){
        setISBN(ISBN);
    }
    
    public int getISBN() {
        return ISBN;
    }

    public void setISBN(int ISBN) {
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
        return cantidadDisPrestamo;
    }

    public void setCantidadDisPrestamo(int cantidadDisPrestamo) {
        this.cantidadDisPrestamo = cantidadDisPrestamo;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
