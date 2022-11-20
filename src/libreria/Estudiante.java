package libreria;

public class Estudiante extends Usuario {
    private String carrera;

    // Se declara el constructor con los atributos de la clase Usuario (Superclase)
    public Estudiante(String tipo, String nombre, String run, char genero, String prestamo, String carrera) {
        super(tipo, nombre, run, genero, prestamo);
        this.carrera = carrera;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;

    }

}
