package com.example.ascensor;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * TODO: document your custom view class.
 */
public class Ascensor extends View {
    //    private String mExampleString; // TODO: use a default from R.string...
//    private int mExampleColor = Color.RED; // TODO: use a default from R.color...
//    private float mExampleDimension = 0; // TODO: use a default from R.dimen...
//    private Drawable mExampleDrawable;
//
//    private TextPaint mTextPaint;
//    private float mTextWidth;
//    private float mTextHeight;
    private Drawable ascensor;
    private int xPositionAscensor;
    private int yPositionAscensor;

    private ThreadAscensor threadAscensor;
    private int velAscensor = 15;

    public Ascensor(Context context) {
        super(context);
        init(null, 0);
    }

    public Ascensor(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public Ascensor(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {
        // Load attributes
        ascensor = getResources().getDrawable(R.drawable.ascensor);

        threadAscensor = new ThreadAscensor();
    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        xPositionAscensor = w/2;
        yPositionAscensor = h / 2;
        threadAscensor.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        ascensor.setBounds(xPositionAscensor - ascensor.getIntrinsicWidth() / 2,
                yPositionAscensor - ascensor.getIntrinsicHeight() / 2, xPositionAscensor + ascensor.getIntrinsicWidth(),
                yPositionAscensor + ascensor.getIntrinsicHeight());

        ascensor.draw(canvas);

    }

    private void actualizarAscensor() {
        if (yPositionAscensor > getHeight()) {
            yPositionAscensor = 0;
        }
        if (yPositionAscensor < 0) {
            yPositionAscensor = getHeight();
        }

        yPositionAscensor = yPositionAscensor + velAscensor;
    }


    class ThreadAscensor extends Thread {

        private final static int PERIODO_PROCESO = 60;

        public void run() {
            while (true) {

                actualizarAscensor();
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
            velAscensor = -velAscensor;
            return true;
        } else {
            return false;
        }
    }


}