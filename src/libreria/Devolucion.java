package libreria;

import java.util.GregorianCalendar;

public class Devolucion {

    private GregorianCalendar fechaDevolucion;
    private int multa;

    public Devolucion(GregorianCalendar fechaDevolucion, int multa) {
        setFechaDevolucion(fechaDevolucion);
        setMulta(multa);
    }

    public GregorianCalendar getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(GregorianCalendar fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }

    public int getMulta() {
        return multa;
    }

    public void setMulta(int multa) {
        this.multa = multa;
    }
}
