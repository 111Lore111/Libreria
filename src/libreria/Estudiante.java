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
public class Estudiante extends Usuario{
    
    private String carreraEnCurso;

    public Estudiante(String nombre, String run, char genero, String prestamo, String carrera, int periodoPrestamo, String carreraEnCurso) throws Exception {
      super(nombre,run,genero,prestamo,carrera,periodoPrestamo);
      setCarreraEnCurso(carreraEnCurso);
       
        
    }

    public String getCarreraEnCurso() {
        return carreraEnCurso;
    }

    public void setCarreraEnCurso(String carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }
    
    
}
