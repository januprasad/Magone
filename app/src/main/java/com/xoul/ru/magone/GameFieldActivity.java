package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.PlayerListener;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField;

import java.util.List;

public class GameFieldActivity extends Activity implements PlayerListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        PlayerField playerField = (PlayerField) findViewById(R.id.playerField);
        playerField.setListener(this);
        playerField.getUnitField().addUnit(new Unit(this), UnitField.Slot.HERO);
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
