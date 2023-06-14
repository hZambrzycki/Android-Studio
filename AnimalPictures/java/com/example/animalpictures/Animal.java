package com.example.animalpictures;

public class Animal {

    int img1,img2,img3,img4,mensajeAcertado,valor;

    public Animal(int img1, int img2, int img3, int img4, int mensajeAcertado ,int valor) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.mensajeAcertado = mensajeAcertado;
        this.valor=valor;
    }
    public int getValor() {
        return valor;
    }
    public int getImg1() {
        return img1;
    }
    public int getImg2() {
        return img2;
    }
    public int getImg3() {
        return img3;
    }
    public int getImg4() {
        return img4;
    }
    public int getMensajeAcertado() {
        return mensajeAcertado;
    }
}
