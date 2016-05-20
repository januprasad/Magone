package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class GameFieldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
    }

    public void runeClicked(View view) {
        Toast.makeText(getApplicationContext(), "Rune clicked: ", Toast.LENGTH_SHORT).show();
    }
}
