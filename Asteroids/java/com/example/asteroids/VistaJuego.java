package com.example.asteroids;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.canvas.CanvasCompat;

import java.util.ArrayList;
import java.util.Vector;

/**
 * TODO: document your custom view class.
 */

public class VistaJuego extends View {
    private Drawable nave;

    private Drawable misil;
    private Drawable misil1;
    private Drawable misil2;
    private Drawable misil3;

    ArrayList<Drawable> misiles = new ArrayList<>(4);
    private Drawable asteroide;
    private Drawable asteroide_1;
    private Drawable asteroide_2;
    private Drawable asteroide_3;
    private Drawable asteroide_4;

    private int X_POSICION_NAVE;
    private int Y_POSICION_NAVE;

    private int VELOCIDAD_NAVE = 10;

    private int VELOCIDAD_MISIL = 30;

    private int X_POSICION_MISIL;
    private int Y_POSICION_MISIL;

    private int X_POSICION_MISIL_1;
    private int Y_POSICION_MISIL_1;

    private int X_POSICION_MISIL_2;
    private int Y_POSICION_MISIL_2;

    private int X_POSICION_MISIL_3;
    private int Y_POSICION_MISIL_3;

    private int X_POSICION_ASTEROIDE;
    private int Y_POSICION_ASTEROIDE;

    private int X_POSICION_ASTEROIDE_1;
    private int Y_POSICION_ASTEROIDE_1;

    private int X_POSICION_ASTEROIDE_2;
    private int Y_POSICION_ASTEROIDE_2;

    private int X_POSICION_ASTEROIDE_3;
    private int Y_POSICION_ASTEROIDE_3;

    private int X_POSICION_ASTEROIDE_4;
    private int Y_POSICION_ASTEROIDE_4;

    private int X_VELOCIDAD_ASTEROIDE = 8;
    private int Y_VELOCIDAD_ASTEROIDE = 8;

    private boolean lanzado = false;

    private ThreadJuego threadJuego;

    private boolean asteroideDestruido = false;
    private boolean asteroide1Destruido = false;
    private boolean asteroide2Destruido = false;
    private boolean asteroide3Destruido = false;
    private boolean asteroide4Destruido = false;

    private boolean naveDestruida = false;

    public VistaJuego(Context context) {
        super(context);
        init(null, 0);
    }
    public VistaJuego(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }
    public VistaJuego(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }
    private void init(AttributeSet attrs, int defStyle) {
        nave = getResources().getDrawable(R.drawable.nave);
        misil = getResources().getDrawable(R.drawable.misil1);
        misil1 = getResources().getDrawable(R.drawable.misil1);
        misil2 = getResources().getDrawable(R.drawable.misil1);
        misil3 = getResources().getDrawable(R.drawable.misil1);
        asteroide = getResources().getDrawable(R.drawable.asteroide);
        asteroide_1 = getResources().getDrawable(R.drawable.asteroide);
        asteroide_2 = getResources().getDrawable(R.drawable.asteroide);
        asteroide_3 = getResources().getDrawable(R.drawable.asteroide);
        asteroide_4 = getResources().getDrawable(R.drawable.asteroide);
        misiles.add(misil);
        misiles.add(misil1);
        misiles.add(misil2);
        misiles.add(misil3);
        threadJuego = new ThreadJuego();
    }
@Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
       X_POSICION_NAVE = 0;
       Y_POSICION_NAVE = h/2 ;

       X_POSICION_MISIL = X_POSICION_NAVE;
       Y_POSICION_MISIL = Y_POSICION_NAVE;

    X_POSICION_MISIL_1 = X_POSICION_NAVE+1;
    Y_POSICION_MISIL_1 = Y_POSICION_NAVE+1;

    X_POSICION_MISIL_2 = X_POSICION_NAVE+2;
    Y_POSICION_MISIL_2 = Y_POSICION_NAVE+2;

    X_POSICION_MISIL_3 = X_POSICION_NAVE+3;
    Y_POSICION_MISIL_3 = Y_POSICION_NAVE+3;

    X_POSICION_ASTEROIDE = (int) (Math.random() * (w - getWidth() / 2)) + getWidth() / 2;
    Y_POSICION_ASTEROIDE = (int) (Math.random() * (h - 0)) + 0;

    X_POSICION_ASTEROIDE_1 = (int) (Math.random() * (w - getWidth() / 2)) + getWidth() / 2;
    Y_POSICION_ASTEROIDE_1 = (int) (Math.random() * (h - 0)) + 0;

    X_POSICION_ASTEROIDE_2 = (int) (Math.random() * (w - getWidth() / 2)) + getWidth() / 2;
    Y_POSICION_ASTEROIDE_2 = (int) (Math.random() * (h - 0)) + 0;

    X_POSICION_ASTEROIDE_3 = (int) (Math.random() * (w - getWidth() / 2)) + getWidth() / 2;
    Y_POSICION_ASTEROIDE_3 = (int) (Math.random() * (h - 0)) + 0;

    X_POSICION_ASTEROIDE_4 = (int) (Math.random() * (w - getWidth() / 2)) + getWidth() / 2;
    Y_POSICION_ASTEROIDE_4 = (int) (Math.random() * (h - 0)) + 0;

       threadJuego.start();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(lanzado == true) {
            misil.setBounds(X_POSICION_MISIL - misil.getIntrinsicWidth() / 2, Y_POSICION_MISIL - misil.getIntrinsicHeight() / 2, X_POSICION_MISIL + nave.getIntrinsicWidth() / 2, Y_POSICION_MISIL + nave.getIntrinsicHeight() / 2);
            misil1.setBounds(X_POSICION_MISIL - misil1.getIntrinsicWidth() /4, Y_POSICION_MISIL - misil1.getIntrinsicHeight() / 4, X_POSICION_MISIL + nave.getIntrinsicWidth() + 10, Y_POSICION_MISIL + nave.getIntrinsicHeight() / 4);
            misil2.setBounds(X_POSICION_MISIL - misil2.getIntrinsicWidth() / 6, Y_POSICION_MISIL - misil2.getIntrinsicHeight() / 6, X_POSICION_MISIL + nave.getIntrinsicWidth() + 20, Y_POSICION_MISIL + nave.getIntrinsicHeight() / 6);
            misil3.setBounds(X_POSICION_MISIL - misil3.getIntrinsicWidth() / 8, Y_POSICION_MISIL - misil3.getIntrinsicHeight() / 8, X_POSICION_MISIL + nave.getIntrinsicWidth() + 30, Y_POSICION_MISIL + nave.getIntrinsicHeight() / 8);

                misil.draw(canvas);
                misil1.draw(canvas);
                misil2.draw(canvas);
                misil3.draw(canvas);

        }
        if (!naveDestruida) {
            nave.setBounds(X_POSICION_NAVE - nave.getIntrinsicWidth() / 4, Y_POSICION_NAVE - nave.getIntrinsicHeight() / 2,
                    X_POSICION_NAVE + nave.getIntrinsicWidth() / 2, Y_POSICION_NAVE + nave.getIntrinsicHeight() / 2);
            nave.draw(canvas);
        }
        if (!asteroideDestruido) {
            asteroide.setBounds(X_POSICION_ASTEROIDE - asteroide.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE - asteroide.getIntrinsicHeight() / 2,
                    X_POSICION_ASTEROIDE + asteroide.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE + asteroide.getIntrinsicHeight() / 2);
            asteroide.draw(canvas);
        }
        if (!asteroide1Destruido) {
            asteroide_1.setBounds(X_POSICION_ASTEROIDE_1 - asteroide_1.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_1 - asteroide_1.getIntrinsicHeight() / 2,
                    X_POSICION_ASTEROIDE_1 + asteroide_1.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_1 + asteroide_1.getIntrinsicHeight() / 2);
            asteroide_1.draw(canvas);
        }
        if (!asteroide2Destruido) {
            asteroide_2.setBounds(X_POSICION_ASTEROIDE_2 - asteroide_2.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_2 - asteroide_2.getIntrinsicHeight() / 2,
                    X_POSICION_ASTEROIDE_2 + asteroide_2.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_2 + asteroide_2.getIntrinsicHeight() / 2);
            asteroide_2.draw(canvas);
        }
        if (!asteroide3Destruido) {
            asteroide_3.setBounds(X_POSICION_ASTEROIDE_3 - asteroide_3.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_3 - asteroide_3.getIntrinsicHeight() / 2,
                    X_POSICION_ASTEROIDE_3 + asteroide_3.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_3 + asteroide_3.getIntrinsicHeight() / 2);
            asteroide_3.draw(canvas);
        }
        if (!asteroide4Destruido) {
            asteroide_4.setBounds(X_POSICION_ASTEROIDE_4 - asteroide_4.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_4 - asteroide_4.getIntrinsicHeight() / 2,
                    X_POSICION_ASTEROIDE_4 + asteroide_4.getIntrinsicWidth() / 2, Y_POSICION_ASTEROIDE_4 + asteroide_4.getIntrinsicHeight() / 2);
            asteroide_4.draw(canvas);
        }
    }
    private void actualizarNave() {
        if (radioColision(nave, asteroide) || radioColision(nave, asteroide_1) ||radioColision(nave, asteroide_2) || radioColision(nave, asteroide_3) || radioColision(nave, asteroide_4)) {
            naveDestruida = true;
        } else {
            if (Y_POSICION_NAVE > getHeight()) {
                Y_POSICION_NAVE = 0;
            }
            if (Y_POSICION_NAVE < 0) {
                Y_POSICION_NAVE = getHeight();
            }
            Y_POSICION_NAVE = Y_POSICION_NAVE + VELOCIDAD_NAVE;
        }
    }

    private void actualizarMisil() {
        if (X_POSICION_MISIL - misil.getIntrinsicWidth() > getWidth()) {
            lanzado = false;
        }
        X_POSICION_MISIL = X_POSICION_MISIL + VELOCIDAD_MISIL;
    }
    private void actualizarMisil1() {
        if (X_POSICION_MISIL - misil1.getIntrinsicWidth() > getWidth()) {
            lanzado = false;
        }
        X_POSICION_MISIL_1 = X_POSICION_MISIL_1+5 + VELOCIDAD_MISIL;
    }
    private void actualizarMisil2() {
        if (X_POSICION_MISIL - misil2.getIntrinsicWidth() > getWidth()) {
            lanzado = false;
        }
        X_POSICION_MISIL_2 = X_POSICION_MISIL_2 +10 + VELOCIDAD_MISIL;
    }
    private void actualizarMisil3() {
        if (X_POSICION_MISIL - misil3.getIntrinsicWidth() > getWidth()) {
            lanzado = false;
        }
        X_POSICION_MISIL_3 = X_POSICION_MISIL_3 + VELOCIDAD_MISIL;
    }
    private void actualizarAsteroide() {

        if (radioColision(misil, asteroide)) {
            asteroide.setVisible(false, false);
            asteroideDestruido = true;
        } else {
            if (X_POSICION_ASTEROIDE > getWidth()) {
                X_POSICION_ASTEROIDE = 0;
            }
            if (X_POSICION_ASTEROIDE < 0) {
                X_POSICION_ASTEROIDE = getWidth();
            }
            if (Y_POSICION_ASTEROIDE > getHeight()) {
                Y_POSICION_ASTEROIDE = 0;
            }
            if (Y_POSICION_ASTEROIDE < 0) {
                Y_POSICION_ASTEROIDE = getHeight();
            }
            X_POSICION_ASTEROIDE = X_POSICION_ASTEROIDE + (int) Math.random() * 8 - 2;
            Y_POSICION_ASTEROIDE = Y_POSICION_ASTEROIDE - (int) Math.random() * 8 - 2;
        }
    }
    private void actualizarAsteroide1() {

        if (radioColision(misil, asteroide_1)) {
            asteroide_1.setVisible(false, false);
            asteroide1Destruido = true;
        } else {
            if (X_POSICION_ASTEROIDE_1 > getWidth()) {
                X_POSICION_ASTEROIDE_1 = 0;
            }
            if (X_POSICION_ASTEROIDE_1 < 0) {
                X_POSICION_ASTEROIDE_1 = getWidth();
            }
            if (Y_POSICION_ASTEROIDE_1 > getHeight()) {
                Y_POSICION_ASTEROIDE_1 = 0;
            }
            if (Y_POSICION_ASTEROIDE_1 < 0) {
                Y_POSICION_ASTEROIDE_1 = getHeight();
            }

            X_POSICION_ASTEROIDE_1 = X_POSICION_ASTEROIDE_1 + (int) Math.random() * 12 - 2;
            Y_POSICION_ASTEROIDE_1 = Y_POSICION_ASTEROIDE_1 - (int) Math.random() * 12 - 2;
        }
    }
    private void actualizarAsteroide2() {
        if (radioColision(misil, asteroide_2)) {
            asteroide_2.setVisible(false, false);
            asteroide2Destruido = true;
        } else {
            if (X_POSICION_ASTEROIDE_2 > getWidth()) {
                X_POSICION_ASTEROIDE_2 = 0;
            }
            if (X_POSICION_ASTEROIDE_2 < 0) {
                X_POSICION_ASTEROIDE_2 = getWidth();
            }
            if (Y_POSICION_ASTEROIDE_2 > getHeight()) {
                Y_POSICION_ASTEROIDE_2 = 0;
            }
            if (Y_POSICION_ASTEROIDE_2 < 0) {
                Y_POSICION_ASTEROIDE_2 = getHeight();
            }

            X_POSICION_ASTEROIDE_2 = X_POSICION_ASTEROIDE_2 - Y_VELOCIDAD_ASTEROIDE+  (int) Math.random() * 18 - 2;
            Y_POSICION_ASTEROIDE_2 = Y_POSICION_ASTEROIDE_2 + X_VELOCIDAD_ASTEROIDE + (int) Math.random() * 18 - 2;
        }
    }
    private void actualizarAsteroide3() {
        if (radioColision(misil, asteroide_3)) {
            asteroide_3.setVisible(false, false);
            asteroide3Destruido = true;
        } else {
            if (X_POSICION_ASTEROIDE_3 > getWidth()) {
                X_POSICION_ASTEROIDE_3 = 0;
            }
            if (X_POSICION_ASTEROIDE_3 < 0) {
                X_POSICION_ASTEROIDE_3 = getWidth();
            }
            if (Y_POSICION_ASTEROIDE_3 > getHeight()) {
                Y_POSICION_ASTEROIDE_3 = 0;
            }
            if (Y_POSICION_ASTEROIDE_3 < 0) {
                Y_POSICION_ASTEROIDE_3 = getHeight();
            }
            X_POSICION_ASTEROIDE_3 = X_POSICION_ASTEROIDE_3 - (int) Math.random() * 14 - 2;
            Y_POSICION_ASTEROIDE_3 = Y_POSICION_ASTEROIDE_3 + (int) Math.random() * 14 - 2;
        }
        }
    private void actualizarAsteroide4() {
        if (radioColision(misil, asteroide_4)) {
            asteroide_4.setVisible(false, false);
            asteroide4Destruido = true;
        } else {
            if (X_POSICION_ASTEROIDE_4 > getWidth()) {
                X_POSICION_ASTEROIDE_4 = 0;
            }
            if (X_POSICION_ASTEROIDE_4 < 0) {
                X_POSICION_ASTEROIDE_4 = getWidth();
            }
            if (Y_POSICION_ASTEROIDE_4 > getHeight()) {
                Y_POSICION_ASTEROIDE_4 = 0;
            }
            if (Y_POSICION_ASTEROIDE_4 < 0) {
                Y_POSICION_ASTEROIDE_4 = getHeight();
            }
            X_POSICION_ASTEROIDE_4 = X_POSICION_ASTEROIDE_4 - Y_VELOCIDAD_ASTEROIDE +  (int) Math.random() * 12 - 2;
            Y_POSICION_ASTEROIDE_4 = Y_POSICION_ASTEROIDE_4 + X_VELOCIDAD_ASTEROIDE + (int) Math.random() * 12 - 2;
        }
    }
        public boolean radioColision(Drawable a, Drawable b) {
            return a.getBounds().intersect(b.getBounds());
        }
    class ThreadJuego extends Thread {

        private final static int PERIODO_PROCESO = 50;

        public void run() {
            while (true) {

                if (naveDestruida || asteroideDestruido && asteroide1Destruido && asteroide2Destruido && asteroide3Destruido && asteroide4Destruido) {
                    ((Activity) getContext()).finish();
                }
                actualizarNave();
                actualizarMisil();
                actualizarMisil1();
                actualizarMisil2();
                actualizarMisil3();
                actualizarAsteroide();
                actualizarAsteroide1();
                actualizarAsteroide2();
                actualizarAsteroide3();
                actualizarAsteroide4();
                postInvalidate();
                try {
                    Thread.sleep(PERIODO_PROCESO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            X_POSICION_MISIL = X_POSICION_NAVE + nave.getIntrinsicWidth() / 2;
            Y_POSICION_MISIL = Y_POSICION_NAVE;
            lanzado = true;
            VELOCIDAD_NAVE =  - VELOCIDAD_NAVE;
            return true;
        }
        return false;

    }

}
