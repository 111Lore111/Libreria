/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.domain;

/**
 *
 * @author Lorraine
 */
public class Usuario {
    
    private String nombre;
    private String run;
    private char genero;
    private String prestamo;
    private String carrera;
    private int periodoPrestamo;

    public Usuario(String nombre, String run, char genero, String prestamo, String carrera, int periodoPrestamo) {
        setNombre(nombre);
        setRun(run);
        setGenero(genero);
        setPrestamo(prestamo);
        setCarrera(carrera);
        setPeriodoPrestamo(periodoPrestamo);
        
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
        this.genero = genero;
    }

    public String getPrestamo() {
        return prestamo;
    }

    public void setPrestamo(String prestamo) {
        this.prestamo = prestamo;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public int getPeriodoPrestamo() {
        return periodoPrestamo;
    }

    public void setPeriodoPrestamo(int periodoPrestamo) {
        this.periodoPrestamo = periodoPrestamo;
    }
    
    
    
    
    
    
}
