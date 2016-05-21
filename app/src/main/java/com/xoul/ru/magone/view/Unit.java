package com.xoul.ru.magone.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

public class Unit extends View {
    private static final float BORDER_MULTIPLIER = 1 / 20f;
    private static final int BORDER_COLOR = 0xff000000;
    private static final int COLOR = 0xffffffff;
    private static final int TEXT_COLOR = 0xffff0000;
    private static final float TEXT_SIZE = 50f;
    private static final float TEXT_PADDING_MULTIPLIER = 1f;

    private RectF outsideRect;
    protected RectF insideRect;
    private Rect bounds;
    protected Paint paint;

    private int hp;
    private int maxHp;

    public Unit(Context context) {
        super(context);
        init();
    }

    public Unit(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        outsideRect = new RectF(0, 0, 0, 0);
        insideRect = new RectF(0, 0, 0, 0);
        bounds = new Rect(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(TEXT_SIZE);
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        int border = (w < h) ? w : h; // min(w, h);
        border *= BORDER_MULTIPLIER;
        insideRect.set(border, border, w - border, h - border);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(BORDER_COLOR);
        canvas.drawOval(outsideRect, paint);
        paint.setColor(COLOR);
        canvas.drawOval(insideRect, paint);
        paint.setColor(TEXT_COLOR);
        makeTextMeasurements();
        canvas.drawText(getText(),
                outsideRect.centerX(),
                outsideRect.bottom - bounds.height() * TEXT_PADDING_MULTIPLIER,
                paint
        );
    }

    private String getText() {
        return Integer.toString(hp) + "/" + Integer.toString(maxHp);
    }

    private void makeTextMeasurements() {
        String text = getText();
        paint.getTextBounds(text, 0, text.length(), bounds);
    }
}
