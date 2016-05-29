package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.PlayerModel;

public class Spell {
    public SpellType spellType;
    public Heal heal;
    public EffectType effectType;
    public Damage damage;
    public PlayerModel target;
    public int manaAmountToCut;
    private boolean settingEffect = true;

    public Spell(PlayerModel target, SpellType spellType, Heal heal, Damage damage, int manaAmountToCut) {
        this.target = target;
        this.spellType = spellType;
        this.heal = heal;
        this.damage = damage;
        this.manaAmountToCut = manaAmountToCut;
        if (damage != null)
            effectType = damage.effectType;
    }

    public boolean isSettingEffect() {
        return settingEffect;
    }

    public void findOppositEffect() {
        settingEffect = false;
    }
}
