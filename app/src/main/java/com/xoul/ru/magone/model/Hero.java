package com.xoul.ru.magone.model;

public class Hero {
    private int currenthp;
    private final int MAXHP;

    public Hero(int MAXHP) {
        this.MAXHP = MAXHP;
        currenthp = MAXHP;

    }

    public int getCurrenthp() {
        return currenthp;
    }

    public void damage(int damage){
        currenthp-=damage;
    }
}
