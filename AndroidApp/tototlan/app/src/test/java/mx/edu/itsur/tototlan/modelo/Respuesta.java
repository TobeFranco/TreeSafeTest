package mx.edu.itsur.tototlan.modelo;

public class Respuesta {

    private long identificador;

    public Respuesta(long identificador) {
        this.identificador = identificador;
    }

    public Respuesta(){

    }


    public long getIdentificador() {
        return identificador;
    }

    public void setIdentificador(long identificador) {
        this.identificador = identificador;
    }
}
