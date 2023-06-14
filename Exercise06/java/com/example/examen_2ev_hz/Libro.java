package com.example.examen_2ev_hz;

public class Libro {
    int id;
    String nombre;
    String autor;

    @Override
    public String toString() {
        return "El Libro seleccionado tiene los siguientes datos: " + "\n" +
                "Su identificador = " + id + "\n" +
                "Su titulo = " + nombre + "\n" +
                "Su autor/a= " + autor + "\n" ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Libro(int id, String nombre, String autor) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
    }
}
