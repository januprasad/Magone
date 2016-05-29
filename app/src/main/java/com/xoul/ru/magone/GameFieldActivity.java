package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.PlayerListener;

import java.util.List;

public class GameFieldActivity extends Activity implements PlayerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        PlayerField playerField1 = (PlayerField) findViewById(R.id.playerField1);
        playerField1.setListener(this);
        PlayerField playerField2 = (PlayerField) findViewById(R.id.playerField2);
        playerField2.setListener(this);
    }

    @Override
    public void onCast(List<Rune> spell) {
        StringBuilder message = new StringBuilder();
        for (Rune rune : spell) {
            message.append(rune + ":");
        }
        if (message.length() > 0) {
            message.deleteCharAt(message.length() - 1);
        }
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNextTurn() {
        Toast.makeText(getApplicationContext(), "Next turn", Toast.LENGTH_SHORT).show();
    }
}
