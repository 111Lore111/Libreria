/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author Lorraine
 */
public class Libreria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException{
        final String archivoLibros = "listaLibros.csv";
        final String archivoUsuarios = "listaUsuarios.csv";
        
        
        ArrayList<Libro> listaLibro = cargaLibros(archivoLibros);
        ArrayList<Usuario> listaUsuario = cargaUsuarios(archivoUsuarios);
        
        //Busca si el ISBN del libro existe
        Libro buscaLibro = Prestamo.buscarLibro(358645, listaLibro);
        //Busca si el Run del usuario existe
        Usuario buscaUsuario = Prestamo.buscarUsuario("5573283-3", listaUsuario);
//        Prestamo prestamo = Prestamo.ingresarPrestamo(358645, "5573283-3", listaLibro, listaUsuario);
//        Usuario a = new Docente("hola","hola","Juanito","1-9",'P',"a","ass",1);
//        System.out.println(a.getGenero());
       
    }
    
    public static ArrayList<Libro> cargaLibros(String archivoLibros) throws FileNotFoundException {
        
        File archivo = new File(archivoLibros);   
        if (!archivo.exists()) {
            throw new IllegalArgumentException("Archivo no existente.");
        }
        
        Scanner leer = new Scanner(archivo);
//        leer.nextLine();
        ArrayList<Libro> listaLibro = new ArrayList<Libro>();
        String columnas = leer.nextLine();
        
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();
            String cortado[] = linea.split(";");
//          String acum = "";
            int ISBN = Integer.parseInt(cortado[0]);
//            String titulo = cortado[1];
//            String autor = cortado[2];
//            int cantidadBiblioteca = Integer.parseInt(cortado[3]);
//            int cantidadDisPrestamo = Integer.parseInt(cortado[4]);
//            String imagen = cortado[5];
            
//            for(int i=0; i < cortado.length; i++){
//                acum+=cortado[i]+" ";
//            }
//            System.out.println("Libros " + acum);
            
            Libro obj = new Libro(ISBN);
            listaLibro.add(obj);

        }
        leer.close();
        return listaLibro;
    }
    
    public static ArrayList<Usuario> cargaUsuarios(String archivoUsuarios) throws FileNotFoundException {
        
        File archivo = new File(archivoUsuarios);   
        if (!archivo.exists()) {
            throw new IllegalArgumentException("Archivo no existente.");
        }
        
        Scanner leer = new Scanner(archivo);
        leer.nextLine();
        ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
//        String columnas = leer.nextLine();
        
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();
            String cortado[] = linea.split(";");
//            String acum = "";
//            String tipo = cortado[0];
            String run = cortado[1];
//            String nombre = cortado[2];
//            for(int i=0; i < cortado.length; i++){
//                acum+=cortado[i]+" ";
//            }
//            System.out.println("Uusarios " + acum);
            Usuario obj = new Usuario(run) {};
            listaUsuario.add(obj);
        }
        leer.close();
        return listaUsuario;
    }
    
}
