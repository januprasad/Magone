package com.xoul.ru.magone.model.effects;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.Effect;
import com.xoul.ru.magone.model.EffectType;

public class WetEffect extends Effect {
    public WetEffect(int timeleft, boolean available, EffectType type) {
        super(timeleft, available, type);
    }

    @Override
    public Damage damage(Damage damage) {
        if(damage.effectType == EffectType.Fire)
            damage.damage-=3;
        return damage;
    }

    @Override
    public boolean isOpposite(EffectType type) {
        return false;
    }
}
