package com.xoul.ru.magone.model;

public class Hero {
    private int currenthp;
    private final int MAXHP;

    public int getMAXHP() {
        return MAXHP;
    }

    public Hero(int MAXHP) {
        this.MAXHP = MAXHP;
        currenthp = MAXHP;

    }

    public int getCurrenthp() {
        return currenthp;
    }

    public void damage(Damage damage) {
        if (damage.damage >= 0)
            currenthp -= damage.damage;
    }

    public void heal(Heal heal) {
        if (heal.heal >= 0)
            currenthp += heal.heal;
        if (currenthp > MAXHP) currenthp = MAXHP;
    }
}
