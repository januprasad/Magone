package com.xoul.ru.magone.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xoul.ru.magone.model.spells.SpellStorage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class Serializer {
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.create();
    BufferedReader br;
    SpellStorage spellStorage;

    public Serializer() throws FileNotFoundException {

    }

    public SpellStorage parse(SpellStorage spellStorage) throws FileNotFoundException {
        br = new BufferedReader(new FileReader("src/main/res/Spells.JSON"));
        spellStorage = gson.fromJson(br, SpellStorage.class);
        System.out.println(gson.toJson(spellStorage));
        return spellStorage;
    }

}
