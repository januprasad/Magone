package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xoul.ru.magone.view.ManaBar;
import com.xoul.ru.magone.view.Rune;

public class GameFieldActivity extends Activity {
    private ManaBar manaBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        manaBar = (ManaBar) findViewById(R.id.manaBar);
    }

    public void runeClicked(View view) {
        int mp = manaBar.getMp();
        mp--;
        if (mp < 0) {
            mp = manaBar.getMaxMp();
        }
        manaBar.setMp(mp);
    }
}
