package com.xoul.ru.magone.model.entitys;

public class EndOfTurnEffectEntity extends Entity {
    public EndOfTurnEffectEntity(int MaxSteps) {
        this.MaxSteps = MaxSteps;
        this.StepsToGo = MaxSteps;
    }

}
