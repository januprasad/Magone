package com.xoul.ru.magone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.xoul.ru.magone.R;

public class Rune extends View {
    private Paint paint;

    public Rune(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.Rune, 0, 0);
        int runeIndex = typedArray.getInteger(R.styleable.Rune_type, 0);
        RuneStyle style = RuneStyle.values()[runeIndex];
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(style.getColor());
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawCircle(50, 50, 50, paint);
    }

    private enum RuneStyle {
        FIRE(0xffff1111, 0xffaaaa00),
        WATER(0xff0000aa, 0xff00aaaa);

        private int color;
        private int boarderColor;

        RuneStyle(int color, int boarderColor) {
            this.color = color;
            this.boarderColor = boarderColor;
        }

        public int getColor() {
            return color;
        }

        public int getBoarderColor() {
            return boarderColor;
        }
    }
}
