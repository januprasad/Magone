package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Constants;
import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.GameModel;
import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.Rune;

import java.util.List;


public class SpellFactory {
    GameModel gameModel;
    public SpellFactory(GameModel gameModel) {
        this.gameModel = gameModel;
    }

    public Spell create(List<Rune> list) {
        if (list.size() == 1) {
            if (list.get(0) == Rune.FIRE) {
                return new Spell(gameModel.getEnemy(), SpellType.Damage, null, new Damage(Constants.SMALLFIREDAMAGE, EffectType.FIRE), list.size());  //Заклинание огня наносящее  урон и вешающее эффект горения
            } else if (list.get(0) == Rune.WATER) {
                return new Spell(gameModel.getEnemy(), SpellType.Damage, null, new Damage(Constants.SMALLWATERAMMOUNT, EffectType.WET), list.size());  //Заклинание воды не наносящее урон и вешающее эффект сырости
            } else if (list.get(0) == Rune.lIFE) {
                return new Spell(gameModel.getCurrentPlayer(), SpellType.Heal, new Heal(Constants.SMALLHEALAMMOUNT), new Damage(0, EffectType.HEAL), list.size());  //Заклинание жизненной энергии восстанавливающее  здоровье
            } else if (list.get(0) == Rune.DEATH) {
                return new Spell(gameModel.getEnemy(), SpellType.Damage, null, new Damage(Constants.SMALLDEATHAMMOUNT, EffectType.DEATH), list.size());  //Заклинание воды не наносящее урон и вешающее эффект сырости
            }
            return null;
        } else

        {
            return null;
        }
    }
}
