package com.xoul.ru.magone.view.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.other.Utils;
import com.xoul.ru.magone.view.player.control.ControlField;
import com.xoul.ru.magone.view.player.info.PlayerInfoField;
import com.xoul.ru.magone.view.player.rune.RuneField;
import com.xoul.ru.magone.view.player.unit.UnitField;

public class PlayerField extends LinearLayout {
    UnitField unitField;
    PlayerInfoField playerInfoField;
    RuneField runeField;
    ControlField controlField;
    private boolean reversed;

    public PlayerField(Context context) {
        super(context);
        initViews(context);
    }

    public PlayerField(Context context, AttributeSet attrs) {
        super(context, attrs);
        initViews(context);
    }

    private void initViews(Context context) {
        setOrientation(VERTICAL);
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                Utils.dpPx(context, 150));

        unitField = new UnitField(context);
        addView(unitField, params);

        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.dpPx(context, 50));
        playerInfoField = new PlayerInfoField(context);
        addView(playerInfoField, params);

        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.dpPx(context, 50));
        runeField = new RuneField(context);
        addView(runeField, params);

        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        controlField = new ControlField(context);
        addView(controlField, params);
    }

    public UnitField getUnitField() {
        return unitField;
    }

    public PlayerInfoField getPlayerInfoField() {
        return playerInfoField;
    }

    public RuneField getRuneField() {
        return runeField;
    }

    public ControlField getControlField() {
        return controlField;
    }
}
