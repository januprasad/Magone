package com.xoul.ru.magone.model;

import com.xoul.ru.magone.Observer;
import com.xoul.ru.magone.Subject;
import com.xoul.ru.magone.view.GameField;

public class GameModel implements Subject {
    Observer view;
    PlayerModel currentPlayer;
    PlayerModel player1;
    PlayerModel player2;
    public void Model() {
        player1 = new PlayerModel();
        player2 = new PlayerModel();
    }
    public void endOfTurn(){
        currentPlayer.clearCurrenSpell();
        currentPlayer.endOfTurn();
        currentPlayer.clearEffects();
        if(currentPlayer==player1)
            currentPlayer=player2;
        else{
            currentPlayer=player1;
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
