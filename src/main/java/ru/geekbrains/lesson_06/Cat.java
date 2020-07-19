package ru.geekbrains.lesson_06;

/**
 * Created by User on 018 18.07.20.
 */
public class Cat extends Animal implements Action {

    public static final int MAX_RANGE_TO_RUN = 200;
    public static final double MAX_RANGE_TO_JUMP = 2;
    public static final int MAX_RANGE_TO_SWIM = 0;

    public Cat(String name, int countRandomToRun, double countRandomToJump) {
        super(name,
                (int) getRandomRange(countRandomToRun, MAX_RANGE_TO_RUN),
                MAX_RANGE_TO_SWIM,
                getRandomRange(countRandomToJump, MAX_RANGE_TO_JUMP));
        countCats++;
    }

    public static int getCountCats() {
        return countCats;
    }

    private static int countCats;

    @Override
    public void run(int range) {
        if (range > this.maxRangeToRun) System.out.println(this.name + " не смог пробежать " + range + " метров. Max для него = " + this.maxRangeToRun);
        else System.out.println(this.name + " пробежал " + range + " метров");
    }

    @Override
    public void swim(int range) {
        System.out.println(this.name + " не умеет плавать!");
    }

    @Override
    public void jump(double height) {
        if (height > this.maxRangeToJump) System.out.println(this.name + " не смог перепрыгнуть препятствие высотой " + String.format("%.2f", height) + " метров. Max для него = " + String.format("%.2f", this.maxRangeToJump));
        else System.out.println(this.name + " перепрыгнул препятствие высотой " + String.format("%.2f", height) + " метров");
    }
}
