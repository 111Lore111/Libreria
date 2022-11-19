/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import libreria.Usuario;

/**
 *
 * @author Lorraine
 */
public class Docente extends Usuario {
    
    private String profesion;
    private String grado;

    public Docente(String profesion, String grado, String nombre, String run, char genero, String prestamo, String carrera, int periodoPrestamo) {
        super(nombre,run,genero,prestamo, carrera, periodoPrestamo);
        setProfesion(profesion);
        setGrado(grado);
    }

    public String getProfesion() {
        return profesion;
    }

    public void setProfesion(String profesion) {
        this.profesion = profesion;
    }

    public String getGrado() {
        return grado;
    }

    public void setGrado(String grado) {
        this.grado = grado;
    }
    
    
}
