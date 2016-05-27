package com.xoul.ru.magone.model;

import com.xoul.ru.magone.model.effects.DeathEffect;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerModelTest {

    GameModel gm = new GameModel();

    @Test
    public void testGetHp() throws Exception {
        assertEquals("Полученное хп не верно", 50, gm.getPlayer1().getHp());
    }

    @Test
    public void testGetMp() throws Exception {
        assertEquals("Полученное mp не верно", 2, gm.getPlayer1().getMp());

    }

    @Test
    public void testSetSpell() throws Exception {
        int hp;
        gm.getPlayer1().addRuneToCurrenSpell(Rune.FIRE);
        gm.getPlayer1().setSpell(gm.getPlayer1().createSpell(), gm.getPlayer2());
        hp = gm.getPlayer2().getHp();
        assertEquals("Тест валится на заклинании огня", hp - Constants.SMALLFIREDAMAGE, GameModel.getPlayer2().getHp());
        gm.getPlayer1().addRuneToCurrenSpell(Rune.DEATH);
        gm.getPlayer1().setSpell(gm.getPlayer1().createSpell(), gm.getPlayer2());
        hp = gm.getPlayer2().getHp();
        assertEquals("Тест валится на заклинании смерти", hp - Constants.SMALLDEATHAMMOUNT, GameModel.getPlayer2().getHp());
        gm.getPlayer1().addRuneToCurrenSpell(Rune.WATER);
        gm.getPlayer1().setSpell(gm.getPlayer1().createSpell(), gm.getPlayer2());
        hp = gm.getPlayer2().getHp();
        assertEquals("Тест валится на заклинании водицы", hp - Constants.SMALLWATERAMMOUNT, GameModel.getPlayer2().getHp());
        gm.getPlayer1().addRuneToCurrenSpell(Rune.LIFE);
        gm.getPlayer1().setSpell(gm.getPlayer1().createSpell(), gm.getPlayer2());
        hp = gm.getPlayer2().getHp();
        assertEquals("Тест валится на заклинании лечения", hp + Constants.SMALLHEALAMMOUNT, GameModel.getPlayer2().getHp());
    }

    @Test
    public void testDamage() throws Exception {
        int hp = gm.getPlayer1().getHp();
        gm.getPlayer1().damage(new Damage(3, EffectType.DEATH));
        assertEquals("Что то не так с дамагом", hp - 3, gm.getPlayer1().getHp());
        hp = gm.getPlayer1().getHp();
        gm.getPlayer1().damage(new Damage(6, EffectType.DEATH));
        assertEquals("Что то не так с дамагом", hp - 6, gm.getPlayer1().getHp());
        hp = gm.getPlayer1().getHp();
        gm.getPlayer1().damage(new Damage(-2, EffectType.DEATH));
        assertEquals("Что то не так с дамагом", hp, gm.getPlayer1().getHp());
    }

    @Test
    public void testHeal() throws Exception {
        int hp = gm.getPlayer1().getHp();
        gm.getPlayer1().heal(new Heal(3));
        assertEquals("Что то не так с хилом", hp + 3, gm.getPlayer1().getHp());
        gm.getPlayer1().heal(new Heal(300));
        assertEquals("Что то не так с хилом", 50, gm.getPlayer1().getHp());
        gm.getPlayer1().heal(new Heal(-300));
        assertEquals("Что то не так с хилом", 50, gm.getPlayer1().getHp());
    }

    @Test
    public void testAddEffect() throws Exception {
        gm.getPlayer1().addEffect(EffectType.DEATH);
        assertEquals("Добавлен не тот эффект или не добаввлен вовсе", true, gm.getPlayer1().currentEffects.contains(new DeathEffect(Constants.DEATHTIME, true, EffectType.DEATH, 0, 2)));
    }

}