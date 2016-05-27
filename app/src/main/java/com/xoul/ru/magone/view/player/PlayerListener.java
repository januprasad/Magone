package com.xoul.ru.magone.view.player;

import com.xoul.ru.magone.model.Rune;

import java.util.List;

public interface PlayerListener {

    void onCast(List<Rune> spell);
    void onNextTurn();

}
