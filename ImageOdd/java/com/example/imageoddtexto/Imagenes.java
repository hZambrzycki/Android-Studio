package com.example.imageoddtexto;

public class Imagenes {
    private int img1, img2,img3,img4;
    private int resNum;
    private String resTxT;


    public Imagenes(int img1, int img2, int img3, int img4, int resNum, String resTxT) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.img4 = img4;
        this.resNum = resNum;
        this.resTxT = resTxT;
    }

    public String getResTxT() {
        return resTxT;
    }

    public void setResTxT(String resTxT) {
        this.resTxT = resTxT;
    }

    public int getResNum() {
        return resNum;
    }

    public void setResNum(int resNum) {
        this.resNum = resNum;
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
}
