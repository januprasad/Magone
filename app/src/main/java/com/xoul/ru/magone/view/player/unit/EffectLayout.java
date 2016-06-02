package com.xoul.ru.magone.view.player.unit;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

public class EffectLayout extends LinearLayout {
    private List<Effect> effects;

    private LayoutParams params;

    public EffectLayout(Context context) {
        super(context);
        init(context);
    }

    public EffectLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        effects = new LinkedList<>();
        setOrientation(HORIZONTAL);
        params = new LayoutParams(0, ViewGroup.LayoutParams.MATCH_PARENT);
        params.weight = 1;
    }

    public void setEffects(List<com.xoul.ru.magone.model.Effect> effects) {
        this.effects.clear();
        for (com.xoul.ru.magone.model.Effect effect : effects) {
            int index = effect.type.ordinal();
            this.effects.add(new Effect())
        }
    }
}
