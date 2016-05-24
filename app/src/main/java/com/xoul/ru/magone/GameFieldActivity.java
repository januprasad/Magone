package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.control.ControlField.OnControlClickedListener;
import com.xoul.ru.magone.view.player.info.PlayerInfoField;
import com.xoul.ru.magone.view.player.rune.Rune;
import com.xoul.ru.magone.view.player.rune.RuneField.OnRuneClickedListener;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField;

public class GameFieldActivity extends Activity implements OnRuneClickedListener, OnControlClickedListener {
    private PlayerField playerField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
//        playerField = (PlayerField) findViewById(R.id.playerField);
//        playerField.getRuneField().setOnRuneClickedListener(this);
//        playerField.getControlField().setOnControlClickedListener(this);
    }

    @Override
    public void onRuneClicked(Rune.RuneStyle runeStyle) {
        PlayerInfoField playerInfo = playerField.getPlayerInfoField();
        UnitField unitField = playerField.getUnitField();
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
