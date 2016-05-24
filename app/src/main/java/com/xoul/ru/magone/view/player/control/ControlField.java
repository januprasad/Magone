package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.other.Utils;

public class ControlField extends LinearLayout implements View.OnClickListener {
    private LayoutParams params;
    private CastButton castButton;

    private OnControlClickedListener listener;

    public ControlField(Context context) {
        super(context);
        initViews(context);
    }

    public ControlField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        params = new LayoutParams(Utils.dpPx(context, 200), Utils.dpPx(context, 50));
        castButton = new CastButton(context);
        castButton.setOnClickListener(this);
        addView(castButton, params);
    }

    public void setOnControlClickedListener(OnControlClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            listener.onCastClicked();
        }
    }

    public interface OnControlClickedListener {
        void onCastClicked();
    }
}
