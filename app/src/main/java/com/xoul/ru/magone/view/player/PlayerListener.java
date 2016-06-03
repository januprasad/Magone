package com.xoul.ru.magone.view.player;

import com.xoul.ru.magone.model.Rune;
import com.xoul.ru.magone.view.player.unit.Unit;
import com.xoul.ru.magone.view.player.unit.UnitField.Slot;

import java.util.List;

public interface PlayerListener {

    void onCast(List<Rune> spell);
    void onUnitSelected(Unit unit, Slot slot);
    void onClear();
    void onNextTurn();

}
