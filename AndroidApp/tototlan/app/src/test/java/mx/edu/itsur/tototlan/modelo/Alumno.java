package mx.edu.itsur.tototlan.modelo;

public class Alumno {

    private long identificador;

    public Alumno(long identificador) {
        this.identificador = identificador;
    }

    public Alumno(){

    }

    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
}
