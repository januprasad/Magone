package com.xoul.ru.magone.model;

import com.xoul.ru.magone.Observer;
import com.xoul.ru.magone.Subject;
import com.xoul.ru.magone.model.spells.Spell;
import com.xoul.ru.magone.model.spells.SpellDescriptor;
import com.xoul.ru.magone.model.spells.SpellStorage;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Map;

public class GameModel implements Subject {
    static SpellStorage spellStorage;
    Observer view;
    Serializer serializer;
    private PlayerModel currentPlayer;
    private PlayerModel player1;
    private PlayerModel player2;
    private int round;

    public GameModel(Serializer serializer) throws FileNotFoundException {
        spellStorage = new SpellStorage();
        this.serializer = serializer;
        spellStorage = serializer.parse(spellStorage);
        player1 = new PlayerModel(new Hero(50, 1), 2, new LinkedList<Rune>(), new LinkedList<Effect>(), spellStorage);
        player2 = new PlayerModel(new Hero(35, 2), 2, new LinkedList<Rune>(), new LinkedList<Effect>(), spellStorage);
        currentPlayer = player1;
    }

    public void endOfTurn() {
        round++;
        currentPlayer.clearCurrenSpell();
        currentPlayer.endOfTurn(currentPlayer);
        currentPlayer.clearEffects();
        getEnemy().clearEffects();
        if (round % 2 == 0) {
            getEnemy().addMP();
            currentPlayer.addMP();
        }
        if (currentPlayer == player1)
            currentPlayer = player2;
        else {
            currentPlayer = player1;
        }
        notifyObserver();
    }

    public void castASpell() {
        Spell sp = currentPlayer.createSpell(currentPlayer, getEnemy());
        if (currentPlayer.getMp() >= sp.manaAmountToCut)
            currentPlayer.setSpell(sp);
        currentPlayer.clearCurrenSpell();
        getEnemy().clearEffects();
        notifyObserver();
    }

    public PlayerModel getCurrentPlayer() {
        return currentPlayer;
    }

    public PlayerModel getEnemy() {
        if (player1 == currentPlayer) {
            return player2;
        } else {
            return player1;
        }
    }

    public PlayerModel getPlayer1() {
        return player1;
    }

    public PlayerModel getPlayer2() {
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

    public Map<String, SpellDescriptor> getSpellMap() {
        return spellStorage.getSpellMap();
    }
}
