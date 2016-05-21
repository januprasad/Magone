package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.xoul.ru.magone.view.Rune;

public class GameFieldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
    }

    public void runeClicked(View view) {
        Rune rune = (Rune) view;
        Toast.makeText(getApplicationContext(), "Rune clicked: " + rune.getStyle(), Toast.LENGTH_SHORT).show();
    }
}
