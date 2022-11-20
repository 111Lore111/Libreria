/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package libreria;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Menu {

    public static void main(String[] args) throws FileNotFoundException {

        try (Scanner lectura = new Scanner(System.in)) {
            int opcion = 1; // Opción del Menú

            do {
                System.out.println("--- SISTEMA DE BIBLIOTECA ---");
                System.out.println("1. Listar Usuarios");
                System.out.println("2. Crear Usuario");
                System.out.println("3. Editar Usuario");
                System.out.println("4. Eliminar de Usuario");
                System.out.println("5. Listar Libros");
                System.out.println("6. Crear Libro");
                System.out.println("7. Eliminar de Libro");
                System.out.println("8. Crear prestamo");
                System.out.println("9. Crear devolucion");
                System.out.println("0. Salir");
                System.out.println("Ingrese opción: ");

                opcion = lectura.nextInt();

                if (opcion < 0 || opcion > 6) {
                    System.out.println("Opción inválida intente nuevamente");
                } else {
                    switch (opcion) {
                        case 1:
                            System.out.println("");
                            System.out.println("");
                            System.out.println("---------- LISTA DE USUARIOS ----------");
                            Usuario.cargaUsuarios("listaUsuarios.csv");
                            // Se carga la lista de usuarios y se imprime en pantalla utilizando el método
                            // imprimirListaUsuarios
                            // ArrayList<Usuario> listaUsuarios =
                            // Usuario.cargaUsuarios("listaUsuarios.csv");
                            // Usuario.imprimirListaUsuarios(listaUsuarios);
                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 2:
                            System.out.println("");
                            System.out.println("");
                            System.out.println("---------- CREAR USUARIO ----------");
                            // Se utiliza agregarUsuario de clase Usuario
                            Usuario.agregarUsuario();
                            break;
                        case 3:
                            System.out.println("---------- EDITAR USUARIO ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 4:
                            System.out.println("---------- ELIMINAR USUARIO ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 5:
                            System.out.println("---------- LISTAR LIBROS ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 6:
                            System.out.println("---------- CREAR LIBRO ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 7:
                            System.out.println("---------- ELIMINAR LIBRO ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 8:
                            System.out.println("---------- CREAR PRESTAMO ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;
                        case 9:
                            System.out.println("---------- CREAR DEVOLUCION ----------");

                            System.out.println("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
                            System.out.println("");
                            System.out.println("");
                            break;

                        case 0:
                            System.out.println("Adiós!");
                            System.out.println("-------------------------------");
                            break;
                    }
                }
            } while (opcion != 0);
        }
    }

}
