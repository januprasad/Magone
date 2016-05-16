package com.xoul.ru.magone;

public interface Subject {
    void addObserver(Object object);
    void removeObserver(Object object);
    void notifyObserver(Object object);
}
