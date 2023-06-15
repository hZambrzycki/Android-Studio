package com.example.examen1eva;

public class Palabra {
    private int palabra;
    private int imagen;

    public Palabra(int palabra, int imagen) {
        this.palabra = palabra;
        this.imagen = imagen;
    }

    public int getPalabra() {
        return palabra;
    }

    public void setPalabra(int palabra) {
        this.palabra = palabra;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Palabra{" +
                "palabra=" + palabra +
                ", imagen=" + imagen +
                '}';
    }
}
