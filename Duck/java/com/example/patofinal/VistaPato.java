package com.example.patofinal;

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

import androidx.core.view.MotionEventCompat;

/**
 * TODO: document your custom view class.
 */
public class VistaPato extends View {

    private Drawable pato;

    private int xPosicion;
    private int yPosicion;

    private int VELOCIDAD = 10;

    private MiThread miThread;
    public VistaPato(Context context) {
        super(context);
        init(null, 0);
    }

    public VistaPato(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public VistaPato(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        pato = getResources().getDrawable(R.drawable.patoida);

        miThread = new MiThread();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        pato.setBounds(xPosicion - pato.getIntrinsicWidth() / 2,
                yPosicion - pato.getIntrinsicHeight() / 2,
                xPosicion + pato.getIntrinsicWidth() / 2,
                yPosicion + pato.getIntrinsicHeight() / 2);

        pato.draw(canvas);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        xPosicion = 0;
        yPosicion = h/2;

        miThread.start();
    }
    public void actualizarPato() {
        if(xPosicion + VELOCIDAD > getWidth() ||
        xPosicion + VELOCIDAD < 0) {
            VELOCIDAD = -VELOCIDAD;
        }
        if(VELOCIDAD > 0) {
            pato = getResources().getDrawable(R.drawable.patoida);
        } else {
            pato = getResources().getDrawable(R.drawable.patovuelta);
        }
        xPosicion = xPosicion + VELOCIDAD;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        int action = MotionEventCompat.getActionMasked(event);

        switch (action) {
            case MotionEvent.ACTION_UP:
                if((Math.sqrt((xPosicion - x)*(xPosicion-x))<pato.getIntrinsicWidth()/2 &&
                        ((Math.sqrt((yPosicion-y)*(yPosicion-y))<pato.getIntrinsicHeight()/2)))) {
                    VELOCIDAD = -VELOCIDAD;
                }
                break;
        }
        return true;
    }

    class MiThread extends Thread {
        final static int REFRESCO = 60;
        public void run() {
            while(true) {
                actualizarPato();
                postInvalidate();
                try {
                    Thread.sleep(REFRESCO);
                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}