package ru.geekbrains.lesson_06;

/**
 * Created by User on 018 18.07.20.
 */
public class Cat extends Animal implements Action {

    private final int MAX_RANGE_TO_RUN = 200;

    public static int getCountCats() {
        return countCats;
    }

    private static int countCats;

    public Cat(String name) {
        super(name);
        countCats++;
    }

    @Override
    public void run(int range) {
        if (range > MAX_RANGE_TO_RUN) System.out.println(this.name + " не смог пробежать " + range + " метров");
        else System.out.println(this.name + " пробежал " + range + " метров");
    }

    @Override
    public void swim(int range) {
        System.out.println(this.name + " не умеет плвать!");
    }
}
