package com.example.ejbbdd_hz;

public class Pregunta {

    private int imagen;
    private int texto_pregunta;
    private int opcion1;
    private int opcion2;
    private int opcion3;
    private int resultado;


    public Pregunta(int imagen, int texto_pregunta, int opcion1, int opcion2, int opcion3, int resultado) {
        this.imagen = imagen;
        this.texto_pregunta = texto_pregunta;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.resultado = resultado;
    }



    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public int getTexto_pregunta() {
        return texto_pregunta;
    }

    public void setTexto_pregunta(int texto_pregunta) {
        this.texto_pregunta = texto_pregunta;
    }

    public int getOpcion1() {
        return opcion1;
    }

    public void setOpcion1(int opcion1) {
        this.opcion1 = opcion1;
    }

    public int getOpcion2() {
        return opcion2;
    }

    public void setOpcion2(int opcion2) {
        this.opcion2 = opcion2;
    }

    public int getOpcion3() {
        return opcion3;
    }

    public void setOpcion3(int opcion3) {
        this.opcion3 = opcion3;
    }

    public int getResultado() {
        return resultado;
    }

    public void setResultado(int resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Pregunta{" +
                "imagen=" + imagen +
                ", texto_pregunta=" + texto_pregunta +
                ", opcion1=" + opcion1 +
                ", opcion2=" + opcion2 +
                ", opcion3=" + opcion3 +
                ", resultado=" + resultado +
                '}';
    }
}
