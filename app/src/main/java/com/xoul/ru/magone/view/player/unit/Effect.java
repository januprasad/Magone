package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

public class Effect extends View {
    private EffectType style;
    private Paint paint;

    public Effect(Context context) {
        super(context);
        init();
    }

    public Effect(Context context, EffectType style) {
        super(context);
        init();
        this.style = style;
    }

    public Effect(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        style = EffectType.FIRE;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int w = getWidth();
        int h = getHeight();
        paint.setColor(style.getColor());
        canvas.drawRect(0, 0, w, h, paint);
    }

    public enum EffectType {
        FIRE(0xffff0000),
        WET(0xff0000ff),
        HEAL(0xff00ff00),
        SHIELD(0xffffff00),
        DEATH(0xff000000);

        private int color;

        EffectType(int color) {
            this.color = color;
        }

        public int getColor() {
            return color;
        }
    }
}
