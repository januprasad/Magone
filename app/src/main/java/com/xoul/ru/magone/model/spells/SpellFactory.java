package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Constants;
import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.Rune;

import java.util.List;

import static com.xoul.ru.magone.model.GameModel.getCurrentPlayer;
import static com.xoul.ru.magone.model.GameModel.getEnemy;

public class SpellFactory {
    public static Spell create(List<Rune> list) {
        if (list.size() == 1) {
            if (list.get(0) == Rune.FIRE) {
                return new Spell(getEnemy(), SpellType.Damage, null, new Damage(Constants.SMALLFIREDAMAGE, EffectType.FIRE), list.size());  //Заклинание огня наносящее  урон и вешающее эффект горения
            } else if (list.get(0) == Rune.WATER) {
                return new Spell(getEnemy(), SpellType.Damage, null, new Damage(Constants.SMALLWATERAMMOUNT, EffectType.WET), list.size());  //Заклинание воды не наносящее урон и вешающее эффект сырости
            } else if (list.get(0) == Rune.LIFE) {
                return new Spell(getCurrentPlayer(), SpellType.Heal, new Heal(Constants.SMALLHEALAMMOUNT), null, list.size());  //Заклинание жизненной энергии восстанавливающее  здоровье
            } else if (list.get(0) == Rune.DEATH) {
                return new Spell(getEnemy(), SpellType.Damage, null, new Damage(Constants.SMALLDEATHAMMOUNT, EffectType.DEATH), list.size());  //Заклинание воды не наносящее урон и вешающее эффект сырости
            }
            return null;
        } else

        {
            return null;
        }
    }
}
