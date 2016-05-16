package com.xoul.ru.magone.model;

public class PlayerFiled {
    BarField barField;
    UnitField unitField;
    RunesField runesField;
    ControleField controleField;
    private boolean isReverse;

    public PlayerFiled() {
        barField = new BarField();
        unitField = new UnitField();
        runesField = new RunesField();
        controleField = new ControleField();
    }

    public BarField getBarField() {
        return barField;
    }

    public UnitField getUnitField() {
        return unitField;
    }

    public RunesField getRunesField() {
        return runesField;
    }

    public ControleField getControleField() {
        return controleField;
    }

    public boolean isReverse() {
        return isReverse;
    }
}
