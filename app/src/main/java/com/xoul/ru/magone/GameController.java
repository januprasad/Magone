package com.xoul.ru.magone;

import android.util.Log;

import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.PlayerModel;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.view.Drawer;
import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.PlayerListener;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField;

import java.util.List;

public class GameController implements PlayerListener {
    private GameModel model;
    private Drawer drawer;

    private PlayerField player1;
    private PlayerField player2;
    private boolean isPlayer1;

    private PlayerModel player1model;
    private PlayerModel player2model;

    private List<Rune> spell;

    public GameController(GameModel model, PlayerField player1, PlayerField player2) {
        this.model = model;
        this.player1 = player1;
        this.player2 = player2;
        this.player1.setListener(this);
        this.player2.setListener(this);
        drawer = new Drawer(model, player1, player2);
        isPlayer1 = model.getCurrentPlayer() == model.getPlayer1();
        this.player1.setEnabled(isPlayer1);
        this.player2.setEnabled(!isPlayer1);
    }

    private void togglePlayer() {
        isPlayer1 = !isPlayer1;
        player1.setEnabled(isPlayer1);
        player2.setEnabled(!isPlayer1);
    }

    private PlayerField getCurrentPlayerField() {
        if (isPlayer1) {
            return player1;
        } else {
            return player2;
        }
    }

    @Override
    public void onCast(List<Rune> spell) {
        // TODO target spell casting
        if (/* model.isTargetingSpell(spell) */ spell.size() > 1) {
            this.spell = spell;
            getCurrentPlayerField().setChooseUnit(true);
        } else {
            this.spell = null;
            model.getCurrentPlayer().addRuneToCurrentSpell(spell);
            model.castASpell();
        }
    }

    @Override
    public void onUnitSelected(Unit unit, UnitField.Slot slot) {
        // TODO target spell casting
        if (spell != null) {
            getCurrentPlayerField().setChooseUnit(false); /* model.castASpell(spell, slot or player); */
            Log.d("Controller", "cast unit spell");
            spell = null;
        }
    }

    @Override
    public void onClear() {
        spell = null;
    }

    @Override
    public void onNextTurn() {
        model.endOfTurn();
        togglePlayer();
    }
}
