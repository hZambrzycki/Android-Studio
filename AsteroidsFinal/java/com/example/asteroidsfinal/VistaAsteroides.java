package com.example.asteroidsfinal;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import androidx.core.view.MotionEventCompat;

/**
 * TODO: document your custom view class.
 */
public class VistaAsteroides extends View {

    private Drawable nave;
    private Drawable misil;
    private Drawable asteroide;

    private int xNave;
    private int yNave;
    private int velocidadNave = 10;

    private int xMisil;
    private int yMisil;
    private int velocidadMisil = 30;
    private boolean lanzado = false;

    private int xAsteroide;
    private int yAsteroide;

    private int XvelocidadAsteroide =  (int) Math.random()* 8 - 2*10;;
    private int YvelocidadAsteroide =  (int) Math.random()* 8 - 2*10;;

    private MiHilo miHilo;

    public VistaAsteroides(Context context) {
        super(context);
        init(null, 0);
    }

    public VistaAsteroides(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public VistaAsteroides(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        nave = getResources().getDrawable(R.drawable.nave);
        misil = getResources().getDrawable(R.drawable.misil1);
        asteroide = getResources().getDrawable(R.drawable.asteroide);


        miHilo = new MiHilo();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        nave.setBounds(xNave - nave.getIntrinsicWidth() / 2,
                yNave - nave.getIntrinsicHeight() / 2,
                xNave + nave.getIntrinsicWidth() / 2,
                yNave + nave.getIntrinsicHeight() / 2);
        nave.draw(canvas);
        misil.setBounds(xMisil - nave.getIntrinsicWidth() / 4,
                yMisil - nave.getIntrinsicHeight() / 4,
                xMisil + nave.getIntrinsicWidth() / 4,
                yMisil + nave.getIntrinsicHeight() / 4);
        if (lanzado) {
            misil.draw(canvas);
        }
        asteroide.setBounds(xAsteroide - asteroide.getIntrinsicWidth()/2,
                yAsteroide - asteroide.getIntrinsicHeight()/2,
                xAsteroide + asteroide.getIntrinsicWidth()/2,
                yAsteroide + asteroide.getIntrinsicHeight()/2);
        asteroide.draw(canvas);

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        xNave = 0;
        yNave = h / 2;

        xMisil = xNave-nave.getIntrinsicWidth()/4;
        yMisil = yNave;

       xAsteroide = (int) (Math.random() * (w - getWidth()/2)) + getWidth()/2;
       yAsteroide = (int) (Math.random() * (h - 0)) + 0;
        miHilo.start();

    }

    public void actualizarNave() {
        if (yNave + velocidadNave > getHeight() ||
                yNave + velocidadNave < 0) {
            velocidadNave = -velocidadNave;
        }
        yNave = yNave + velocidadNave;
    }

    public void actualizarMisil() {

            lanzado = false;

        xMisil = xMisil + velocidadMisil;
    }
    public void actualizarAsteroide() {
        if(xAsteroide + XvelocidadAsteroide > getWidth()) {
            XvelocidadAsteroide = -XvelocidadAsteroide;
            int aleatorio = (int) (10*Math.random()+1);
            Log.println(aleatorio, "VALOR", aleatorio+"");
            Log.d("VALOR", aleatorio+"");            if(aleatorio <= 5) {
                YvelocidadAsteroide = -YvelocidadAsteroide;
            } else if(aleatorio > 5) {
                YvelocidadAsteroide = +YvelocidadAsteroide;
            }

        }
        if(yAsteroide + YvelocidadAsteroide > getHeight()) {
            YvelocidadAsteroide = -YvelocidadAsteroide;
            int aleatorio = (int) (10*Math.random()+1);
            Log.println(aleatorio, "VALOR", aleatorio+"");
            Log.d("VALOR", aleatorio+"");
            if(aleatorio > 5) {

                XvelocidadAsteroide = -XvelocidadAsteroide;
            } else if(aleatorio <= 5) {
                XvelocidadAsteroide = +XvelocidadAsteroide;
            }
        }
        if(xAsteroide < 0) {
            XvelocidadAsteroide = -XvelocidadAsteroide;
            int aleatorio = (int) (10*Math.random()+1);
            
            Log.d("VALOR", aleatorio+"");
            if(aleatorio > 5) {
                YvelocidadAsteroide = -YvelocidadAsteroide;
            } else if(aleatorio <=5) {
                YvelocidadAsteroide = +YvelocidadAsteroide;
            }
        }
        if(yAsteroide < 0) {
            YvelocidadAsteroide = -YvelocidadAsteroide;
            int aleatorio = (int) (10*Math.random()+1);
            Log.println(aleatorio, "VALOR", aleatorio+"");
            Log.d("VALOR", aleatorio+"");
            if(aleatorio >=5) {
                XvelocidadAsteroide = +XvelocidadAsteroide;
            } else if(aleatorio < 5) {
                XvelocidadAsteroide = -XvelocidadAsteroide;
            }
        }
        xAsteroide = xAsteroide + XvelocidadAsteroide;
        yAsteroide = yAsteroide + YvelocidadAsteroide;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_UP:
                lanzado = true;
                break;
        }
        return true;
    }

    class MiHilo extends Thread {
        final static int REFRESCO = 60;

        public void run() {
            while (true) {
                actualizarNave();
                actualizarMisil();
                actualizarAsteroide();
                postInvalidate();
                try {
                    Thread.sleep(REFRESCO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}