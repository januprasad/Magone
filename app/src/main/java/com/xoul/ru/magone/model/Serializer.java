package com.xoul.ru.magone.model;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.xoul.ru.magone.model.spells.SpellStorage;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;


public class Serializer {
    private GsonBuilder gsonBuilder = new GsonBuilder();
    private Gson gson = gsonBuilder.create();
    InputStreamReader inputStreamReader;

    public Serializer(InputStream inputStream) throws FileNotFoundException {
        inputStreamReader = new InputStreamReader(inputStream);
    }

    public SpellStorage parse(SpellStorage spellStorage) throws FileNotFoundException {
        spellStorage = gson.fromJson(inputStreamReader, SpellStorage.class);
        System.out.println(gson.toJson(spellStorage));
        return spellStorage;
    }

}
