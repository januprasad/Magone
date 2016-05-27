package com.xoul.ru.magone.model;

import com.xoul.ru.magone.model.effects.BurningEffect;
import com.xoul.ru.magone.model.effects.DeathEffect;
import com.xoul.ru.magone.model.spells.Spell;
import com.xoul.ru.magone.model.spells.SpellFactory;
import com.xoul.ru.magone.model.spells.SpellType;

import java.util.List;

public class PlayerModel {
    private Hero hero;
    private int mp;
    private int maxSpellLength;
    public List<Effect> currentEffects;
    public List<Rune> currentSpell;
    private Spell spell;

    public PlayerModel(Hero hero, int mp, List<Rune> currentSpell, List<Effect> currentEffects) {
        this.hero = hero;
        this.mp = mp;
        this.currentSpell = currentSpell;
        this.currentEffects = currentEffects;
    }

    public int getHp() {
        return hero.getCurrenthp();
    }

    public int getMp() {
        return mp;
    }

    //Приводит в действие переданное заклинание, проверяя его тип и изменяя в соответсвии с имющимися эффектами
    public void setSpell(Spell spell,PlayerModel enemy) {
        if (spell.spellType == SpellType.Damage) {
            for (Effect eff : enemy.currentEffects) {
                eff.damage(spell.damage);
                eff.isOpposite(spell.effectType);//проверяем вешать ли еффект
            }
            //наносим урон цели
            if (spell.damage.damage > 0)
                spell.target.damage(spell.damage);
        }
        if (spell.spellType == SpellType.Heal) {
            for (Effect eff : enemy.currentEffects) {
                eff.heal(spell.heal);
                eff.isOpposite(spell.effectType);//проверяем вешать ли еффект
            }
            //лечим цель
            if (spell.heal.heal > 0)
                spell.target.heal(spell.heal);
        }
        if (spell.spellType == SpellType.Buff) {

        }
        //вешаем эффект
        if (spell.isSettingEffect() && spell.effectType!=null) addEffect(spell.effectType);
        mp-=spell.manaAmountToCut;

    }

    //Наносит целочисленный урон игроку
    public void damage(Damage dmg) {
        hero.damage(dmg);
    }

    //Добавляет игроку какое-то целочисленное количество жизней
    public void heal(Heal heal) {
        hero.heal(heal);
    }

    //Добавляет руну по которой кликнули в текущий лист хранящий набранное заклинание
    public void addRuneToCurrenSpell(Rune rune) {
        currentSpell.add(rune);
    }

    //добавляет к текущим эффектам висящим на игроке новый переданного типа
    public void addEffect(EffectType effectType) {
        Effect effect = null;
        if (effectType == EffectType.FIRE) {
            effect = new BurningEffect(Constants.BURNINGTIME, true, effectType,0,2);
        }
        if (effectType == EffectType.DEATH) {
            effect = new DeathEffect(Constants.DEATHTIME, true, effectType,0,2);
        }
        if (effectType == EffectType.HEAL) {
            effect = new BurningEffect(Constants.HEALTIME, true, effectType,2,0);
        }
        if (effectType == EffectType.WET) {
            effect = new BurningEffect(Constants.WETTIME, true, effectType,0,0);
        }
        for (Effect eff : currentEffects) {
            if (eff.type == EffectType.FIRE)
                currentEffects.remove(eff);
        }
        if (effect != null)
            currentEffects.add(effect);
    }

    //очищает текущий лист заклинаний
    public void clearCurrenSpell() {
        currentSpell.clear();
    }

    //очищает эффекты у которых либо закончилось время действия либо которые были сняты другим эффектом
    public void clearEffects() {
        for (Effect eff : currentEffects) {
            if (!eff.isAvailable()) currentEffects.remove(eff);
        }
    }

    //для каждого эффекта из текущих вызывает метод оповещающий эффекты о конце текущего хода
    public void endOfTurn(PlayerModel currentPlayer) {
        for (Effect eff : currentEffects) {
            eff.endOfTurn(currentPlayer);
        }
    }

    //собирает заклинание из уже переданных
    public Spell createSpell() {
        spell = SpellFactory.create(currentSpell);
        return spell;
    }

    public void endTurnEffect(int heal , int damage) {
        heal(new Heal(heal));
        damage(new Damage(damage,null));
    }
}
