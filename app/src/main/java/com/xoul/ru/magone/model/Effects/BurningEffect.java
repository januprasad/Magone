package com.xoul.ru.magone.model.Effects;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Effect;

public class BurningEffect extends Effect {


    public BurningEffect(int timeleft, boolean available, EffectType type) {
        super(timeleft, available, type);
    }

    @Override
    public Damage damage(Damage damage) {
        if(damage.effectType == EffectType.Wet)
        damage.damage -= 3;
        return damage;
    }

    @Override
    public boolean isOpposite(EffectType type) {
        if (type == EffectType.Wet)
            return true;
        return false;
    }
}
