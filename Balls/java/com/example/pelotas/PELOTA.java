package com.example.pelotas;

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

/**
 * TODO: document your custom view class.
 */
public class PELOTA extends View {

    private Drawable pelotaRoja;
    private Drawable pelotaRoja2;

    private  int posXPelota;
    private  int posYPelota;

    private  int posXPelota1;
    private  int posYPelota1;

    private int velocidad = 10;

    private MiThread miThread;

    public PELOTA(Context context) {
        super(context);
        init(null, 0);
    }

    public PELOTA(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public PELOTA(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        pelotaRoja = getResources().getDrawable(R.drawable.pelota1);
        pelotaRoja2 = getResources().getDrawable(R.drawable.pelota1);
        miThread = new MiThread();
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        posXPelota = 0;
        posYPelota = h/2;

        posXPelota1 = w-w/10;
        posYPelota1 = 0;
        miThread.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pelotaRoja.setBounds(posXPelota - pelotaRoja.getIntrinsicWidth(),
                posYPelota - pelotaRoja.getIntrinsicHeight(),
                posXPelota + pelotaRoja.getIntrinsicWidth(),
                posYPelota + pelotaRoja.getIntrinsicHeight());
        pelotaRoja.draw(canvas);

        pelotaRoja2.setBounds(posXPelota1 - pelotaRoja2.getIntrinsicWidth(),
                posYPelota1 - pelotaRoja2.getIntrinsicHeight(),
                posXPelota1 + pelotaRoja2.getIntrinsicWidth(),
                posYPelota1 + pelotaRoja2.getIntrinsicHeight());
        pelotaRoja2.draw(canvas);
    }

    class MiThread extends Thread {
        final static int REFRESCO = 60;
        @Override
        public void run() {
            while (true) {
                actualizarPelotaX();
                actualizarPelotaY();
                postInvalidate();
                try {
                    Thread.sleep(REFRESCO);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void actualizarPelotaX() {
        if(posXPelota + velocidad > getWidth() ||
                posXPelota + velocidad < 0) {
            posXPelota = 0;

        }
        posXPelota = posXPelota + velocidad;
    }
    public void actualizarPelotaY() {
        if(posYPelota1 + velocidad >getHeight() ||
                posYPelota1 + velocidad < 0) {
            posYPelota1 = 0;
        }
        posYPelota1 = posYPelota1 + velocidad+5;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        if(event.getAction() == MotionEvent.ACTION_UP) {
            if((Math.sqrt((posXPelota -x)*(posYPelota-x))<pelotaRoja.getIntrinsicWidth())
                    &&
                    (((Math.sqrt((posYPelota-y)*(posYPelota-y)))<pelotaRoja.getIntrinsicHeight()))) {
                pelotaRoja = getResources().getDrawable(R.drawable.pelota2);
            }
            if((Math.sqrt((posXPelota1 -x)*(posYPelota1-x))<pelotaRoja2.getIntrinsicWidth())
                    &&
                    ((Math.sqrt((posYPelota1-y)*(posYPelota1-y))<pelotaRoja2.getIntrinsicHeight()))) {
                pelotaRoja2 = getResources().getDrawable(R.drawable.pelota2);
            }
        }

        return true;
    }
}