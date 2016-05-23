package com.xoul.ru.magone.view.player;

import android.content.Context;

import com.xoul.ru.magone.view.player.control.ControlField;
import com.xoul.ru.magone.view.player.info.PlayerInfoField;
import com.xoul.ru.magone.view.player.rune.RuneField;
import com.xoul.ru.magone.view.player.unit.UnitField;

public class PlayerField extends android.view.View {
    PlayerInfoField playerInfoField;
    UnitField unitField;
    RuneField runeField;
    ControlField controlField;
    private boolean isReverse;

    public PlayerField(Context context) {
        super(context);
    }
//
//    public PlayerField() {
//        barField = new BarField();
//        unitField = new UnitField();
//        runesField = new RunesField();
//        controleField = new ControleField();
//    }


}
