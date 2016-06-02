package com.xoul.ru.magone.model;

import com.xoul.ru.magone.Observer;
import com.xoul.ru.magone.Subject;
import com.xoul.ru.magone.model.spells.Spell;

import java.util.LinkedList;

public class GameModel implements Subject {
    Observer view;
    private PlayerModel currentPlayer;
    private PlayerModel player1;
    private PlayerModel player2;

    public GameModel() {
        player1 = new PlayerModel(new Hero(50), 10, new LinkedList<Rune>(), new LinkedList<Effect>());
        player2 = new PlayerModel(new Hero(50), 10, new LinkedList<Rune>(), new LinkedList<Effect>());
        currentPlayer = player1;
    }

    public void endOfTurn() {
        currentPlayer.clearCurrenSpell();
        currentPlayer.endOfTurn(currentPlayer);
        currentPlayer.clearEffects();
        getEnemy().clearEffects();
        if (currentPlayer == player1)
            currentPlayer = player2;
        else {
            currentPlayer = player1;
        }
        notifyObserver();
    }

    public void castASpell() {
        Spell sp = currentPlayer.createSpell(currentPlayer, getEnemy());
        if (sp != null)
            if (currentPlayer.getMp() >= sp.manaAmountToCut)
                currentPlayer.setSpell(sp);
        currentPlayer.clearCurrenSpell();
        getEnemy().clearEffects();
        notifyObserver();
    }

    public PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerModel getEnemy() {
        if (player1 == currentPlayer) {
            return player2;
        } else {
            return player1;
        }
    }

    public PlayerModel getPlayer1() {
        return player1;
    }

    public PlayerModel getPlayer2() {
        return player2;
    }

    @Override
    public void addObserver(Observer observer) {
        view = observer;
    }

    @Override
    public void removeObserver(Observer observer) {
        view = null;
    }

    @Override
    public void notifyObserver() {
        view.update();
    }

}
