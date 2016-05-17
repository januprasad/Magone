package com.xoul.ru.magone.model;

public class PlayerField {
    BarField barField;
    UnitField unitField;
    RunesField runesField;
    ControleField controleField;
    private boolean isReverse;

    public PlayerField() {
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
