package com.example.examen;

public class Grupo {
    private int imagen;
    private int opcion1, opcion2, opcion3;
    private int opcionCorrecta;

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
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

    public int getOpcionCorrecta() {
        return opcionCorrecta;
    }

    public void setOpcionCorrecta(int opcionCorrecta) {
        this.opcionCorrecta = opcionCorrecta;
    }

    public Grupo(int imagen, int opcion1, int opcion2, int opcion3, int opcionCorrecta) {
        this.imagen = imagen;
        this.opcion1 = opcion1;
        this.opcion2 = opcion2;
        this.opcion3 = opcion3;
        this.opcionCorrecta = opcionCorrecta;
    }
}
