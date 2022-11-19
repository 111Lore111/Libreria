/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package libreria;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;


/**
 *
 * @author Lorraine
 */
public abstract class Usuario {
    
    private String nombre;
    private String run;
    private char genero;
    private String prestamo;
    private String carrera;
    private int periodoPrestamo;
    
    
    public Usuario(){
    }

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
        
        if(!(ValidarRut(run))){
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

    public void setGenero(char genero){
           if(!(ValidarGenero(genero))){
               try {
                   throw new Exception( "valor invalido favor ingresar 'M' o 'F'");
               } catch (Exception ex) {
                   Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
               }
        }
        
        
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
    
    /*
        
        El RUN no puede repetirse.
1.2.2. Debe validar formato y dígito verificador del RUN.
1.2.3. Debe validar que el género del usuario sea M o F.
1.2.4. Préstamo corresponde a si el usuario tiene en su poder o no un libro, siendo cero no, e ISBN que sí.
1.3. Eliminar usuario, debe validar que exista.
1.4. Existen usuarios que son Docentes o Estudiantes. A los docentes adicionalmente se les registra la profesión con sus grados
(magíster y/o doctor); y a los estudiantes la carrera que está estudiando.
        */

    
    public boolean ValidarRut (String run){
        
        boolean validacion = false;
       
            run = run.toUpperCase();
            run = run.replace(".", "");
            run = run.replace("-","");
            int runAux = Integer.parseInt(run.substring(0, run.length()- 1));
            char dv = run.charAt(run.length() - 1);
            
            int m=0, s=1;
            
            for(;runAux != 0; runAux /= 10)
            {
                s = (s + runAux % 10 *(9 - m++ % 6))%11;
                
        }
            if (dv == (char)(s != 0 ? s + 47 : 75)){
                validacion = true;
            }
  
        return validacion;
    }


    
    public boolean ValidarGenero(char genero){
        
       return(genero =='M' || genero == 'm' || genero  =='F' || genero == 'f');
        
    }
      
}

