package com.example.memorycards;

public class Carta {

    private int img;
    private int nImagen;


    public Carta(int img, int nImagen) {
        this.img = img;
        this.nImagen = nImagen;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getnImagen() {
        return nImagen;
    }

    public void setnImagen(int nImagen) {
        this.nImagen = nImagen;
    }
}
