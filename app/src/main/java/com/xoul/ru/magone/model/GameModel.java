package com.xoul.ru.magone.model;

import com.xoul.ru.magone.Observer;
import com.xoul.ru.magone.Subject;
import com.xoul.ru.magone.model.spells.Spell;

import java.util.LinkedList;

public class GameModel implements Subject {
    Observer view;
    private static PlayerModel currentPlayer;
    private static  PlayerModel player1;
    private static  PlayerModel player2;

    static {
        player1 = new PlayerModel(new Hero(50), 2, new LinkedList<Rune>(), new LinkedList<Effect>());
        player2 = new PlayerModel(new Hero(50), 2, new LinkedList<Rune>(), new LinkedList<Effect>());
        currentPlayer = player1;
    }

    public void endOfTurn() {
        currentPlayer.clearCurrenSpell();
        currentPlayer.endOfTurn(currentPlayer);
        currentPlayer.clearEffects();
        if (currentPlayer == player1)
            currentPlayer = player2;
        else {
            currentPlayer = player1;
        }
    }

    public void castASpell() {
        Spell sp = currentPlayer.createSpell();
        if(currentPlayer.getMp() >= sp.manaAmountToCut)
        currentPlayer.setSpell(sp,getEnemy());
        currentPlayer.clearCurrenSpell();
    }

    public static PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }

    public static PlayerModel getEnemy() {
        if (player1 == currentPlayer) {
            return player2;
        } else {
            return player1;
        }
    }

    public static  PlayerModel getPlayer1() {
        return player1;
    }

    public static  PlayerModel getPlayer2() {
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
