/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria.domain;

/**
 *
 * @author Lorraine
 */
public class Estudiante {
    
    private String carreraEnCurso;

    public Estudiante(String carreraEnCurso) {
        setCarreraEnCurso(carreraEnCurso);
    }

    public String getCarreraEnCurso() {
        return carreraEnCurso;
    }

    public void setCarreraEnCurso(String carreraEnCurso) {
        this.carreraEnCurso = carreraEnCurso;
    }
    
    
}
