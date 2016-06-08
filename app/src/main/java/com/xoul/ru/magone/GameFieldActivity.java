package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.view.Drawer;
import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.PlayerListener;

import java.io.FileNotFoundException;
import java.util.List;

public class GameFieldActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        PlayerField playerField1 = (PlayerField) findViewById(R.id.playerField1);
        PlayerField playerField2 = (PlayerField) findViewById(R.id.playerField2);
        GameModel model = null;
        try {
            model = new GameModel();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        GameController controller = new GameController(model, playerField1, playerField2);
    }
}
