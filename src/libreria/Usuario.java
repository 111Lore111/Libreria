/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Lorraine
 */
public abstract class Usuario {

    private String nombre;
    private String run;
    private char genero;
    private String prestamo;
    private String tipo;
    // private int periodoPrestamo; // TODO: No pertece a la clase Usuario es de la
    // clase Prestamo
    // private String carrera; // TODO: Carrera es un atributo de Estudiante, no de

    public Usuario(String tipo, String nombre, String run, char genero, String prestamo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.run = run;
        this.genero = genero;
        this.prestamo = prestamo;
        // this.periodoPrestamo = periodoPrestamo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRun() {
        return run;
    }

    public void setRun(String run) {
        // TODO: Ese try catch no es necesario, el método setRun() no lanza ninguna
        // excepción
        if (!(ValidarRut(run))) {
            try {
                throw new Exception("rut invalido");
            } catch (Exception ex) {
                Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        this.run = run;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        try {
            if (genero == 'M' || genero == 'F') {
                this.genero = genero;
            } else {
                throw new Exception("Genero invalido");
            }
        } catch (Exception ex) {

        }
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    // public int getPeriodoPrestamo() {
    // return periodoPrestamo;
    // }

    // public void setPeriodoPrestamo(int periodoPrestamo) {
    // this.periodoPrestamo = periodoPrestamo;
    // }

    /*
     * 
     * El RUN no puede repetirse.
     * 1.2.2. Debe validar formato y dígito verificador del RUN.
     * 1.2.3. Debe validar que el género del usuario sea M o F.
     * 1.2.4. Préstamo corresponde a si el usuario tiene en su poder o no un libro,
     * siendo cero no, e ISBN que sí.
     * 1.3. Eliminar usuario, debe validar que exista.
     * 1.4. Existen usuarios que son Docentes o Estudiantes. A los docentes
     * adicionalmente se les registra la profesión con sus grados
     * (magíster y/o doctor); y a los estudiantes la carrera que está estudiando.
     */

    public boolean ValidarRut(String run) {

        boolean validacion = false;

        run = run.toUpperCase();
        run = run.replace(".", "");
        run = run.replace("-", "");
        int runAux = Integer.parseInt(run.substring(0, run.length() - 1));
        char dv = run.charAt(run.length() - 1);

        int m = 0, s = 1;

        for (; runAux != 0; runAux /= 10) {
            s = (s + runAux % 10 * (9 - m++ % 6)) % 11;

        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

        return validacion;
    }

    public boolean ValidarGenero(char genero) {
        // * 1.2.3. Debe validar que el género del usuario sea M o F.
        // Retorna true si el genero es valido sino retorna false
        return genero == 'M' || genero == 'F';
    }

    public static ArrayList<Usuario> cargaUsuarios(String archivoUsuarios) throws FileNotFoundException {

        File archivo = new File(archivoUsuarios);
        if (!archivo.exists()) {
            throw new IllegalArgumentException("Archivo no existente.");
        }

        try (Scanner leer = new Scanner(archivo)) {
            leer.nextLine();
            ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
            String columnas = leer.nextLine();

            while (leer.hasNextLine()) {
                String linea = leer.nextLine();
                String cortado[] = linea.split(";");
                String acum = "";
                String tipo = cortado[0];
                String run = cortado[1];
                String nombre = cortado[2];
                char genero = cortado[3].charAt(0);
                String prestamo = cortado[4];

                for (int i = 0; i < cortado.length; i++) {
                    acum += cortado[i] + " ";
                }
                // La estructura del archivo de usuarios es la siguiente:
                // tipo,run;nombre,genero;prestamo;carrera;profesion;grado

                if (tipo.equals("Estudiante")) {
                    String carrera = cortado[5];
                    listaUsuario.add(new Estudiante(tipo, nombre, run, genero, prestamo, carrera));
                } else if (tipo.equals("Docente")) {
                    String profesion = cortado[5];
                    String grado = cortado[6];
                    listaUsuario.add(new Docente(tipo, nombre, run, genero, prestamo, profesion, grado));
                }
                System.out.println(acum);
            }

            return listaUsuario;
        }
    }

    public static void agregarUsuario() throws FileNotFoundException {
        // Se crea una lista con los usuarios leidos desde cargaUsuarios
        ArrayList<Usuario> listaUsuarios = cargaUsuarios("listaUsuarios.csv");

        // Solicita el rut del usuario a agregar
        String run = solicitarRut();
        // Se recorre la lista para ver si el usuario ya existe
        for (Usuario usuario : listaUsuarios) {
            // Si el usuario ya existe se muestra un mensaje y se solicita el hasta que el
            // rut no exista dentro de la lista
            while (usuario.getRun().equals(run)) {
                System.out.println("El usuario ya existe");
                run = solicitarRut();
            }
        }

        // Se solicita el nombre del usuario
        String nombre = solicitarNombre();
        // Se solicita el genero del usuario
        char genero = solicitarGenero();
        // Se solicita el tipo de usuario (Docente o Estudiante)
        String tipo = solicitarTipoUsuario();
        // Si es un Docente se solicitan los atributos correspondientes para instanciar
        // un Docente
        if (tipo.equals("Docente")) {
            String profesion = solicitarProfesion();
            String grado = solicitarGrado();
            // Se instancia un Docente con los atributos ingresados
            String prestamo = "0";
            Docente docente = new Docente(tipo, nombre, run, genero, prestamo, profesion, grado);

            // Se agrega el docente a la lista de usuarios
            listaUsuarios.add(docente);
        }
        // Si es un Estudiante se solicitan los atributos correspondientes para
        // instanciar
        // un Estudiante
        else if (tipo.equals("Estudiante")) {
            String carrera = solicitarCarrera();
            // Se instancia un Estudiante con los atributos ingresados
            String prestamo = "0";
            Estudiante estudiante = new Estudiante(tipo, nombre, run, genero, prestamo, carrera);

            // Se agrega el estudiante a la lista de usuarios
            listaUsuarios.add(estudiante);
        }

        // Se imprime el nuevo usuario agregado
        System.out.println("Nuevo usuario agregado: " + listaUsuarios.get(listaUsuarios.size() - 1));

        // Se escribe el archivo con los usuarios actualizados
        escribirArchivo(listaUsuarios);

    }

    public static void escribirArchivo(ArrayList<Usuario> listaUsuarios) throws FileNotFoundException {
        // Se crea un archivo con el nombre listaUsuarios.csv
        File archivo = new File("listaUsuarios.csv");
        // Se crea un PrintWriter para escribir en el archivo
        PrintWriter escribir = new PrintWriter(archivo);
        // Se escribe la cabecera del archivo
        escribir.println("tipo;run;nombre;genero;prestamo;carrera;profesion;grado");
        // Se recorre la lista de usuarios para escribir cada usuario en el archivo
        for (Usuario usuario : listaUsuarios) {
            // Si el usuario es un Docente se escribe en el archivo los atributos
            // correspondientes
            if (usuario instanceof Docente) {
                escribir.println(usuario.getTipo() + ";" + usuario.getRun() + ";" + usuario.getNombre() + ";"
                        + usuario.getGenero() + ";" + usuario.getPrestamo() + ";" + ((Docente) usuario).getProfesion()
                        + ";"
                        + ((Docente) usuario).getGrado());
            }
            // Si el usuario es un Estudiante se escribe en el archivo los atributos
            // correspondientes
            else if (usuario instanceof Estudiante) {
                escribir.println(usuario.getTipo() + ";" + usuario.getRun() + ";" + usuario.getNombre() + ";"
                        + usuario.getGenero() + ";" + usuario.getPrestamo() + ";"
                        + ((Estudiante) usuario).getCarrera());
            }
        }
        // Se cierra el PrintWriter
        escribir.close();
    }

    // ----------- METODOS PARA SOLICITAR DATOS AL USUARIO ------------

    private String getTipo() {
        return null;
    }

    // Solicita el rut del usuario a agregar
    public static String solicitarRut() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el rut del usuario: ");
        String rut = sc.nextLine();
        while (!validarRut(rut)) {
            System.out.println("El rut ingresado no es valido, ingrese uno nuevo. El formato es 12345678-9");
            rut = sc.nextLine();
        }
        System.out.println("Rut en formato válido");
        return rut;

    }

    // * 1.2.2. Debe validar formato y dígito verificador del RUN.
    public static boolean validarRut(String rut) {
        boolean validacion = false;
        rut = rut.toUpperCase();
        rut = rut.replace(".", "");
        rut = rut.replace("-", "");
        int rutAux = Integer.parseInt(rut.substring(0, rut.length() - 1));

        char dv = rut.charAt(rut.length() - 1);

        int m = 0, s = 1;
        for (; rutAux != 0; rutAux /= 10) {
            s = (s + rutAux % 10 * (9 - m++ % 6)) % 11;
        }
        if (dv == (char) (s != 0 ? s + 47 : 75)) {
            validacion = true;
        }

        return validacion;
    }

    // Solicita el nombre del nuevo usuario no debe ser numeros ni vacio
    public static String solicitarNombre() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del usuario: ");
        String nombre = sc.nextLine();
        while (nombre.isEmpty() || nombre.matches(".*\\d.*")) {
            System.out
                    .println("El nombre ingresado no es valido, ingrese uno nuevo. El nombre no debe contener numeros");
            nombre = sc.nextLine();
        }
        return nombre;
    }

    // Solicita genero valida que el genero ingresado sea valido (M o F)
    public static char solicitarGenero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el genero del usuario (M o F): ");
        char genero = sc.nextLine().charAt(0);
        while (genero != 'M' && genero != 'F') {
            System.out.println("El genero ingresado no es valido, ingrese uno nuevo");
            genero = sc.nextLine().charAt(0);
        }
        return genero;
    }

    // Solicita Docente o Estudiante, se refiera a las clases respectivas
    public static String solicitarTipoUsuario() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el tipo de usuario (Docente o Estudiante): ");
        String tipo = sc.nextLine();
        while (!tipo.equals("Docente") && !tipo.equals("Estudiante")) {
            System.out.println("El tipo de usuario ingresado no es valido, ingrese uno nuevo");
            tipo = sc.nextLine();
        }
        return tipo;
    }

    // ****************************************************************
    // **** Métodos específicos para solicitar datos de un Docente ****
    // ****************************************************************

    // Solicita la profesion del docente, no debe estar vacio
    public static String solicitarProfesion() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la profesion del docente");
        String profesion = sc.nextLine();
        while (profesion.isEmpty()) {
            System.out.println("La profesion no puede estar vacia, ingrese nuevamente");
            profesion = sc.nextLine();
        }
        return profesion;
    }

    // Solicita el grado del docente validando que sea magister o doctor
    public static String solicitarGrado() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el grado del docente (Magister o Doctor)");
        String grado = sc.nextLine();
        while (!grado.equals("Magister") && !grado.equals("Doctor")) {
            System.out.println("Grado invalido, ingrese Magister o Doctor");
            grado = sc.nextLine();
        }
        return grado;
    }

    // ****************************************************************
    // *** Métodos específicos para solicitar datos de un Estudiante **
    // ****************************************************************

    // Solicita la carrera del estudiante, no debe estar vacio
    public static String solicitarCarrera() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese la carrera del estudiante");
        String carrera = sc.nextLine();
        while (carrera.isEmpty()) {
            System.out.println("La carrera no puede estar vacia, ingrese nuevamente");
            carrera = sc.nextLine();
        }
        return carrera;
    }

    // // Se crea metodo para imprimir los datos de una lista de usuarios
    // public static void imprimirListaUsuarios(ArrayList<Usuario> listaUsuarios) {
    // for (Usuario usuario : listaUsuarios) {
    // // Se pasa a string
    // String datosUsuario = usuario.toString();
    // // Se imprime
    // System.out.println(datosUsuario);
    // }
    // }

}