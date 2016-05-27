package com.xoul.ru.magone.view.player.control;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;

import com.xoul.ru.magone.view.other.Utils;

public class ControlField extends RelativeLayout implements View.OnClickListener {
    private LayoutParams params;
    private CastButton castButton;
    private NextTurn nextTurn;

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
        params = new LayoutParams(Utils.dpPx(context, 175), Utils.dpPx(context, 50));
        params.addRule(CENTER_IN_PARENT);
        castButton = new CastButton(context);
        castButton.setOnClickListener(this);
        addView(castButton, params);
        params = new LayoutParams(Utils.dpPx(context, 50), Utils.dpPx(context, 50));
        params.addRule(ALIGN_PARENT_RIGHT);
        nextTurn = new NextTurn(context);
        nextTurn.setOnClickListener(this);
        addView(nextTurn, params);
    }

    public void setOnControlClickedListener(OnControlClickedListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View v) {
        if (listener != null) {
            if (v == castButton) {
                listener.onCastClicked();
            } else if (v == nextTurn) {
                listener.onNextTurnClicked();
            }
        }
    }

    public interface OnControlClickedListener {
        void onCastClicked();
        void onNextTurnClicked();
    }
}
