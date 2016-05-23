package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;

import com.xoul.ru.magone.view.ManaBar;
import com.xoul.ru.magone.view.Rune;
import com.xoul.ru.magone.view.RuneField;
import com.xoul.ru.magone.view.RuneField.OnRuneClickedListener;
import com.xoul.ru.magone.view.Unit;
import com.xoul.ru.magone.view.UnitField;

public class GameFieldActivity extends Activity implements OnRuneClickedListener {
    private ManaBar manaBar;
    private UnitField unitField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        manaBar = (ManaBar) findViewById(R.id.manaBar);
        RuneField field = (RuneField) findViewById(R.id.rune_field);
        field.setOnRuneClickedListener(this);
        unitField = (UnitField) findViewById(R.id.unitField);
    }

    @Override
    public void onRuneClicked(Rune.RuneStyle runeStyle) {
        int mp = manaBar.getValue();
        mp--;
        if (mp < 0) {
            mp = manaBar.getMaxValue();
        }
        manaBar.setValue(mp);
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
}
