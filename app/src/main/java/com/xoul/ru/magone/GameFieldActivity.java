package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;

import com.xoul.ru.magone.view.ManaBar;
import com.xoul.ru.magone.view.Rune;
import com.xoul.ru.magone.view.RuneField;
import com.xoul.ru.magone.view.RuneField.OnRuneClickedListener;

public class GameFieldActivity extends Activity implements OnRuneClickedListener {
    private ManaBar manaBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        manaBar = (ManaBar) findViewById(R.id.manaBar);
        RuneField field = (RuneField) findViewById(R.id.rune_field);
        field.setOnRuneClickedListener(this);
    }

    @Override
    public void onRuneClicked(Rune.RuneStyle runeStyle) {
        int mp = manaBar.getMp();
        mp--;
        if (mp < 0) {
            mp = manaBar.getMaxMp();
        }
        manaBar.setMp(mp);
    }
}
