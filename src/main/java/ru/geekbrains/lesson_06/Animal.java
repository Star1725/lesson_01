package ru.geekbrains.lesson_06;

/**
 * Created by User on 018 18.07.20.
 */
public abstract class Animal {

    protected String name;
    private static int countAnimals;

    public Animal(String name) {
        this.name = name;
        countAnimals++;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }
}
