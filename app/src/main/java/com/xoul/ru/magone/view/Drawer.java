package com.xoul.ru.magone.view;

import android.util.Log;

import com.xoul.ru.magone.Observer;
import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField.Slot;

public class Drawer implements Observer {
    private GameModel model;
    private PlayerField player1;
    private PlayerField player2;

    public Drawer(GameModel model, PlayerField player1, PlayerField player2) {
        this.model = model;
        this.player1 = player1;
        this.player2 = player2;
        model.addObserver(this);
        initViews();
    }

    private void initViews() {
        int maxHp1 = model.getPlayer1().getMaxHp();
        int hp1 = model.getPlayer1().getHp();
        Unit hero1 = player1.getUnitField().getUnit(Slot.HERO);
        hero1.setMaxHp(maxHp1);
        hero1.setHp(hp1);

        int maxHp2 = model.getPlayer2().getMaxHp();
        int hp2 = model.getPlayer2().getHp();
        Unit hero2 = player2.getUnitField().getUnit(Slot.HERO);
        hero2.setMaxHp(maxHp2);
        hero2.setHp(hp2);

        player1.getPlayerInfoField().setMaxMp(10);
        player2.getPlayerInfoField().setMaxMp(10);

        update();
    }

    @Override
    public void update() {
        int hp1 = model.getPlayer1().getHp();
        int mp1 = model.getPlayer1().getMp();
        Unit hero1 = player1.getUnitField().getUnit(Slot.HERO);
        hero1.setHp(hp1);
        player1.getPlayerInfoField().setMp(mp1);

        int hp2 = model.getPlayer2().getHp();
        int mp2 = model.getPlayer2().getMp();
        Unit hero2 = player2.getUnitField().getUnit(Slot.HERO);
        hero2.setHp(hp2);
        player2.getPlayerInfoField().setMp(mp2);

        Log.d("Drawer", "update: hp1 = " + hp1 + " hp2 = " + hp2);
        Log.d("Drawer", "update: mp1 = " + mp1 + " mp2 = " + mp2);
    }
}
