package ru.geekbrains.lesson_06;

/**
 * Created by User on 018 18.07.20.
 */
public abstract class Animal {

    protected int maxRangeToRun;
    protected int maxRangeToSwim;
    protected double maxRangeToJump;

    protected String name;
    private static int countAnimals;

    public Animal(String name, int maxRangeToRun, int maxRangeToSwim, double maxRangeToJump) {
        this.maxRangeToRun = maxRangeToRun;
        this.maxRangeToSwim = maxRangeToSwim;
        this.maxRangeToJump = maxRangeToJump;
        this.name = name;
        countAnimals++;
    }

    public static double getRandomRange(double n, double defaultMax){
        double factor;
        if (n >= 1) factor = 1;
        else factor = 0.1;
        return defaultMax + Math.random() * -(n*2 + factor) + n;
    }

    public static int getCountAnimals() {
        return countAnimals;
    }
}
