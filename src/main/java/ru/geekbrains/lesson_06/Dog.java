package ru.geekbrains.lesson_06;

/**
 * Created by User on 018 18.07.20.
 */
public class Dog extends Animal implements Action{

    private final int MAX_RANGE_TO_RUN = 500;
    private final int MAX_RANGE_TO_SWIM = 10;

    public static int getCountDogs() {
        return countDogs;
    }

    private static int countDogs;

    public Dog(String name) {
        super(name);
        countDogs++;
    }

    @Override
    public void run(int range) {
        if (range > MAX_RANGE_TO_RUN) System.out.println(this.name + " не смог пробежать " + range + " метров");
        else System.out.println(this.name + " пробежал " + range + " метров");
    }

    @Override
    public void swim(int range) {
        if (range > MAX_RANGE_TO_SWIM) System.out.println(this.name + " не смог проплыть " + range + " метров");
        else System.out.println(this.name + " проплыл " + range + " метров");
    }
}
