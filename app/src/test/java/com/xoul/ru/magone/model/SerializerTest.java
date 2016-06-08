package com.xoul.ru.magone.model;

import com.xoul.ru.magone.model.spells.SpellStorage;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class SerializerTest {

    Serializer s = new Serializer(new SpellStorage());

    @Test
    public void testParse() throws Exception {
        s.parse();
        List<Rune> list = new LinkedList<Rune>();
     //   list.add(Rune.LIFE);
        list.add(Rune.FIRE);
        s.spellStorage.getSpellDescriptor(list);
    }
}