package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Rune;

import java.util.List;

import static com.xoul.ru.magone.model.GameModel.getEnemy;

public class SpellFactory {
    public static Spell create(List<Rune> list){
      if(list.size() == 1){
          if(list.get(0) == Rune.FIRE){
              return new Spell(getEnemy(),SpellType.Damage,null,new Damage(5,EffectType.Fire));
          }
          return null;
      }else{
          return null;
      }
    }
}
