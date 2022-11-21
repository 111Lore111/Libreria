package libreria;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class Usuario {

    private String nombre;
    private String run;
    private char genero;
    private String prestamo;
    private String tipo;

    public Usuario(String tipo, String nombre, String run, char genero, String prestamo) {
        this.tipo = tipo;
        this.nombre = nombre;
        this.run = run;
        this.genero = genero;
        this.prestamo = prestamo;
        // this.periodoPrestamo = periodoPrestamo;
    }

    // ---- GETTERS Y SETTERS ----
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
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

    // ---- METODOS CRUD ----

    public static void crearUsuario() throws FileNotFoundException {
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

        System.out.println("Nuevo usuario agregado!!");

        // Se escribe el archivo con los usuarios actualizados
        guardarUsuariosEnArchivo(listaUsuarios);

    }

    public static void eliminarUsuario() throws FileNotFoundException {
        // Se crea una lista con los usuarios leidos desde cargaUsuarios
        ArrayList<Usuario> listaUsuarios = cargaUsuarios("listaUsuarios.csv");

        // Se solicita el rut del usuario a eliminar
        String run = solicitarRut();
        // Se recorre la lista para ver si el usuario existe
        for (Usuario usuario : listaUsuarios) {
            // Si el usuario existe se elimina de la lista
            if (usuario.getRun().equals(run)) {
                listaUsuarios.remove(usuario);
                System.out.println("Usuario eliminado");
                break;
            }
        }

        // Se escribe el archivo con los usuarios actualizados
        guardarUsuariosEnArchivo(listaUsuarios);
    }

    public static void editarUsuario() throws FileNotFoundException {
        // Se crea una lista con los usuarios leidos desde cargaUsuarios
        ArrayList<Usuario> listaUsuarios = cargaUsuarios("listaUsuarios.csv");

        // Se solicita el rut del usuario a modificar
        String run = solicitarRut();
        // Se recorre la lista para ver si el usuario existe
        for (Usuario usuario : listaUsuarios) {
            // Si el usuario existe se modifica
            if (usuario.getRun().equals(run)) {
                // Se solicita el nombre del usuario
                String nombre = solicitarNombre();
                // Se solicita el genero del usuario
                char genero = solicitarGenero();
                // Se solicita el tipo de usuario (Docente o Estudiante)
                String tipo = solicitarTipoUsuario();
                // Si es un Docente se solicitan los atributos correspondientes
                if (tipo.equals("Docente")) {
                    String profesion = solicitarProfesion();
                    String grado = solicitarGrado();

                    // Se mantiene el prestamo del usuario
                    String prestamo = usuario.getPrestamo();
                    Docente docente = new Docente(tipo, nombre, run, genero, prestamo, profesion, grado);

                    // Se agrega el docente a la lista de usuarios
                    listaUsuarios.set(listaUsuarios.indexOf(usuario), docente);
                }
                // Si es un Estudiante se solicitan los atributos correspondientes
                else if (tipo.equals("Estudiante")) {
                    String carrera = solicitarCarrera();

                    // Se mantiene el prestamo del usuario
                    String prestamo = usuario.getPrestamo();
                    Estudiante estudiante = new Estudiante(tipo, nombre, run, genero, prestamo, carrera);

                    // Se agrega el estudiante a la lista de usuarios
                    listaUsuarios.set(listaUsuarios.indexOf(usuario), estudiante);
                }

                // Se imprime el usuario modificado
                System.out.println("Usuario modificado correctamente");
                break;
            }
        }

        // Se escribe el archivo con los usuarios actualizados
        guardarUsuariosEnArchivo(listaUsuarios);
    }

    public static void listarUsuarios() throws FileNotFoundException {
        // Se crea una lista con los usuarios leidos desde cargaUsuarios
        ArrayList<Usuario> listUsuarios = cargaUsuarios("listaUsuarios.csv");

        System.out.println(
                "---------------------------------------- LISTA DE USUARIOS ----------------------------------------");
        // Se imprimen los encabezados de la tabla
        System.out.println("Tipo\t\tNombre\t\tRut\t\tGenero\t\tPrestamo\tProf/Carrera\tGrado");
        // Se recorre la lista de usuarios y se imprimen en terminal
        for (Usuario usuario : listUsuarios) {
            String strUsuario = usuario.getTipo() + " \t"
                    + usuario.getNombre() + " \t"
                    + usuario.getRun() + " \t"
                    + usuario.getGenero() + " \t\t"
                    + usuario.getPrestamo();

            if (usuario.getTipo().equals("Docente")) {
                strUsuario += " \t\t" + ((Docente) usuario).getProfesion() + " \t"
                        + ((Docente) usuario).getGrado();
            } else if (usuario.getTipo().equals("Estudiante")) {
                strUsuario += " \t\t" + ((Estudiante) usuario).getCarrera();
            }
            System.out.println(strUsuario);
        }
        System.out.println(
                "xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    public static Usuario buscarUsuario(String run, ArrayList<Usuario> listaUsuarios) {
        // Se recorre la lista de usuarios para ver si el usuario existe
        for (Usuario usuario : listaUsuarios) {
            // Si el usuario existe se retorna
            if (usuario.getRun().equals(run)) {
                return usuario;
            }
        }
        return null;
    }

    // ---- METODOS AUXILIARES MANEJO DE ARCHIVOS ----

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
                // System.out.println(acum);
            }

            return listaUsuario;
        }
    }

    public static void guardarUsuariosEnArchivo(ArrayList<Usuario> listaUsuarios) throws FileNotFoundException {
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

    // ****************************************************************
    // ---- METODOS PARA SOLICITAR DATOS AL USUARIO CON VALIDADORES ---
    // ****************************************************************

    // Solicita el rut del usuario a agregar
    public static String solicitarRut() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el rut del usuario: ");
        String rut = sc.nextLine();
        while (!validarRut(rut)) {
            System.out.println("El rut ingresado no es valido, ingrese uno nuevo   :");
            rut = sc.nextLine();
        }
        // System.out.println("Rut en formato válido");
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

}