package com.xoul.ru.magone.model;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class PlayerModelTest {

    GameModel gm = new GameModel();
    @Test
    public void testGetHp() throws Exception {
      assertEquals("Прийденное хп не соответсвует",50,gm.getPlayer1().getHp());
    }

    @Test
    public void testGetMp() throws Exception {

    }

    @Test
    public void testSetSpell() throws Exception {

    }

    @Test
    public void testDamage() throws Exception {

    }

    @Test
    public void testHeal() throws Exception {

    }

    @Test
    public void testAddRuneToCurrenSpell() throws Exception {

    }

    @Test
    public void testAddEffect() throws Exception {

    }

    @Test
    public void testClearCurrenSpell() throws Exception {

    }

    @Test
    public void testClearEffects() throws Exception {

    }

    @Test
    public void testEndOfTurn() throws Exception {

    }

    @Test
    public void testCreateSpell() throws Exception {

    }

    @Test
    public void testEndTurnEffect() throws Exception {

    }
}