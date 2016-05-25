package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class NextTurn extends View {
    protected float borderMultiplier = 1 / 10f;
    protected int borderColor = 0xffe0e0e0;
    protected int color = 0xffffffff;
    protected int textColor = 0xff000000;
    protected float textSize = 70f;

    private Path outsidePath;
    private Rect outsideRect;
    private Matrix tmp;
    private Path insidePath;
    private Rect insideRect;
    private Rect bounds;
    private Paint paint;

    protected String text;

    public NextTurn(Context context) {
        super(context);
        init();
    }

    public NextTurn(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        text = "✔";
        outsidePath = new Path();
        outsideRect = new Rect();
        tmp = new Matrix();
        insidePath = new Path();
        insideRect = new Rect();
        bounds = new Rect(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(textSize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        outsidePath.reset();
        outsidePath.lineTo(w, h / 2);
        outsidePath.lineTo(0, h);
        outsidePath.close();

        int border = (w < h) ? w : h; // min(w, h);
        border *= borderMultiplier;
        insideRect.set(border, border, w - border, h - border);
        tmp.setScale(0.5f, 0.5f, w / 2, h / 2);
        outsidePath.transform(tmp, insidePath);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(borderColor);
        canvas.drawPath(outsidePath, paint);
        paint.setColor(color);
        canvas.drawPath(insidePath, paint);
        paint.setColor(textColor);
        makeTextMeasurements();
        canvas.drawText(text, outsideRect.right / 3, outsideRect.centerY() - bounds.centerY(), paint);
    }

    private void makeTextMeasurements() {
        paint.getTextBounds(text, 0, text.length(), bounds);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_POINTER_DOWN:
                setPressed(true);
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_POINTER_UP:
            case MotionEvent.ACTION_CANCEL:
                if (isPressed()) {
                    performClick();
                }
                setPressed(false);
                break;
        }
        return true;
    }

    @Override
    public void setPressed(boolean pressed) {
        super.setPressed(pressed);
        invalidate();
    }
}
