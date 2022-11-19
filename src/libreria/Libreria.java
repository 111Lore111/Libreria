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
        
        Usuario a = new Docente("hola","hola","Juanito","1-9",'P',"a","ass",1);
        System.out.println(a.getGenero());
       
    }
    
    public static ArrayList<Libro> cargaLibros(String nombreArchivo) throws FileNotFoundException {
        File archivo = new File(nombreArchivo);
        
        if (!archivo.exists()) {
            throw new IllegalArgumentException("Archivo no existente.");
        }
        
        Scanner leer = new Scanner(archivo);
        ArrayList<Libro> listaLibro = new ArrayList<Libro>();
        String columnas = leer.nextLine();
        
        while (leer.hasNextLine()) {
            String linea = leer.nextLine();
            String cortado[] = linea.split(";");
            int ISBN = Integer.parseInt(cortado[0]);

            Libro obj = new Libro(ISBN);
            listaLibro.add(obj);
        }
        leer.close();
        return listaLibro;
    }
    
}
