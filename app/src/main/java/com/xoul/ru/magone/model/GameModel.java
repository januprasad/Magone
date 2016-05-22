package com.xoul.ru.magone.model;

import com.xoul.ru.magone.Observer;
import com.xoul.ru.magone.Subject;

public class GameModel implements Subject {
    Observer view;
    private static PlayerModel currentPlayer;
    private static PlayerModel player1;
    private static PlayerModel player2;

    public void Model() {
        player1 = new PlayerModel();
        player2 = new PlayerModel();
    }

    public void endOfTurn() {
        currentPlayer.clearCurrenSpell();
        currentPlayer.endOfTurn();
        currentPlayer.clearEffects();
        if (currentPlayer == player1)
            currentPlayer = player2;
        else {
            currentPlayer = player1;
        }
    }

    public void castASpell() {
        currentPlayer.setSpell(currentPlayer.createSpell());
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
