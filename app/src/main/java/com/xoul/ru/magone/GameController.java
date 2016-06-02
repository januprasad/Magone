package com.xoul.ru.magone;

import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.PlayerModel;
import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.view.Drawer;
import com.xoul.ru.magone.view.player.PlayerField;
import com.xoul.ru.magone.view.player.PlayerListener;

import java.util.List;

public class GameController implements PlayerListener {
    private GameModel model;
    private Drawer drawer;

    private PlayerField player1;
    private PlayerField player2;
    private boolean isPlayer1;

    private PlayerModel player1model;
    private PlayerModel player2model;

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

    @Override
    public void onCast(List<Rune> spell) {
        model.getCurrentPlayer().addRuneToCurrentSpell(spell);
        model.castASpell();
    }

    @Override
    public void onNextTurn() {
        model.endOfTurn();
        togglePlayer();
    }
}
