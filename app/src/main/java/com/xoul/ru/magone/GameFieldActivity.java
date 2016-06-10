package com.xoul.ru.magone;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.Serializer;
import com.xoul.ru.magone.view.player.PlayerField;

import java.io.IOException;
import java.io.InputStream;

public class GameFieldActivity extends Activity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_field);
        PlayerField playerField1 = (PlayerField) findViewById(R.id.playerField1);
        PlayerField playerField2 = (PlayerField) findViewById(R.id.playerField2);
        GameModel model = null;
        try {
            InputStream inputStream = getResources().openRawResource(R.raw.spells);
            Serializer serializer = new Serializer(inputStream);
            model = new GameModel(serializer);
        } catch (IOException e) {
            e.printStackTrace();
            Log.d("GameFieldActivity:","Shit happens");
        }
        GameController controller = new GameController(model, playerField1, playerField2);
    }
}
