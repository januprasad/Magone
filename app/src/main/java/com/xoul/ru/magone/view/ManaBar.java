package com.xoul.ru.magone.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import com.xoul.ru.magone.R;

public class ManaBar extends View {
    private static final float BORDER_MULTIPLER = 1 / 10f;
    private static final int BORDER_COLOR = 0xff0000aa;
    private static final int BACKGROUND_COLOR = 0xff111111;
    private static final int COLOR = 0xff0000ff;
    private static final int TEXT_COLOR = 0xffffffff;
    private static final float TEXT_SIZE = 50f;

    private Rect outsideRect;
    private Rect insideRect;
    private Rect filledRect;
    private Paint paint;
    private Rect bounds;

    private int mp;
    private int maxMp;

    public ManaBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.getTheme().obtainStyledAttributes(attrs, R.styleable.ManaBar, 0, 0);
        mp = typedArray.getInteger(R.styleable.ManaBar_mp, 0);
        maxMp = typedArray.getInteger(R.styleable.ManaBar_maxMp, 1);
        outsideRect = new Rect(0, 0, 0, 0);
        insideRect = new Rect(0, 0, 0, 0);
        filledRect = new Rect(0, 0, 0, 0);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setTypeface(Typeface.create("Roboto", Typeface.NORMAL));
        paint.setTextAlign(Paint.Align.CENTER);
        paint.setTextSize(TEXT_SIZE);
        bounds = new Rect(0, 0, 0, 0);
    }

    public int getMp() {
        return mp;
    }

    public void setMp(int mp) {
        if (mp > maxMp) {
            this.mp = maxMp;
        } else if (mp < 0) {
            this.mp = 0;
        } else  {
            this.mp = mp;
        }
        invalidate();
    }

    public int getMaxMp() {
        return maxMp;
    }

    public void setMaxMp(int maxMp) {
        if (maxMp < 1) {
            this.maxMp = 1;
        } else {
            this.maxMp = maxMp;
        }
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int w = MeasureSpec.getSize(widthMeasureSpec);
        int h = MeasureSpec.getSize(heightMeasureSpec);
        outsideRect.set(0, 0, w, h);
        int border = (w < h) ? w : h; // min(w, h);
        border *= BORDER_MULTIPLER;
        insideRect.set(border, border, w - border, h - border);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        paint.setColor(BORDER_COLOR);
        canvas.drawRect(outsideRect, paint);
        paint.setColor(BACKGROUND_COLOR);
        canvas.drawRect(insideRect, paint);
        paint.setColor(COLOR);
        makeMpMeasurements();
        canvas.drawRect(filledRect, paint);
        paint.setColor(TEXT_COLOR);
        makeTextMeasurements();
        canvas.drawText(getText(),
                outsideRect.centerX(),
                outsideRect.centerY() - bounds.centerY(),
                paint
        );
    }

    private String getText() {
        return Integer.toString(mp) + "/" + Integer.toString(maxMp);
    }

    private void makeTextMeasurements() {
        String text = getText();
        paint.getTextBounds(text, 0, text.length(), bounds);
    }

    private void makeMpMeasurements() {
        float percent = mp / (float) maxMp;
        int right = (int) (insideRect.right * percent);
        filledRect.set(insideRect.left, insideRect.top, right, insideRect.bottom);
    }
}
