package libreria;

public class Docente extends Usuario {

    private String profesion;
    private String grado;

    // Se declara el constructor con los atributos de la clase Usuario (Superclase)
    public Docente(String tipo, String nombre, String run, char genero, String prestamo, String profesion,
            String grado) {
        super(tipo, nombre, run, genero, prestamo);
        this.profesion = profesion;
        this.grado = grado;
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
