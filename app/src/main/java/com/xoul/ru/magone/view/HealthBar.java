package com.xoul.ru.magone.view;

import android.content.Context;
import android.util.AttributeSet;

public class HealthBar extends ValueProgressBar {

    public HealthBar(Context context) {
        super(context);
        init();
    }

    public HealthBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        color = 0xffff0000;
        borderColor = 0xffaa0000;
    }
}
