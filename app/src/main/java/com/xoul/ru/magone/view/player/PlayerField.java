package com.xoul.ru.magone.view.player;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.xoul.ru.magone.view.other.Utils;
import com.xoul.ru.magone.view.player.control.ControlField;
import com.xoul.ru.magone.view.player.info.PlayerInfoField;
import com.xoul.ru.magone.view.player.rune.Rune;
import com.xoul.ru.magone.view.player.rune.RuneField;
import com.xoul.ru.magone.view.player.unit.UnitField;

import java.util.LinkedList;
import java.util.List;

public class PlayerField extends LinearLayout implements RuneField.OnRuneClickedListener, ControlField.OnControlClickedListener {
    private static final int MARGIN_DP = 10;

    private UnitField unitField;
    private PlayerInfoField playerInfoField;
    private RuneField runeField;
    private ControlField controlField;

    private PlayerListener listener;

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
                Utils.dpPx(context, 125));
        params.weight = 1;
        //params.setMargins(MARGIN_DP, MARGIN_DP, MARGIN_DP, MARGIN_DP / 2);
        unitField = new UnitField(context);
        addView(unitField, params);

        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.dpPx(context, 25));
        params.setMargins(MARGIN_DP, 0, MARGIN_DP, MARGIN_DP );
        playerInfoField = new PlayerInfoField(context);
        addView(playerInfoField, params);

        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, Utils.dpPx(context, 50));
        params.setMargins(MARGIN_DP, 0, MARGIN_DP, MARGIN_DP);
        runeField = new RuneField(context);
        runeField.setOnRuneClickedListener(this);
        addView(runeField, params);

        params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.setMargins(MARGIN_DP, 0, MARGIN_DP, MARGIN_DP);
        controlField = new ControlField(context);
        controlField.setOnControlClickedListener(this);
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

    public void setListener(PlayerListener listener) {
        this.listener = listener;
    }

    @Override
    public void onCastClicked() {
        List<com.xoul.ru.magone.model.Rune> spell = new LinkedList<>();
        for (Rune.RuneStyle style : controlField.getRunes()) {
            spell.add(com.xoul.ru.magone.model.Rune.values()[style.ordinal()]);
        }
        if (listener != null) {
            listener.onCast(spell);
        }
        controlField.clear();
    }

    @Override
    public void onNextTurnClicked() {
        if (listener != null) {
            listener.onNextTurn();
        }
    }

    @Override
    public void onRuneClicked(Rune.RuneStyle runeStyle) {
        controlField.addRune(runeStyle);
    }
}
