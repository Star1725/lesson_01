package ru.geekbrains.lesson_06;

/**
 * Created by User on 018 18.07.20.
 */
public class Dog extends Animal implements Action{

    public static final int MAX_RANGE_TO_RUN = 500;
    public static final int MAX_RANGE_TO_SWIM = 10;
    public static final double MAX_RANGE_TO_JUMP = 1.0;

    public Dog(String name, int countRandomToRun, int countRandomToSwim, double countRandomToJump) {
        super(name,
                (int) getRandomRange(countRandomToRun, MAX_RANGE_TO_RUN),
                (int) getRandomRange(countRandomToSwim, MAX_RANGE_TO_SWIM),
                getRandomRange(countRandomToJump, MAX_RANGE_TO_JUMP));
        countDogs++;
    }

    public static int getCountDogs() {
        return countDogs;
    }

    private static int countDogs;



    @Override
    public void run(int range) {
        if (range > this.maxRangeToRun) System.out.println(this.name + " не смог пробежать " + range + " метров. Max для него = " + this.maxRangeToRun);
        else System.out.println(this.name + " пробежал " + range + " метров");
    }

    @Override
    public void swim(int range) {
        if (range > this.maxRangeToSwim) System.out.println(this.name + " не смог проплыть " + range + " метров. Max для него = " + this.maxRangeToSwim);
        else System.out.println(this.name + " проплыл " + range + " метров");
    }

    @Override
    public void jump(double height) {
        if (height > this.maxRangeToJump) System.out.println(this.name + " не смог перепрыгнуть препятствие высотой " + String.format("%.2f", height) + " метров. Max для него = " + String.format("%.2f", this.maxRangeToJump));
        else System.out.println(this.name + " перепрыгнул препятствие высотой " + String.format("%.2f", height) + " метров");
    }
}
