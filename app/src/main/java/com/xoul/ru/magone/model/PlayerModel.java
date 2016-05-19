package com.xoul.ru.magone.model;

import java.util.List;

public class PlayerModel {
    private Hero hero;
    private int mp;
    private int maxSpellLength;
    private List<Effect> currentEffects;
    private List<Rune> currentSpell;
    Effect eff;

    public int getHp(){
        return hero.getCurrenthp();
    }
    public void damage(){

    }
}
