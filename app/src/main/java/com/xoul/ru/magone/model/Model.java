package com.xoul.ru.magone.model;

import com.xoul.ru.magone.Subject;

public class Model implements Subject{
    GameField gameField;
    public void Model(){
        gameField = new GameField();

    }
    @Override
    public void addObserver(Object object) {

    }

    @Override
    public void removeObserver(Object object) {

    }

    @Override
    public void notifyObserver(Object object) {

    }
}
