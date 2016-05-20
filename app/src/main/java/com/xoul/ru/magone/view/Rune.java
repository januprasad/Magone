package com.xoul.ru.magone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xoul.ru.magone.R;

public class Rune extends View {
    private static final float BORDER_MULTIPLER = 1 / 10f;
    private Paint paint;
    private RuneStyle style;

    public Rune(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Rune, 0, 0);
        int runeIndex = typedArray.getInteger(R.styleable.Rune_type, 0);
        style = RuneStyle.values()[runeIndex];
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth();
        int h = getHeight();
        float r = (h < w) ? h : w; // min(h, w);
        r /= 2f;
        paint.setColor(style.getBorderColor());
        canvas.drawCircle(w / 2f, h / 2f, r, paint);
        float r2 = r * (1 - BORDER_MULTIPLER);
        paint.setColor(style.getColor());
        canvas.drawCircle(w / 2f, h / 2f, r2, paint);
    }

    // using order of attrs.xml type enum
    private enum RuneStyle {
        FIRE(0xffff0000, 0xffaa0000),
        WATER(0xff0000ff, 0xff0000aa),
        LIFE(0xff00ff00, 0xff00aa00),
        DEATH(0xff000000, 0xff555555);

        private int color;
        private int borderColor;

        RuneStyle(int color, int borderColor) {
            this.color = color;
            this.borderColor = borderColor;
        }

        public int getColor() {
            return color;
        }

        public int getBorderColor() {
            return borderColor;
        }
    }
}
