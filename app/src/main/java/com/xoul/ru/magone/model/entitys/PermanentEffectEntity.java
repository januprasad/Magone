package com.xoul.ru.magone.model.entitys;

public class PermanentEffectEntity extends Entity {
    public PermanentEffectEntity(int MaxSteps) {
        this.MaxSteps = MaxSteps;
        this.StepsToGo = MaxSteps;
    }
}
