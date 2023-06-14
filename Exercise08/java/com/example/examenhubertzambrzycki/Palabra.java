package com.example.examenhubertzambrzycki;

public class Palabra {

    private int palabra;
    private int imagen;

    public int getImagen() {
        return imagen;
    }

    public int getPalabra() {
        return palabra;
    }

    public void setPalabra(int palabra) {
        this.palabra = palabra;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Palabra(int palabra, int imagen) {
        this.palabra = palabra;
        this.imagen = imagen;
    }


}
