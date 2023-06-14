package com.example.imageodd4;

public class Imagenes {

    private int img1;
    private int img2;
    private int img3;
    private int img4;
    private int resNum;
    private String resTxt;
    private int valor;

    public Imagenes(int img1, int img2, int img3, int img4, int resNum, String resTxt,int valor) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.resNum = resNum;
        this.resTxt = resTxt;
        this.valor = valor;
    }

    public int getImg1() {
        return img1;
    }

    public void setImg1(int img1) {
        this.img1 = img1;
    }

    public int getImg2() {
        return img2;
    }

    public void setImg2(int img2) {
        this.img2 = img2;
    }

    public int getImg3() {
        return img3;
    }

    public void setImg3(int img3) {
        this.img3 = img3;
    }

    public int getImg4() {
        return img4;
    }

    public void setImg4(int img4) {
        this.img4 = img4;
    }

    public int getResNum() {
        return resNum;
    }

    public void setResNum(int resNum) {
        this.resNum = resNum;
    }

    public String getResTxt() {
        return resTxt;
    }

    public void setResTxt(String resTxt) {
        this.resTxt = resTxt;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}
