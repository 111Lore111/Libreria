/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
        ArrayList<Libro> listaLibro = cargaLibros(archivoLibros);
        
//        Usuario a = new Docente("hola","hola","Juanito","1-9",'P',"a","ass",1);
//        System.out.println(a.getGenero());
       
    }
    
    public static ArrayList<Libro> cargaLibros(String archivoLibros) throws FileNotFoundException {
        
        File archivo = new File(archivoLibros);
//        ArrayList<Libro> listaLibro = new ArrayList<Libro>();       
        if (!archivo.exists()) {
            throw new IllegalArgumentException("Archivo no existente.");
        }
        
        Scanner leer = new Scanner(archivo);
        leer.nextLine();
        ArrayList<Libro> listaLibro = new ArrayList<Libro>();
        String columnas = leer.nextLine();
        
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();
            String cortado[] = linea.split(";");
            String acum = "";
            int ISBN = Integer.parseInt(cortado[0]);
            String titulo = cortado[1];
            String autor = cortado[2];
            int cantidadBiblioteca = Integer.parseInt(cortado[3]);
            int cantidadDisPrestamo = Integer.parseInt(cortado[4]);
            String imagen = cortado[5];
            
            for(int i=0; i < cortado.length; i++){
                acum+=cortado[i]+" ";
            }
            System.out.println("Prueba " + acum);
        }
        return listaLibro;
    }
    
}
