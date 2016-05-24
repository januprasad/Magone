package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xoul.ru.magone.view.player.control.ControlField;
import com.xoul.ru.magone.view.player.control.ControlField.OnControlClickedListener;
import com.xoul.ru.magone.view.player.info.PlayerInfoField;
import com.xoul.ru.magone.view.player.rune.Rune;
import com.xoul.ru.magone.view.player.rune.RuneField;
import com.xoul.ru.magone.view.player.rune.RuneField.OnRuneClickedListener;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField;

public class GameFieldActivity extends Activity implements OnRuneClickedListener, OnControlClickedListener {
    private PlayerInfoField playerInfo;
    private UnitField unitField;
    private ControlField controlField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        playerInfo = (PlayerInfoField) findViewById(R.id.playerInfo);
        RuneField field = (RuneField) findViewById(R.id.rune_field);
        field.setOnRuneClickedListener(this);
        unitField = (UnitField) findViewById(R.id.unitField);
        controlField = (ControlField) findViewById(R.id.controlField);
        controlField.setOnControlClickedListener(this);
    }

    @Override
    public void onRuneClicked(Rune.RuneStyle runeStyle) {
        int mp = playerInfo.getMp();
        mp--;
        if (mp < 0) {
            mp = playerInfo.getMaxMp();
        }
        playerInfo.setMp(mp);
        switch (runeStyle) {
            case DEATH:
                unitField.removeAllUnits();
                break;
            case LIFE:
                unitField.addUnit(new Unit(this), UnitField.Slot.HERO);
                break;
            case FIRE:
                unitField.addUnit(new Unit(this), UnitField.Slot.WARRIOR);
                break;
            case WATER:
                unitField.addUnit(new Unit(this), UnitField.Slot.SUPPORT);
                break;
        }
    }

    @Override
    public void onCastClicked() {
        Toast.makeText(getApplicationContext(), "CAST!!!", Toast.LENGTH_SHORT).show();
    }
}
