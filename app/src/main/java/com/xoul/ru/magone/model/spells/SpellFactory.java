package com.xoul.ru.magone.model.spells;

import com.xoul.ru.magone.model.Damage;
import com.xoul.ru.magone.model.EffectType;
import com.xoul.ru.magone.model.Heal;
import com.xoul.ru.magone.model.Rune;

import java.util.List;

import static com.xoul.ru.magone.model.GameModel.getEnemy;

public class SpellFactory {
    public static Spell create(List<Rune> list) {
        if (list.size() == 1) {
            if (list.get(0) == Rune.FIRE) {
                return new Spell(getEnemy(), SpellType.Damage, null, new Damage(5, EffectType.FIRE),list.size());  //���������� ���� ���������  ���� � �������� ������ �������
            } else if (list.get(0) == Rune.WATER) {
                return new Spell(getEnemy(), SpellType.Damage, null, new Damage(0, EffectType.WET),list.size());  //���������� ���� �� ��������� ���� � �������� ������ �������
            } else if (list.get(0) == Rune.lIFE) {
                return new Spell(getEnemy(), SpellType.Heal, new Heal(4), new Damage(0, EffectType.HEAL),list.size());  //���������� ��������� ������� �����������������  ��������
            }
            return null;
        } else {
            return null;
        }
    }
}
