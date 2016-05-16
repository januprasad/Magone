package com.xoul.ru.magone.model;

import static com.xoul.ru.magone.model.Runes.*;

public class RunesField {
    Runes runes[];

    public RunesField() {
        runes = new Runes[6];
        runes[0] = Frost;
        runes[1] = Fire;
        runes[2] = Death;
        runes[3] = lifeEnergy;
        runes[4] = Ground;
        runes[5] = Water;
    }

}
